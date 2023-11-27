package CodingTest.src.programmers_lv2;

public class Solution66 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String tree : skill_trees){
            int idx = 0;
            for (int i = 0; i < tree.length(); i++) {
                // 글자 하나씩 가져와서
                for (int j = 0; j < skill.length(); j++) {
                    // skill 과 비교해봄
                    if(tree.charAt(i)==skill.charAt(j)){
                        if(i)
                        idx = j;
                    }
                }
            }
        }

        return answer;
    }
}
