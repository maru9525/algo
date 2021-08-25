package Algo0825;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_bj_1753_최단경로 {
	
	static class Node implements Comparable<Node> { 
		int vertex;
		int weight;
		
		public Node(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return weight- o.weight;
		}
	}
	
	static int v,e,k;
	static int[] distance;
	static int INF = Integer.MAX_VALUE;
	
	static ArrayList<Node>[] list;

	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_1753.txt"));
		Scanner sc = new Scanner(System.in);
		v = sc.nextInt();
		e = sc.nextInt();
		k = sc.nextInt();
		
		list = new ArrayList[v+1];
		distance = new int[v+1];
		
		for (int i = 1; i <= v; i++) {
			list[i] = new ArrayList<>();
		}
		Arrays.fill(distance, INF);
		distance[k] = 0;
		for (int i = 0; i < e; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			list[u].add(new Node(v, w));
		}
		dijkstra();
		for (int i = 1; i <= v; i++) {
			if(distance[i] == INF) {
				System.out.println("INF");
			} else {
				System.out.println(distance[i]);
			}
		}
		
	}

	private static void dijkstra() {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.offer(new Node(k,0));
		while(!q.isEmpty()) {
			Node node = q.poll();
			int vertex = node.vertex;
			int weight = node.weight;
			
			if(distance[vertex] < weight) {
				continue;
			}
			for(int i= 0; i < list[vertex].size(); i++) {
				int nvertex = list[vertex].get(i).vertex;
				int nweight = list[vertex].get(i).weight + weight;
				if(distance[nvertex] > nweight) {
					distance[nvertex] = nweight;
					q.offer(new Node(nvertex, nweight));
				}
			}
		}
		
	}

}
