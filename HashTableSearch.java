package algobook_src;

import java.util.Scanner;

public class HashTableSearch {
	
	// �ؽ� ���̺��� ��ü�� �Ǵ� �迭(��� ���� 10���� ��)
	public static int[] hashTable = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
	
	// �ؽ� �Լ� ������ �ϴ� �޼ҵ�
	public static int hashFunc(int data) {
		return data%10;		
	}
	
	// ���α׷� ������ ���� ���� main �޼ҵ�
	public static void main(String[] args) {
		int data, hashValue;
		// Ű����� �����͸� �Է� �Ͽ� �ؽ����̺� ����
		Scanner sc = new Scanner(System.in);
		do {
			//������ ������ �Է�
			System.out.printf("\n ������ ������ = ");
			data = sc.nextInt();
			if(data<0) {
				break;
			}
			
			// �ؽ� ���� ����			
			hashValue = hashFunc(data);
			
			// �ؽ� ���̺� ����
			hashTable[hashValue] = data;						
			
		} while(true);
		
		// �ؽ� ���̺��� �����͸� Ž��
		do {
			// �˻��� �����͸� Ű����� �Է�
			System.out.printf("\n Ž���� ������ = ");
			data = sc.nextInt();
			
			if(data < 0 ){
				break;
			}
			
			// �ؽ� ���� ����
			hashValue = hashFunc(data);
			
			// �˻��� ����� ǥ��
			if(hashTable[hashValue]==data) {
				System.out.printf("%d��°���� �߰ߵǾ����ϴ�. \n", hashValue);
			} else {
				System.out.printf("ã�� ���� �����ϴ�. ");
			}
		} while(true);
		sc.close();
	}

}
