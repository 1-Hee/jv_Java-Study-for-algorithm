
public class Matrix_Multiplication {

	public static void main(String[] args) {
		
//		int[][] arr1 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
//		int[][] arr2 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};
		
		
		int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
		int[][] arr2 = {{3, 3}, {3, 3}};
		
		
//		int[][] arr1  = {{1, 2, 3}, {4, 5, 6}};
//		int[][] arr2 = {{1, 4}, {2, 5}, {3, 6}};

//		return : [[14, 32], [32, 77]]
		

		int[][] answer = new int [arr1.length][arr2[0].length];
						
		int row = arr1.length;
		int col = arr2[0].length;
		
		
		int sum = 0;
		
		for(int i = 0 ; i < row ; i++){
			for(int j = 0 ; j < col ; j++){
					for(int k = 0 ; k<arr2.length; k++ ) {
						sum += arr1[i][k] * arr2[k][j];
					}				
				answer[i][j] = sum;
				sum = 0;
			}
		}
		
		for(int i = 0 ; i < answer.length ; i ++) {
			for(int j = 0 ; j < answer[i].length ; j++) {
				System.out.print(answer[i][j]);
				System.out.print(" / ");
			}
			System.out.println();
		}
			

	}

}
