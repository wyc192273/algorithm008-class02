package leetcode2.P20200608;

/**
 * https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 * Created by yuchen.wu on 2020-06-08
 */

public class Pms17 {

    int index = 0;

    public int[] printNumbers(int n) {
        int[] res = new int[(int) Math.pow(10, n) - 1];
        printNumbers(new int[n], 0, n, res);
        return res;
    }

    private void printNumbers(int[] chars, int i, int n, int[] res) {
        if (i == n) {
            int nu = getNumber(chars);
            if (nu == 0) {
                return;
            }
            res[index++] = nu;
            return;
        }
        for (int j = 0; j < 10; j++) {
            chars[i] = j;
            printNumbers(chars, i + 1, n, res);
        }
    }

    private int getNumber(int[] chars) {
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            res *= 10;
            res += chars[i];
        }
        return res;
    }

    public int[] printNumbers2(int n) {
        int[] res = new int[(int) Math.pow(10, n) - 1];
        printNumbers2("", 0, n, res);
        return res;
    }

    private void printNumbers2(String number, int i, int n, int[] res) {
        if (i == n) {
            int nu = Integer.parseInt(number);
            if (nu == 0) {
                return;
            }
            res[index++] = nu;
            return;
        }
        for (int j = 0; j < 10; j++) {
            printNumbers2(number + (char)(j + '0'), i + 1, n, res);
        }
    }

    public static void main(String[] args) {
        int[] res = new Pms17().printNumbers(3);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

}
