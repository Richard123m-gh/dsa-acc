package com.demo.dsa.answer;

import java.util.Arrays;

/*
    合并两个有序数组

 */
public class L1_MergeTwoArrays {

    public static void main(String[] args) {

        int[] arr1={1,2,3,7,9};
        int[] arr2={5,6,8,10};

        int[] arr3=merge(arr1,arr2);

        System.out.println(Arrays.toString(arr3));

    }


    private static int[] merge(int[] arr1,int[] arr2){

        //变量用于存储两个集合应该被比较的索引（存入新集合就加一）
        int a = 0;
        int b = 0;
        int[] arr3 = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr3.length; i++) {
            if (a < arr1.length && b < arr2.length) {   //两数组都未遍历完，相互比较后加入
                if (arr1[a] > arr2[b]) {
                    arr3[i] = arr2[b];
                    b++;
                } else {
                    arr3[i] = arr1[a];
                    a++;
                }
            } else if (a < arr1.length) {   //arr2已经遍历完，无需比较，直接将剩余arr1加入
                arr3[i] = arr1[a];
                a++;
            } else if (b < arr2.length) {    //arr1已经遍历完，无需比较，直接将剩余arr2加入
                arr3[i] = arr2[b];
                b++;
            }
        }

        return  arr3;

    }

}
