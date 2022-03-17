package com.feichai.leetcode;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 */
public class Four {

    static int[] nums1 = new int[]{1,2};

    static int[] nums2 = new int[]{3};


    public static void main(String[] args) {
       double d = findMedianSortedArrays(nums1,nums2);
        System.out.println(d);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int a =0 ,b = 0;
        a = nums1.length;
        b = nums2.length;
        int k = a + b;

        for (int i = 0; i < k/2; i++) {

        }

        return 1.0;
    }
}
