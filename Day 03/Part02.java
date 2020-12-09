import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Part02 {
	public static void main(String[] args) {
		int[] slopeX = {1, 3, 5, 7, 1};
		int[] slopeY = {1, 1, 1, 1, 2};
		BigInteger mult = new BigInteger("1");
		for(int i = 0; i < slopeX.length; i++) {
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
					while(!(curCalcRow >= lines.size())) {
						if(((String) lines.get(curCalcRow)).charAt(curCalcCol) == '#') ++treesEncount;
						curCalcRow += slopeY[i];
						if(curCalcCol + slopeX[i] >= ((String) lines.get(0)).length()) {
							curCalcCol = (curCalcCol + slopeX[i]) - ((String) lines.get(0)).length();
						} else curCalcCol += slopeX[i];
					}
				} catch (IndexOutOfBoundsException c) {
					System.out.println(treesEncount);
					mult = mult.multiply(BigInteger.valueOf(treesEncount));
					
				}
				System.out.println(treesEncount);
				mult = mult.multiply(BigInteger.valueOf(treesEncount));
			} catch (FileNotFoundException e) {
				System.out.println("Oops, something went wrong.");
				e.printStackTrace();
			}
		}
		System.out.println(mult);
	}

}
