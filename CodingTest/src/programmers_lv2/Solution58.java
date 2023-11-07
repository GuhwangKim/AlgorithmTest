package CodingTest.src.programmers_lv2;

import java.util.HashSet;

public class Solution58 {
	String[] userId;
	String[] banId;
	HashSet<HashSet<String>> result = new HashSet<HashSet<String>>();
	
    public int solution(String[] user_id, String[] banned_id) {
        /*
        * 1. b �迭�� ���ҵ��� ���� �������� ������
        * 2. u �迭���� ���� ���� �ϳ��� ���� b �迭�� ����
        * 3. b>u ���Ұ��� ���̰� ū ��� break �� ���� u ���ҷ� �Ѿ
        * 4. ���� ��� ���� �ϳ��� ����
        *   ���ߴµ� ���� ���ٸ�
        * 5. �׷��� ���� ��� 0 ����
        *
        * */
        
        // 1. ��ŷ�� �ش��ϴ� ���� ã������ ��� �ߺ�ó�� �� ������ 
        userId = user_id;
        banId = banned_id;
        
        DFS(new HashSet<>(), 0);

        return result.size();
    }

	private void DFS(HashSet hashSet, int depth) {
		if(depth == banId.length) {
			// �����ϴ� ������ 
			result.add(hashSet);
			// set ���� �ȿ� set ������ �־��� 
			// ���� �ߺ� ���� 
			return;
		}
		
		for (int i = 0; i < userId.length; i++) {
			// userId �߽����� loop
			// ���� ����� 
			if(hashSet.contains(userId[i])) {
				// set �ȿ� �̹� �� ���ڰ� �ִٸ� 
				continue;
			}
			if(check(userId[i], banId[depth])) {
				// �����Ѵٸ� 
				hashSet.add(userId[i]);
				// �� ���� ������� ���� userId�� ó������ => 
				DFS(new HashSet<>(hashSet), depth+1);
				hashSet.remove(userId[i]);
			}
		}
		
		
	}

	private boolean check(String userId, String banId) {
		// userId�� �������� banId�� ���� 
		
		// 1. ���� 
		if(userId.length()!=banId.length()) {
			// �ٸ��� ���� �͵� ���� 
			return false;
		}
		// 2. ���� �ϳ� �ϳ� �� �ϳ��� Ʋ���� �ٸ� 
		boolean match = true;
		for (int i = 0; i < userId.length(); i++) {
			if(banId.charAt(i)!='*' && userId.charAt(i)!=banId.charAt(i)) {
				// �������� �ʴ� ���, * �� ���ų�, �ϳ��� �ٸ��� 
				match = false;
				break; // �� 
			}
		}
		
		return match;
	}
}
