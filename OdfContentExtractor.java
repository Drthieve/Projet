package Projet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.xml.sax.SAXException;
import java.nio.file.attribute.*;
import java.sql.DatabaseMetaData;
import java.nio.file.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class OdfContentExtractor {
public static void main (String []args) throws IOException
try {
BodyContentHandler handler= new BodyContentHandler();
DatabaseMetaData metadata = new DatabaseMetaData();
 // Here .odt is open document text format.
FileInputStream inputstream= new FileInputStream(new File("F:\\geeks.odt"));
ParseContext parsecontent = new ParseContext();
// Parsing the open document.
OpenDocumentParser opendocumentparser= new OpenDocumentParser(); 
// Passing the InputStream , ContentHandler,
// Metadata , ParseContext to the parse method.
opendocumentparser.parse(inputstream, handler,metadata,parsecontent);
System.out.println("Content in the document :"+ handler.toString());
// Displaying the metadata of the odf file.
System.out.println("Metadata of the document:");
String[] metaName = metadata.names();
int l = metaName.length;
for (int i = 0; i < l; i++) {
System.out.println(metaName[i]+ " : =  " + metadata.get(metaName[i]));
            }
        }
catch (Exception e) {
System.out.println("failed to extract content due to " +e);
        }
    }
}