import java.util.LinkedHashMap;
import java.util.Map;

public class ShippingService {
    double shippingCostPerGram = 0.1;
    
    public double calculateShipping(LinkedHashMap<Product,Integer> products){
        double packageWeight = 0;
        double totalShippingCost = 0;
        for(Map.Entry<Product, Integer> entry : products.entrySet()){
            packageWeight+=entry.getKey().getWeight()*entry.getValue();
            totalShippingCost+=entry.getKey().getWeight()*entry.getValue()*shippingCostPerGram;
        }
        return packageWeight*shippingCostPerGram;

    }
    public void displayShippingNotice(LinkedHashMap<Product,Integer> products){
        double packageWeight = 0;
        for(Map.Entry<Product, Integer> entry : products.entrySet()){
            String name = entry.getKey().getName();
            double weight = entry.getKey().getWeight()*entry.getValue();
            int quantity = entry.getValue();
            packageWeight+=entry.getKey().getWeight()*entry.getValue();
            System.out.println("***SHIPPING NOTICE***");
            System.out.println(quantity+"x "+name+" " + weight);
            
        }
    }
}
