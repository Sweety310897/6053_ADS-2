import java.util.Scanner;
import java.io.File; 
import java.io.*;
import java.util.*;
public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		String synsetFile = scan.nextLine();
		String hyperfile = scan.nextLine();
		
		
		try {
			WordNet obj = new WordNet(synsetFile, hyperfile);
			String inputType = scan.nextLine();
			if(inputType.equals("Graph")) {
				System.out.println(obj.graph);
			}
			if(inputType.equals("Queries")){
				while(scan.hasNext()) {
				String[] inputQ = scan.nextLine().split(" ");
				obj.sap(inputQ[0],inputQ[1]);
				System.out.println("distance = "+obj.distance(inputQ[0],inputQ[1]) +", ancestor = " +obj.sap(inputQ[0],inputQ[1]));
			    }
			}

		} catch(Exception e) {
			System.out.println(e);
		}
		
	}
}