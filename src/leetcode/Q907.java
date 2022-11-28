package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Q907 {
    int MOD = (int) 1e9 + 7;

    public int sumSubarrayMins(int[] arr) {
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        Arrays.fill(left,-1);
        Arrays.fill(right,arr.length);
        Deque<Integer> q = new ArrayDeque();
        int result=0;
        for (int i = 0; i < arr.length; i++) {
            while (!q.isEmpty() && arr[q.peekLast()] >= arr[i]) {
                right[q.pollLast()] = i;
            }
            q.addLast(i);
        }
        q.clear();
        for (int i = arr.length-1; i >=0; i--) {
            while (!q.isEmpty() && arr[q.peekLast()] > arr[i]) {
                left[q.pollLast()] = i;
            }
            q.addLast(i);
        }
        for (int i = 0; i < arr.length; i++) {
            int leftNum= i-left[i];
            int rightNum=right[i]-i;
            result += leftNum * rightNum * arr[i] %MOD;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test=new int[]{3,1,2,4};
        Q907 q907 = new Q907();
        q907.sumSubarrayMins(test);
    }
}
