package al_sty0001;

import java.util.Scanner;

public class LinearSearch {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] Array1 = {41, 58, 78, 23, 64, 22, 16, 44, 88, 76, 52, 58};
		System.out.println("�迭 �ӿ� ã���� �ϴ� x�� �Է��ϼ���");
		int x = sc.nextInt();
		int index = 0;
		int pos = -1;
		sc.close();
		
		for (int i = 0; i <Array1.length ; i++) {
			if(Array1[i]==x) {
				pos = x;
				index = i;
				break;
			}
		}
		
		if(pos != -1) {
			System.out.printf("����� �Է��� ���� %d�� %d��°�� �ֽ��ϴ�", x, index+1);
		} else {
			System.out.println("����� �Է��� ���ڸ� ã�� �� �������ϴ�");
		}

		
		

	}

}
