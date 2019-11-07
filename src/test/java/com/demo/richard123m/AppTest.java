package com.demo.richard123m;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Arrays;

/**
 * Unit test for simple App.
 */
public class AppTest {
    public static void main(String[] args) {

           int[] arr={3,8,4,0,7,1};
           int[] result=bubsort(arr);

        System.out.println(Arrays.toString(result));



    }


    public static int[] bubsort(int[] arr){

        int len=arr.length;

        for(int outter=len-1;outter>0;outter--){
            for(int inner=0;inner<outter;inner++){
                 if(arr[inner]>arr[inner+1]){
                     int temp=arr[inner];
                     arr[inner]=arr[inner+1];
                     arr[inner+1]=temp;
                 }
            }
        }

        return arr;


    }


}
