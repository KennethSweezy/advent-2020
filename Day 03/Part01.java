import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Part01 {



	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out);
		ArrayList lines = new ArrayList<String>();
		try {
			File input = new File("input/input.txt");
			Scanner scan = new Scanner(input);
			while(scan.hasNextLine()) {
				lines.add(scan.nextLine());
			}
			int curCalcRow = 0;
			int curCalcCol = 0;
			int treesEncount = 0;
			try {
				while(curCalcRow != lines.size()) {
					System.out.println(((String) lines.get(curCalcRow)).charAt(curCalcCol));
					if(((String) lines.get(curCalcRow)).charAt(curCalcCol) == '#') treesEncount++;
					curCalcRow++;
					if(curCalcCol + 3 >= ((String) lines.get(0)).length()) {
						curCalcCol = (curCalcCol + 3) - ((String) lines.get(0)).length();
					} else curCalcCol += 3;
					
				}
			} catch (IndexOutOfBoundsException c) {
				System.out.println(treesEncount);
			}
			System.out.println(treesEncount);
		} catch (FileNotFoundException e) {
			System.out.println("Oops, something went wrong.");
			e.printStackTrace();
		}

	}

}
