package algobook_src;


// BST Ŭ������ ������
class BST{
	public int data; // ��� ��
	public int left;
	public int right;
}

// ���� Ž�� Ʈ���� �����ϴ� Ŭ���� ����
public class BinarySearchTree{
	
	// ���� Ž�� Ʈ���� �迭, ��� ���� 10��
	public static BST[] tree = new BST[10];
	// ���� ���� ������ ������ ������ Ŭ������ ������ ���ǵǾ� �־��� �����̴�.
	// ���� �迭 ���� �� int[] arr = new int [] �̷� ������ ���� ���� �ϴµ�,
	// 15�� �ٰ� ���� ������ �� �ִ� �� Ŭ������ �迭 ������ �����صξ��� �����̴�.
	// ���� 15���ٰ� ���� "����� ����" �迭�� ��� ������ ��.
	
	// ��Ʈ ����� ������ ��ġ �ε���(���� ����Ʈ�� head)
	public static int rootIdx = 0;
	
	// �������� �߰��� ����� ������ ��ġ �ε���
	public static int newIdx = 0;
	
	// ���� Ž�� Ʈ���� ��Ҹ� �߰��ϴ� �޼���
	public static void addBST(int data) {
		int currentIdx;  // ���� ����� ������ ��ġ �ε���
		boolean addFlag; // ��Ұ� �߰� �Ϸ�Ǿ��ִ��� Ȯ���ϴ� �Ҹ��� �÷���
		
		// ������ ��ġ�� ��ڰ��� ���� ���� �߰�
		tree[newIdx].data = data;
		tree[newIdx].left = -1;
		tree[newIdx].right = -1;
		
		// ��Ʈ ��Ұ� �ƴ϶�� ���� ������ ���� ��� ��ġ Ž�� �� ����
		if(newIdx != rootIdx) {
			currentIdx = rootIdx;
			addFlag = false;
			
			do {
				// ��Ʈ ��ڰ����� �� ������ �������� ������
				if( data < tree[currentIdx].data) {
					// �������� �������� �� ���̸� left�� ����� ������ ��ġ �ε����� �߰�
					if(tree[currentIdx].left==-1) {
						tree[currentIdx].left = newIdx;
						addFlag = true;
					}
					// �������� �������� �� ���� �ƴ϶�� ������ ��Һ��� ��������
					else {
						currentIdx = tree[currentIdx].left;
					}				
				}
				
				// ��Ʈ ��ڰ� ���� �� ũ�� ���������� ������(������ ���� ����)
				else {
					// ���������� �������� �� ���̸� right�� ����� ������ ��ġ �ε����� �߰�(�������� ����)
					if(tree[currentIdx].right==-1) {
						tree[currentIdx].right=newIdx;
						addFlag = true;
					} // ���������� �������� �� ���� �ƴ϶�� �������� ��Һ��� �� ������
					else {
						currentIdx = tree[currentIdx].right;
					}
				}				
				
			} while(addFlag==false);
		}
		
		// ������ �߰��� ��Ҹ� ���� ������ ��ġ�� �ε����� 1 �ø�
		newIdx++;				
	}
	
	// ���� �˻� Ʈ���� ��ü�� �迭�� ������ ��ġ ������ ǥ���ϴ� �޼ҵ�
	public static void printPhysicalBST() {
		int i;
		for (i  = 0 ; i < newIdx ; i++) {
			System.out.printf("tree[%d]: data = %d, left = %d, right %d\n", i , tree[i].data, tree[i].left, tree[i].right);
		}
	}
	
	// ���� Ž�� Ʈ���� ������ ����*���� �켱 Ž��)�� ǥ���ϴ� �޼���
	public static void printLogicalBST(int currentIdx) {
		if(currentIdx != -1) {
			System.out.printf("tree[%d] : data = %d / left = %d / right = %d\n", 
					currentIdx, tree[currentIdx].data, tree[currentIdx].left, tree[currentIdx].right);
			// ��� ȣ�� �κ�
			printLogicalBST(tree[currentIdx].left);
			printLogicalBST(tree[currentIdx].right);

			}		
	}
	
	
	// ����Ž�� Ʈ���� Ž���ϴ� �Լ� (Basic)
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
	
	// ��� ȣ��� ���� Ž�� Ʈ���� Ž���ϴ� �޼���
	public static int searchRecBST(int x, int currentIdx) {
		if(currentIdx==-1) {
			return -1;
		} else {
			if(tree[currentIdx].data==x) {
				return currentIdx;
			} else if (tree[currentIdx].data > x) {
				// ��� ȣ�� �κ�
				return searchRecBST(x, tree[currentIdx].left);
			} else {
				// ��� ȣ�� �κ�
				return searchRecBST(x, tree[currentIdx].right);
			}
		} 
		
	}
	
	
	
	// ���α׷� ������ �������� main �޼���	
	 public static void main(String[] args) {
		 // �ڹٴ� �ν��Ͻ� ������ �ʿ� ( �� ó���� �ǻ��ڵ峪 C������ ���ʿ� )
		 
		 for( int i = 0 ; i < tree.length ; i++) {
			 tree[i] = new BST();
		 }
		 
		 // ��Ҹ� �߰�
		 addBST(4);
		 addBST(6);
		 addBST(5);
		 addBST(2);
		 addBST(3);
		 addBST(7);
		 addBST(1);

		 
		 /*
		 // ������ ��ġ ������ ǥ��
		 printPhysicalBST();
		 
		 
		 System.out.println("-------------");
		 // ���� Ž�� Ʈ���� ���� ����(���� �켱 Ž��)���� ǥ��
		 printLogicalBST(rootIdx);
		 */
		 
		 // ���� Ž�� Ʈ���� Ž��
		 System.out.printf("data ���� '5'�� �� ������ ��ġ Ž�� ��� = tree[%d]\n", searchBST(5));
		 System.out.printf("data ���� '8'�� �� ������ ��ġ Ž�� ��� = tree[%d]\n", searchBST(8));
		 
		 
		 // ���ȣ��� Ʈ���� Ž��
		 System.out.println("-------------");
		 System.out.printf("data ���� '5'�� �� ������ ��ġ Ž�� ��� = %d\n", searchRecBST(5, rootIdx));
		 System.out.printf("data ���� '8'�� �� ������ ��ġ Ž�� ��� = %d\n", searchRecBST(8, rootIdx));

		 

		 

	 }
	
	
}