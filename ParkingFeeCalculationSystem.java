import java.util.ArrayList;

public class ParkingFeeCalculationSystem {

	public static void main(String[] args) {
		int[] fees = {180, 5000, 10, 600};
		String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
		
		
		// int[] fees = {120, 0, 60, 591};
		// String[] records = {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};
		
		//int[] fees = {1, 461, 1, 10};	
		//String[] records = {"00:00 1234 IN"};
		
		
		
		///
String[][] Rec = new String[records.length][3];
		
        for(int ins=1 ; ins < records.length ; ins++) {
        	int cmp;
        	String temp = records[ins];
        	int tempInt = Integer.valueOf((String) records[ins].subSequence(6, 10));
        	for(cmp = ins-1; cmp >=0 ; cmp--) {
        		
        		int control = Integer.valueOf((String) records[cmp].subSequence(6, 10));
        		
        		if(control > tempInt) {
        			records[cmp+1] = records[cmp];        			
        		} else {
        			break;        			
        		}
        	}records[cmp+1]= temp; 
        	
        }
        
		ArrayList CarNum = new ArrayList<>();

		for(int i = 0 ; i < records.length ; i++) {
			Rec[i] = records[i].split(" ");
			
			if(!CarNum.contains(Rec[i][1])) {
				CarNum.add(Rec[i][1]);
			}
		}
		
		
		String[] time = new String[2];
		for(int i = 0 ; i < Rec.length ; i++) {
			time = Rec[i][0].split(":");
			Rec[i][0] = String.valueOf(Integer.valueOf(time[0])*60+Integer.valueOf(time[1]));			
		}
		
		int[][] carBoard = new int [CarNum.size()][3];
		
		for(int i = 0 ; i < CarNum.size() ; i++) {
			carBoard[i][0] = Integer.valueOf((String) CarNum.get(i));
		}
		
		
		for(int i = 0 ; i < Rec.length ; i++) {
			if(Rec[i][2].equals("OUT")) {
				int start = Integer.valueOf(Rec[i-1][0]);
				int end = Integer.valueOf(Rec[i][0]);
				for(int v = 0 ; v < carBoard.length ; v++) {
					if(carBoard[v][0] == Integer.valueOf(Rec[i][1])) {
						carBoard[v][1] += (end-start);
					}
				}				
			} else {
				
				if(i==Rec.length-1) {
						int start = Integer.valueOf(Rec[i][0]);
						for(int v = 0 ; v < carBoard.length ; v++) {
							if(carBoard[v][0] == Integer.valueOf(Rec[i][1])) {
									carBoard[v][1] += (1439-start);
							}
						}						
										
				} else {
					if(Rec[i+1][2].equals("IN")) {
						int start = Integer.valueOf(Rec[i][0]);
						for(int v = 0 ; v < carBoard.length ; v++) {
							if(carBoard[v][0] == Integer.valueOf(Rec[i][1])) {
									carBoard[v][1] += (1439-start);
							}
						}						
					}
				}


			}
			
		}
		
		int[] answer = new int[CarNum.size()];
		
		for(int i = 0 ; i < carBoard.length ; i++) {
			if(carBoard[i][1]<=fees[0]) {
				carBoard[i][2] = fees[1];
			} else {
				int cal = carBoard[i][1]-fees[0];
				carBoard[i][2] += fees[1];
				if(cal%fees[2]==0) {
					carBoard[i][2] += ((cal/fees[2])*fees[3]);
				} else {
					carBoard[i][2] += (((cal/fees[2])+1)*fees[3]);					
				}				
			}
			answer[i]=carBoard[i][2];
		}

	}

}
