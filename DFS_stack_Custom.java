package algoPractice;

import java.util.Stack;

public class DFS_stack_Custom {
	
	
	static boolean[] visited = new boolean[10];	
	static int[][] graph = {{1,3,5}, {0,2,9}, {1}, {0}, {5,6}, {4, 8}, {4}, {8}, {5, 7}, {1}};	
	static Stack<Integer> stack = new Stack<>();
	
	public static void main(String[] args) {
		
		// stack�� �̿��� ����� ������� �������� ����� ��,
		// node�� �ܰ踦 �켱���� ����ϱ� ��ƴ�.
		// ����, �迭�� �������� �ָ� ������ ������, �������� �ָ� ������ ������ ��� ���� �����Ѵ�.
		
		
		stack.push(0);
		
		visited[0] = true;
		
		while(!stack.isEmpty()) {
			
			int nodeIndex = stack.pop();

			System.out.print((nodeIndex+1)+" �� ");
			
			for(int member : graph[nodeIndex]) {
				
				if(!visited[member]) {
					stack.push(member);
					visited[member] = true;
				}				
			}			
		}
	}
}
