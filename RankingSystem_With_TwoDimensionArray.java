import java.util.ArrayList;
import java.util.Arrays;

public class RankingSystem_With_TwoDimensionArray {

	public static void main(String[] args) {
		
		
		// int[] stages = {2,1,2,6,2,4,3,3};
		int[] stages = {4,4,4,4};

		// int N = 5;
		int N = 4;
		////
			
		int PlayerNumber = stages.length;

		
		int[] failerNum= new int[N];
		double[] failRatio = new double[N];
		double[][] RatioRank = new double[N][2];

		int count = 0;

		
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < PlayerNumber ; j++) {
				if(i+1==stages[j]) {
					count++;
				} 
			}
			failerNum[i] = count;
			count=0;
		}
		
		for(int i = 0 ; i <failRatio.length;i++) {
			
			int past = 0;
			for(int j=0; j<i ; j++) {
				past +=failerNum[j];
			}
			if(failerNum[i]!=0) {
				double failratio = (double) failerNum[i]/ (double) (PlayerNumber- past);
				failRatio[i] = failratio;
			} else {
				failRatio[i] = 0;
			}
		}
		
		for(int i = 0 ; i < N ; i++) {
			RatioRank[i][0] = i;
			RatioRank[i][1] = failRatio[i];
		}
		
		int ins, cmp;
		double temp1, temp2;
		
        for(ins=1 ; ins < RatioRank.length ; ins++) {
        	temp1 = RatioRank[ins][1];
        	temp2 = RatioRank[ins][0];
        	for(cmp = ins-1; cmp >=0 ; cmp--) {        		
        		if((double) RatioRank[cmp][1]<temp1) {
        			RatioRank[cmp+1][1] = RatioRank[cmp][1];
        			RatioRank[cmp+1][0] = RatioRank[cmp][0];
        		} else {
        			break;        			
        		}
        	}RatioRank[cmp+1][1]= temp1;
			RatioRank[cmp+1][0] = temp2;

        }
        
        int answer[] = new int[RatioRank.length];

        for(int i= 0 ; i < answer.length ; i++) {
        	answer[i] = (int) RatioRank[i][0]+1;
        }
        		


	}

}

