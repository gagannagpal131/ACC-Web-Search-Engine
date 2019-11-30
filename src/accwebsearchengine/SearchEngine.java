package accwebsearchengine;

import java.io.File;
import java.util.*;
import textprocessing.*;
import sorting.*;
import static java.util.stream.Collectors.toMap;


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
	
	
	
	
	
	
	
	
	
	
	public static TST<Integer> getTST(String finalPath) {
		
		TST<Integer> tst = new TST<Integer>();
		
		In in = new In(finalPath);
		
		int j = 0;
        while (!in.isEmpty()) {
        	
        String text = in.readLine();
        	
	        if (j == 0) {
	            	 
	        	j = 1;
	            continue;
	            	 
	        } else if (j == 1) {
	            		  
	        	j = 0; 
	        	
	        	StringTokenizer st  = new StringTokenizer(text, " ");
	        	
	        	while (st.hasMoreTokens()) { 
	    			
	    			String word = st.nextToken();
	    			word = word.toLowerCase();
	    			//System.out.println(word);
	    			
	        		if(tst.contains(word)) {
	        			
	        			tst.put(word, tst.get(word)+1);
	        			//System.out.println("true");
	        			
	        		} else {
	        			
	        			tst.put(word, 1);
	        			
	        		}

	            }

	        }
        	    	
        }
        
//        for (String key : tst.keys()) {
//            System.out.println(key + " " + tst.get(key));
//        }
        
		return tst;
		
	}
	
	
	
	
	
	
	
	public static HashMap<Integer, Integer> getFreqList(String[] keyWords){
		
		
		//Map each text file to its corresponding number into an arraylist
		ArrayList<String> textList = new ArrayList<>();
		
		File folder = new File("/Users/gagandeepnagpal/Desktop/ACC-Web-Search-Engine/src/accwebsearchengine/urls"); 
        File[] files = folder.listFiles();
 
        for (File file : files)
        {
        	
            String myURL = file.getName();
            //myURL = myURL.substring(0, (myURL.length()-4));
            textList.add(myURL);
        	
        }
       
        HashMap<Integer,Integer > freqList = new HashMap<Integer, Integer>();
        
        for (int i = 0 ; i < textList.size() ; i++) {
        	
	        String filePath = "/Users/gagandeepnagpal/Desktop/ACC-Web-Search-Engine/src/accwebsearchengine/urls/";
	        String fileName = textList.get(i);
	        String finalPath = filePath+fileName;
	        
	        //System.out.println(finalPath);
	        
	        String tempFileIndex = fileName.substring(0, (fileName.length()-4));
        	int fileIndex = Integer.parseInt(tempFileIndex);
			//System.out.println(fileIndex); 
			
	        TST<Integer> tst = new TST<Integer>();
	        tst = SearchEngine.getTST(finalPath);
	        //System.out.println(tst);
	        
//	        for (String key : tst.keys()) {
//	        	System.out.println(key + " " + tst.get(key));
//	        }
	        
	        int counter = 0;
	        
	        for (String str: keyWords) {
	        	
	        	if (tst.contains(str)){
	        		
	        		int count = tst.get(str);
	        		//System.out.println(str+" "+count);
	        		counter = counter + count;
	        		
	        	}
	        	
	        }
	       
	        freqList.put(fileIndex, counter);
	             
        }  
        
        //System.out.println(freqList);
		return freqList;
	}

	
	
	
	public static HashMap<Integer, Integer> sortHashMap(HashMap<Integer,Integer> freqList){
		
		
		  HashMap<Integer, Integer> sortedFreqList = freqList
		          .entrySet()
		          .stream()
		          .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
		          .collect(
		              toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2,
		                  LinkedHashMap::new));
		
		 
		
		return sortedFreqList;		
		
	}
	
	
	public static void main(String[] args) {
		
		String mySearch = "Masters of Applied Computing";
		
		String[] keyWords = SearchEngine.getKeywords(mySearch);
		Sort.mergeSort(keyWords);
		
//		for (String str : keyWords) {
//			
//			System.out.println(str);
//		}
		
	

		HashMap<Integer,String> urlIndex = new HashMap<Integer, String>();
		urlIndex = SearchEngine.indexURLS();
		//System.out.println(UrlIndex);
		
		
		HashMap<Integer,Integer> freqList = new HashMap<Integer,Integer>();
		freqList = SearchEngine.getFreqList(keyWords);
		//System.out.println(freqList);
		
		freqList = SearchEngine.sortHashMap(freqList);
		System.out.println(freqList);
		
		int j = 0;
		for (HashMap.Entry<Integer, Integer> entry : freqList.entrySet()) {
			
			if (j < 10) {
				
				//System.out.println(entry.getKey() + " = " + entry.getValue());
				int urlKey = entry.getKey();
				System.out.println("\n"+urlIndex.get(urlKey)+"\n");
				j++;
				
			} else {
				
				break;
			}
		}

	}

}
