package algobook_src;

import java.util.Scanner;

public class knapsackGA {
	
	public static final int KNAP_MAX = 6; 							// �賶�� �ִ� ����
	public static final int ITEM_NUM = 5; 							// ������ ������
	public static final int IND_NUM = 8; 							// ��ü��
	public static final double MUTATE_RATE = 0.1; 					// �������� Ȯ�� 10%;
	
	public static char[] itemName = {'A', 'B', 'C', 'D', 'E'}; 		// ������ �̸�
	public static int[] itemWeight = {1,2,3,4,5}; 					// ������ ����
	public static int[] itemValue = {100,300,350,500,650}; 			// ������ ��ġ
	
	public static int indGeneration; // ��ü�� ����
	public static int[][] indGene = new int[IND_NUM][ITEM_NUM]; 	// ��ü�� ������
	public static int[] indWeight = new int[IND_NUM]; 				// ��ü�� ����
	public static int[] indValue = new int[IND_NUM]; 				// ��ü�� ��ġ
	public static int[] indFitness = new int[IND_NUM];				// ��ü�� ������
	
	//��ü�� �������� �����ϴ� �޼���
	public static void createIndividual() {
		int ind, item; //���� ī����
		
		// 0�Ǵ� 1�� �������� ����
		for(ind = 0 ; ind <IND_NUM ; ind++) {
			for(item = 0 ; item < ITEM_NUM ; item++) {
				indGene[ind][item] = Math.random() > 0.5 ? 0:1;
			}
		}
	}
	
	
	//��ü�� ����, ��ġ, �������� ����ϴ� �޼���
	public static void calcIndividual() {
		int ind, item; //���� ī����
		for(ind = 0; ind <IND_NUM ; ind++) {
			//���Կ� ��ġ�� ���
			indWeight[ind] = 0;
			indValue[ind]=0;
			for(item=0; item < ITEM_NUM; item++) {
				if(indGene[ind][item]==1) {
					indWeight[ind]+=itemWeight[item];
					indValue[ind]+=itemValue[item];
				}
			}
			
			//�������� ���
			if(indWeight[ind] <= KNAP_MAX) {
				//�ִ� ���� ���ϸ� ��ġ�� �״�� �������� ����
				indFitness[ind] = indValue[ind];
			} else {
				//�ִ� ���Ը� �ʰ��ϸ� �������� 0���� ��
				indFitness[ind] = 0;
			}
		}
	}
	
	//��ü�� �������� ǥ���ϴ� �޼ҵ�
	public static void showIndividual() {
		int ind, item;
		
		//���븦 ǥ��
		System.out.printf("\n<%d����>\n", indGeneration);
		
		//������, ����, ��ġ, �������� ǥ��		
		System.out.printf("������\t\t����\t��ġ\t������\n");
		
		for(ind = 0 ; ind <IND_NUM ; ind++) {
			for(item = 0; item<ITEM_NUM ; item++) {
				System.out.printf("[%d]", indGene[ind][item]);
			}
			System.out.printf("\t%2dkg\t%4d��\t%4d\n", indWeight[ind], indValue[ind], indFitness[ind]);
		}
		System.out.printf("\n");
	}
	
	// �������� ū ������� ��ü�� �����ϴ� �޼ҵ�
	public static void sortIndividual() {
		int pos; 	// ������ ���
		int ins; 	// ������ ��ġ
		int item; 	// ���� ī����
		int temp; 	// �ӽú���
		
		// ���� ���ķ� ����
		for(pos=1 ; pos <IND_NUM; pos++) {
			ins = pos;
			while(ins>=1 && indFitness[ins-1] < indFitness[ins]) {
				for(item=0; item< ITEM_NUM; item++) {
					temp = indGene[ins-1][item];
					indGene[ins-1][item] = indGene[ins][item];
					indGene[ins][item]=temp;
				}
				
				temp =indWeight[ins-1];
				indWeight[ins-1] = indWeight[ins];
				indWeight[ins] = temp;
				
				temp = indValue[ins-1];
				indValue[ins-1] = indValue[ins];
				indValue[ins] = temp;
				
				temp = indFitness[ins-1];
				indFitness[ins-1] = indFitness[ins];
				indFitness[ins] = temp;
				
				ins--;
								
			}
		}				
	}
	
	// ���¸� �����ϴ� �޼���
	public static void selectIndividual() {
		int ind, item;
		
		// ������ ���� 50%�� ���� 50%�� ����(���� 50%�� ���½�Ŵ)
		for(ind=0; ind<IND_NUM/2; ind++) {
			for(item = 0; item<ITEM_NUM; item++) {
				indGene[ind+IND_NUM/2][item] = indGene[ind][item];
			}			
		}
		System.out.println("���� 50%�� ���½��׽��ϴ�.\n");
	}
	
	//������ �����ϴ� �Լ�
	public static void crossoverIndividual() {
		int ind, item; 			//���� ī����
		int crossoverPoint; 	//���� ���� ��ġ
		int temp; 				// �ӽú���
		
		// ���� 50%�� ������ ��ü�� ������� ��
		for(ind = IND_NUM/2; ind<(IND_NUM-1); ind+=2) {
			//������ ��ġ�� ���Ƿ� ����
			crossoverPoint = (int)(Math.random() * 10000)%(ITEM_NUM-1) +1;
			for(item=crossoverPoint; item<ITEM_NUM ; item++) {
				// �̿� ��ü�� ���� ����
				temp = indGene[ind][item];
				indGene[ind][item] = indGene[ind+1][item];
				indGene[ind+1][item] = temp;
			}
			System.out.printf("��ü %d�� %d�� %d�� ��ġ���� �����߽��ϴ�. \n", ind, ind+1, crossoverPoint);
		}
	}
	
	
	// �������̸� ����� �޼ҵ�
	public static void mutateIndividual() {
		int ind, item;
		//���� 50%�� ������ ��ü�� ������� ��.
		for(ind = IND_NUM/2; ind<IND_NUM; ind++) {
			for(item=0; item<ITEM_NUM; item++) {
				// �̸� ������ Ȯ���� �������� �����
				if(Math.random() <= MUTATE_RATE) {
					//������ ������ ������
					indGene[ind][item] ^= 1;
					System.out.printf("��ü %d�� %d ��ġ���� �������̸� ��������ϴ�.\n", ind, item);				
				}
			}
		}
	}
	

	public static void main(String[] args) {
		int genMax; 		// �ִ뼼��
		int item; 			// ���� ī����
		
		// Ű����� �ִ� ���븦 �Է�
		Scanner sc = new Scanner(System.in);
		System.out.print("�ִ� ���� : ");
		genMax = sc.nextInt();
		sc.close();
		
		// 1���� ��ü�� ����
		indGeneration = 1;
		createIndividual();
		
		// �������� ���
		calcIndividual();
		
		// �������� ū ������� ��ü�� ����
		sortIndividual();
		
		// ��ü�� ǥ��
		showIndividual();
		
		// 1���뾿 ��ȭ��Ű��
		indGeneration++;
		while(indGeneration<=genMax){
			// �������� ū ������ ��ü�� ����
			sortIndividual();
			
			// ���½�Ŵ
			selectIndividual();
			
			//������Ŵ
			crossoverIndividual();
			
			//�������� ��Ŵ
			mutateIndividual();
			
			//�������� ����
			calcIndividual();
			
			//�������� ū ������ ��ü�� ����
			sortIndividual();
			
			// ��ü�� ǥ��
			showIndividual();
			
			//���� ����� ���ư�
			indGeneration++;
		}
		
		// �������� ���� ���� ��ü�� �������� ǥ��
		System.out.printf("<�賶�� ����ִ� ������ ǥ��>\n");
		for(item = 0 ; item<ITEM_NUM; item++) {
			if(indGene[0][item]==1) {
				System.out.printf("%c, %dkg, %d\n", 
						itemName[item], itemWeight[item], itemValue[item]);
			}
		}
		
		System.out.printf("\n<������ ǥ��>\n");
		System.out.printf("������ �հ� = %dkg\n", indWeight[0]);
		System.out.printf("��ġ�� �ִ밪 = %d��\n", indValue[0]);

		
		

	}

}
