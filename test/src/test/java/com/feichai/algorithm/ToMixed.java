package com.feichai.algorithm;

import java.util.Arrays;

/**
 * 求交集
 */
public class ToMixed {

    static int[] nums1 = {4,2,4,1};
    static int[] nums2 = {2,1};

    public static void main(String[] args) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
    }




}
