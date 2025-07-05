import java.time.LocalDate;

public class App {

    public static void main(String[] args) {
        Cart cart = new Cart(); //creating the cart

        //creating products
        Product cheese = new Product("cheese", 15, 15,true,LocalDate.of(2025,07,11), true, 15);
        Product TV = new Product("Samsung TV", 5000, 20);
        Product scratchCards = new Product("Vodafone Scratch Cards", 200, 100);
        Product yogurt = new Product("yogurt", 15, 150, true,LocalDate.of(2025,07,1));
        Product biscuits = new Product("biscuits",5.0,10,true,LocalDate.of(2025,07,31));

        cart.addToCart(cheese, 5);

        cart.checkout(2000);
    }
}