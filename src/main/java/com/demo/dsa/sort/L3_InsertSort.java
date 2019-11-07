package com.demo.dsa.sort;

import com.demo.dsa.array.L1_DisorderArray;

/**
 * @author Richard123m
 * @date 2019-09-03
 *
 *  插入排序
 *
 */
public class L3_InsertSort {

    public static void main(String[] args) {
        L1_DisorderArray disorderArray=new L1_DisorderArray(100);

        disorderArray.insert(11);
        disorderArray.insert(14);
        disorderArray.insert(22);
        disorderArray.insert(78);
        disorderArray.insert(9);
        disorderArray.insert(7);
        disorderArray.insert(88);

        //原数组
        disorderArray.display();


        long[] arr_src=disorderArray.getArr();
        int nElems=disorderArray.getnElems();
        System.out.println("nElems=>"+nElems);

        //排序后数组
        long[] arr=insertSort(arr_src,nElems);


        for(int i=0;i<nElems;i++){
            System.err.println(arr[i]);
        }


    }



    private static long[] insertSort(long[] arr,int nElems){

          int outer;
          int inner;
          long temp;

          for(outer=1;outer<nElems;outer++){
              inner=outer;

              temp=arr[outer];
              while (inner>0 && arr[inner-1] > temp){
                  arr[inner]=arr[inner-1];
                  --inner;
              }

              //把temp的值插入回来
              arr[inner]=temp;


          }


          return arr;



    }



}
