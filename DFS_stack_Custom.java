package algoPractice;

import java.util.Stack;

public class DFS_stack_Custom {
	
	
	static boolean[] visited = new boolean[10];	
	static int[][] graph = {{1,3,5}, {0,2,9}, {1}, {0}, {5,6}, {4, 8}, {4}, {8}, {5, 7}, {1}};	
	static Stack<Integer> stack = new Stack<>();
	
	public static void main(String[] args) {
		
		// stack을 이용한 방법은 결과값을 선형으로 출력할 때,
		// node의 단계를 우선으로 출력하기 어렵다.
		// 또한, 배열을 오름차로 주면 내림차 순으로, 내림차로 주면 오름차 순으로 결과 값을 리턴한다.
		
		
		stack.push(0);
		
		visited[0] = true;
		
		while(!stack.isEmpty()) {
			
			int nodeIndex = stack.pop();

			System.out.print((nodeIndex+1)+" → ");
			
			for(int member : graph[nodeIndex]) {
				
				if(!visited[member]) {
					stack.push(member);
					visited[member] = true;
				}				
			}			
		}
	}
}
