package com.demo.dsa.stackQueue;

import java.util.ArrayDeque;

/**
 * @author Richard123m
 * @date 2020-03-09
 *
 * 双向队列
 *
 **/
public class L5_DeQueue {


    public static void main(String[] args) {

        /*
           jdk中的双向队列
           ArrayDeque 按位与，取模
         */



    }



}

class DoubleEndedQueue{

    //存放数据的数组
    private Object[] elementsArray;

    //队列的最大长度
    private int maxSize;

    //队列的头部下标
    private int head;

    //队列的尾部下标
    private int tail;

    public DoubleEndedQueue() {
        /*
            初始长度为2的倍数，按位与的时候，就可以将其限定在长度范围内。

            比如16，其范围为0-15
            elementsArray.length=15，二进制表示为1111，前面为n个0.
            无论是哪个与其与，其出现1的位置只可能在低4位，即1111上，因为前面全是0.
            因此其长度应为2的倍数，以便做成这种效果。

         */
        maxSize=16;
        elementsArray=new Object[maxSize]; //最初大小为16
        head=0;
        tail=0; //只有为空队列的时候，头尾指针才相等

    }

    /*
        指针位置
        取模运算,实现指针在数组中无限的循环

        即在边界时，在尾部右移至头部，即由下标n转为下标0；
        在头部左移时至尾部，即由下标0转为下标n
     */
    public int getMod(int index){

          if(index<0){
              index=index+maxSize;
          }

          if(index>=maxSize){
              index=index-maxSize;
          }

          return index;
    }

    //在头部插入元素
    public void addHead(Object data){

        this.head=getMod(head-1); //指针左移一位，取真正的指针位置

        elementsArray[head]=data;

        if(head==tail){//队列已满，扩容

        }

    }

    //在尾部插入
    public void addTail(Object data){

        //先把数据插入
        elementsArray[tail]=data;
        tail=getMod(tail+1); //尾部指针，向右移动一位

        if(tail==head){  //队列已满，进行扩容

        }

    }

    //在头部移除
    public Object removeHead(){

        Object removeObj=null;

         //判断是否为空队列
        if(head!=tail){
            removeObj=elementsArray[head];
            elementsArray[head]=null;
            head=getMod(head+1);
        }

        return removeObj;

    }


    //删除尾部数据
    public Object removeTail(){
        Object removeObj=null;

        //判断队列是否为空
        if(head!=tail){
            tail=getMod(tail-1);
            removeObj=elementsArray[tail];
            elementsArray[tail]=null;
        }

        return removeObj;
    }


    //只获取头部的元素，不删除
    public Object peekHead(){
         if(tail!=head){
             return elementsArray[head];
         }else {
             return null;
         }
    }

    //只获取尾部元素，不删除
    public Object peekTail(){
        if(head!=tail){
            return elementsArray[getMod(tail-1)];
        }else{
            return null;
        }
    }


}


