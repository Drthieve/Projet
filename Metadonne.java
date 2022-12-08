package Projet;

import java.nio.file.attribute.*;
import java.nio.file.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Metadonne {
File file ;
Path pathfile ;
String CheminFichier;
public Metadonne (String Chemin){
	CheminFichier=Chemin;
	this.file=new File(CheminFichier); 
	this.pathfile=Paths.get(CheminFichier);
}
public void dateCreation() {

try {
BasicFileAttributes attr = Files.readAttributes(pathfile, BasicFileAttributes.class);
System.out.println("Date de creation du fichier  : " + attr.creationTime());
}
catch(IOException e) {
e.printStackTrace();
}
}
   
public void tailleFichier() {
double octets = file.length();
        double kiloOctets = (octets / 1024);
        double megaOctets = (kiloOctets / 1024);
        double gigaOctets = (megaOctets / 1024);
        System.out.println("La taille du fichier : ");
        System.out.println("octets : " + octets);
        System.out.println("kilo Octets : " + kiloOctets);
        System.out.println("mega Octets : " + megaOctets);
        System.out.println("giga Octets : " + gigaOctets);
}

public void titreFichier() {
System.out.println("Titre  : " + file.getName());
}

public   void nombreMots() throws IOException {   
     int count = 0;    
     FileReader fr;
try {
fr = new FileReader(file);
     BufferedReader br = new BufferedReader(fr);    
     String str;
     while((str = br.readLine()) != null)    
     {
    	String[] words = str.split(" ");  
        for(String word : words)
        {
//            System.out.println(word); Afficher tous le contenu du Fichier; 
        	count ++;
        }
     }
     fr.close();
     System.out.println("Nombre des mots :" +count);
  }
catch (FileNotFoundException e) {
e.printStackTrace();
  }
}
public static void main (String []args) throws IOException
{ 
	Metadonne a = new Metadonne("/home/modder/Bureau/a.odt");
	a.tailleFichier();
	a.dateCreation();
	a.nombreMots();
	a.titreFichier();
	
}
}