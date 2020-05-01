package com.demo.dsa.graph;

import java.util.ArrayDeque;

/**
 * @author Richard123m
 * @date 2020-05-01
 *
 * 最小生成树  Minimum Spanning Trees
 *
 * 由深度优先搜索改变而成
 *
 */
public class L2_MST {

    //属于图,这种数据结构的基本的属性
    private L1_Vertex[] vertexList;   //保存的顶点的数组
    private int[][] adjMat; //邻接矩阵，保存边
    private int nVerts; //图中的存在的顶点的计数器
    private ArrayDeque stack; //实现深度优先搜索用的栈
    private ArrayDeque queue; //实现广度优先搜索的队列
    private final int MAX_VERTS=16;   //初始化一个图中顶点的最大的个数

    public L2_MST(){
        this.vertexList=new L1_Vertex[this.MAX_VERTS];
        this.adjMat=new int[this.MAX_VERTS][this.MAX_VERTS];
        for(int i=0;i<this.MAX_VERTS;i++){
            for(int j=0;j<this.MAX_VERTS;j++){
                adjMat[i][j]=0;
            }
        }

        this.nVerts=0;

        this.stack=new ArrayDeque();
        this.queue=new ArrayDeque();
    }


    //向图中插入新的元素
    public void insert(char label){
        vertexList[nVerts++]=new L1_Vertex(label);
    }

    /**
     *
     * @param start  开始的节点
     * @param end    结束的节点
     *
     *   有了顶点后，更新边，设置哪个顶点与哪个顶点是连接的
     *
     */
    public void addEdge(int start,int end){

        //这里要更新两部分
        adjMat[start][end]=1;
        adjMat[end][start]=1;
    }

    //输出指定顶点中的label值
    public void displayVertext(int index){
        System.out.print(vertexList[index].label);
    }


    //深度优先搜索方法。DFS
    public void depthFirstSearch(){
        // 首先访问的顶点中的第一个顶点
        vertexList[0].isVistied=true;
      //  displayVertext(0);
        this.stack.push(0);

        while (!this.stack.isEmpty()){
            //获取当前顶点的下标
            int currentVert=(Integer)this.stack.peek();

            /*
               根据这个下标进一步的，找当前顶点的其他没有访问过的邻接顶点
               如果没找到，返回-1
             */
            int v=getAdjUnvisited(currentVert);

            //表示当前顶点的邻接顶点，全部都已访问过了
            if(v==-1){
                this.stack.pop();
            }else {
                vertexList[v].isVistied=true;
                displayVertext(currentVert);   //加入
                displayVertext(v);
                System.out.println();
                this.stack.push(v);
            }
        }


        //还原所有顶点的标记。
        for(int i=0;i<nVerts;i++){
            vertexList[i].isVistied=false;
        }

    }


    //获取当前节点未访问的邻接顶点
    private int getAdjUnvisited(int currentVert){
        for(int i=0;i<nVerts;i++){
            //这里核心的判断，判断遍历的顶点和当前的顶点v是不是邻接的
            if(adjMat[currentVert][i]==1 && !vertexList[i].isVistied){
                return i;  //是要找的目标顶点,返回其在vertexList中的下标。
            }
        }

        return -1;  //表示当前顶点已经没有了邻接顶点.
    }








}
