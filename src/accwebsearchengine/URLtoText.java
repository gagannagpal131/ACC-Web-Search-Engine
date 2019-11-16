package accwebsearchengine;

import java.io.*;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import textprocessing.*;

public class URLtoText {

	public static void main(String[] args) {
		
		ArrayList<String> urlList = new ArrayList<>();
		
		//Use URL of own PC while running on local computer
		In in = new In("/Users/gagandeepnagpal/Desktop/ACC-Web-Search-Engine/src/accwebsearchengine/websites.txt");
		
        while (!in.isEmpty()) {
        	
        	String myText = in.readLine();
        	//System.out.println(myText);
        	urlList.add(myText);
        	    	
        }
        
        
        for(int i = 0; i < urlList.size(); i++) {
        	
        	try {
        		
        		org.jsoup.nodes.Document doc = Jsoup.connect(urlList.get(i)).get();
        		String text = doc.text();
            	String FilePath = "/Users/gagandeepnagpal/Desktop/ACC-Web-Search-Engine/src/accwebsearchengine/urls/" + (i)+".txt" ;
            	PrintWriter out = new PrintWriter(FilePath);
        		out.println(urlList.get(i));
            	out.println(text);
        		System.out.println(urlList.get(i));
        		out.close();
        		
        		
        	}catch(Exception e){
        		
        		System.out.println("Exception, Cannot be converted to text: "+ urlList.get(i));
        	}
        	
        
        }
	}
}
