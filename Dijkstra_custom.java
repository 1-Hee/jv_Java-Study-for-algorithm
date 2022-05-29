package algoPractice;

import java.util.Scanner;
import java.util.*;

class Arr {
	int idx;
	int cost;
	
	Arr(int idx, int cost){
		this.idx = idx;
		this.cost = cost;
	}
}


public class Dijkstra_custom {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		int Start = sc.nextInt()-1;
		sc.nextLine();
		
		ArrayList<ArrayList<Arr>> graph = new ArrayList<ArrayList<Arr>>();
	
		
		for(int i = 0 ; i < V ; i++) {
			// 여기서 자식 ArrayList를 선언만 했어서 빈칸? 상태임.
			// 반복문을 통해 새로이 생성되면서 노드의 개수만큼 생성이 됨.
			graph.add(new ArrayList<>());			
		}
		
		
		boolean[] visited = new boolean[V];
		int[] distance = new int[V];
		
		for(int i = 0 ; i<distance.length; i ++) {			
			distance[i] = Integer.MAX_VALUE;			
		}
		distance[Start] = 0;
		
		for(int i = 0 ; i < E ; i++) {
			int StartNode = sc.nextInt()-1;
			int EndNode = sc.nextInt()-1;
			int cost = sc.nextInt();
			
			// 입력값을 받아 자식 ArrayList에 넣는데,
			// 상위 ArrayList에 접근은 가능하나, 자식노드는 새로 생성해주면서 값을 넣어주어야 하는데,
			// 그 이유는 앞에서 반복문을 통해 초기화 할 때 상위 ArrayList에 대한 값이 매칭이 되으나
			// 자식 노드에 대해서는 값을 아직 할당 안해줬기 때문.
			graph.get(StartNode).add(new Arr(EndNode, cost));
		}
		
		// 다익스트라 알고리즘의 본체
		
		// 첫번째 반복문은 노드의 개수만큼 값을 탐색하기 위하여 노드의 개수만큼 반복
		// 이 반복문은 노드를 "이동"시키는 역할을 함.
		for (int i = 0; i < V; i++) {
			
			// 반복문이 실행될때마다 바로 아래의 반복문에 들어갈 초기 값이 필요함(대소비교를 위해)
			int nodeValue = Integer.MAX_VALUE;

			// 이 변수는 첫 실행에서는 첫 노드의 2차 ArrayList를 접근하는 Index의 역할을 하고,
			// 두 번째 실행부터는 초기화의 기능을 함.
			// 첫번째 실행에는 아래에 반복문에서 값의 변경이 일어날 수 없으므로, 그대로 그 다음 반복문으로 값이 이동됨.
			int nodeIdx = 0;  
			
			for(int j = 0 ; j < V; j ++) {
				
				// 각노드를 방문했는지를 담아둔 배열 vistied를 사용하여 판단 및
				// 동시에 다익스트라 알고리즘에서 입력받은 값이 있는지를 탐색해줌.
				// 첫 실행에서는 이 반복문은 그냥 넘어가지만, 두번째 실행부터는 이미 첫 실행에서
				// 초기화된 distance 배열에 값의 변경이 일어나므로 이 반복문이 작동하고,
				// 인접 노드 중에서 가장 거리가 가까운 경로를 탐색해줌 (그리디 알고리즘이라고 볼 수 있을듯...)
				if(!visited[j]&& distance[j]<nodeValue) {
					nodeValue = distance[j];
					nodeIdx = j;
				}
			}
			
			// 바로 위에서 선택된 "최소" 거리 값을 갖는 다음 노드랑 거리 값을 가져옴.
			visited[nodeIdx] = true;
			
			
			// 위에서 선택한 노드 지점을 기준으로 연결된 바로 옆 이웃 노드들의 거리 값을 비교해보고,
			// distance 배열에 값을 초기화 해주기 위한 반복문
			for (int j = 0 ; j < graph.get(nodeIdx).size(); j ++) {
				
				// 위에서 선택한 노드지점 배열을 선택함 
				// 노드와 연결된 이웃 노드 사이의 거리값을 가진 클래스를 반복문을 통해 하나씩 선택하여 모두 가져옴.
				Arr NearNode = graph.get(nodeIdx).get(j);
				
				
				// 예컨데 이미 A - C 경로가 있을 때, 이미 A를 탐색하면서 C로 가는 경로 cost가 세팅 되었을 텐데,
				// 노드를 따라 탐색하며 누적한 값이 기존의 cost보다 저렴하면 그 값으로 대체해주기 위한 조건문
				
				if(distance[NearNode.idx]>distance[nodeIdx]+NearNode.cost) {					
					distance[NearNode.idx] = distance[nodeIdx] + NearNode.cost;					
				}								
			}						
		}
		
		// 최종 비용 출력
		for(int i = 0 ; i < V ; i++) {
			System.out.println(distance[i]);
		}
		
		
		
		

	}

}
