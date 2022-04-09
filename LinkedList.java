package algobook_src;

class StationList{
	public String name;
	public int next;
}

public class LinkedList{
	// 연결 리스트의 실체가 되는 배열(요소의 최대수는 10으로 설정)
	public static StationList[] list = new StationList[10];
	// head 선언
	public static int head;
	
	// 연결 리스트의 초기 상태를 만드는 함수
	public static void initStationList() {
		//자바에서는 인스턴스 생성이 필요함.
		// C에서는 불필요함
		
		for(int i = 0 ; i < list.length ; i++) {
			list[i] = new StationList();
		}
		
		String[] trainst = {"부산", "대전", "서울", "동대구", "천안아산"};
		int[] next = {-1,3,4,0,1};
		for(int i = 0 ; i < trainst.length ; i++) {
			list[i].name = trainst[i];
			list[i].next = next[i];
		}
		
		// head 값 설정
		head = 2;
		
		// 연결리스트의 요소를 표시하는 메소드
	}
	
	public static void printStationList() {
		int idx = head;
		while(idx !=-1) {
			System.out.printf("["+list[idx].name+"] → ");
			idx = list[idx].next; // next 에 저장된 값을 찾아 역이름을 순회하도록 idx값을 재설정 함
		}
		
		System.out.printf("\n");		
	}
	
	
	// 역을 추가하기 위해 새로 작성할 함수
	// insIdx(insert Index) : 새로 삽입할 요소의 인덱스 결정
	// insName(insert Name) : 새로 삽입할 역 이름을 지정
	// prevIdx(previous index) : 삽입할 요소의 하나 앞 요소의 인덱스를 지정
	
	
	public static void insertStationList(int insIdx, String insName, int prevIdx) {
		list[insIdx].name = insName;
		list[insIdx].next = list[prevIdx].next;
		list[prevIdx].next = insIdx;
	}
	
	
	// 역을 제거하기 위해 새로 작성하는 함수
	// delIdx(delete Index) :  삭제할 요소의 인덱스를 지정
	// prevIdx(previous Index) : 삭제할 요소의 하나 앞 요소의 인덱스
	
	public static void deleteStationList(int delIdx, int prevIdx) {
		list[prevIdx].next = list[delIdx].next;
	}
	
	
	
	public static void main(String[] args) {
		// 초기상태의 연결 리스트를 표시함
		
		initStationList();
		printStationList();
		
		// 연결리스트에 요소를 삽입하여 표시
		insertStationList(5, "광명", 2);
		printStationList();
		
		// 연결 리스트에서 요소를 제거하여 표시
		deleteStationList(5, 2);
		printStationList();


		
	}

	 
	
	
}