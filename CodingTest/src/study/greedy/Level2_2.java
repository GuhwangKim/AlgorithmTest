package CodingTest.src.study.greedy;

public class Level2_2 {
    public int solution(String name) {
        int updown = 0;
        int side = name.length() - 1; // 오른쪽으로만 간 경우

        int[] goal = new int[name.length()];

        for (int i = 0; i < name.length(); i++) {
            goal[i] = (name.charAt(i) - 0) - 97;
        }

        for (int i = 0; i < name.length(); i++) {
            // 상하 움직임
            updown += Math.min((goal[i]), (25 - goal[i] + 1));
            if (i == name.length() - 1 && goal[i + 1] == 0) {
                // 그 다음 알파벳이 A 인 경우의 A 인덱스
                int endA = i + 1;
                while (endA < name.length() && goal[endA] == 0) {
                    // while의 조건인자가 이해가 안됨
                    endA++;
                    side = Math.min(side, i * 2 + (name.length() - endA)); // 오른쪽으로 갔다가 다시 왼쪽
                    side = Math.min(side, i + (name.length() - endA) * 2); //왼쪽으로 갔다가 다시 오른쪽
                }
            }
        }
        return updown+side;
    }
}
