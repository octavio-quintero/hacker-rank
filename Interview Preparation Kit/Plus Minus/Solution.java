import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Problem: Plus Minus
 * URL: https://www.hackerrank.com/challenges/plus-minus/problem
 * Difficulty: Easy
 */
public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        plusMinus(arr);

        bufferedReader.close();
    }

    static void plusMinus(List<Integer> arr) {
        final int DECIMALS = 6;
        int positiveCounter = 0;
        int negativeCounter = 0;
        int zeroCounter = 0;
        BigDecimal totalNumbers = new BigDecimal(arr.size());

        for(int number : arr){
            if(number > 0){
                positiveCounter++;
            }else if(number < 0){
                negativeCounter++;
            } else {
                zeroCounter++;
            }
        }

        BigDecimal positiveDecimal = new BigDecimal(positiveCounter);
        BigDecimal negativeDecimal = new BigDecimal(negativeCounter);
        BigDecimal zeroDecimal = new BigDecimal(zeroCounter);

        System.out.println(positiveDecimal.divide(totalNumbers,DECIMALS, RoundingMode.FLOOR));
        System.out.println(negativeDecimal.divide(totalNumbers,DECIMALS, RoundingMode.FLOOR));
        System.out.println(zeroDecimal.divide(totalNumbers,DECIMALS, RoundingMode.FLOOR));
    }
}