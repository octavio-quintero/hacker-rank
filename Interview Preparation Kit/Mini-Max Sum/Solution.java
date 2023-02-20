import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Problem: Mini-Max Sum
 * URL: https://www.hackerrank.com/challenges/mini-max-sum/problem
 * Difficulty: Easy
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        miniMaxSum(arr);

        bufferedReader.close();
    }

    static void miniMaxSum(List<Integer> arr) {
        long minValue = 0;
        long maxValue = 0;

        for(int i = 0; i < arr.size(); i++ ){
            long sum = 0;
            for(int j = 0; j < arr.size(); j++){
                if(i != j){
                    sum += arr.get(j);
                }
            }
            if(i == 0) {
                minValue = sum;
                maxValue = sum;
            }else {
                if (minValue > sum)
                    minValue = sum;

                if (maxValue < sum)
                    maxValue = sum;
            }
        }

        System.out.println(String.format("%s %s", minValue, maxValue));

    }
}
