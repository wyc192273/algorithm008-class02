package leetcode.P20200423;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/fizz-buzz/
 * Created by yuchen.wu on 2020-04-23
 */

public class P412 {

    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (isFizz(i) && isBuzz(i)) {
                result.add("FizzBuzz");
            } else if (isFizz(i)) {
                result.add("Fizz");
            } else if (isBuzz(i)) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }

    private boolean isFizz(int n) {
        return n % 3 == 0;
    }

    private boolean isBuzz(int n) {
        return n % 5 == 0;
    }

}
