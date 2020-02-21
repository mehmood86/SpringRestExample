public class JsonQuote {

	String quote;

	public JsonQuote(String quote) {
		// TODO Auto-generated constructor stub
		this.quote = quote;
	}

	public String toString() {
		return "{\n  " + "Quote of the Day: "  + quote + "\n}";
	}

}
