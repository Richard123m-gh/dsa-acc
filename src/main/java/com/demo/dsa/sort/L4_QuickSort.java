package com.demo.dsa.sort;

import java.util.Arrays;

/**
 * @author Richard123m
 * @date 2019-9-13
 *
 * 快速排序
 *
 * 如果原数组是从大到小，要将其改为从小到大，其时间复杂度为O(n^2),最坏情况
 *
 */
public class L4_QuickSort {

    public static void main(String[] args) {

        int[] data=new int[]{3,1,4,1,5,9,2,6,5,3};


        quickSort(data,0,data.length-1);

        System.out.println(Arrays.toString(data));

    }


    /*
       递归

     */
    public static void quickSort(int[] data,int left,int right){

        //边界条件
        if(left >= right) {

            return;  //结束方法
        }else{
            //递归前把数组data分割成两个部分，左半部分都应小于后半部分
            int partition=partitionLR(data, left, right);  //分割后基准元素的正确位置

            //分割后，递归
            quickSort(data,left,partition-1);
            quickSort(data,partition+1,right);
        }


    }


    public static int partitionLR(int[] data,int left,int right){

           int i=left;
           int j=right+1;

           int base=data[left];  //基准值

           while (true){

               while (i<right && data[++i] < base) {}  //左指针一直往右走，直到遇到比自身大的数,遇到相同的值停
               while (j>left && data[--j]>base){} //右指针一直往左走，直到遇到比自身小的数。相同值停。

               if(i>=j) {
                   break;
               }else{   //交换数据，在两指针都停止时。
                   swap(data,i,j);
               }


           }

           /*
               第n次循环结束，如第一次后，将基准元素与右指针位置（即j）交换。
               此时两指针结束行走。如果数组是奇数，那么i=j；是偶数,i>j
            */
           swap(data,left,j);


          return j;
    }


    //数组元素交换,数组是一个引用，指向的是同一个对象，因此这里不需要返回值数组。
    public static void swap(int[] data,int i,int j){

          int temp=data[i];
          data[i]=data[j];
          data[j]=temp;

    }


}
