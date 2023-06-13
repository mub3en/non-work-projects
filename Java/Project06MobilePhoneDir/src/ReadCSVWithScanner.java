import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadCSVWithScanner {

    public DoublyLinkedList getPhoneDirectoryFromCSV(String filePath) {
        DoublyLinkedList dList = new DoublyLinkedList();
        try {
            // open file input stream
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            // read file line by line
            String line = null;
            Scanner scanner = null;
            int index = 0;
            //  This flag is used if there is a header to ignore the first line of the CSV file
            //  If there is no header,  set this to false.
            boolean firstLine = true;
            while ((line = reader.readLine()) != null) {
            	PhonebookData pbd = new PhonebookData();
                scanner = new Scanner(line);
                scanner.useDelimiter(",");
                if (! firstLine)
                    while (scanner.hasNext()) {
                        String data = scanner.next();
                            if (index == 0) 
                            	pbd.setName(data);
                            else if (index == 1)
                            	pbd.setMobilePhone(data);
                            else
                                System.out.println("invalid data::" + data);
                            index++;
                        }
                        index = 0;
                        if (! firstLine)
                        	dList.addNode(pbd);
                        firstLine = false;
                }
            //close reader
            reader.close();
        }
        catch (IOException e) {
            System.out.println("File not found");
        }
        return dList;
    }

}