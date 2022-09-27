package programmers_lv1;

public class Solution37 {
	class Solution {
		public String solution(String s, int n) {
			String answer = "";

			for (int i = 0; i < s.length(); i++) {
				char x = s.charAt(i);
				int y = (int) x;
				int z = y + n;
				
				if(x==' ') {
					answer+=" ";
					
				} else {
					if (y >= 65 && y <= 90) {
						if (z > 90) {
							answer += String.valueOf((char) (z - 26));
						} else {
							answer += String.valueOf((char) (z));
						}
					} else {
						if (z > 122) {
							answer += String.valueOf((char) (z - 26));
						} else {
							answer += String.valueOf((char) (z));
						}
					}
				}
			}
			return answer;
		}

		private void elseif(boolean b) {
			// TODO Auto-generated method stub
			
		}
	}

	public static void main(String[] args) {
		String answer = "";
		String s = "aBz";
		int n = 4;

		if (s == "") {
			answer = "";
		} else {
			for (int i = 0; i < s.length(); i++) {
				char x = s.charAt(i);
				int y = (int) x;
				int z = y + n;
				if (y >= 65 && y <= 90) {
					if (z > 90) {
						answer += String.valueOf((char) (z - 26));
					} else {
						answer += String.valueOf((char) (z));
					}
				} else {
					if (z > 122) {
						answer += String.valueOf((char) (z - 26));
					} else {
						answer += String.valueOf((char) (z));
					}
				}
			}
		}
		System.out.println(answer);
	}
}
