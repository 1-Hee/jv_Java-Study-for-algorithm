import java.util.ArrayList;
import java.util.Arrays;

public class KakaoDclarationSystem {

	public static void main(String[] args) {
		
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		
//		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
//		String[] report = {"muzi frodo","muzi frodo","muzi neo","neo muzi","muzi frodo"};
		
		int k = 2;
		
		String[][] Rec = new String[report.length][2];
		String[][] TreatRec = new String[report.length][2];
		String[][] Sign = new String[id_list.length][2];
		String[][] Mail = new String[id_list.length][2];
		ArrayList Ban = new ArrayList<>();
		int[] answer = new int[id_list.length];
		
		for(int i = 0 ; i < id_list.length ; i++) {
			Sign[i][0] = id_list[i];
			Sign[i][1] = "";
			Mail[i][0] = id_list[i];
			Mail[i][1] = "";
		}
		
		Arrays.sort(report);

		for(int i = 0 ; i < report.length ; i++) {
			Rec[i] = report[i].split(" ");
			
			if(i>0) {
				if(!(Rec[i][0].equals(Rec[i-1][0]) && Rec[i][1].equals(Rec[i-1][1]))) {
					TreatRec[i][0] = Rec[i][0];
					TreatRec[i][1] = Rec[i][1];
					
					for(int j = 0 ; j < Sign.length ; j++) {
						if (Sign[j][0].equals(Rec[i][1])) {
							Sign[j][1]+="1";
						}
					}					
				}
			} else {
				TreatRec[i][0] = Rec[i][0];
				TreatRec[i][1] = Rec[i][1];
				for(int j = 0 ; j < Sign.length ; j++) {					
					if (Sign[j][0].equals(Rec[i][1])) {
						Sign[j][1]+="1";
					}
				}				
			}
		}
		
		for(int i = 0 ; i < Sign.length ; i++) {
			if(Sign[i][1].length() >=k) {
				Ban.add(Sign[i][0]);
			}			
		}
		
		
		for(int i = 0 ; i < TreatRec.length ; i++) {
			if(TreatRec[i][0]!=null) {
				for(int t = 0 ; t <Ban.size(); t++) {
					if(TreatRec[i][1].equals(Ban.get(t))) {
						for(int r = 0 ; r < Mail.length ; r++) {
							if(TreatRec[i][0].equals(Mail[r][0])) {
								Mail[r][1] += 1;
							}
						}
						
					}
				}
			}
		}
		
		for (int i = 0 ; i < Mail.length ; i++) {
			answer[i] = Mail[i][1].length();
		}

	}

}
