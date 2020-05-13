package com.demo.dsa.graph;

/**
 * @author Richard123m
 * @date 2020-05-12
 *
 *
 *
 *
 */
public class L5_Graph {

    //属于图,这种数据结构的基本的属性
    private L5_Vertex[] vertexList;   //保存的顶点的数组
    private int[][] adjMat; //邻接矩阵，保存边
    private int nVerts; //图中存在的顶点的计数器
    private final int MAX_VERTS=16;   //初始化一个图中顶点的最大的个数
    private int nTree; // 计数器，分析中有聚合S,nTree计数S中的节点个数
    private int currentVert; //循环过程中当前的顶点的指向，下标
    private final int INF=100000; //设一个很大的数
    private L5_DistanceParent[] uPath;  //相当于U集合
    private int startToCurrent; //起始点到当前节点的距离，比如 A经B到C的距离,或是址接A->C的节点



    public L5_Graph(){
        this.vertexList=new L5_Vertex[this.MAX_VERTS];
        this.adjMat=new int[this.MAX_VERTS][this.MAX_VERTS];
        for(int i=0;i<this.MAX_VERTS;i++){
            for(int j=0;j<this.MAX_VERTS;j++){
                adjMat[i][j]=INF; //初始化一个很大的数
            }
        }

        this.nTree=0;
        this.nVerts=0;
        this.uPath=new L5_DistanceParent[this.MAX_VERTS];

    }


    //向图中插入新的元素
    public void insert(char label){
        vertexList[nVerts++]=new L5_Vertex(label);
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

    }

    //输出指定顶点中的label值
    public void displayVertext(int index){
        System.out.println(vertexList[index].label);
    }

    // 最重要的核心部分，实现求解最短路径的算法
    public void path(){

         //1. 选一个节点,超始节点，下标为0的节点做起始节点
         int startNode=0;
         this.vertexList[startNode].isInTree=true; //相当于把0节点放到S集合中
         nTree ++;

         //2. 初始化U集合,以0位起点的路径和距离放到U集合，放到uPath数组中
         int tmpDis;
         for(int i=0;i<nVerts;i++){
              tmpDis=adjMat[startNode][i];
              uPath[i]=new L5_DistanceParent(tmpDis,startNode);
         }

         //3. 步骤
        int indexMin;
        int minDist;
         while (nTree < nVerts){ //nTree < nVerts -1
              // 从U集合中找最短路径的点，即从uPath数组中,找距离distance最小的元素
              indexMin=getMin(); //找到uPath数组distance值最小的元素，返回其下标
              minDist=uPath[indexMin].distance; //最小距离

              if(minDist == INF){
                  System.err.println("起始点为孤点，没有任何邻接点.");
                  break;
              }else{
                   currentVert=indexMin;
                   startToCurrent=minDist;
              }

              //找到最短的点，放到S集合中
             vertexList[currentVert].isInTree=true;
             nTree ++;

             // 调整uPath数组，即更新U集合
             adjust_uPath();
         }

         // 算法的结果上面的循环，得到了
         displayPaths();

         //isInTree还原
         nTree=0;
         for(int i=0;i<nVerts;i++){
             vertexList[i].isInTree=false;
         }

    }

    //找到uPath数组distance值最小的元素，返回其下标
    private int getMin(){

         int minDist=INF;
         int indexMin=0;
         for(int i=0;i<nVerts;i++){
              if(!vertexList[i].isInTree
                    && uPath[i].distance < minDist){

                   minDist=uPath[i].distance;
                   indexMin=i;
              }
         }


         return indexMin;
    }

    //if('B到D,C,E的距离' + 'AB距离' < 'A到D，C，E的距离')则更新U里的对应数据。
    private void adjust_uPath(){

          int j=1;  //从1开始循环，跳晕了起点0
          while (j<nVerts){

              //如果扫描到的点，如果在S集合，跳过
              if(vertexList[j].isInTree){
                  j++;
                  continue;
              }

              //上面的if过滤后，剩下的点，就都是U集合里的点
              //拿到上个距离
              int currentToj=adjMat[currentVert][j];
              int startToj=startToCurrent + currentToj; //左边的距离
              int rightDis=uPath[j].distance;

              if(startToj < rightDis){

                   //更新对应数据
                   uPath[j].parentVert=currentVert;
                   uPath[j].distance=startToj;
              }
              j++;
          }

    }

    //输出结果
    private void displayPaths(){

         for(int j=0;j<nVerts;j++){
             //到目标节点
             System.out.print(vertexList[j].label+"=");

             //从起始到目标点之间的最短的距离
             if(uPath[j].distance==INF){
                 System.out.print("inf");
             }else{
                 System.out.print(uPath[j].distance);
             }

             char parent=vertexList[uPath[j].parentVert].label;
             System.out.print("(经过点:"+parent+")");

             System.out.println();
         }
    }



}
