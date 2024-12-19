import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.lang.Boolean;



public class Main {
    public static void main(String[] args) {


        ArrayList<String> fileData = getFileData("src/input.txt");
        ArrayList<Integer> numbersF = new ArrayList<Integer>();
        ArrayList<Boolean> booleans = new ArrayList<>();

        for(String l: fileData){
            String[] nums= l.split(" ");
            ArrayList<Integer> numsAfter = new ArrayList<Integer>();
            for(String n : nums){
                numsAfter.add(Integer.parseInt(n));
            }
            numbersF.add(partOne(numsAfter));
            booleans.add(checkSafe(numsAfter));
            System.out.println(partOne2(booleans));

            

}



    }
    private static int partOne2(ArrayList<Boolean> nums){
        int total = 0;
        for (int i = 0; i < nums.size(); i++){
            total++;
        }
        return total;
    }


    private static int partOne(ArrayList<Integer> numbers){
        int safed = 0;
        for (int i = 0; i < numbers.size(); i++){
            if(checkSafe(numbers)){
                safed++;
            }
        }
        return safed;
    }
    private static boolean checkSafe(ArrayList<Integer> numbers){
    if(checkIfSame(numbers)){
        return false;
    }
    if(!checkIfDecreasingRight(numbers) || !(checkIfIncreasingRight(numbers))){
        return false;
    }
    return true;

    }
    private static Boolean checkIfDecreasingRight (ArrayList<Integer> numbers){
        for (int i = 0 ; i < numbers.size() - 1; i++){
            int diff = numbers.get(i) - numbers.get(i+1);
            if(diff == 1 ){
                return true;
            }
            if(diff == 2){
                return true;
            }
        }
        return false;
    }


    private static Boolean checkIfSame (ArrayList<Integer> numbers){
        for (int i = 0 ; i < numbers.size() - 1; i++){
            if(numbers.get(i) == numbers.get(i + 1)){
                return true;
            }
        }
        return false;
    }


    private static Boolean checkIfIncreasingRight (ArrayList<Integer> numbers){
        for (int i = 0 ; i < numbers.size() - 1; i++){
            int diff = numbers.get(i+1) - numbers.get(i);
            if(diff == 1 || diff == 2 || diff == 3){
                return true;
            }
        }
        return false;
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
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}
