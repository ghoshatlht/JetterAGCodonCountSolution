/**
 * 
 */
package com.jetter.samya;

import edu.duke.FileResource;
import java.util.HashMap;
import java.io.*;


/**
 * @author Samya
 *
 */
public class Jettercodoncount {
	
	// Create a private variable to store a HashMap to map DNA codons to their count//
	private HashMap<String, Integer> DNAhashmap;
	
	
     // Default Constructor for objects of class Jettercodoncount //
	// Write a constructor to initialize the HashMap variable
	
	public Jettercodoncount(){
	
		//initialize-ing  the HashMap variable
		DNAhashmap = new HashMap<String, Integer>();
	}
     
   /* Write a void method named buildCodonMap that has two parameters
    * This method will build a new map of codons mapped to their counts from the string dna
    * position start.
    */
	
	private void buildCodonMap(int start, String dna){
    
		DNAhashmap.clear(); //Removes all of the mappings from this map. The map will be empty after this call returns, will make sure map will be empty//
		String newelement;
	      for(int i = 0;i < (dna.length() - start)/3;i++)
	      {
	    	  newelement = dna.substring(start+i*3, start+i*3+3);
                  
	          if (!DNAhashmap.containsKey(newelement)) DNAhashmap.put(newelement, 1);
                  
	          else DNAhashmap.put(newelement, DNAhashmap.get(newelement)+1);
	      }
    }
	
	/**
     * Write a method named getMostCommonCodon that has no parameters. 
     * This method returns a String, the codon in a reading frame that has the largest count. If there are
     * several such codons, return any one of them. This method assumes the HashMap of codons to counts has already been built.
     * 
     */
	
	
	private String getMostCommonCodon()
    {
      int val = 0;  
      int largestcount = 0;
      String largestkey = null;
      for(String key : DNAhashmap.keySet()){
          val = DNAhashmap.get(key);
          if (largestcount < val)
          {
              largestcount = val;
              largestkey = key;
          }
      }
      return largestkey;
    }
	
	
	/*Write a void method named printCodonCounts that has two int parameters,
	 * start and end . This method prints all the codons in the HashMap along with their counts if their
	 * count is between start and end , inclusive.
	 * 
	 */
	
	
	private void printCodonCounts(int start, int end) 
    {
        int val = 0;
        for(String key : DNAhashmap.keySet()){   
                    val = DNAhashmap.get(key);
            if (val >= start && val <= end)
                System.out.println( key + "     " + val +     "\t");
        }
    }
	
	
	/*Write a tester method that prompts the user for a file that contains a DNA strand
	 *
	 */
	 
	 public void tester() throws FileNotFoundException{
		 
		 FileResource fr = new FileResource();
        String dna = fr.asString().trim();
        dna = dna.toUpperCase();
        int start = 1;
        int end = 5;
       
       buildCodonMap(0, dna);
       System.out.println("Reading frame starting with 0 results in "+DNAhashmap.size()+" unique codons"+"\t");
       String largest = getMostCommonCodon();
       System.out.println("and most common codon is "+largest+" with count "+DNAhashmap.get(largest)+"\t"); 
       System.out.println("Counts of codons between "+start+" and "+end+" inclusive are:"+"\t");
       printCodonCounts(start, end);
       
       buildCodonMap(1, dna);
       System.out.println("Reading frame starting with 1 results in "+DNAhashmap.size()+" unique codons"+"\t");
       largest = getMostCommonCodon();
       System.out.println("and most common codon is "+largest+" with count "+DNAhashmap.get(largest)+"\t"); 
       System.out.println("Counts of codons between "+start+" and "+end+" inclusive are:"+"\t");
       printCodonCounts(start, end);
       
       buildCodonMap(2, dna);
       System.out.println("Reading frame starting with 2 results in "+DNAhashmap.size()+" unique codons"+"\t");
       largest = getMostCommonCodon();
       System.out.println("and most common codon is "+largest+" with count "+DNAhashmap.get(largest)+"\t"); 
       System.out.println("Counts of codons between "+start+" and "+end+" inclusive are:"+"\t");
       printCodonCounts(start, end);
  }

	 }
	 

