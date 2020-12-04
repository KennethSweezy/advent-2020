import java.io.*;
import java.util.*;


public class Day01 {
	
	public static void main(String[] args) {
		try {
			File input = new File("input/input.txt");
			Scanner scan = new Scanner(input);
			while(scan.hasNextLine()) {
				String data = scan.nextLine();
				System.out.println(data);
			}
			scan.close();
		} catch (FileNotFoundException e) {
			System.out.println("Oops, something went wrong.");
			e.printStackTrace();
		}
	}

}
