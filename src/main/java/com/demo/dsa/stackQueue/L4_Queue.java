package com.demo.dsa.stackQueue;

/**
 * @author Richard123m
 * @date 2020-03-07
 *
 *  单向队列
 *
 *  循环
 *
 */
public class L4_Queue {

    public static void main(String[] args) {

           MyQueue myQueue=new MyQueue(3);
           myQueue.insert(1);
           myQueue.insert(2);
           myQueue.insert(3);

           while (!myQueue.isEmpty()){
               System.out.println("读==>"+myQueue.remove());
           }


    }

}


class MyQueue{

     private Object[] eleDataArray;
     private int maxSize;   //数组的最大长度，容量
     private int rear;   //队尾指针
     private int front;  //队头指针
     private int nElems; //队列中数据元素的个数

    public MyQueue(int maxSize) {
        this.maxSize = maxSize;
        eleDataArray=new Object[maxSize];
        rear=-1;
        front=0;
        nElems=0;
    }


    //插入
    public void insert(Object data){

        //判断队列是否满了
        if(nElems >= maxSize){
            System.err.println("队列已满，禁止插入!");
        }else{

            if((rear+1)==maxSize){ //循环的单身队列
                rear=-1;
            }
            eleDataArray[++rear]=data;
            nElems++;
        }
    }

    //查看
    public Object peek(){
        //判断是否为空队列
        if(nElems==0){
            return null;
        }else{
            return eleDataArray[front];
        }
    }

    //出队，移出
    public Object remove(){

        Object removeObj=null;
        if(nElems!=0){
            removeObj=eleDataArray[front];
            eleDataArray[front]=null;
            nElems--;
            if((front+1)==maxSize){
                 front=0;
            }else{
                 front++;
            }
        }

        return removeObj;
    }


    //判断队列是不是空队列
    public boolean isEmpty(){
          return nElems==0;
    }


    //判断队列是否为满队列
    public boolean isFull(){
         return (nElems==maxSize);
    }

    //返回队列的大小
    public int getSize(){
        return nElems;
    }

}

