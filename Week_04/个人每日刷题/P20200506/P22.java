package leetcode.P20200506;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 * Created by yuchen.wu on 2020-05-06
 */

public class P22 {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateHelp(n, n, result, "", n);
        return result;
    }

    private void generateHelp(int left, int right, List<String> result, String str, int n) {
        if (left == 0 && right == 0) {
            result.add(str);
            return;
        }
        if (right <= 0 || left < 0 || right < left ) {
            return;
        }
        generateHelp(left - 1, right, result, str + "(", n);
        generateHelp(left, right - 1, result, str + ")", n);
    }

}
