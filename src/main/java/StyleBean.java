public class StyleBean {

	String quote;

	public StyleBean(String quote){
		this.quote = quote;
	}

	public String toString(){
		//give some style to message
		return " :::: " + quote + " ::::";
	}

}
