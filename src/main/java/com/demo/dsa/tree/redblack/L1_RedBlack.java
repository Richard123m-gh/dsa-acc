package com.demo.dsa.tree.redblack;



public class L1_RedBlack{

    private L1_Node root;


    public L1_Node getRoot() {
        return root;
    }

    public L1_RedBlack(){
        root=null; //新创建的树什么也没有
    }


    //实现左旋，是普通二叉树转红黑树真正的核心操作

    public void leftRotate(L1_Node x){
         //1. 把y节点的左子节点变为x的右子节点
         L1_Node y=x.getRightChild();
         x.setRightChild(y.getLeftChild()); //把y节点的左子节点赋值x的右子节点
         if(y.getLeftChild()!=null){
             y.getLeftChild().setParent(x);
         }

         //2.x的父节点变y的父节点
         y.setParent(x.getParent());
         if(x.getParent()==null){ //根节点
               root=y;
         }else{
              if(x==x.getParent().getLeftChild()){
                  x.getParent().setLeftChild(y);  //真正实现x父节点变成y的父节点地主
              }else{
                  x.getParent().setRightChild(y);
              }
         }

         //3.y的左子节点变成x,y变x的父节点
         y.setLeftChild(x);
         x.setParent(y);

    }



    //实现右旋
    public void rightRotate(L1_Node y){

        //先拿到x节点
        L1_Node x=y.getRightChild();

        //1.把x的右子节点变为y的左子节点
        y.setLeftChild(x.getRightChild());

        if(x.getRightChild()!=null){
           x.getRightChild().setParent(y);
        }

        //2.把y的父节点变成x的父节点
        x.setParent(y.getParent());
        if(y.getParent()==null){
            root=x;
        }else{
            if(y==y.getParent().getLeftChild()){
                y.getParent().setLeftChild(x);
            }else{
                y.getParent().setRightChild(x);
            }
        }

        //3.把y变成x的右子节点,y的父节点设置为x
        x.setRightChild(y);
        y.setParent(x);

    }


    public void insert(int data){

        L1_Node newNode=new L1_Node(true,data,null,null,null);//默认插入红色节点
        if(root==null){
             root=newNode;
             root.setColor(false);  //根节点为黑色
             return;
        }else{
              L1_Node current=root;
              L1_Node parentNode=null;
              while (current!=null){
                  parentNode=current;
                  if(data<current.getData()){
                      current=current.getLeftChild();
                      if(current==null){
                           parentNode.setLeftChild(newNode);
                           newNode.setParent(parentNode);
                      }else{
                          current=current.getRightChild();
                          if(current==null){
                              parentNode.setRightChild(newNode);
                              newNode.setParent(parentNode);
                          }
                      }
                  }
              }
        }


        //新节点插入后，可能会破坏掉树的平衡，检查红黑色规则，如果不符合红黑，纠正
        insertFixup(newNode);








    }

    //纠正
    private void insertFixup(L1_Node node){
         L1_Node parent;
         L1_Node grandfather;
         L1_Node uncle;

         //修正违反红黑规则的节点:父节点不为空且颜色为红色
         while((parent=node.getParent())!=null && parent.getColor()){
             //祖父节点
             grandfather=parent.getParent();


             //判断当前节点是父节点的左子节点还是右子节点
              if(parent==grandfather.getLeftChild()){
                   uncle=grandfather.getRightChild();

                   //第一种情况,parent是红的,uncle也是红的
                   if(uncle!=null && uncle.getColor()){
                       parent.setColor(false);
                       uncle.setColor(false);
                       grandfather.setColor(true);
                       node=grandfather;
                       continue;
                   }

                   //第二种情况,parent是红的,uncle是黑的,node在parent的右边
                   if(node==parent.getRightChild()){
                       leftRotate(parent);//以当前节点的父节点为支点，左旋
                       L1_Node temp=parent;
                       parent=node;
                       node=temp;
                   }

                   //第三种情况,parent红的，uncle是黑的,node在parent的左边
                   parent.setColor(false);
                   grandfather.setColor(true);
                   rightRotate(grandfather);

              }else{
                   uncle=grandfather.getLeftChild();

                   //第一种情况
                   if(uncle!=null && uncle.getColor()){
                       parent.setColor(false);
                       uncle.setColor(false);
                       grandfather.setColor(true);
                       node=grandfather;
                       continue;
                   }

                   //第二种情况,parent是红的,uncle是黑的,node是parent的左边
                   if(node==parent.getLeftChild()){
                       rightRotate(parent);
                       L1_Node temp=parent;
                       parent=node;
                       node=temp;
                   }

                   //第三种情况,parent是红的,uncle是黑的,node是parent的右边
                   parent.setColor(false);
                   grandfather.setColor(true);
                   leftRotate(grandfather);


              }




         }



    }

}


















