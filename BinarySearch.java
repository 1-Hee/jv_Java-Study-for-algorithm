package al_std0002;

import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] Array1 = {39, 41, 44, 55, 67, 89, 93, 99};
		System.out.println("배열 속에 찾고자 하는 x를 입력하세요");
		int x = sc.nextInt();
		
		int pos = -1;
		int left = 0;
		int right = Array1.length-1;
		sc.close();
		
		while(pos == -1 && left <= right) {
			int middle = (left+right)/2;
			if(Array1[middle] == x) {
				pos = middle;
			} else if (Array1[middle] > x) {
				right=middle-1;				
			} else {
				left=middle-1;				
			}
					
		}
		
		if(pos != -1) {
			System.out.printf("당신이 입력한 숫자 %d는 %d번째에 있습니다", x, pos+1);
		} else {
			System.out.println("당신이 입력한 숫자를 찾을 수 없었습니다");
		}

		
		

	}

}
