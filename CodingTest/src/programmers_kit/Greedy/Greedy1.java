package programmers_kit.Greedy;

public class Greedy1 {
	public int solution(String name) {
        int answer = 0;
        int move = name.length()-1;
        
        // 1) �� �Ʒ��� ������ ���� : �ش� ������ - A / ��ü���� (�ش�� - A) �� ª�� ������ �ö� 
        // 2) �ε��� ���� �� �߿�, �� �������� A �� ��� 
        
        for (int i = 0; i < name.length(); i++) {
			answer+=Math.min(name.charAt(i)-'A', 'Z'-name.charAt(i));
			
			// �� �������� A ��� A�� ������ ��ġ ã�� 
			int idxNow = i + 1;
			while(idxNow<name.length()&&name.charAt(idxNow)=='A') {
				idxNow++;
			}
			
			
			
		}
        
        
        return answer;
    }

}
