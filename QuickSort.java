package aglos;

public class QuickSort {
	// �迭 ������ ǥ���ϴ� �޼ҵ�
	public static void printArray(int[] a) {
		for(int i=0 ; i < a.length ; i++) System.out.printf("["+a[i]+"]");
		System.out.println();

	}
	
	// �迭 a[head] ~ a[tail]�� �׷����� ������ �޼���
	public static int divideArray(int[] a, int head, int tail) {
		int left, right, temp;
		left = head+1; // �迭 ù ��� +1 ���� �޿�ҷ� �Ⱦ� ���� ��ġ
		right = tail; // �迭 �� ��Һ��� �� ��ҷ� �Ⱦ� ���� ��ġ
		
		// ���� �� a[head]���� ���� ��Ҹ� ��������, ū ��Ҹ� �������� �̵�
		while(true) {
			// �迭�� ù ��� +1���� �������� �Ⱦ, ���ذ����� ū ��Ҹ� ã��
			while(left <tail && a[head] > a[left]) {
				left++;
			}
			// �迭 �� ��ҿ��� ������ �Ⱦ� ���� ������ ���� ��Ҹ� ã��
			while(a[head] < a[right]) {
				right--;
			}
			
			// Ȯ�� �� ��Ұ� �������� ����
			if(left >= right) break;
			
			// ���� ������ ū a[left]�� ���� ������ ���� a[right]�� ��ȯ
			temp = a[left];
			a[left] = a[right];
			a[right] = temp;
			
			
			// ���� ��Ҹ� Ȯ����
			left++;
			right--;
		}
		
		// ���� �� a[head]�� a[right]�� ��ȯ
		temp = a[head];
		a[head] = a[right];
		a[right] = temp;
		
		// ���� �� a[right]�� ��ġ�� ��ȯ
		return right;		
	}
	
	// �迭 a[start] ~ a[end]�� ������ ������ �����ϴ� �޼���
	public static void sortArray(int[] a, int start, int end) {
		int pivot; // �迭�� �׷����� ������ ���� ���� �ε��� ��ġ
		// �迭 ��Ұ� 2�� �̻��� ��� ���� ó�� ����
		if(start < end ) {
			// ���� ���� ��� ���迡 ���� �׷� ������
			pivot = divideArray(a, start, end);
			
			// ���� ������ ���� ���� �׷쿡 ������ ó���� ����(���ȣ��)
			sortArray(a, start, pivot-1);
			
			// ���� ������ ū ���� �׷쿡 ������ ó���� ����(��� ȣ��)
			sortArray(a, pivot+1, end);
			
		}		
	}
	
	// ���α׷� ������ �������� main �޼���
	public static void main(String[] args) {
		int[] a = {4,7,1,6,2,5,3};
		
		// ���� �� ������ ǥ��
		printArray(a);
		
		// �� ���� ����
		sortArray(a, 0, a.length-1);
		
		// ���ĵ� �迭�� ǥ��
		printArray(a);
		
	}
	

}
