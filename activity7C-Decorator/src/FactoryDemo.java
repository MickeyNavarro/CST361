
public class FactoryDemo {
	public static void main(String[] args) {
	      Bakery bakery = new Bakery();
	      
	      System.out.println("*****COOKIE*****");

	      //get an object of Cookie
	      Pastry cookie = bakery.getPastry("COOKIE");

	      //call the methods of Cookie
	      cookie.gatherIngredients();
	      cookie.mixIngredients();
	      cookie.bake();
	      cookie.serve();
	     
	      System.out.println("*****CAKE*****");
	      
	      //get an object of Cake
	      Pastry cake = bakery.getPastry("CAKE");

	      //call the methods of Cookie
	      cake.gatherIngredients();
	      cake.mixIngredients();
	      cake.bake();
	      cake.serve();

	      System.out.println("*****BROWNIE*****");
	      
	      //get an object of Cake
	      Pastry brownie = bakery.getPastry("BROWNIE");

	      //call the methods of Cookie
	      brownie.gatherIngredients();
	      brownie.mixIngredients();
	      brownie.bake();
	      brownie.serve();
	   }
}
