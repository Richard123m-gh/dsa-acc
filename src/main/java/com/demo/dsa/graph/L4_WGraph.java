package com.demo.dsa.graph;

import java.util.ArrayDeque;

/**
 * @author Richard123m
 * @date 2020-05-08
 */
public class L4_WGraph {

    //属于图,这种数据结构的基本的属性
    private L4_Vertex[] vertexList;   //保存的顶点的数组
    private int[][] adjMat; //邻接矩阵，保存边
    private int nVerts; //图中的存在的顶点的计数器
    private final int MAX_VERTS=16;   //初始化一个图中顶点的最大的个数
    private L4_PriorityQ priorityQ;
    private int nTree; //已经求解到的最小生成树的顶点的下标
    private int currentVert; //循环过程中当前的顶点的指向，下标
    private final int INF=100000; //设一个很大的数


    public L4_WGraph(){
        this.vertexList=new L4_Vertex[this.MAX_VERTS];
        this.adjMat=new int[this.MAX_VERTS][this.MAX_VERTS];
        for(int i=0;i<this.MAX_VERTS;i++){
            for(int j=0;j<this.MAX_VERTS;j++){
                adjMat[i][j]=INF; //初始化一个很大的数
            }
        }

        this.nVerts=0;
        this.priorityQ=new L4_PriorityQ();

    }


    //向图中插入新的元素
    public void insert(char label){
        vertexList[nVerts++]=new L4_Vertex(label);
    }

    /**
     *
     * @param start  开始的节点
     * @param end    结束的节点
     *
     *   有了顶点后，更新边，设置哪个顶点与哪个顶点是连接的
     *    有权重
     *
     */
    public void addEdge(int start,int end,int price){

        //这里为有向图，一个边从头到尾，以及从尾到头为两个边
        adjMat[start][end]=price;
        adjMat[end][start]=price;

    }

    //输出指定顶点中的label值
    public void displayVertext(int index){
        System.out.println(vertexList[index].label);
    }

    //核心重点，实现求解带权值的图的最小生成树，结果找到。输出
    public void mstw(){

    }



}
