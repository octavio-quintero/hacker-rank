import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Problem: Time Conversion
 * URL: https://www.hackerrank.com/challenges/time-conversion/problem
 * Difficulty: Easy
 */
public class Solution {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

     static String timeConversion(String s) throws ParseException {

        DateFormat notMilitarFormat = new SimpleDateFormat("hh:mm:ssaa");
        DateFormat militarFormat = new SimpleDateFormat("HH:mm:ss");

        Date time = notMilitarFormat.parse(s);
        String  result = militarFormat.format(time);

        return  result;
    }
}