package algobook_src;


// BST 클래스를 정의함
class BST{
	public int data; // 요소 값
	public int left;
	public int right;
}

// 이진 탐색 트리를 구성하는 클래스 정의
public class BinarySearchTree{
	
	// 이진 탐색 트리의 배열, 요소 수는 10개
	public static BST[] tree = new BST[10];
	// 위와 같은 문법이 가능한 이유는 클래스로 사전에 정의되어 있었기 때문이다.
	// 보통 배열 선언 시 int[] arr = new int [] 이런 식으로 정의 많이 하는데,
	// 15번 줄과 같이 정의할 수 있는 건 클래스로 배열 정보를 정의해두었기 때문이다.
	// 따라서 15번줄과 같은 "사용자 정의" 배열이 사용 가능한 것.
	
	// 루트 요소의 물리적 위치 인덱스(연결 리스트의 head)
	public static int rootIdx = 0;
	
	// 다음으로 추가할 요소의 물리적 위치 인덱스
	public static int newIdx = 0;
	
	// 이진 탐색 트리에 요소를 추가하는 메서드
	public static void addBST(int data) {
		int currentIdx;  // 현재 요소의 물리적 위치 인덱스
		boolean addFlag; // 요소가 추가 완료되어있는지 확인하는 불리언 플래그
		
		// 물리적 위치에 요솟값과 연결 정보 추가
		tree[newIdx].data = data;
		tree[newIdx].left = -1;
		tree[newIdx].right = -1;
		
		// 루트 요소가 아니라면 논리적 순서에 따라 요소 위치 탐색 및 결정
		if(newIdx != rootIdx) {
			currentIdx = rootIdx;
			addFlag = false;
			
			do {
				// 루트 요솟값보다 더 작으면 왼쪽으로 내려감
				if( data < tree[currentIdx].data) {
					// 왼쪽으로 내려갔을 때 끝이면 left에 요소의 물리적 위치 인덱스를 추가
					if(tree[currentIdx].left==-1) {
						tree[currentIdx].left = newIdx;
						addFlag = true;
					}
					// 왼쪽으로 내려갔을 때 끝이 아니라면 왼쪽의 요소보다 더내려감
					else {
						currentIdx = tree[currentIdx].left;
					}				
				}
				
				// 루트 요솟값 보다 더 크면 오른쪽으로 내려감(동일한 값은 없음)
				else {
					// 오른쪽으로 내려갔을 때 끝이면 right에 요소의 물리적 위치 인덱스를 추가(연결정보 설정)
					if(tree[currentIdx].right==-1) {
						tree[currentIdx].right=newIdx;
						addFlag = true;
					} // 오른쪽으로 내려갔을 때 끝이 아니라면 오른쪽의 요소보다 더 내려감
					else {
						currentIdx = tree[currentIdx].right;
					}
				}				
				
			} while(addFlag==false);
		}
		
		// 다음에 추가할 요소를 위해 물리적 위치의 인덱스를 1 늘림
		newIdx++;				
	}
	
	// 이진 검색 트리의 실체인 배열을 물리적 위치 순서로 표시하는 메소드
	public static void printPhysicalBST() {
		int i;
		for (i  = 0 ; i < newIdx ; i++) {
			System.out.printf("tree[%d]: data = %d, left = %d, right %d\n", i , tree[i].data, tree[i].left, tree[i].right);
		}
	}
	
	// 이진 탐색 트리를 논리적인 순서*깊이 우선 탐색)로 표시하는 메서드
	public static void printLogicalBST(int currentIdx) {
		if(currentIdx != -1) {
			System.out.printf("tree[%d] : data = %d / left = %d / right = %d\n", 
					currentIdx, tree[currentIdx].data, tree[currentIdx].left, tree[currentIdx].right);
			// 재귀 호출 부분
			printLogicalBST(tree[currentIdx].left);
			printLogicalBST(tree[currentIdx].right);

			}		
	}
	
	
	// 이진탐색 트리를 탐색하는 함수 (Basic)
	public static int searchBST(int x) {
		int idx;
		int currentIdx;
		idx = -1;
		currentIdx = rootIdx;
		
		while(currentIdx != -1) {
			if(tree[currentIdx].data == x) {
				idx = currentIdx;
				break;
			} else if (tree[currentIdx].data > x) {
				currentIdx = tree[currentIdx].left;
			} else {
				currentIdx = tree[currentIdx].right;
			}
		}
		
		return idx;
	}
	
	// 재귀 호출로 이진 탐색 트리를 탐색하는 메서드
	public static int searchRecBST(int x, int currentIdx) {
		if(currentIdx==-1) {
			return -1;
		} else {
			if(tree[currentIdx].data==x) {
				return currentIdx;
			} else if (tree[currentIdx].data > x) {
				// 재귀 호출 부분
				return searchRecBST(x, tree[currentIdx].left);
			} else {
				// 재귀 호출 부분
				return searchRecBST(x, tree[currentIdx].right);
			}
		} 
		
	}
	
	
	
	// 프로그램 실행의 시작점인 main 메서드	
	 public static void main(String[] args) {
		 // 자바는 인스턴스 생성이 필요 ( 이 처리는 의사코드나 C에서는 불필요 )
		 
		 for( int i = 0 ; i < tree.length ; i++) {
			 tree[i] = new BST();
		 }
		 
		 // 요소를 추가
		 addBST(4);
		 addBST(6);
		 addBST(5);
		 addBST(2);
		 addBST(3);
		 addBST(7);
		 addBST(1);

		 
		 /*
		 // 물리적 위치 순서로 표시
		 printPhysicalBST();
		 
		 
		 System.out.println("-------------");
		 // 이진 탐색 트리를 논리적 순서(깊이 우선 탐색)으로 표시
		 printLogicalBST(rootIdx);
		 */
		 
		 // 이진 탐색 트리를 탐색
		 System.out.printf("data 값이 '5'일 때 물리적 위치 탐색 결과 = tree[%d]\n", searchBST(5));
		 System.out.printf("data 값이 '8'일 때 물리적 위치 탐색 결과 = tree[%d]\n", searchBST(8));
		 
		 
		 // 재귀호출로 트리를 탐색
		 System.out.println("-------------");
		 System.out.printf("data 값이 '5'일 때 물리적 위치 탐색 결과 = %d\n", searchRecBST(5, rootIdx));
		 System.out.printf("data 값이 '8'일 때 물리적 위치 탐색 결과 = %d\n", searchRecBST(8, rootIdx));

		 

		 

	 }
	
	
}