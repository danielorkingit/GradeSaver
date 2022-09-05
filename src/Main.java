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

public class Main {

	  

	  public static void main(String... args) throws IOException, GeneralSecurityException {
		  
	    final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
	    Drive service = new Drive.Builder(HTTP_TRANSPORT, auth.JSON_FACTORY, auth.getCredentials(HTTP_TRANSPORT))
	        .setApplicationName(auth.APPLICATION_NAME)
	        .build();
	    
	    List<File> files = new ArrayList<File>();
	    
	    
	    
	    File fileMetadata = new File();
	    fileMetadata.setName("OBERSTUFE_PUNKTE");
	    fileMetadata.setMimeType("application/vnd.google-apps.folder");
	    try {
	      File file = service.files().create(fileMetadata)
	          .setFields("id")
	          .execute();
	      System.out.println("Folder ID: " + file.getId());
	      
	    } catch (GoogleJsonResponseException e) {
	      // TODO(developer) - handle error appropriately
	      System.err.println("Unable to create folder: " + e.getDetails());
	      throw e;
	    }
	  }
	}


/* public class Main {
	
	String apikey = "AIzaSyAkIZocpL1dALVYfNtAcg3LkVOrwT5cdPQ";
	
	public static void main(String[] args) {
		GradeModel grade = new GradeModel("Math", "Klausur", "GFS",15);
		
		
		grade.writeToFile(grade.subject, grade.type, grade.description, grade.points);
		
		
	}

}
*/
