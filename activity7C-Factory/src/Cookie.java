
public class Cookie implements Pastry {

	@Override
	public void gatherIngredients() {
		System.out.println("We are gathering the ingredients of the cookies");
		
	}

	@Override
	public void mixIngredients() {
		System.out.println("We are mixing the ingredients of the cookies");
		
	}
	
	@Override
	public void bake() {
		System.out.println("We are baking the cookies");
	}

	@Override
	public void serve() {
		System.out.println("We are serving the cookies");
		
	}

}
