package al_std0006;

public class SelectionSorting {

	public static void main(String[] args) {
		
		int ins, cmp, min, temp;
		
		int Array1[] = {90, 88, 56, 21, 34, 58, 74, 66, 32, 80};
		
		System.out.println("정렬 전 배열의 순서");
		for(int i = 0 ; i < Array1.length; i ++) {
			System.out.printf("[ %d ] ", Array1[i]);
		}
		System.out.printf("\n");
		
		for(ins = 0; ins < Array1.length-1; ins++) {
			min = ins;
			for(cmp = ins+1 ; cmp < Array1.length; cmp++) {
				if(Array1[cmp] < Array1[ins]) {
					min = cmp;
					temp = Array1[ins];
					Array1[ins] = Array1[min];
					Array1[min] = temp;
				}
			}
		}
		
		System.out.println("정렬 후 배열의 순서");
		for(int i = 0 ; i < Array1.length; i ++) {
			System.out.printf("[ %d ] ", Array1[i]);
		}
		System.out.printf("\n");


	}

}
