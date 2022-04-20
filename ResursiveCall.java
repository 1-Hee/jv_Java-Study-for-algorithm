package aglos;

public class ResursiveCall {
	// �μ� n�� ����� ���ϴ� �޼���
	public static int factorial(int n) {
		if (n == 0){
			// 0�� ����� 1�̹Ƿ� 1�� ��ȯ�Ͽ� ��� ȣ���� ����
			return 1;
		} else {
			// n�� ����� (n-1)�� ����̹Ƿ�, ��� ȣ��� (n-1)�� ����� ����.
			return n*factorial(n-1);
		}
	}
	
	public static void main(String[] args) {
		int ans;
		//5�� ����� ����
		ans = factorial(5);
		System.out.printf("%d\n", ans);
	}

}

