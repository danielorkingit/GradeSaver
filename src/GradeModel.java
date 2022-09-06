import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;

public class GradeModel {

	String subject;
	int type;
	int points;
	String description;
	
	public GradeModel(String subject, int type, String description, int points) {
		this.subject = subject;
		this.type = type;
		this.points = points;
		this.description = description;
	}
	
	public void writeToFile (String subject, int type, String description, int points) {
		String path = "C:\\Users\\danie\\eclipse-workspace\\GradeSaver\\json\\data.json";
		
		try {
			
	        JSONParser parser = new JSONParser();

			Object obj = parser.parse(new FileReader(path));
			
			JSONObject jsonObject = (JSONObject) obj;
			
	        JSONObject json = new JSONObject();
	        
		    json.put("subject", subject);
		    json.put("points", points);
		    json.put("type", type);
		    json.put("description", description);
		    jsonObject.put(java.time.LocalDate.now(), json);
		    try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
	            out.write(jsonObject.toJSONString());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		} catch (Exception e){
			System.out.println("An error has occurred.");
		}
		
	}
}

