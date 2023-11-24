package programmers_lv2;

public class Solution64 {
	public static void main(String[] args) {
		Solution64 s = new Solution64();
		s.solution("aabbaccc");
		
	}
	
	public int solution(String s) {
        int answer = s.length();
        int half = s.length()/2;

		if(s.length()==1){
			return 1;
		}
        for (int i = 1; i <= half; i++) { // ����
			int currentLen = check(i, s);
			answer = Math.min(currentLen, answer);
		}
        return answer;
    }

	private int check(int itrVal, String str) {
		StringBuilder builder = new StringBuilder();
		String startStr = str.substring(0, itrVal); // ó�� �� ����
		int cnt = 1; // ó������ ���������� 1��

		for (int i = itrVal; i <= str.length(); i+=itrVal) { // ���ڿ��� ���� ��ŭ

			// *** ���ݺ��� �����ִٰ�, �� ���̺��� Ŀ����, �� ���̸� ��ȯ�� **
			int endIdx = Math.min(i+itrVal, str.length());
			String curStr = str.substring(i, endIdx); // �ش� ���� ��ŭ �ɰ�
//			if(startStr.equals("")) {
//				// ���� �������� �ʴ� ���, ó���̰ų� �ƴϸ� ������� �� �ٷ� ����
//				startStr = curStr;
//			}
			if(startStr.equals(curStr)) {
				// ���� ������ ����� 
				cnt++;
				//continue;
			}else {
				if(cnt>1) {
					// 2���̻� ����, ���ڸ� �������
					builder.append(cnt);
					// builder.append(startStr);
				}
				builder.append(startStr);
				startStr = curStr;
				cnt=1; // �ߺ����� �ʱ�ȭ��
//				startStr = ""; // ó������ �ʱ�ȭ
//				cnt=0; // �ߺ����� �ʱ�ȭ��
			}
		}
		builder.append(startStr); // ������ ���� ������
		// endIdx�� ����鼭 ������� �ʾƵ� ��
//		if(cnt>1) {
//			// ��� ��ŭ ���� ���� �����ٰ� ��� ������ �ٷ� for �� ������ ���� ��� ��ĥ ���� ����
//			builder.append(String.valueOf(cnt));
//			builder.append(startStr);
//		}
//
//		if(str.length()%itrVal>0) {
//			// ������ �������� �ʴ� ���
//			int restStartIdx = str.length() - itrVal;
//			String restStr = str.substring(restStartIdx);
//			builder.append(restStr);
//		}
		return builder.length();
	}
}
