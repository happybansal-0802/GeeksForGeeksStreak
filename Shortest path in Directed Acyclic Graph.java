Given a Directed Acyclic Graph of N vertices from 0 to N-1 and a 2D Integer array(or vector) edges[ ][ ] of length M, where there is a directed edge from edge[i][0] to edge[i][1] with a distance of edge[i][2] for all i.

Find the shortest path from src(0) vertex to all the vertices and if it is impossible to reach any vertex, then return -1 for that vertex.
  Solution:
//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {

	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		List<List<Integer[]>> list=new ArrayList<>();
		for(int i=0;i<N;i++)    list.add(new ArrayList<>());
		for(int e[]:edges)   list.get(e[0]).add(new Integer[]{e[1],e[2]});
		int ans[]=new int[N];
		Arrays.fill(ans,-1);
		Queue<Integer[]> q = new LinkedList<>();
		q.add(new Integer[]{0,0});
		
		while(!q.isEmpty()){

		    Integer pop[] = q.remove();
		    if(ans[pop[0]]==-1) ans[pop[0]] = pop[1];
		    else if(ans[pop[0]]<=pop[1]) continue;
		    else    ans[pop[0]] = pop[1];
		    
		    for(Integer[] nbr:list.get(pop[0])) q.add(new Integer[]{nbr[0],nbr[1]+pop[1]});
		    
		}
		
		return ans;
	}
}
