
import java.io.FileWriter;
import java.io.PrintWriter;

import java.util.List;



import org.json.simple.*;

public class GradeModel {

	String subject;
	String type;
	int points;
	String description;
	
	public GradeModel(String subject, String type, String description, int points) {
		this.subject = subject;
		this.type = type;
		this.points = points;
		this.description = description;
	}
	
	public void writeToFile (String subject, String type, String description, int points) {
		String path = "C:\\Users\\danie\\eclipse-workspace\\GradeSaver\\json\\data.json";
        JSONObject json = new JSONObject();
        try {
            json.put("subject", subject);
            json.put("points", points);
            json.put("type", type);
        } catch (Exception e){
            System.out.print("Operation failed.");
        }
 
        try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
            out.write(json.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
}

