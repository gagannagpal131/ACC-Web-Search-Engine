package accwebsearchengine;

import java.util.*;

import textprocessing.In;

public class SearchEngine {
	
	//Method to Remove stop words and Tokenize keywords
	public static String[] getKeywords(String inputStr) {
		
	
		In in = new In("/Users/gagandeepnagpal/Desktop/ACC-Web-Search-Engine/src/accwebsearchengine/stop-words.txt");
		
		inputStr = inputStr.toLowerCase();
		
		while (!in.isEmpty()) {
			
			String text = in.readLine();
			text = text.toLowerCase();
			text = "\\b"+text+"\\b";
			inputStr = inputStr.replaceAll(text,"");
			
		}
		
		//System.out.println(inputStr);
		
		StringTokenizer st  = new StringTokenizer(inputStr, " ");
		
		String[] keyWords = new String[st.countTokens()];
	
		int i = 0;
		
		while (st.hasMoreTokens()) { 
			
			keyWords[i]=st.nextToken();
				i++;
			
        	 }
		
		return keyWords;
		
	}
	
	//Code to index URLS
	public static HashMap<Integer,String> indexURLS() {
		
		HashMap<Integer,String> UrlIndex = new HashMap<Integer,String>();
		
		In in = new In("/Users/gagandeepnagpal/Desktop/ACC-Web-Search-Engine/src/accwebsearchengine/websites.txt");
		
		int i = 0;
        while (!in.isEmpty()) {
        	
        	String text = in.readLine();
        	UrlIndex.put(i,text);
        	i++;
           
        	    	
        }
       
		return UrlIndex;
		
	}

	
	public static void main(String[] args) {
		
		
		
		
		
		
		String[] keyWords = SearchEngine.getKeywords("hello This is A test environment Gagandeep Singh Nagpal");
		
		for (String str : keyWords) {
			
			System.out.println(str);
		}
		
		
		
	
		
		HashMap<Integer,String> UrlIndex = new HashMap<Integer, String>();
		
		UrlIndex = SearchEngine.indexURLS();
		
		System.out.println(UrlIndex);
		//System.out.println(UrlIndex.get(1));
		
		

	}

}
