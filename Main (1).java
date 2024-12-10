import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.lang.String;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/input.txt");
        ArrayList<Integer> location1 = new ArrayList<Integer>();
        ArrayList<Integer> location2 = new ArrayList<Integer>();
        for (int i = 0; i <= fileData.size() - 1; i++) {
            String line = fileData.get(i);
            String a = line.substring(0, line.indexOf("   "));
            String b = line.substring(line.indexOf("   "), line.length()).trim();
            int x = Integer.parseInt(a);
            int y = Integer.parseInt(b);
            location1.add(x);
            location2.add(y);
        }
        Collections.sort(location1);
        Collections.sort(location2);
        System.out.println(location1);
        System.out.println(location2);
        System.out.println(partOne(location1,location2));
        System.out.println(partTwo(location1,location2));

    }
    public static int partOne(ArrayList<Integer> location1, ArrayList<Integer> location2) {
        int sum = 0;
        for (int a = 0; a <= location1.size() - 1; a++) {
            int one = location1.get(a);
            int two = location2.get(a);
            int difference = Math.abs(one - two);
            sum = sum + difference;
        }
        return sum; // Return the calculated sum
    }
    public static int partTwo(ArrayList<Integer> location1, ArrayList<Integer> location2) {
        int sum = 0;
        for (int b = 0; b <= location1.size() - 1; b++) {
            int one = location1.get(b);

            int counting = 0;
            for (int c = 0; c <= location2.size() - 1; c++){
                int compareTo = location2.get(c);
                if (one == compareTo){
                    counting++;
                }
            }
            int point = one * counting;
            sum = sum + point;
        }
        return sum; // Return the calculated sum
    }


    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        } catch (FileNotFoundException e) {
            return fileData;
        }
    }

}