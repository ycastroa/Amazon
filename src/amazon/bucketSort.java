package amazon;
import java.util.*;

public class bucketSort {
	public static void main(String[] args) {
		LinkedList<String> boxes = new LinkedList<>();
		boxes.add("yck 82 01");
		boxes.add("eo first qpx");
		boxes.add("09z cat hamster");
		boxes.add("06f 12 25 6");
		boxes.add("az0 first qpx");
		boxes.add("236 cat dog rabbit snake");
		if(boxes.size()>0)
		bucketSortList(boxes);
		showList(boxes);
	}
	public static void bucketSortList(LinkedList<String> boxes){
        // Create 2 empty bucket
        Vector<String> newGen = new Vector<String>();
        Vector<String> oldGen = new Vector<String>();
        for(String temp: boxes) {
        	String[] arrTemp = temp.split(" ");
	        if(isNewGeneration(arrTemp)) 
	        	newGen.add(temp);
	        else 
	        	oldGen.add(temp);
        }
        bubbleSortList(oldGen); // bubble sort old generation boxes
        boxes.clear(); //remove all elements from the box
        boxes.addAll(oldGen); // add sorted old gen boxes
        boxes.addAll(newGen); // add new boxes
        
	}
	public static void bubbleSortList(Vector<String> newGen) {
		for(int i = 0;  i< newGen.size()-1 ; i++) {
			for(int j =1+i; j<newGen.size() ; j++) {
				String[] tempi = newGen.get(i).split(" ");
				String[] tempj = newGen.get(j).split(" ");
				int aplhab = alphabeticallyHigher(tempj, tempi);
				if(aplhab < 0) { //if alphabetically higher swap
					swapValues(newGen, j, i);
				}
				if (aplhab == 0) { //if string is the same check the box id's ascii value
					if(isASCIIHigher(tempj, tempi)) {
						swapValues(newGen, j, i);
					}
				}
			}
		}
	}
	public static void swapValues(Vector<String> newGen, int indexj, int indexi ) {
		String tempHigher = newGen.get(indexj);
		newGen.set(indexj, newGen.get(indexi));//swap higher with lower
		newGen.set(indexi, tempHigher);//swap lower with higher
	}
	// if the box id is alphabetically higher returns a positive number, if same returns 0
	//if lower returns a negative number, first in the list
	public static int alphabeticallyHigher(String[] ytemp, String[] xtemp){
		int result = 0;
		int counter = 1;// start after the box id
		do {
			result = ytemp[counter].compareTo(xtemp[counter]);
			counter++;
		}
		while(counter < ytemp.length && counter < xtemp.length && result==0);
		return result;
	}
	public static boolean isASCIIHigher(String[] idy, String[] idx) {
		if(IDtoASCII(idy) > IDtoASCII(idx))
			return true;
		else
			return false;
	}
	public static int IDtoASCII(String[] id) {
		int ascii =0;
		char[] tempChar = id[0].toCharArray();
		for(char temp : tempChar)
			ascii += (int)temp;
		return ascii;
	}
	public static boolean isNewGeneration(String[] id) {
		if(Character.digit(id[1].charAt(0), 10) > 0)
			return true;	
			else 
			return false;
	}
	public static void showList(LinkedList<String> list) {
		for(String temp : list)
			System.out.println(temp);			
	}
}