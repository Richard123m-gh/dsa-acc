package com.demo.dsa.graph;

/**
 * @author Richard123m
 * @date 2020-05-12
 *
 *  最短路径问题
 *
 */
public class L5_Main {

    public static void main(String[] args) {

           L5_Graph graph=new L5_Graph();
           graph.insert('A');  //0
           graph.insert('B');  //1
           graph.insert('C');  //2
           graph.insert('D');  //3
           graph.insert('E');  //4

           graph.addEdge(0,1,50);   // AB 50
           graph.addEdge(0,3,80);   // AD 80
           graph.addEdge(1,2,60);   // BC 60
           graph.addEdge(1,3,90);   // BD 90
           graph.addEdge(2,4,40);   // CE 40
           graph.addEdge(3,2,20);   // DC 20
           graph.addEdge(3,4,70);   // DE 70
           graph.addEdge(4,1,50);   // EB 50

           graph.path();


    }

}
