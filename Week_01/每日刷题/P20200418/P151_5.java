package leetcode.P20200418;

/**
 * Created by yuchen.wu on 2020-04-18
 */

public class P151_5 {

    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left <= right && chars[left] == ' ') {
            left++;
        }
        while (left <= right && chars[right] == ' ') {
            right--;
        }
        if (left > right) {
            return "";
        }
        if (left == right) {
            return "" + s.charAt(left);
        }
        reverseWord(chars, left, right);
        int charLeft = left;
        int nextLeft = left + 1;
        while (nextLeft < right) {
            if(chars[nextLeft] == ' ') {
                reverseWord(chars, left, nextLeft -1);
                nextLeft++;
                left = nextLeft;
                continue;
            }
            nextLeft++;
        }
        reverseWord(chars, left, nextLeft);
        StringBuilder result = new StringBuilder();
        for (int i = charLeft; i <= right; i++) {
            if (chars[i] == ' ' && chars[i - 1] == ' ') {
                continue;
            }
            result.append(chars[i]);
        }
        return result.toString();
    }

    private void reverseWord(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        System.out.println(new P151_5().reverseWords("the sky is blue"));
    }

}
