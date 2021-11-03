package com.feichai.basejar.leetcode;

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
        int a = 0,b = 0;
        int sum = 0;
        int o , s;
        int res[] = new int[10];
        for (int i = 0; i < 1000 * 1000 ; i++) {
            if ((i+1) >= nums1.length && (i+1) >= nums2.length){
                break;
            }

            if ((i+1) < nums1.length) {
                a = nums1[i];
            }
            if ((i+1) < nums2.length) {
                b = nums2[i];
            }

            if (a == b){
                res[i] = a;
                continue;
            }
            if (a > b){
                res[i] = b;
            }
            if (a < b ){
                res[i] = a;
            }
        }
        sum = res.length;

        if (sum % 2 == 0){
            o = sum / 2;
            s = (sum / 2) + 1;
            return (res[o] + res[s]) / 2.0;
        }else{
            return res[(sum / 2) + 1];
        }
    }
}
