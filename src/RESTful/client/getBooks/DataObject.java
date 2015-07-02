package RESTful.client.getBooks;

public class DataObject {
	private String name = "";
	private String author = "";
	private String year = "";
	private String publisher = "";
	
	public DataObject() {
	}
	
	public DataObject(String n, String a, String y, String p ) {
		this.name = n;
		this.author = a;
		this.year = y;
		this.publisher = p;
	}
	
	@Override
	public String toString() {
		return "DataObject [name : " + this.name + ", author : " + this.author + ", year :"
				+ this.year + " publisher: "+ this.publisher +"]";
	}
}
