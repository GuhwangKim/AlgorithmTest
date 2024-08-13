package CodingTest.src.programmers_lv2;

public class Solution100 {
    public int solution(String[][] relation) {
        int answer = 0;
        // 앞자리부터 중복되는지 여부 확인함
        // 중복 안되면 ++ 하고 넘어감
        // 중복 되면 그 다음 숫자와 조인해서 비교함
        // 끝까지 도달하면 다시 한번 넘어가고 다시
        for (int i = 0; i < relation.length; i++) { // 후보키 길이 판별
            for (int j = i; j < relation.length-1; j++) { // 중복 확인
                if (relation[i][j] == relation[i][j + 1]) {
                    // 같은게 있으면 넘어가야함
                    // ** 뒤에 있는 것 까지 같이 해서 비교해야함
                    break;
                }
                if (j == relation.length-1) {
                    // 끝까지 옴 , 중복 값 없음
                    answer++;
                }
            }
        }

        return answer;
    }

}
