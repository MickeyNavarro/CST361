
public class Brownie implements Pastry {

	@Override
	public void gatherIngredients() {
		System.out.println("We are gathering the ingredients of the brownies");

	}

	@Override
	public void mixIngredients() {
		System.out.println("We are mixing the ingredients of the brownies");

	}

	@Override
	public void bake() {
		System.out.println("We are baking the brownies");

	}

	@Override
	public void serve() {
		System.out.println("We are serving the brownies");

	}

}
