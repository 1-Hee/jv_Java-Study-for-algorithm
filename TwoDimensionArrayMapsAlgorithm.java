
public class TwoDimensionArrayMapsAlgorithm {

	public static void main(String[] args) {
		
		Solution sc = new Solution();

	}

}
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        
        String [][] trans1 = new String [n][n];
		String [][] trans2 = new String [n][n];
		int [][] result = new int[n][n];
		
		
		for(int i = 0 ; i <arr1.length ; i++) {
			String binaryString = Integer.toBinaryString(arr1[i]);
			
			int count;
			String front = "", finalBinaryString;
			
			for(count = binaryString.length() ; count < n; count++) {
				front+="0";
			}
			finalBinaryString = front+binaryString;
			
			for(int j = 0 ; j<finalBinaryString.length() ; j++) {
				trans1[i][j] = String.valueOf(finalBinaryString.charAt(j));						
						
			}
			
		}
		
		for(int i = 0 ; i <arr2.length ; i++) {
			String binaryString = Integer.toBinaryString(arr2[i]);
			
			int count;
			String front = "", finalBinaryString;
			
			for(count = binaryString.length() ; count < n; count++) {
				front+="0";
			}
			finalBinaryString = front+binaryString;
			
			for(int j = 0 ; j<finalBinaryString.length() ; j++) {
				trans2[i][j] = String.valueOf(finalBinaryString.charAt(j));						
						
			}
			
		}
		
		for(int i = 0 ; i < n; i++) {
			for(int j = 0 ; j <n; j ++) {
				result[i][j]= Integer.valueOf(trans1[i][j]) + Integer.valueOf(trans2[i][j]);
			}
		}
		
		String[] answer = new String[n];
		
		for(int i = 0 ; i < n; i ++) {
			String Test = "";
			
			for(int j = 0 ; j <n ; j++) {
				if(result[i][j]>0) {
					Test += "#";
				} else {
					Test += " ";
				}			
			}
			
			answer[i]=Test;

		}
        
        return answer;
    }
}



