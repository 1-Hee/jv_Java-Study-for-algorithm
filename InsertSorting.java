package al_std0004;

public class InsertSorting {

	public static void main(String[] args) {
		
		int [] Array1 = {90, 34, 78, 12, 56};
		int ins, cmp, temp;
		
		for(int i = 0 ; i < Array1.length ; i ++) {
			System.out.printf("[ %d ]", Array1[i]);
		} System.out.println();
		
		for (ins = 1 ; ins < Array1.length; ins++) {
			temp = Array1[ins];
			for(cmp = ins-1 ; cmp >=0 ; cmp--) {
				if(Array1[cmp] > temp) {
					Array1[cmp+1] = Array1[cmp];
				} else {
					System.out.println("break");
					break;
				}
			} Array1[cmp+1] = temp;
		}
		
		for(int i = 0 ; i < Array1.length ; i ++) {
			System.out.printf("[ %d ]", Array1[i]);
		} System.out.println();

	}

}
