package al_sty0001;

import java.util.Scanner;

public class LinearSearch {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] Array1 = {41, 58, 78, 23, 64, 22, 16, 44, 88, 76, 52, 58};
		System.out.println("배열 속에 찾고자 하는 x를 입력하세요");
		int x = sc.nextInt();
		int index = 0;
		int pos = -1;
		sc.close();
		
		for (int i = 0; i <Array1.length ; i++) {
			if(Array1[i]==x) {
				pos = x;
				index = i;
				break;
			}
		}
		
		if(pos != -1) {
			System.out.printf("당신이 입력한 숫자 %d는 %d번째에 있습니다", x, index+1);
		} else {
			System.out.println("당신이 입력한 숫자를 찾을 수 없었습니다");
		}

		
		

	}

}
