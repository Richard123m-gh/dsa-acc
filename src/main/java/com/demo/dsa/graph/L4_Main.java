package com.demo.dsa.graph;

/**
 * @author Richard123m
 * @date 2020-05-08
 *
 *  带权值的最小生成树
 *
 *  所有边的权值之和最小
 *
 */
public class L4_Main {

    public static void main(String[] args) {

        L4_WGraph wGraph=new L4_WGraph();
        wGraph.insert('A'); //0
        wGraph.insert('B'); //1
        wGraph.insert('C'); //2
        wGraph.insert('D'); //3
        wGraph.insert('E'); //4
        wGraph.insert('F'); //5

        wGraph.addEdge(0,1,6); //AB 6
        wGraph.addEdge(0,3,4); //AD 4
        wGraph.addEdge(1,2,10); //BC 10
        wGraph.addEdge(1,3,7);  //BD 7
        wGraph.addEdge(1,4,7);  //BE 7
        wGraph.addEdge(2,3,8);  //CD 8
        wGraph.addEdge(2,4,5);  //CE 5
        wGraph.addEdge(2,5,6);  //CF 6
        wGraph.addEdge(3,4,12); //DE 12
        wGraph.addEdge(4,5,7);  //EF 7


        wGraph.mstw();
    }
}
