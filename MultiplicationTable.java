package al_std0003;

public class MultiplicationTable {

	public static void main(String[] args) {
		
		int step, num;
		
		for(step = 1; step <10; step++) {
			for(num = 1 ; num<10; num++) {
				System.out.printf("%d x %d = %d\n", step, num, step*num);
			}
		}
		
		

	}

}
