package leetcode.P20200427;

/**
 * Created by yuchen.wu on 2020-04-27
 */

public class Heap {

    private int[] array;
    private int count;

    public Heap(int size) {
        array = new int[size];
    }

    /**
     * O(logn)
     * @param i
     */
    public void insert(int i) {
        if (count >= array.length) {
            throw new RuntimeException("out memory");
        }
        array[count] = i;
        heapifyUp(count);
        count++;
    }

    /**
     * O(logn)
     * @return
     */
    private int deleteMax() {
        int num = array[0];
        array[0] = array[--count];
        array[count] = 0;
        heapifyDown(0);
        return num;
    }

    private void heapifyDown(int index) {
        int left = getLeftChidlren(index);
        if (left >= count) {
            return;
        }
        int right = getRightChidlren(index);
        if (right >= count || array[left] > array[right]) {
            if (array[left] < array[index]) {
                return;
            }
            int temp = array[left];
            array[left] = array[index];
            array[index] = temp;
            heapifyDown(left);
        } else {
            if (array[right] < array[index]) {
                return;
            }
            int temp = array[right];
            array[right] = array[index];
            array[index] = temp;
            heapifyDown(right);
        }
    }

    private int getParent(int index) {
        return (index - 1) / 2;
    }

    private int getLeftChidlren(int index) {
        return index * 2 + 1;
    }

    private int getRightChidlren(int index) {
        return index * 2 + 2;
    }

    private void heapifyUp(int index) {
        int parent = getParent(index);
        if (parent == index) {
            return;
        }
        if (array[parent] > array[index]) {
            return;
        }
        int temp = array[parent];
        array[parent] = array[index];
        array[index] = temp;
        heapifyUp(parent);
    }



    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        heap.deleteMax();
        heap.deleteMax();
        heap.deleteMax();
        heap.deleteMax();
    }
}
