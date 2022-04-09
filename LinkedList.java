package algobook_src;

class StationList{
	public String name;
	public int next;
}

public class LinkedList{
	// ���� ����Ʈ�� ��ü�� �Ǵ� �迭(����� �ִ���� 10���� ����)
	public static StationList[] list = new StationList[10];
	// head ����
	public static int head;
	
	// ���� ����Ʈ�� �ʱ� ���¸� ����� �Լ�
	public static void initStationList() {
		//�ڹٿ����� �ν��Ͻ� ������ �ʿ���.
		// C������ ���ʿ���
		
		for(int i = 0 ; i < list.length ; i++) {
			list[i] = new StationList();
		}
		
		String[] trainst = {"�λ�", "����", "����", "���뱸", "õ�Ⱦƻ�"};
		int[] next = {-1,3,4,0,1};
		for(int i = 0 ; i < trainst.length ; i++) {
			list[i].name = trainst[i];
			list[i].next = next[i];
		}
		
		// head �� ����
		head = 2;
		
		// ���Ḯ��Ʈ�� ��Ҹ� ǥ���ϴ� �޼ҵ�
	}
	
	public static void printStationList() {
		int idx = head;
		while(idx !=-1) {
			System.out.printf("["+list[idx].name+"] �� ");
			idx = list[idx].next; // next �� ����� ���� ã�� ���̸��� ��ȸ�ϵ��� idx���� �缳�� ��
		}
		
		System.out.printf("\n");		
	}
	
	
	// ���� �߰��ϱ� ���� ���� �ۼ��� �Լ�
	// insIdx(insert Index) : ���� ������ ����� �ε��� ����
	// insName(insert Name) : ���� ������ �� �̸��� ����
	// prevIdx(previous index) : ������ ����� �ϳ� �� ����� �ε����� ����
	
	
	public static void insertStationList(int insIdx, String insName, int prevIdx) {
		list[insIdx].name = insName;
		list[insIdx].next = list[prevIdx].next;
		list[prevIdx].next = insIdx;
	}
	
	
	// ���� �����ϱ� ���� ���� �ۼ��ϴ� �Լ�
	// delIdx(delete Index) :  ������ ����� �ε����� ����
	// prevIdx(previous Index) : ������ ����� �ϳ� �� ����� �ε���
	
	public static void deleteStationList(int delIdx, int prevIdx) {
		list[prevIdx].next = list[delIdx].next;
	}
	
	
	
	public static void main(String[] args) {
		// �ʱ������ ���� ����Ʈ�� ǥ����
		
		initStationList();
		printStationList();
		
		// ���Ḯ��Ʈ�� ��Ҹ� �����Ͽ� ǥ��
		insertStationList(5, "����", 2);
		printStationList();
		
		// ���� ����Ʈ���� ��Ҹ� �����Ͽ� ǥ��
		deleteStationList(5, 2);
		printStationList();


		
	}

	 
	
	
}