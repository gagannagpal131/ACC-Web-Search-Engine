# Web-Search-Engine
Web Search Engine developed in Java, while web crawler is developed in Python 3.<br/>
A simple search engine which is based on the frequency of the key words in the text files.<br/>

**Project Components:**<br/>
--> Imported Packages : Text Processing, Sorting<br/>
--> Python Web crawler: web-crawler.py<br/>
--> Text Files: websites.txt, stop-words.txt<br/>
--> Folders: hashmap_data, urls<br/>
--> Java File: URLtoText.java - Code to parse URLs to text files.<br/>
--> Jave File: SearchEngine.java - Driver Code along with functions.<br/>

**Concepts Used:**<br/>
1) Sorting (Merge Sort)
2) Ternary Search Trie
3) Hash Maps
4) Text Processing (JSoup, String Functions)
5) Memory Management (Caching)

**Flow of Execution of the Search Engine:**<br/>
1) Use of Python web crawler to crawl the web and recursively retreive around 1500 URLs.<br/>
2) Each URL is parsed to a text file using JSoup. 
3) Stop words are removed from the Search String given by the user.
4) String is converted to token using Java String Tokenizer.
5) All URLs are indexed into a Hash Map.
6) TST is generated for each text file and frequency of keywords are extracted.
7) To implement page ranking, frequency of these words along with the URL index are stored in the Hash Map.
8) The page ranking Hash Map is sorted in decreasing order of frequency words.
9) Page ranking Hash Map is stored in memory to implement cache and drastically improve search time.

**Screenshots:**<br/><br/>
--> Driver Java file<br/>
<img src = "https://github.com/gagannagpal131/ACC-Web-Search-Engine/blob/master/Screenshots/Eclipse%20View.png" width = "750">

--> Cache file generated<br/>
<img src = "https://github.com/gagannagpal131/ACC-Web-Search-Engine/blob/master/Screenshots/Cache%20File.png" width = "600">
