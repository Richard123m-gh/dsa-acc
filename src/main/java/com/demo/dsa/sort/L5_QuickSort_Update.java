package com.demo.dsa.sort;

import java.util.Arrays;

/**
 * @author Richard123m
 * @date 2019-9-13
 *
 * 快速排序改造
 *
 * 基准值选中值，即选 (数组第一个数，中间数，最后一个数) 中间的那个值作为基准值。
 *
 */
public class L5_QuickSort_Update {


    public static void main(String[] args) {


        int[] array={5,4,3,2,1};


        quickSort(array,0,array.length-1);


        System.out.println(Arrays.toString(array));


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

        int base=data[left];  //基准值 如果数组的长度小于3


        int size=(right-left)+1; //待分割数组的长度
        if(size >=3){
            base=getMid(data, left, right);  //基准值仍取数组的第一个元素，但第一个元素必须是三者中的第二大数。
        }


        while (true){

            while (i<right && data[++i] < base) {}  //左指针一直往右走，直到遇到比自身大的数,遇到相同的值不停
            while (j>left && data[--j]>base){} //右指针一直往左走，直到遇到比自身小的数。相同值不停。

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


    public static int getMid(int[] data,int left,int right){

        //数组中间元素对应的索引值
        int mid=(right-left)/2+left;

        if(data[left]>data[right]){
            swap(data,left,right);
        }

        if(data[mid]>data[right]){
            swap(data,mid,right);
        }

        /*
            以上两个交换，保证三个数中最大值，放在数组后面

            三个数当中，第二大的数，应放在数组的第一位置。保证分割数组，其左右两边的子数组相等。

            即  变为  2,1,3  大数在最后，二大数在最前

         */

        if(data[left]<data[mid]){
            swap(data,left,mid);
        }


        return data[left];

    }


}
