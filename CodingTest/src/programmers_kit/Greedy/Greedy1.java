package programmers_kit.Greedy;

public class Greedy1 {
	public int solution(String name) {
		int answer = 0;
		int move = name.length() - 1;

		// 1) �� �Ʒ��� ������ ���� : �ش� ������ - A / ��ü���� (�ش�� - A) �� ª�� ������ �ö�
		// 2) �ε��� ���� �� �߿�, �� �������� A �� ���

		for (int i = 0; i < name.length(); i++) {
			answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i)+1);

			// �� �������� A ��� A�� ������ ��ġ ã��
			int idxNext = i + 1;
			while (idxNext < name.length() && name.charAt(idxNext) == 'A') {
				idxNext++;
			}
			// i ���ݱ��� �� ��ŭ + ���ư� + ���� �� - A�� ������ ��ŭ �� +
			// ���� ��� ���ڿ����� �Ѵٸ� �׶� ���� ���� ����
			move = Math.min(move, i + Math.min(i,name.length() - idxNext) + (name.length() - idxNext));

		}

		return move + answer;
	}

}
