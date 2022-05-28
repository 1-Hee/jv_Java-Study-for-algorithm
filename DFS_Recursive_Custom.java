package algoPractice;

public class DFS_Recursive_Custom {
	
	static boolean[] visited = new boolean[10];
	static int[][] graph = {{1,3,5}, {0,2,9}, {1}, {0}, {5,6}, {4, 8}, {4}, {8}, {5, 7}, {1}};
			

	public static void main(String[] args) {
		
		dfs(0);
				
	}
	
	static void dfs(int searchNode) {
		visited[searchNode]=true;
		
		System.out.print((searchNode+1) + "¡æ");
		
		for(int member : graph[searchNode]) {
			if(!visited[member]) {
				dfs(member);
			}			
			
		}		
		
	}
	
}


