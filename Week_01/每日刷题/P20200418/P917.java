package leetcode.P20200418;

/**
 * Created by yuchen.wu on 2020-04-18
 */

public class P917 {

    public String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            while (left < right && !isWord(chars[left])) {
                left++;
            }
            while (left < right && !isWord(chars[right])) {
                right--;
            }
            if (left >= right) {
                break;
            }
            char c = chars[left];
            chars[left] = chars[right];
            chars[right] = c;
            left++;
            right--;
        }
        return new String(chars);
    }

    private boolean isWord(char c) {
        if (c >= 'a' && c <= 'z') {
            return true;
        }
        if (c >= 'A' && c <= 'Z') {
            return true;
        }
        return false;
    }

}
