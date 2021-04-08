package amazon;
import java.util.*;
public class OrderBy {
	public static void main(String[] args) {
		LinkedList<String> boxes = new LinkedList<>();
		boxes.add("yck 82 01");
		boxes.add("eo first qpx");
		boxes.add("09z cat hamster");
		boxes.add("06f 12 25 6");
		boxes.add("az0 first qpx");
		boxes.add("236 cat dog rabbit snake");
		showList(boxes);
		sortList(boxes);
		System.out.println("=================");
		showList(boxes);
	}
	public static LinkedList<String> sortList(LinkedList<String> boxes){
		for(int x= 0; x < boxes.size() - 1; x++) {
			for (int y = 1+x; y < boxes.size(); y++) {
				if(isYOlder(boxes.get(y),boxes.get(x))) {
				String tempOlder = boxes.get(y);
				boxes.set(y,boxes.get(x));
				boxes.set(x,tempOlder);
				}
		}
	}
		return boxes;
	}
	public static boolean isYOlder(String idy, String idx) {
		String[] ytemp = idy.split(" ");
		String[] xtemp = idx.split(" ");
		boolean newGenerationX = isNewGeneration(xtemp);
		boolean newGenerationY = isNewGeneration(ytemp);
		    if(newGenerationX && newGenerationY) 
		    	return false;
			if(newGenerationX && !newGenerationY)
				return true;
			if(!newGenerationX && newGenerationY)
				return false;
			//old generation only
			int alOlder = alphabeticallyHigher(ytemp, xtemp);
			if(alOlder == 0) {
				//tide breaker by id
				if(isASCIIHigher(ytemp, xtemp))
					return true;
				else
					return false;
			}   
			if (alOlder < 0) 
					return true;
				else
					return false;
	}
	
	// negative numbers comes first, 0 is equal and positive numbers comes after
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


