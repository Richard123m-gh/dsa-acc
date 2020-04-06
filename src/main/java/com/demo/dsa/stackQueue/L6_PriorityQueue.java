package com.demo.dsa.stackQueue;

/**
 * @author Richard123m
 * @date 2020-03-12
 *
 *
 *   优先队列，可以排序的
 *
 */
public class L6_PriorityQueue {

    public static void main(String[] args) {

        PriorityQueue priorityQueue=new PriorityQueue(16);
        priorityQueue.insert(1);
        priorityQueue.insert(100);
        priorityQueue.insert(23);

        while (!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.peek());
        }





    }


}

class PriorityQueue{

    private int[] elementArray;
    private int maxSize;
    private int nElms;  //实际存在的元素个数

    public PriorityQueue(int size){
         elementArray=new int[size];
         maxSize=size;
         nElms=0;
    }

    //插入数据
    public void insert(int data){

        if(nElms==0){
             elementArray[nElms++]=data;
        }else{

             int index=nElms-1;
             while (index>=0 && data>elementArray[index]){
                   elementArray[index+1]=elementArray[index];
                   index--;
             }
             elementArray[index+1]=data;
             nElms++;

        }

    }


    //取数,从小到大取,因为nElms初始值为0
    public int peek(){
        if(nElms>0){
            return elementArray[(nElms--)-1];
        }else{
             return -1;
        }
    }

    //移除数据
    public int remove(){
        if(nElms>0){
            int removeData=elementArray[nElms-1];
            elementArray[nElms-1]=-1; //表示删除
            nElms--;
            return removeData;
        }else{
             return -1;
        }
    }

    public boolean isEmpty(){
        return nElms==0;
    }


}


