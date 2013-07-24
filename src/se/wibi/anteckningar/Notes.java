package se.wibi.anteckningar;

public class Notes {
	private String text;
	private String images;
	private String date;
	public Notes(String text, String image, String date){
		this.text = text;
		this.images = image;
		this.date = date;
	}
	public Notes(){}
	public void setText(String text){this.text = text;}
	public String getText(){return this.text;}
	
	public void setImages(String image){this.images = image;}
	public String getImages(){return this.images;}
	
	public void setDate(String date){this.date = date;}
	public String getDate(){return this.date;}
}
