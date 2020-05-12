package com.demo.dsa.graph;

/**
 * @author Richard123m
 * @date 2020-05-12
 */
public class L5_Vertex {

    public char label;
    public boolean isInTree; //顶点在最小生成树里面，为true，不在为false

    public L5_Vertex(char label){
        this.label=label;
        this.isInTree=false;
    }


}
