package programmers_kit.DfsBfs;

public class DfsBfs3 {
	static int answer;
	static boolean[] visited;

	public int solution(String begin, String target, String[] words) {
		answer = 51;
		DFS(begin, target, words, 0);
		if (answer == 51) {
			return 0;
		}
		return answer;
	}

	public void DFS(String originWord, String finalWord, String[] wordList, int cnt) {
		if (cnt > answer) {
			return;
		}

		if (originWord.equals(finalWord)) {
			// 1. ��耳� �뼵�뼱�� final �뼵�뼱媛� 媛숇떎硫� 由ы꽩
			answer = Math.min(answer, cnt);
			return;
		}
		for (int i = 0; i < wordList.length; i++) {
			if (visited[i] == true) {
				// 4. �씠誘� �떎��媛� �떒�뼱�뒗 嫄대꼫 �쎇怨� 泥섎━�빐以섏빞 �슚�쑉�쟻�엫
				continue;
			}

			// 2. 湲��옄媛� �븳媛�吏�留� �떎瑜� 寃껋쓣 李얠쓬
			int k = 0;
			for (int j = 0; j < wordList[i].length(); j++) {
				if (originWord.charAt(j) == wordList[i].charAt(j)) {
					k++;
				}
			}
			if (k == originWord.length() - 1) {
				// 3. 媛쒖닔媛� �떒�뼱�쓽 媛쒖닔 -1 利� �븳 �떒�뼱留� �떎瑜� �븣 洹� �떒�뼱 flag 泥섎━
				visited[i] = false;
				// �씠�젃寃� flag 泥섎━瑜� �빐以섏빞留� �빐�떦 �떒�뼱 �꽆湲곌퀬 洹� �떎�쓬 �떒�뼱遺��꽣 泥섎━�븯寃� �맖
				DFS(wordList[i], finalWord, wordList, cnt++);
				visited[i] = true;
			}

		}

	}
}
