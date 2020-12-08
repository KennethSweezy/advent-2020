import java.io.*;
import java.util.*;


public class Part02 {
	
	public static void main(String[] args) {
		ArrayList nums = new ArrayList<Integer>();
		try {
			File input = new File("input/input.txt");
			Scanner scan = new Scanner(input);
			while(scan.hasNextInt()) {
				nums.add(scan.nextLine());
			}
			for(int i = 0; i < nums.size(); i++) {
				for(int j = 0; j < nums.size(); j++) {
					if(i == j) continue;
					for(int k =  0; k < nums.size(); k++) {
						if(i == k | j == k) continue;
						if(Integer.parseInt((String) nums.get(i)) + Integer.parseInt((String) nums.get(j)) + Integer.parseInt((String) nums.get(k)) == 2020) {
							System.out.println(nums.get(i) + "," + nums.get(j) + "," + Integer.parseInt((String) nums.get(k)));
							System.out.println(Integer.parseInt((String) nums.get(i)) * Integer.parseInt((String) nums.get(j)) * Integer.parseInt((String) nums.get(k)));
							System.exit(1);
						}
					}
				}
			}
			scan.close();
		} catch (FileNotFoundException e) {
			System.out.println("Oops, something went wrong.");
			e.printStackTrace();
		}
	}

}
