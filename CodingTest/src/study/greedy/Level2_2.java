package CodingTest.src.study.greedy;

public class Level2_2 {
    public int solution(String name) {
        int updown = 0;
        int side = name.length() - 1; // ���������θ� �� ���

        int[] goal = new int[name.length()];

        for (int i = 0; i < name.length(); i++) {
            goal[i] = (name.charAt(i) - 0) - 97;
        }

        for (int i = 0; i < name.length(); i++) {
            // ���� ������
            updown += Math.min((goal[i]), (25 - goal[i] + 1));
            if (i == name.length() - 1 && goal[i + 1] == 0) {
                // �� ���� ���ĺ��� A �� ����� A �ε���
                int endA = i + 1;
                while (endA < name.length() && goal[endA] == 0) {
                    // while�� �������ڰ� ���ذ� �ȵ�
                    endA++;
                    side = Math.min(side, i * 2 + (name.length() - endA)); // ���������� ���ٰ� �ٽ� ����
                    side = Math.min(side, i + (name.length() - endA) * 2); //�������� ���ٰ� �ٽ� ������
                }
            }
        }
        return updown+side;
    }
}
