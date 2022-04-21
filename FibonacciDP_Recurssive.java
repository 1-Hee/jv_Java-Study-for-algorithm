package aglos;

public class FibonacciDP_Recurssive {
	
	public static int[] fibonacciNumbers = new int[100];
	
	public static void initfibonacciNumbers() {
		for(int i = 0 ; i<fibonacciNumbers.length ; i++) fibonacciNumbers[i] = -1;
	}
	
	public static int fibonacci(int n) {
		if(fibonacciNumbers[n]==-1) {
			if(n==0) fibonacciNumbers[n]=0;
			else if(n==1) fibonacciNumbers[n]=1;
			else {
				fibonacciNumbers[n] = fibonacci(n-1) + fibonacci(n-2);
			}
		}
		return fibonacciNumbers[n];
	}
	
	

	public static void main(String[] args) {
		
		initfibonacciNumbers();
		System.out.printf("%d 번째 피보나치 수는 : %d \n",5, fibonacci(5));

	}

}
