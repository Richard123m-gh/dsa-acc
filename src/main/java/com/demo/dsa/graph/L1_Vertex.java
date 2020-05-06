package com.demo.dsa.graph;

/**
 * @author Richard123m
 * @date 2020-04-22
 *
 *  顶点   顶点对象能放在数组中，然后用下标指示，也可以放到链表中。无论何种存储，与边如何连接点没有关系。
 *  边    用两种方式表示,邻接矩阵和邻接表
 *
 *
 *
 *
 */
public class L1_Vertex {

      public char label;     //顶点内
      public boolean isVistied;   //顶点位，表示是否被访问过。

      public L1_Vertex(char label){
             this.label=label;
             this.isVistied=false;
      }



}
