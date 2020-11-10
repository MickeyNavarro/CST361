package beans;

public class Track {
	
	Song data = new Song();

	//default constructor
	public Track() {
		data.title = "";
		data.number = 0;
	}
	
	//constructor
	public Track(String title, int number) {
		super();
		this.data.title = title;
		this.data.number = number;
	}
	
	//getters and setters
	public String getTitle() {
		return data.title;
	}
	public void setTitle(String title) {
		this.data.title = title;
	}
	public int getNumber() {
		return data.number;
	}
	public void setNumber(int number) {
		this.data.number = number;
	} 
	

}
