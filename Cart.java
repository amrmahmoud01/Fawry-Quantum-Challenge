import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;
public class Cart {
    LinkedHashMap<Product,Integer> cart = new LinkedHashMap<>();
    ShippingService shippingService = new ShippingService();

    public LinkedHashMap<Product,Integer> addToCart(Product product, Integer quantity){
        int availableQunatity = product.getQuantity();
        if(cart.containsKey(product)){
            int currentQuantity = cart.get(product);
            if(currentQuantity+quantity<=availableQunatity){
                cart.put(product,quantity+currentQuantity);
            }
            else{
                System.out.println("Insufficient stock available. Only "+availableQunatity+" remaining");
            }
            
        }
        else{
            
            if(quantity<=availableQunatity){
                cart.put(product,quantity);
            }
            else{
                System.out.println("Insufficient stock available. Only "+availableQunatity+" remaining");
            }
        }
        return cart;
    }
    public LinkedHashMap<Product,Integer> removeFromCart(Product product, Integer quantity){
        if(cart.containsKey(product)){
            int currentQuantity = cart.get(product);
            cart.put(product,currentQuantity - quantity);
        }
        return cart;
    }
    public LinkedHashMap<Product,Integer> getCart(){
        return cart;
    }

    private boolean checkOutOfStock(){ //in this code, in a local environment, a product will never be out of stock at
                                        //check out because they cant add more than the available amount to the cart, this is hypothetical.

        for(Map.Entry<Product, Integer> entry : cart.entrySet()){
            if(entry.getKey().getQuantity()<entry.getValue()){
                // System.err.println("Not enough "+ entry.getKey()+" in stock. Only "+entry.getKey().getQuantity()+" remaining.");
                return true;
            }
    }
        return false;

}
    private boolean checkExpired(){
        LocalDate today = LocalDate.now();
        for(Map.Entry<Product, Integer> entry : cart.entrySet()){
            if(entry.getKey().canExpire()){
                if(entry.getKey().getExpiration().isBefore(today)){
                return true;
            }
            }
            
        }
        return false;
}
    public void checkout(double paidAmount){ 
        
        double subtotal = 0;
        for(Map.Entry<Product, Integer> entry : cart.entrySet()){
            subtotal += entry.getKey().getPrice()*entry.getValue();
        }
        if (cart.isEmpty()){
            System.out.println("Add some items to cart before checking out");
        }
        else if(checkOutOfStock()){
            System.out.println("Some items are out of stock. Can't checkout");
        }
        else if(checkExpired()){
            System.out.println("Some items are expired. Can't checkout");
        }
        else if(paidAmount<subtotal){
            System.out.println("Insufficient Funds, need more money");
        }
        else{
            LinkedHashMap<Product,Integer> shippableItems = new LinkedHashMap<Product,Integer>();
            System.out.println("*** Checkout Receipt ***");
            for(Map.Entry<Product, Integer> entry : cart.entrySet()){ //printing reciept and checking shippable items
                String name = entry.getKey().toString();
                int quantity = entry.getValue();
                double price = entry.getKey().getPrice()*quantity;
                if(entry.getKey().isShippable()){
                    shippableItems.put(entry.getKey(), entry.getValue());
                }
                System.out.println(quantity+"x "+name+" " + price);
            }
            double shippingCost = shippingService.calculateShipping(shippableItems);
            shippingService.displayShippingNotice(shippableItems);
            System.out.println("\nSubtotal : "+ subtotal);
            System.out.println("Shipping : "+ shippingCost);
            double total = shippingCost + subtotal;
            System.out.println("Total : "+ total);




        }
    }

}
