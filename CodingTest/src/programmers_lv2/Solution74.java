package CodingTest.src.programmers_lv2;

public class Solution74 {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int maxPlayTime = -1;
        
        // 멜로디에 들어있는 # 붙은 음 치환 
        m = changeMelody(m);
        
        for (String musicInfo : musicinfos){
        	String[] info = musicInfo.split(",");
        	String title =info[2];
        	String melodyInfo = changeMelody(info[3]);
        	// 시작 시간 
        	String[] timeInfo = info[0].split(":");
        	int start = Integer.valueOf(timeInfo[0])*60 + Integer.valueOf(timeInfo[1]);
        	int end = 0;
        	// 종료 시간 
        	timeInfo = info[1].split(":");
        	end = Integer.valueOf(timeInfo[0])*60 + Integer.valueOf(timeInfo[1]);
        	
        	// 총 재생 기간
        	int totalPlay = end - start;
        	
        	// 음악길이 > 재생 지속 기간 
        	if(totalPlay>melodyInfo.length()) {
        		StringBuilder newMelody = new StringBuilder();
        		
        		// 나눈 몫 만큼 악보 처음부터 반복함 
        		for (int i = 0; i < totalPlay/melodyInfo.length(); i++) {
        			newMelody.append(melodyInfo);
				}
        		
        		// 나머지 만큼 잘라서 붙힘 
        		newMelody.append(melodyInfo.substring(0, totalPlay%melodyInfo.length()));
        		melodyInfo = newMelody.toString();
        	} else {
        		//  음악길이 <= 재생 지속 기간 => 더 짧아짐 
        		melodyInfo = melodyInfo.substring(0, totalPlay);
        	}
        	
        	// 조건이 일치하는 음악이 여러개일 떄, 재생된 시간이 제일 긴 음악 제목 반환 
        	if(melodyInfo.contains(m) && totalPlay>maxPlayTime) {
        		answer = title;
        		maxPlayTime = totalPlay;
        	}
        	
        }

        return maxPlayTime != -1 ? answer : "(None)";
    }

	private String changeMelody(String m) {
		m = m.replaceAll("C#", "H");
		m = m.replaceAll("D#", "I");
		m = m.replaceAll("F#", "J");
		m = m.replaceAll("G#", "K");
		String newM = m.replaceAll("A#", "L");
		return newM;
	}
}
