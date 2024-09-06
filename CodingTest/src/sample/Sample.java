package CodingTest.src.sample;

public class Sample {
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

        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
    int answer = 1;
    int standard = routes[0][1];
		for (int i = 0; i < routes.length; i++) {
        if (standard >= routes[i][0]) {
            continue;
        } else {
            standard = routes[i][1];
            answer++;
        }
    }
		return answer;

}
