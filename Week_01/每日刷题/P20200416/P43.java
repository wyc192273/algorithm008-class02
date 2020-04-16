package leetcode.P20200416;

/**
 * https://leetcode-cn.com/problems/multiply-strings/submissions/
 * Created by yuchen.wu on 2020-04-16
 */

public class P43 {

    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        num1 = reverse(num1, 0, num1.length() - 1);
        num2 = reverse(num2, 0, num2.length() - 1);

        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int[] ans = new int[num1.length() + num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                ans[i + j] += (chars1[i] - '0') * (chars2[j] - '0');
            }
        }

        for (int i = 0; i < ans.length; i++) {
            if (ans[i] > 9) {
                int t = ans[i];
                ans[i] = t % 10;
                ans[i + 1] += (t / 10);
            }
        }

        int pos = ans[ans.length - 1] == 0 ? ans.length - 2 : ans.length - 1;
        StringBuilder stringBuilder = new StringBuilder();
        for (; pos >= 0; pos--) {
            stringBuilder.append(ans[pos]);
        }
        return stringBuilder.toString();
    }

    private String reverse(String s, int start, int end) {
        char[] chars = s.toCharArray();
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        return new String(chars);
    }

}
