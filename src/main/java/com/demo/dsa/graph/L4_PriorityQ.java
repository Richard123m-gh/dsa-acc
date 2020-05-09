package com.demo.dsa.graph;

/**
 * @author Richard123m
 * @date 2020-05-08
 *
 *  全部边放在一个优先级队列
 *
 */
public class L4_PriorityQ {

       private L4_Edge[] edgeArray;       //不是普通数组，有序的，从大到小排列。
       private final int MAX_SIZE=20;  //上面数组的默认长度
       private int size;  //上面数组中真实保存着的边的条数

       public L4_PriorityQ(){
            this.edgeArray=new L4_Edge[MAX_SIZE];
            this.size=0;
       }

       //向队列中插入新的边
       public void insert(L4_Edge edge){  //按照从大到小的有序的插入

            int i;
            for(i=0;i<size;i++){
                  if(edge.price >= edgeArray[i].price) {
                      break;
                  }
            }

            //循环完毕后，i停留在新边应该插入的位置，数组中i和i后面的元素后移，i的位置让了出来
            for(int j=size-1;j>=i;j--){
                edgeArray[j+1]=edgeArray[j];
            }

            //循环完了,i的位置空出来了
           edgeArray[i]=edge; //保证edges是一个从在大到小的有序数组

           size++;

       }

       //删除并获取到队列中最小的权的边
       public L4_Edge removeMin(){
            return edgeArray[--size];
       }

       //删除指定下标的边
       public void removeN(int n){
            for(int i=n;i<size-1;i++){
                 edgeArray[i]=edgeArray[i+1];
            }
            size--;
       }

       //获取最小的边，不删除
       public L4_Edge peekMin(){
            return edgeArray[size-1];
       }

       //获取队列是不是空id
       public boolean isEmpty(){
           return (size==0);
       }

       //获取队列中的元素个数
       public int getSize(){
            return size;
       }

       //获取指定下标的边
       public L4_Edge peekN(int n){
           return edgeArray[n];
       }

}
