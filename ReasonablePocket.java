import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ReasonablePocket {

	public static void main(String[] args) {
		
	

	}

}

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
    
        int[] Width = new int[sizes.length];
		int[] Height = new int[sizes.length];
		int MaxWidth, MaxHeight;
		
		for(int i = 0 ; i < sizes.length ; i++) {
			if(sizes[i][0]<sizes[i][1]) {
				int temp = sizes[i][0];
				sizes[i][0] = sizes[i][1];
				sizes[i][1] = temp;
			}
		}
		
		for(int i = 0; i < sizes.length ; i++) {
			Width[i] = sizes[i][0];
			Height[i] = sizes[i][1];
		}
		
		Arrays.sort(Width);
		Arrays.sort(Height);
		
		MaxWidth = Width[Width.length-1];
		MaxHeight = Height[Height.length-1];
		
		answer = MaxWidth * MaxHeight;
        
        return answer;
    }
}
