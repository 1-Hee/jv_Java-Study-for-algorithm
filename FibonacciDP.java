package aglos;

public class FibonacciDP {
	
	public static int[] fibonacciNumbers = new int[100];
	
	
	public static int getfFbonacci(int n) {
		for(int i= 0 ; i <= n ; i ++) {
			if (i == 0) {
				fibonacciNumbers[i] = 0;
			}else if(i == 1) {
				fibonacciNumbers[i] = 1;
			}
			else {
				fibonacciNumbers[i] = fibonacciNumbers[i-1]+fibonacciNumbers[i-2];
			}
		}
		return fibonacciNumbers[n];		
	}
	

	public static void main(String[] args) {
		for(int i = 0 ; i<= 8 ; i++) {
			System.out.printf("%d | ", getfFbonacci(i));
		}
		System.out.println();

	}

}
