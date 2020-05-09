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
    private int nVerts; //图中存在的顶点的计数器
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

         //步骤1，任意选择一个顶点，一般选择下标是0的顶点
         currentVert=0;
         while (nTree<nVerts-1){
             vertexList[currentVert].isInTree=true;  //相当于分析的时候，将引顶点放入U选中集合
             nTree++;

             for(int i=0;i<nVerts;i++){
                   if(i==currentVert) continue; //遍历到自身，不做操作
                   if(vertexList[i].isInTree) continue; //遍历到点，本身已在U集合中
                   int price=adjMat[currentVert][i]; //取权值
                   if(price==INF) continue; //两点不连接，不做操作

                   //剩下的情况，就是当前点的邻接点
                   priorityQ.insert(new L4_Edge(currentVert,i,price));

             }

             //小细节
             if(priorityQ.getSize()==0){
                 System.out.println("出错了，当前顶点，一个邻接点都没有，也就没有最小生成树");
                 return;  //结束方法
             }



             //要把已经放到U集合中的顶点，为边的顶点和终点的边，即一个边的两个项点在U集合中，那么这个边应从优先队列中删除
             for(int i=0;i<priorityQ.getSize();i++){
                 if(vertexList[priorityQ.peekN(i).startVert].isInTree
                     && vertexList[priorityQ.peekN(i).endVert].isInTree){

                     priorityQ.removeN(i);   //比如，第二步会删掉BD间的边

                 }
             }


             L4_Edge minEdge=priorityQ.removeMin(); //拿到权值最小的边
             int startV=minEdge.startVert;
             currentVert=minEdge.endVert;


             //输出找到的边，相当于把目标边，放到分析中把到TE集合
             System.out.println(vertexList[startV].label+" -> "+vertexList[currentVert].label+", 权值最小边的结束顶点->"+currentVert);

         }


         //上面循环把所有顶点的isInTree=true,还原它
        for(int i=0;i<nVerts;i++){
            vertexList[i].isInTree=false;
        }


    }



}
