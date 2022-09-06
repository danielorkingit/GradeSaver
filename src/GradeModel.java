
import java.io.FileWriter;
import java.io.PrintWriter;

import java.util.List;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.google.gson.JsonParser;
import com.google.gson.JsonElement;

import org.apache.commons.io.IOUtils;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.mortbay.util.ajax.JSON;

import com.google.gson.JsonParser;


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

