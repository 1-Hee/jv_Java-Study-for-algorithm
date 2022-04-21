package aglos;

public class KnapsackDP {
	
	//�賶�� �ִ� ����
	public static final int KNAP_MAX = 6;
	// ������ ����
	public static final int ITEM_NUM = 5;
	// ������ ��Ī
	public static char[] name = {'A', 'B', 'C', 'D', 'E'};
	// ������ ����
	public static int[] weight = {1,2,3,4,5};
	// ������ ����
	public static int[] value = {100,300,350,500,650};
	
	// ������ ������ �Ǵ��� ������ �ִ� ��ġ(����, ������ ���� �迭)
	public static int[][] maxValue = new int[ITEM_NUM][KNAP_MAX+1];
	// �������� ���� ����
	public static int[] lastItem = new int[KNAP_MAX +1];
	
	// item ��° ������ ������ �Ǵ��� ���� ������ ������ ǥ���ϴ� �޼ҵ�
	public static void showKnap(int item) {
		int knap ; // 0~6kg �賶�� ����Ŵ
		// ������ ���� �Ǵ��� ������ ������ ǥ��
		System.out.printf("<%c, %dkg,%d���� ����� ���>\n", name[item], weight[item], value[item]);
		
		// �� �賶�� ���Ը� ǥ��
		for(knap = 0 ; knap <= KNAP_MAX; knap++) {
			System.out.printf("%d kg \t", maxValue[item][knap]);
		}
		System.out.printf("\n");
		
		// �賶�� ��� ��ǰ ��ġ�� �հ踦 ǥ��
		for(knap = 0 ; knap <= KNAP_MAX; knap++) {
			System.out.printf("%d�� \t", maxValue[item][knap]);
		}
		System.out.printf("\n");

		// �賶�� ���������� ���� ������ ǥ��
		for(knap = 0 ; knap <= KNAP_MAX; knap++) {
			if(lastItem[knap] != -1) {
				System.out.printf("%c \t", name[lastItem[knap]]);
			} else {
				System.out.printf("���� \t");
			}
		}
		System.out.printf("\n\n");

	}

	// ���α׷� ������ �������� main �޼���
	public static void main(String[] args) {
		int item; 	// ������ ��ȣ
		int knap; 	// 0~6kg�� �質�� ����Ŵ
		int selVal; 	// �ӽ÷� ������ ������ ����� ��ġ �հ�
		int totalWeight; // �߷��� �հ�
		
		//0 ��° ������ ������ �Ǵ�
		item = 0;
		// 0~KNAP_MAX kg�� �賶�� ���
		for(knap = 0; knap <= KNAP_MAX ; knap++) {
			// �ִ빫�� ���ϸ� ����
			if(weight[item]<=knap) {
				maxValue[item][knap] = value[item];
				lastItem[knap] = item;
			}
			
			// �ִ� ���� ���ϰ� �ƴϸ� �������� ����
			else {
				maxValue[0][knap]=0;
				lastItem[knap] = -1;
			}
		}
		showKnap(item);
		
		// 1��° ~ITEM_NUM-1 ��° ������ ���
		for(item = 1; item < ITEM_NUM; item++) {
			// 0kg ~ KNAP_MAXkg�� �賶�� ���
			for(knap=0; knap <= KNAP_MAX; knap++) {
				// �ִ� ���� ������ ���
				if(weight[item] <= knap) {
					// ������ ����� ��ġ�� ����
					selVal = maxValue[item-1][knap-weight[item]]+value[item];
					//��ġ�� ũ�� ����
					if(selVal > maxValue[item-1][knap]) {
						maxValue[item][knap] = selVal;
						lastItem[knap] = item;
					}
					// ��ġ�� ũ�� ������ �������� ����
					else {
						maxValue[item][knap] = maxValue[item-1][knap];
					}
				}
				//�ִ� ���� ���ϰ� �ƴϸ� �������� ����
				else {
					maxValue[item][knap] = maxValue[item-1][knap];
				}
			}
			showKnap(item);
		}
			
			// �賶�� ��� �ִ� ������ �����Ͽ� ������ ǥ��
			System.out.printf("<�賶�� ����ִ� ������ ����>\n");
			totalWeight = 0;
			for(knap = KNAP_MAX; knap >0; knap-=weight[item]) {
				item = lastItem[knap];
				System.out.printf("%dkg�� �賶�� ���������� ���� ������ %c �Դϴ�\n", knap, name[item]);
				totalWeight += weight[item];
				System.out.printf("%c %dkg, %d��\n", name[item], weight[item], value[item]);				
				System.out.printf("%d kg - %d kg = %d kg �Դϴ� \n", knap, weight[item], knap-weight[item]);
				System.out.printf("\n<������ ǥ��>");
				System.out.printf("������ �հ� = %d kg\n", totalWeight);
				System.out.printf("��ġ�� �ִ밪 = %d��\n", maxValue[ITEM_NUM-1][KNAP_MAX]);
			
			}
		
		

	}

}
