package com.demo.dsa.sort;

import com.demo.dsa.array.L1_DisorderArray;


/**
 *
 * @author Richard123m
 * @date  2019-09-03
 *
 *  冒泡排序
 *
 */
public class L1_bubSort {


    public static void main(String[] args) throws Exception{

        L1_DisorderArray disorderArray=new L1_DisorderArray(100);

        disorderArray.insert(11);
        disorderArray.insert(14);
        disorderArray.insert(22);
        disorderArray.insert(78);
        disorderArray.insert(9);
        disorderArray.insert(7);
        disorderArray.insert(17);

        //原数组
        disorderArray.display();


        long[] arr_src=disorderArray.getArr();
        int nElems=disorderArray.getnElems();
        System.out.println("nElems=>"+nElems);

        //排序后数组
        long[] arr=bubSort(arr_src,nElems);


        for(int i=0;i<nElems;i++){
            System.err.println(arr[i]);
        }

    }



  //从小到大
    public static long[] bubSort(long[] arr,int nElems){

         int outer;  //外循环,数组元素的个数
         int inner;   //内循环，每一轮循环的次数


         for(outer=nElems-1;outer>0;outer--){
             for(inner=0;inner<outer;inner++) {
                  if(arr[inner]>arr[inner+1]){  //前面的元素比后面的元素大，交换位置
                      long temp=arr[inner];
                      arr[inner]=arr[inner+1];
                      arr[inner+1]=temp;
                  }
             }
             inner=0; //下一次循环重置为0
         }

        return arr;

    }


}
