package CodingTest.src.programmers_lv2;

public class Solution100 {
    public int solution(String[][] relation) {
        int answer = 0;
        // ���ڸ����� �ߺ��Ǵ��� ���� Ȯ����
        // �ߺ� �ȵǸ� ++ �ϰ� �Ѿ
        // �ߺ� �Ǹ� �� ���� ���ڿ� �����ؼ� ����
        // ������ �����ϸ� �ٽ� �ѹ� �Ѿ�� �ٽ�
        for (int i = 0; i < relation.length; i++) { // �ĺ�Ű ���� �Ǻ�
            for (int j = i; j < relation.length-1; j++) { // �ߺ� Ȯ��
                if (relation[i][j] == relation[i][j + 1]) {
                    // ������ ������ �Ѿ����
                    // ** �ڿ� �ִ� �� ���� ���� �ؼ� ���ؾ���
                    break;
                }
                if (j == relation.length-1) {
                    // ������ �� , �ߺ� �� ����
                    answer++;
                }
            }
        }

        return answer;
    }

}
