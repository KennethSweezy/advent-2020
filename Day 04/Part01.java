import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Part01 {



	public static void main(String[] args) {
		ArrayList tempLines = new ArrayList<String>();
		ArrayList temp = new ArrayList<String>();
		int validPass = 0;
		try {
			File input = new File("input/input.txt");
			Scanner scan = new Scanner(input).useDelimiter("\n\n");
			while(scan.hasNextLine()) {
				tempLines.add(scan.next());
			}
			for(int i = 0; i < tempLines.size(); i++) {
				System.out.print(tempLines.get(i));
				if(((String) tempLines.get(i)).contains("byr") && ((String) tempLines.get(i)).contains("iyr") && ((String) tempLines.get(i)).contains("eyr") && ((String) tempLines.get(i)).contains("hgt") && ((String) tempLines.get(i)).contains("hcl") && ((String) tempLines.get(i)).contains("ecl") && ((String) tempLines.get(i)).contains("pid")) {
					validPass++;
				}
			}
			System.out.println(validPass);
		} catch (FileNotFoundException e) {
			System.out.println("Oops, something went wrong.");
			e.printStackTrace();
		}

	}

}
