package com.jew.ActivitiDeveloperQuickStart;

import static com.jew.ActivitiDeveloperQuickStart.Graph.MAX;

/**
 * 最小生成树 普里姆算法 克鲁斯卡尔算法
 */
public class MinTree {
    Graph graph;

    public static void main(String[] args) {
        MinTree minTree=new MinTree();
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

        minTree.graph=graph;
    }
}
