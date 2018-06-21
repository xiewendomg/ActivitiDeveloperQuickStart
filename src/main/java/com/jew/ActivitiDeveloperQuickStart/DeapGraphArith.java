package com.jew.ActivitiDeveloperQuickStart;

import java.util.LinkedList;

import static com.jew.ActivitiDeveloperQuickStart.Graph.MAX;

/**
 * Created by Administrator on 2018/6/13.
 */
public class DeapGraphArith {
    Graph graph;

    /**
     *  找到第一个连接点
     * @param v 顶点
     * @return
     */
    public int getFirstNeighbor(int v){
        for (int j=0;j<graph.num;j++){
            if (graph.m[v][j]>0&&graph.m[v][j]< MAX){
                return j;
            }
        }
        return -1;
    }
    /**
     *  获取顶点v当前连接点的下标v1后面的下一个连接点
     * @param v 顶点
     * @return
     */
    public int getNextNeighbor(int v,int v1){
        for (int j=v1+1;j<graph.num;j++){
            if (graph.m[v][j]>0&&graph.m[v][j]< MAX){
                return j;
            }
        }
        return -1;
    }

    public void depthFirstSearch(int index){
        graph.isVisited[index]=true;
        int w=getFirstNeighbor(index);
        while (w!=-1){
            if (!graph.isVisited[w]){
                System.out.println("访问到了顶点"+w);
                depthFirstSearch(w);
            }
           w=getNextNeighbor(index,w);
        }
    }

    /**
     * 深度优先算法
     */
    public void depthFirstSearch(){

        for (int i=0;i<graph.num;i++)
        {
            if (!graph.isVisited[i]) {
                depthFirstSearch(i);
            }

        }
    }

    /**
     * 广度优先算法 层级遍历
     */
    public void broadFirstSearch(){
        for (int i=0;i<graph.num;i++)
        {
            if (!graph.isVisited[i]) {
                broadFirstSearch(i);
            }

        }
    }

    /**
     * 实现深度遍历
     * @param i
     */
    private void broadFirstSearch(int i) {
        int u,w;
        LinkedList<Integer> queue=new LinkedList<>();
        System.out.println("访问到："+i+"顶点");
        graph.isVisited[i]=true;
        queue.add(i);
        while (!queue.isEmpty()){
            u=queue.removeFirst();
            w=getFirstNeighbor(u);
            while (w!=-1){
                if (!graph.isVisited[w]){
                    System.out.println("访问到："+w+"顶点");
                    graph.isVisited[w]=true;
                    queue.add(w);
                }
                w=getNextNeighbor(u,w);
            }
        }
    }

    public static void main(String[] args) {
        DeapGraphArith dgf=new DeapGraphArith();
        Graph graph = new Graph(9);

        int [] a1 = new int[]{0,10,MAX,MAX,MAX,11,MAX,MAX,MAX};
        int [] a2 = new int[]{10,0,18,MAX,MAX,MAX,16,MAX,12};
        int [] a3 = new int[]{MAX,MAX,0,22,MAX,MAX,MAX,MAX,8};
        int [] a4 = new int[]{MAX,MAX,22,0,20,MAX,MAX,16,21};
        int [] a5 = new int[]{MAX,MAX,MAX,20,0,26,MAX,7,MAX};
        int [] a6 = new int[]{11,MAX,MAX,MAX,26,0,17,MAX,MAX};
        int [] a7 = new int[]{MAX,16,MAX,MAX,MAX,17,0,19,MAX};
        int [] a8 = new int[]{MAX,MAX,MAX,16,7,MAX,19,0,MAX};
        int [] a9 = new int[]{MAX,12,8,21,MAX,MAX,MAX,MAX,0};

        graph.m[0] = a1;
        graph.m[1] = a2;
        graph.m[2] = a3;
        graph.m[3] = a4;
        graph.m[4] = a5;
        graph.m[5] = a6;
        graph.m[6] = a7;
        graph.m[7] = a8;
        graph.m[8] = a9;

        dgf.graph=graph;
//        dgf.depthFirstSearch();
        dgf.broadFirstSearch();
    }
}
