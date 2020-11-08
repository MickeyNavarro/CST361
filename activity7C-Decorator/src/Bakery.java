
public class Bakery {
	public Pastry getPastry(String pastryType) { 
		if(pastryType == null){
	         return null;
	      }		
	      if(pastryType.equalsIgnoreCase("COOKIE")){
	         return new Cookie();
	         
	      } else if(pastryType.equalsIgnoreCase("CAKE")){
	         return new Cake();
	         
	      } else if(pastryType.equalsIgnoreCase("BROWNIE")){
	         return new Brownie();
	      }
	      
	      return null;
	}

}
