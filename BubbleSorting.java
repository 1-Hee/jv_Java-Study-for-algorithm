package al_std0005;

public class BubbleSorting {

	public static void main(String[] args) {
		
		
		int ins, cmp, temp;
		
		int Array1[] = {10, 55, 94, 27, 64, 65, 32, 24, 77};
		
		
		System.out.println("정렬전 배열의 순서 :");
		for(int i = 0; i < Array1.length; i++) {
			System.out.printf("[ %d ]", Array1[i]);
		}
		System.out.printf("\n");
					
		
		for (ins=0; ins < Array1.length; ins++) {
			for(cmp=0; cmp < Array1.length-ins-1; cmp++) {
				if(Array1[cmp] > Array1[cmp+1]) {
					temp = Array1[cmp];
					Array1[cmp] = Array1[cmp+1];
					Array1[cmp+1] = temp;
				}
			}
		}
		
		System.out.println("정렬 후 배열의 순서 :");
		for(int i = 0; i < Array1.length; i++) {
			System.out.printf("[ %d ]", Array1[i]);
		}
		System.out.printf("\n");


	}

}
