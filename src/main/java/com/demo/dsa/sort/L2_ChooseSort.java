package com.demo.dsa.sort;

import com.demo.dsa.array.L1_DisorderArray;

/**
 * @author Richard123m
 * @date 2019-09-03
 *
 * 选择排序
 *
 */
public class L2_ChooseSort {

    public static void main(String[] args) {

        L1_DisorderArray disorderArray=new L1_DisorderArray(100);

        disorderArray.insert(11);
        disorderArray.insert(14);
        disorderArray.insert(22);
        disorderArray.insert(78);
        disorderArray.insert(9);
        disorderArray.insert(7);
        disorderArray.insert(17);

        //原数组
       // disorderArray.display();


        long[] arr_src=disorderArray.getArr();
        int nElems=disorderArray.getnElems();
        //System.out.println("nElems=>"+nElems);

        //排序后的数组
        long[] arr=chooseSort(arr_src,nElems);

        for(int i=0;i<nElems;i++){
            System.err.println(arr[i]);
        }

    }


   private static long[] chooseSort(long[] arr,int nElems){

        int outer;
        int inner;
        int min;

        for(outer=0;outer<nElems-1;outer++){
            min=outer;  //每次循环初始化min指向outer的位置，剩下元素中的第一个
            for(inner=outer+1;inner<nElems;inner++){
                 if(arr[min] > arr[inner]){
                     min=inner;
                 }
            }//每次循环完后，min指向的元素才是剩下元素中最小的元素。

            //找到最小元素后，和outer指向的元素交换位置
            long temp=arr[outer];
            arr[outer]=arr[min];
            arr[min]=temp;

        }



        return arr;

   }




}
