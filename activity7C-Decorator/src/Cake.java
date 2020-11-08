
public class Cake implements Pastry {

	@Override
	public void gatherIngredients() {
		System.out.println("We are gathering the ingredients of the cake");

	}

	@Override
	public void mixIngredients() {
		System.out.println("We are mixing the ingredients of the cake");

	}

	@Override
	public void bake() {
		System.out.println("We are baking the cake");

	}

	@Override
	public void serve() {
		System.out.println("We are serving the cake");

	}

}
