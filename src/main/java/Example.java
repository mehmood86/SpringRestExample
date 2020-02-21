import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;
import java.util.Random;
import java.io.*;
import java.util.ArrayList;


@RestController
@EnableAutoConfiguration
public class Example {

	@RequestMapping("/")
  String home() throws Exception{
			File file = new File("src/main/java/RandomQuotes.txt");
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

			ArrayList<String> quotesList = new ArrayList<String>();
			String st;

			while ((st = bufferedReader.readLine()) != null) {
				quotesList.add(st);
			}

	    Random random = new Random();
	    JsonQuote jsonQuote = new JsonQuote(quotesList.get(random.nextInt(quotesList.size())));
	    bufferedReader.close();

			StyleBean styleBean = new StyleBean(jsonQuote.toString());
	    return "Hello World!, Random number is " + random.nextInt(10) + "<br> Json Styled Quote " + jsonQuote.toString() + "<br> Custom Styled Quote " + styleBean.toString();
    }

	@RequestMapping("/random")
	//	@RequestParam(value = "message")
  String random(@RequestParam String message) {
		Random rand = new Random();
		message += "<br>";
		for (int i=1; i<11; i++){
			for (int j=1; j<11; j++){
					message += j*i + "\t";
				}
				message += "<br>";
		}
		return message;

    }


    public static void main(String[] args) {
        SpringApplication.run(Example.class, args);
    }

}
