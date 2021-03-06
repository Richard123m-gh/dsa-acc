package com.demo.dsa.graph;

/**
 * @author Richard123m
 * @date 2020-04-30
 *
 *  以该图为例
 *
 *
 *   A --- B --- C
 *   | --- D
 *   | --- E
 *
 *
 *   深度优先搜索、广度优先搜索
 *
 */
public class L1_Main {

    public static void main(String[] args) {

          L1_Graph graph=new L1_Graph();
          graph.insert('A'); //index=0
          graph.insert('B'); //index=1
          graph.insert('C'); //index=2
          graph.insert('D'); //index=3
          graph.insert('E'); //index=4


          //邻接表
          graph.addEdge(0,1);
          graph.addEdge(1,2);
          graph.addEdge(0,3);
          graph.addEdge(0,4);


          //DFS
          graph.depthFirstSearch();

          System.out.println("---------------");
          //BFS
          graph.breathFirstSearch();



    }

}
