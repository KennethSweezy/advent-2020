import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Part01 {

	public static void main(String[] args) {
		ArrayList lines = new ArrayList<String>();
		try {
			File input = new File("input/input.txt");
			Scanner scan = new Scanner(input);
			while(scan.hasNextLine()) {
				lines.add(scan.nextLine());
			}
			String[] arr;
			String[] tempIntarr;
			int[] allowedNum = new int[2];
			String allowedChar;
			int validPasses = 0;
			for(int i = 0; i < lines.size(); i++) {
				arr = ((String) lines.get(i)).split(" ", 3);
				tempIntarr = arr[0].split("-", 2);
				allowedNum[0] = Integer.parseInt(tempIntarr[0]);
				allowedNum[1] = Integer.parseInt(tempIntarr[1]);
				allowedChar = arr[1].substring(0, 1);
				System.out.print(lines.get(i) + " " + (arr[2].length() - arr[2].replace(allowedChar, "").length()));
				if((arr[2].length() - arr[2].replace(allowedChar, "").length()) >= allowedNum[0] & (arr[2].length() - arr[2].replace(allowedChar, "").length()) <= allowedNum[1]) {
					validPasses++;
					System.out.print(" VALID! \n");
				} else {
					System.out.print("\n");
				}
			}
			System.out.println(validPasses);
			scan.close();
		} catch (FileNotFoundException e) {
			System.out.println("Oops, something went wrong.");
			e.printStackTrace();
		}
	}
}
