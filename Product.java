import java.time.LocalDate;
public class Product implements Shippable {
    private String name;
    private double price;
    private boolean canExpire = false;
    private LocalDate expirationDate = null;
    private int quantity;
    private boolean shippable = false;
    private double weight = 0;

    public Product(String name, double price, int quantity, boolean canExpire, LocalDate expirationDate, boolean shippable,double weight){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.weight = weight;
        this.canExpire = canExpire;
        this.expirationDate = expirationDate;
    }

    public Product(String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    public Product(String name, double price, int quantity, boolean canExpire, LocalDate expirationDate){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.canExpire = canExpire;
        this.expirationDate = expirationDate;
    }
    
    public void getProductInfo(){
        System.out.println(name+ " "+price+" "+ canExpire + " "+ expirationDate + " " + quantity);
    }

    public int getQuantity(){
        return this.quantity;
    }
    public double getPrice(){
        return this.price;
    }
    public void setPrice(int price){
        this.price = price;
    }
    
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public void setExpiration(LocalDate date){
        this.expirationDate = date;
    }
    public LocalDate getExpiration(){
        return this.expirationDate;
    }
    public void updateQunatity(int quantity){
        this.quantity+=quantity;
    }
    public String toString(){
        return name;
    }

    public double getWeight(){
        return this.weight;
    }

    public String getName(){
        return this.name;
    }
    public boolean isShippable(){
        return this.shippable;
    }



}
