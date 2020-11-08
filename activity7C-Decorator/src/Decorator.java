
public class Decorator extends PastryDecorator{

	public Decorator(Pastry decoratedPastry) {
		super(decoratedPastry);
	}

	@Override
	public void serve() {
		decoratedPastry.serve();
		sell(decoratedPastry); 
	}
	
	private void sell(Pastry decoratedPastry) { 
		System.out.println("We have sold out of this pastry"); 
	}
}
