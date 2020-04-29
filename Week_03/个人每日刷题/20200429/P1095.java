package leetcode.P20200429;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuchen.wu on 2020-04-29
 */

public class P1095 {

    List<Integer> re = new ArrayList<>();


    public int findInMountainArray(int target, MountainArray mountainArr) {
        int length = mountainArr.length();
        int result = findInMountainArray(target, mountainArr, 0, length - 1);
        if (result == -1 ){
            if (re.size() == 0) {
                return -1;
            }
            return re.get(0);
        }
        return result;
    }

    private int findInMountainArray(int target, MountainArray mountainArr, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (mid + 1 <= right && mountainArr.get(mid) < mountainArr.get(mid + 1)) {
            if (mountainArr.get(mid) == target) {
                return mid;
            } else if(mountainArr.get(mid) > target){
                return findInMountainArray(target, mountainArr, left, mid - 1);
            } else {
                return findInMountainArray(target, mountainArr, mid + 1, right);
            }
        } else {
            if (mountainArr.get(mid) == target) {
                re.add(mid);
            } else if (mountainArr.get(mid) > target) {
                findInMountainArray(target, mountainArr, mid + 1, right);
            }
            return findInMountainArray(target, mountainArr, left, mid - 1);
        }
    }

    interface MountainArray {

        int get(int index);

        int length();
  }

}
