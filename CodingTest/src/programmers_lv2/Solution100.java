package CodingTest.src.programmers_lv2;

public class Solution100 {
    static int answer = 0;
    String[][] arr;
    public int solution(String[][] relation) {
        arr = new String[relation.length][relation[0].length]
        // 앞자리부터 중복되는지 여부 확인함
        // 중복 안되면 ++ 하고 넘어감
        // 중복 되면 그 다음 숫자와 조인해서 비교함
        // 끝까지 도달하면 다시 한번 넘어가고 다시
        // 첫번쨰 줄만 비교용
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

        for (int j = 1; j < arr.length; j++) { // 중복 확인
            if (str.equals(arr[j][start]+arr[j][end])) {
                // 같은게 있으면 넘어가야함
                // ** 뒤에 있는 것 까지 같이 해서 비교해야함
                return;
            }
        }
        // 끝까지 루프를 탔다면 같은게 없다는 말
        answer++;
    }


}
