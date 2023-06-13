import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Map.Entry;
//import java.util.Set;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		///New way of copying files
		
//		Path source = Paths.get("files", "source");
//		Path dest = Paths.get("files", "target2");
//		
//		Path path = FileSystems.getDefault().getPath("files", "source");
//	    try {
//			BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
//			while(true) {
//				String line = reader.readLine();
//				if(line == null)
//					break;
//				
//				System.out.println(line);
//				
//			}
//			
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
//		try {
//			Files.copy(source, dest, StandardCopyOption.REPLACE_EXISTING);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		/////OLD way of copying files
		
//		String source = "files/source";
//		String target = "files/target";
//		
//		try(
//				FileReader fr = new FileReader(source);
//				BufferedReader br = new BufferedReader(fr);
//				FileWriter fw = new FileWriter(target);	
//			) {
//			
//			
//			while(true) {
//				String line = br.readLine();
//				
//				if(line == null)
//					break;
//				
//				fw.write(line + "\n");
//				
//			}
//			
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
