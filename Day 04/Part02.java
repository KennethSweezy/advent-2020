import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Part02 {
	public static void main(String[] args) {
		ArrayList tempLines = new ArrayList<String>();
		ArrayList temp = new ArrayList<String>();
		int validPass = 0;
		try {
			File input = new File("input/input.txt");
			Scanner scan = new Scanner(input).useDelimiter("\n\n");
			while(scan.hasNextLine()) {
				tempLines.add(" " + scan.next());
			}
			for(int i = 0; i < tempLines.size(); i++) {
				if(((String) tempLines.get(i)).contains("byr") && ((String) tempLines.get(i)).contains("iyr") && ((String) tempLines.get(i)).contains("eyr") && ((String) tempLines.get(i)).contains("hgt") && ((String) tempLines.get(i)).contains("hcl") && ((String) tempLines.get(i)).contains("ecl") && ((String) tempLines.get(i)).contains("pid")) {
					String[] KVPair = ((String) tempLines.get(i)).split(" ");
					int numCorrectFields = 0;
					for(String s : KVPair) {
						numCorrectFields = 0;
						String[] kvInd = s.split(":");
						switch(kvInd[0]) {
						case "byr":
							if(getNums(kvInd[1]) >= 1920 && getNums(kvInd[1]) <= 2002) numCorrectFields++;
							break;
						case "iyr":
							if(getNums(kvInd[1]) >= 2010 && getNums(kvInd[1]) <= 2020) numCorrectFields++;
							break;
						case "eyr":
							if(getNums(kvInd[1]) >= 2020 && getNums(kvInd[1]) <= 2030) numCorrectFields++;
							break;
						case "hgt":
							if(kvInd[1].contains("cm")) {
								int tn = getNums(kvInd[1]);
								if(tn >= 150 && tn <= 193) numCorrectFields++;
							} else if(kvInd[1].contains("in")) {
								int tn = getNums(kvInd[1]);
								if(tn >= 59 && tn <= 76) numCorrectFields++;
							}
							break;
						case "hcl":
							if(kvInd[1].length() < 6) break;
							String temphcl = kvInd[1].substring(0, 6);
							if(temphcl.matches("[a-fA-F0-9]{6}")) numCorrectFields++;
							break;
						case "ecl":
							String tempecl = kvInd[1].substring(0, 2);
							if(tempecl.matches("(amb|blu|brn|gry|grn|hzl|oth)")) numCorrectFields++;
							break;
						case "pid":
							if(String.valueOf(getNums(kvInd[1])).length() == 9) numCorrectFields++;
							break;
						}
					}
					if(numCorrectFields == 7) validPass++;
				}
			}
			System.out.println(validPass);
		} catch (FileNotFoundException e) {
			System.out.println("Oops, something went wrong.");
			e.printStackTrace();
		}

	}
	
	private static int getNums(String s) {
		if(s.equals("")) return 0;
		String[] n = s.split("");
		StringBuffer f = new StringBuffer();
		for(int i = 0; i < n.length; i++) {
			if((n[i].matches("[0-9]+"))) {
				f.append(n[i]);
			} else {
				try {
					return Integer.parseInt(f.toString());
				} catch (Exception e) {
					return 0;
				}
			}
		}
		return 0;
	}

}
