package com.demo.dsa.graph;

/**
 * @author Richard123m
 * @date 2020-05-06
 *
 *
 *
 *
 */
public class L3_Main {

    public static void main(String[] args) {

        L3_GraphTopo graphTopo=new L3_GraphTopo();
        graphTopo.insert('A');   //0
        graphTopo.insert('B');   //1
        graphTopo.insert('C');   //2
        graphTopo.insert('D');   //3
        graphTopo.insert('E');   //4
        graphTopo.insert('F');   //5


        graphTopo.addEdge(0,1);
        graphTopo.addEdge(1,2);
        graphTopo.addEdge(2,3);
        graphTopo.addEdge(3,4);
        graphTopo.addEdge(4,5);
        graphTopo.addEdge(0,5);
        graphTopo.addEdge(1,5);
        graphTopo.addEdge(1,3);
        graphTopo.addEdge(3,5);

        graphTopo.topo();


    }


}
