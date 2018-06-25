package com.jew.ActivitiDeveloperQuickStart;

import static com.jew.ActivitiDeveloperQuickStart.Graph.MAX;

import java.rmi.server.SocketSecurityException;

public class DnjavaDijstra {
	Graph graph;

	/**
	 * 创建图的过程
	 */
	public Graph createGraph() {
		Graph graph = new Graph(9);
		int[] a1 = new int[] { 0, 1, 5, MAX, MAX, MAX, MAX, MAX, MAX };
		int[] a2 = new int[] { 1, 0, 3, 7, 5, MAX, MAX, MAX, MAX };
		int[] a3 = new int[] { 5, 3, 0, MAX, 1, 7, MAX, MAX, MAX };
		int[] a4 = new int[] { MAX, 7, MAX, 0, 2, MAX, 3, MAX, MAX };
		int[] a5 = new int[] { MAX, 5, 1, 2, 0, 3, 6, 9, MAX };
		int[] a6 = new int[] { MAX, MAX, 7, MAX, 3, 0, MAX, 5, MAX };
		int[] a7 = new int[] { MAX, MAX, MAX, 3, 6, MAX, 0, 2, 7 };
		int[] a8 = new int[] { MAX, MAX, MAX, MAX, 9, 5, 2, 0, 4 };
		int[] a9 = new int[] { MAX, MAX, MAX, MAX, MAX, MAX, 7, 4, 0 };

		graph.m[0] = a1;
		graph.m[1] = a2;
		graph.m[2] = a3;
		graph.m[3] = a4;
		graph.m[4] = a5;
		graph.m[5] = a6;
		graph.m[6] = a7;
		graph.m[7] = a8;
		graph.m[8] = a9;
		return graph;
	}

	public static void main(String[] args) {
		DnjavaDijstra d = new DnjavaDijstra();
		d.graph = d.createGraph();
		d.shortestPathDijstra();
	}

	/**
	 * 迪杰斯特拉
	 */
	public void shortestPathDijstra() {
		for (int i = 0; i < graph.num; i++) {
			System.out.println("============================");
			shortestPathDijstra(i);
			System.out.println("============================");
		}
	}

	private void shortestPathDijstra(int j) {
		int[] lowcost = new int[graph.num];
		int[] adj = new int[graph.num];
		graph.isVisited =new boolean[graph.num];
		graph.isVisited[j]=true;
		for (int i = 0; i < graph.num; i++) {
			lowcost[i] = graph.m[j][i];
			adj[i]=j;
		}
		int sum=0;
		while (find()) {
			int min = MAX;
			int minId = 0;
			// 找到最小值
			for (int i=0;i<lowcost.length;i++) {
				if (!graph.isVisited[i]&&lowcost[i]<min) {
					min=lowcost[i];
					minId=i;
				}
			}
			graph.isVisited[minId]=true;
			//更新数组 lowcost
			for(int i=0;i<lowcost.length;i++){
				int next=graph.m[minId][i]+min;
				if(!graph.isVisited[i]&&lowcost[i]>next){
					lowcost[i]=next;
				}
			}
		}
		for(int i=0;i<lowcost.length;i++){
			System.out.println("顶点V"+j+"到V"+i+"的距离="+lowcost[i]);
		}
		
	}

	private boolean find(){
		for(boolean flag:graph.isVisited){
			if(!flag){
				return true;
			}
		}
		return false;
	}
}
