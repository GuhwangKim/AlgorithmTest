package programmers_lv2;

public class Solution66 {
	public static void main(String[] args) {
		Solution66 s = new Solution66();
		String[] arr = {"BACDE", "CBADF", "AECB", "BDA"};
		s.solution("CBD", arr);
	}
	public int solution(String skill, String[] skill_trees) {
		int answer = 0;

		for (String tree : skill_trees) {
			boolean flag = true;
			tree = tree.replaceAll("[^"+skill+"]", "");
			System.out.println(tree);

			for (int i = 0; i < tree.length(); i++) {
				if (tree.charAt(i) != skill.charAt(i)) {
					// ´Ù¸£´Ù¸é ¾Æ´Ô
					flag = false;
					break;
				}
			}
			if (!flag) {
				continue;
			}
			answer++;
			// ÇÑ¹Ù²î ´Ù µ·¼À
		}
		return answer;
	}
}
