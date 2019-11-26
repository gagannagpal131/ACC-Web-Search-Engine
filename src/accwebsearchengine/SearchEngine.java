package accwebsearchengine;

import java.util.*;

import textprocessing.In;

public class SearchEngine {
	
	public static String[] getKeywords(String inputStr) {
		
		//ArrayList<String> keyWords = new ArrayList<>();
		
		In in = new In("/Users/gagandeepnagpal/Desktop/ACC-Web-Search-Engine/src/accwebsearchengine/stop-words.txt");
		while (!in.isEmpty()) {
			
			String text = in.readLine();
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

	public static void main(String[] args) {
		
		String[] keyWords = SearchEngine.getKeywords("hello this is a test environment Gagandeep Singh Nagpal");
		
		for (String str : keyWords) {
			
			System.out.println(str);
		}

	}

}
