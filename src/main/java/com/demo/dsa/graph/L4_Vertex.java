package com.demo.dsa.graph;

/**
 * @author Richard123m
 * @date 2020-05-08
 *
 *  顶点类
 *
 */
public class L4_Vertex {

   public char label;
   public boolean isInTree; //顶点在最小生成树里面，为true，不在为false

   public L4_Vertex(char label){
        this.label=label;
        this.isInTree=false;
   }


}
