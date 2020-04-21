package com.demo.dsa.recursion;

/**
 * @author Richard123m
 * @date 2020-04-20
 *
 *  递归
 *
 *  阶乘
 *  0！=1
 *  因为 1!=1!*0!=1，推导 0!=1
 *
 */
public class L1_factorical {

    public static void main(String[] args) {

           //用for实现阶乘
           int result=factoricalFor(5);
           System.out.println("5的阶乘=>"+result);

           //用递归实现
           int result2=factorialByRecursion(5);
           System.out.println("5的阶乘=>"+result2);

    }



    private static int factoricalFor(int n){

           if(n>=0){
                int result=1;
                for(int i=1;i<=n;i++){
                    result=result*i;
                }
                return result;

           }else {
               return -1;
           }
    }



    //n!=n*(n-1)!
    private static int  factorialByRecursion(int n){

          if(n<0) return -1;

          if(n==0){
               return 1;
          }else{
               return n* factorialByRecursion(n-1);
          }


    }



}
