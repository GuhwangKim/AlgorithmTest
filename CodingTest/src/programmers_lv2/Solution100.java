package CodingTest.src.programmers_lv2;

public class Solution100 {
    static int answer = 0;
    String[][] arr;
    public int solution(String[][] relation) {
        arr = new String[relation.length][relation[0].length]
        // ���ڸ����� �ߺ��Ǵ��� ���� Ȯ����
        // �ߺ� �ȵǸ� ++ �ϰ� �Ѿ
        // �ߺ� �Ǹ� �� ���� ���ڿ� �����ؼ� ����
        // ������ �����ϸ� �ٽ� �ѹ� �Ѿ�� �ٽ�
        // ù���� �ٸ� �񱳿�
        for (int i = 0; i < relation.length; i++) {
            String str = "";
            for (int j = 0; j < relation.length; j++) {
                str += relation[i][j];
                calculate(str, i, j);
            }
        }

        return answer;
    }

    public void calculate (String str, int start, int end) {

        for (int j = 1; j < arr.length; j++) { // �ߺ� Ȯ��
            if (str.equals(arr[j][start]+arr[j][end])) {
                // ������ ������ �Ѿ����
                // ** �ڿ� �ִ� �� ���� ���� �ؼ� ���ؾ���
                return;
            }
        }
        // ������ ������ ���ٸ� ������ ���ٴ� ��
        answer++;
    }


}
