import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
// 15jul4-Iv8TdGq8gxvH49EGX_xmNeAAls folder-id
	  

	  public static void main(String... args) throws IOException, GeneralSecurityException {
		  
		Scanner userinput = new Scanner(System.in);
		
		String subject;
		int type;
		String description;
		int points;
		
		System.out.println("Fach: ");
		subject = userinput.next();
		
		System.out.println("Klausur (1) Mündliche Note (2) Sonstiges (3): ");
		type = Integer.parseInt(userinput.next());
		
		System.out.println("Beschreibung: ");
		description = userinput.next();
		
		System.out.println("Punktanzahl (0-15): ");
		points = Integer.parseInt(userinput.next());
		
		GradeModel grade = new GradeModel(subject, type, description, points);
		
		grade.writeToFile(grade.subject, grade.type, grade.description, grade.points);
		
	    final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
	    Drive service = new Drive.Builder(HTTP_TRANSPORT, auth.JSON_FACTORY, auth.getCredentials(HTTP_TRANSPORT))
	        .setApplicationName(auth.APPLICATION_NAME)
	        .build();
	    
	    
	    File fileMetadata = new File();
	    fileMetadata.setName(java.time.LocalDate.now()+".json");
	    fileMetadata.setParents(Collections.singletonList("15jul4-Iv8TdGq8gxvH49EGX_xmNeAAls"));
	    java.io.File filePath = new java.io.File("C:\\Users\\danie\\eclipse-workspace\\GradeSaver\\json\\data.json");
	    FileContent mediaContent = new FileContent("application/json", filePath);

	    // fileMetadata.setMimeType("application/vnd.google-apps.folder");
	    try {
	      File file = service.files().create(fileMetadata, mediaContent)
	          .setFields("id")
	          .execute();
	      System.out.println("Success.");
	      
	    } catch (GoogleJsonResponseException e) {
	      // TODO(developer) - handle error appropriately
	      System.err.println("Unable to create folder: " + e.getDetails());
	      throw e;
	    }
	    
	    Scanner sc = new Scanner(System.in);
	    String x = sc.nextLine();
	    
	    service.files().delete(x);
	    
	  }
	}


/* public class Main {
		
	public static void main(String[] args) {
		GradeModel grade = new GradeModel("Math", "Klausur", "GFS",15);
		
		
		grade.writeToFile(grade.subject, grade.type, grade.description, grade.points);
		
		
	}

}
*/
