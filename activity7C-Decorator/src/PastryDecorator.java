
public class PastryDecorator implements Pastry {
	protected Pastry decoratedPastry; 
	
	public PastryDecorator(Pastry decoratedPastry) {
		super();
		this.decoratedPastry = decoratedPastry;
	}

	@Override
	public void gatherIngredients() {
		decoratedPastry.gatherIngredients();

	}

	@Override
	public void mixIngredients() {
		decoratedPastry.mixIngredients();
	}

	@Override
	public void bake() {
		decoratedPastry.bake();
	}

	@Override
	public void serve() {
		decoratedPastry.serve();
	}

}
