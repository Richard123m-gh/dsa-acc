package com.demo.dsa.stackQueue;

import sun.lwawt.macosx.CSystemTray;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @author Richard123m
 * @date 2020-03-03
 *
 *  增强版
 *
 *  数组实现堆栈，可以增加堆栈的长度
 *
 *  数据入栈和出栈的时间复杂度为O(1)
 *
 *
 */
public class L2_Stack {

    public static void main(String[] args) {

         HightStack hightStack=new HightStack();
         hightStack.push(1);
         hightStack.push(2);
         hightStack.push(3);
         hightStack.push(4);
         hightStack.push(5);
         hightStack.push(6);
         hightStack.push(7);
         hightStack.push(8);
         hightStack.push(9);
         hightStack.push(10);
         hightStack.push(11);

        System.out.println("栈顶元素的下标=>"+hightStack.length());
        System.out.println("栈顶元素=>"+hightStack.pop());
        System.out.println("栈的容量 =>"+hightStack.capacity());

    }


}

class HightStack{

    private Object[] elemDataArray;
    private int maxSize;
    private int topPointer;  //top 从0开始

    public HightStack(){
         elemDataArray=new Object[10];
         this.maxSize=10;
         topPointer=-1;

    }

    //压栈
    public void push(Object data){

         if((topPointer+1)==maxSize){

              if((maxSize<<1)-Integer.MAX_VALUE>0){
                  maxSize=Integer.MAX_VALUE;
              }else{
                  maxSize=maxSize <<1;  //往左移一位，表示乘以2
              }
              elemDataArray= Arrays.copyOf(elemDataArray,maxSize);
         }

         elemDataArray[++topPointer]=data;

    }

    //获取栈顶元素值
    public Object peek(){
        if(topPointer==-1) {
            throw new EmptyStackException();
        }else{
            return elemDataArray[topPointer];
        }
    }

    //实现出栈功能
    public Object pop(){
          Object object=peek();
          elemDataArray[topPointer]=null;
          this.topPointer--;
          return object;
    }

    //是否为空栈
    public boolean isEmpty(){
         return (topPointer==-1);
    }

    //是否为满栈
    public boolean isFull(){
         return (topPointer==(maxSize-1));
    }

    //栈的容量
    public int capacity(){
        return maxSize;
    }

    //栈顶元素的下标
    public int length(){
         return topPointer;
    }

}





