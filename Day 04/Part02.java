import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part02 {
	public static void main(String[] args) {
		ArrayList tempLines = new ArrayList<String>();
		ArrayList temp = new ArrayList<String>();
		int validPass = 0;
		try {
			File input = new File("Day 04/input/input.txt");
			Scanner scan = new Scanner(input).useDelimiter("\n\n");
			while(scan.hasNextLine()) {
				tempLines.add(scan.next());
			}
			for(int i = 0; i < tempLines.size(); i++) {
				int counter = 0;
				if(((String) tempLines.get(i)).contains("byr") & ((String) tempLines.get(i)).contains("iyr") & ((String) tempLines.get(i)).contains("eyr") & ((String) tempLines.get(i)).contains("hgt") & ((String) tempLines.get(i)).contains("hcl") & ((String) tempLines.get(i)).contains("ecl") & ((String) tempLines.get(i)).contains("pid")) {
					for(String chunk : ((String) tempLines.get(i)).split("[ |\n]")) {
						String ftc = chunk.substring(0, 3);
						switch(ftc) {
							case "byr":
								try {
									int byrtemp = Integer.parseInt(chunk.split(":")[1].substring(0, 4));
									if((byrtemp >= 1920 & byrtemp <= 2002)) ++counter;
								} catch (Exception e) {
									continue;
								}
								break;
							case "iyr":
								try {
									int iyrtemp = Integer.parseInt(chunk.split(":")[1].substring(0, 4));
									if((iyrtemp >= 2010 & iyrtemp <= 2020)) ++counter;
								} catch (Exception e) { continue; }
								break;
							case "eyr":
								try {
									int eyrtemp = Integer.parseInt(chunk.split(":")[1].substring(0, 4));
									if((eyrtemp >= 2020 & eyrtemp <= 2030)) ++counter;
								} catch (Exception e) { continue; }
								break;
							case "ecl":
								if((chunk.contains("amb") ^ chunk.contains("blu") ^ chunk.contains("brn") ^ chunk.contains("gry") ^ chunk.contains("grn") ^ chunk.contains("hzl") ^ chunk.contains("oth"))) ++counter;
								break;
							case "pid":
								try {
									int tempers = Integer.parseInt(chunk.split(":")[1].substring(0, 8));
									++counter;
								} catch (Exception e) { continue; }
								break;
							case "hcl":
								Pattern pattern = Pattern.compile("^#([a-fA-F0-9]{6})");
								Matcher matcher = pattern.matcher(chunk.split(":")[1]);
								if(matcher.find()) ++counter;
								break;
							case "hgt":
									try {
										if(chunk.contains("cm")) {
											if((Integer.parseInt(chunk.split(":")[1].substring(0, 3)) >= 150 & Integer.parseInt(chunk.split(":")[1].substring(0, 3)) <= 193)) ++counter;
										} else if(chunk.contains("in")) {
											if((Integer.parseInt(chunk.split(":")[1].substring(0, 2)) >= 59 & Integer.parseInt(chunk.split(":")[1].substring(0, 2)) <= 76)) ++counter;
										} else continue;
									} catch (Exception e) { continue; }
									break;
						}
						
					}
					if(counter == 7) validPass++;
				}
			}
			System.out.println(validPass);
		} catch (FileNotFoundException e) {
			System.out.println("Oops, something went wrong.");
			e.printStackTrace();
		}

	}

}
