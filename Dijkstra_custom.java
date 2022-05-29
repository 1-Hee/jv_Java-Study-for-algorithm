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
			// ���⼭ �ڽ� ArrayList�� ���� �߾ ��ĭ? ������.
			// �ݺ����� ���� ������ �����Ǹ鼭 ����� ������ŭ ������ ��.
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
			
			// �Է°��� �޾� �ڽ� ArrayList�� �ִµ�,
			// ���� ArrayList�� ������ �����ϳ�, �ڽĳ��� ���� �������ָ鼭 ���� �־��־�� �ϴµ�,
			// �� ������ �տ��� �ݺ����� ���� �ʱ�ȭ �� �� ���� ArrayList�� ���� ���� ��Ī�� ������
			// �ڽ� ��忡 ���ؼ��� ���� ���� �Ҵ� ������� ����.
			graph.get(StartNode).add(new Arr(EndNode, cost));
		}
		
		// ���ͽ�Ʈ�� �˰����� ��ü
		
		// ù��° �ݺ����� ����� ������ŭ ���� Ž���ϱ� ���Ͽ� ����� ������ŭ �ݺ�
		// �� �ݺ����� ��带 "�̵�"��Ű�� ������ ��.
		for (int i = 0; i < V; i++) {
			
			// �ݺ����� ����ɶ����� �ٷ� �Ʒ��� �ݺ����� �� �ʱ� ���� �ʿ���(��Һ񱳸� ����)
			int nodeValue = Integer.MAX_VALUE;

			// �� ������ ù ���࿡���� ù ����� 2�� ArrayList�� �����ϴ� Index�� ������ �ϰ�,
			// �� ��° ������ʹ� �ʱ�ȭ�� ����� ��.
			// ù��° ���࿡�� �Ʒ��� �ݺ������� ���� ������ �Ͼ �� �����Ƿ�, �״�� �� ���� �ݺ������� ���� �̵���.
			int nodeIdx = 0;  
			
			for(int j = 0 ; j < V; j ++) {
				
				// ����带 �湮�ߴ����� ��Ƶ� �迭 vistied�� ����Ͽ� �Ǵ� ��
				// ���ÿ� ���ͽ�Ʈ�� �˰��򿡼� �Է¹��� ���� �ִ����� Ž������.
				// ù ���࿡���� �� �ݺ����� �׳� �Ѿ����, �ι�° ������ʹ� �̹� ù ���࿡��
				// �ʱ�ȭ�� distance �迭�� ���� ������ �Ͼ�Ƿ� �� �ݺ����� �۵��ϰ�,
				// ���� ��� �߿��� ���� �Ÿ��� ����� ��θ� Ž������ (�׸��� �˰����̶�� �� �� ������...)
				if(!visited[j]&& distance[j]<nodeValue) {
					nodeValue = distance[j];
					nodeIdx = j;
				}
			}
			
			// �ٷ� ������ ���õ� "�ּ�" �Ÿ� ���� ���� ���� ���� �Ÿ� ���� ������.
			visited[nodeIdx] = true;
			
			
			// ������ ������ ��� ������ �������� ����� �ٷ� �� �̿� ������ �Ÿ� ���� ���غ���,
			// distance �迭�� ���� �ʱ�ȭ ���ֱ� ���� �ݺ���
			for (int j = 0 ; j < graph.get(nodeIdx).size(); j ++) {
				
				// ������ ������ ������� �迭�� ������ 
				// ���� ����� �̿� ��� ������ �Ÿ����� ���� Ŭ������ �ݺ����� ���� �ϳ��� �����Ͽ� ��� ������.
				Arr NearNode = graph.get(nodeIdx).get(j);
				
				
				// ������ �̹� A - C ��ΰ� ���� ��, �̹� A�� Ž���ϸ鼭 C�� ���� ��� cost�� ���� �Ǿ��� �ٵ�,
				// ��带 ���� Ž���ϸ� ������ ���� ������ cost���� �����ϸ� �� ������ ��ü���ֱ� ���� ���ǹ�
				
				if(distance[NearNode.idx]>distance[nodeIdx]+NearNode.cost) {					
					distance[NearNode.idx] = distance[nodeIdx] + NearNode.cost;					
				}								
			}						
		}
		
		// ���� ��� ���
		for(int i = 0 ; i < V ; i++) {
			System.out.println(distance[i]);
		}
		
		
		
		

	}

}
