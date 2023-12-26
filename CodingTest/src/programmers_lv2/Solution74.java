package CodingTest.src.programmers_lv2;

public class Solution74 {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int maxPlayTime = -1;
        
        // ��ε� ����ִ� # ���� �� ġȯ 
        m = changeMelody(m);
        
        for (String musicInfo : musicinfos){
        	String[] info = musicInfo.split(",");
        	String title =info[2];
        	String melodyInfo = changeMelody(info[3]);
        	// ���� �ð� 
        	String[] timeInfo = info[0].split(":");
        	int start = Integer.valueOf(timeInfo[0])*60 + Integer.valueOf(timeInfo[1]);
        	int end = 0;
        	// ���� �ð� 
        	timeInfo = info[1].split(":");
        	end = Integer.valueOf(timeInfo[0])*60 + Integer.valueOf(timeInfo[1]);
        	
        	// �� ��� �Ⱓ
        	int totalPlay = end - start;
        	
        	// ���Ǳ��� > ��� ���� �Ⱓ 
        	if(totalPlay>melodyInfo.length()) {
        		StringBuilder newMelody = new StringBuilder();
        		
        		// ���� �� ��ŭ �Ǻ� ó������ �ݺ��� 
        		for (int i = 0; i < totalPlay/melodyInfo.length(); i++) {
        			newMelody.append(melodyInfo);
				}
        		
        		// ������ ��ŭ �߶� ���� 
        		newMelody.append(melodyInfo.substring(0, totalPlay%melodyInfo.length()));
        		melodyInfo = newMelody.toString();
        	} else {
        		//  ���Ǳ��� <= ��� ���� �Ⱓ => �� ª���� 
        		melodyInfo = melodyInfo.substring(0, totalPlay);
        	}
        	
        	// ������ ��ġ�ϴ� ������ �������� ��, ����� �ð��� ���� �� ���� ���� ��ȯ 
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
