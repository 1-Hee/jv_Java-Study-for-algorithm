package algobook_src;

import java.util.Scanner;

public class HashTableSearchSync {
	
	// �ؽ� ���̺��� ��ü�� �Ǵ� �迭(��� ���� 10���� ��)
	public static int[] hashTable = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
	
	// �ؽ� �Լ� ������ �ϴ� �޼ҵ�
		public static int hashFunc(int data) {
			return data%10;		
		}
		
		// ���α׷� ������ ���� ���� main �޼ҵ�
		public static void main(String[] args) {
			int data, hashValue;
			int pos;  //  ���� ��ġ, �˻� ��
			
			
			//Ű����� �����͸� �Է��Ͽ� �ؽ� ���̺� ����
			
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
				
				// �������� ���� ��ġ�� ����
				pos = hashValue;
				while(hashTable[pos] != -1 ) {
					// ���� �迭 ��ҿ��� �����͸� ������ �� �ִ��� Ȯ��
					pos ++;
					
					// �迭 ������ ��ұ��� ������ ���� ���� ���θ� Ȯ���ϸ� �迭 ù ��° ��Ҹ� ����					
					if(pos >= hashTable.length) {
						pos = 0;
					}
					
					// �ؽ� ���� �迭 ��� ��ġ���� ���ƿ���, �ؽ� ���̺� �����Ͱ� ���� �� ���̹Ƿ� �ݺ��� ����
					if(pos == hashValue) {
						break;
					}										
				}
				
				if(hashTable[pos] == -1) {
					// �ؽ� ���̺� �����Ͱ� ���� ���� �ʾҴٸ� �����͸� ����
					hashTable[pos] = data;
					
				} else {
					// '�ؽ� ���̺��� ����á���ϴ�'�� ǥ��
					System.out.println("�ؽ� ���̺��� ���� á���ϴ�");
				}
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
				
				// �����͸� Ž��
				pos = hashValue;
				
				while(hashTable[pos]!=-1 && hashTable[pos] != data) {
					// ���� �迭 ��ҷ� Ž�� ��ġ�� �̵�
					pos ++;
					
					// �迭 ������ ��ұ��� Ž���ϸ� �迭 ù ��° ��Ҹ� ����
					if(pos >= hashTable.length) {
						pos = 0;
					}
					
					// -1 �� ã�Ұų�, �ؽ� ���� �ε��� ��ġ�� ���ƿ���, �����͸� ã�� �� ���� ���̹Ƿ� �ݺ��� ����
					if(hashTable[pos] == -1 || pos == hashValue) {
						break;
					}

				}
				
				// Ž���� ����� ǥ��
				if(hashTable[pos] == data) {
					System.out.printf("%d ��°���� �߰ߵǾ����ϴ�. \n", pos);
				} else {
					System.out.printf("ã�� �� �����ϴ� \n ");
				}
			} while(true);
			sc.close();
			
			
		}

}
