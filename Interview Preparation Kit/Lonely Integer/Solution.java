import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = lonelyInteger(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
    
    public static int lonelyInteger(List<Integer> numbers) {
        int result = 0;
        
        //The operator will compare bit by bit with previous number
        //the result will be a new number, if both numbers are same the result 
        //will be 0, if are no equals will result in another number
        //at the end the result will be the unique number in the 
        //array.
        //This operator will works like elimination process when 2 numbers are equals 
        //and will be 0.
        for(int number : numbers){
           
            result ^= number;
        }
        
        return result;
    }
}

