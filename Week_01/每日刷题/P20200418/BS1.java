package leetcode.P20200418;

/**
 *  https://leetcode-cn.com/problems/na-ying-bi/
 * Created by yuchen.wu on 2020-04-18
 */

public class BS1 {

    /**
     * @param coins
     * @return
     */
    public int minCount(int[] coins) {
        int result = 0;
        for (int coin : coins) {
            if (coin % 2 == 0) {
                result += coin / 2;
            } else {
                result += coin / 2 + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new BS1().minCount(new int[] {4,2,1}));
        System.out.println(new BS1().minCount(new int[] {2,3,10}));
    }

}
