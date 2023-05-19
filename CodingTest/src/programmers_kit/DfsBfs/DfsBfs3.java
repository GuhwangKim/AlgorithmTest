package CodingTest.src.programmers_kit.DfsBfs;

public class DfsBfs3 {
    static int answer;
    static boolean[] visited;
    public static void main(String[] args) {
        DfsBfs3 d = new DfsBfs3();
        String[] word = {"hot", "dot", "dog", "lot", "log", "cog"};
        d.solution("hit", "dog", word );
    }
    public int solution(String begin, String target, String[] words) {

        /*
        1. loop를 돌면서 단어를 계속 넘기면서
        * 배열을 정렬?
        * target 이랑 비슷한 것대로 가는게 맞는 것 같은데
        * 방법을 정말 모르겠다...
        2. cnt ++
        * target 단어와
        마지막 단계에선 originWord = target 이면 그 개수를 반납
        */

        DFS(begin, target, words, 0);
        return answer;
    }

    public void DFS(String originWord, String finalWord, String[] wordList, int cnt){
        if(originWord.equals(finalWord)){
            // 1. 타켓 언어와 final 언어가 같다면 리턴
            answer = cnt;
            return;
        }
        for (int i = 0; i < wordList.length; i++) {
            if(visited[i]==true){
                // 4. 이미 다녀간 단어는 건너 뛰고 처리해줘야 효율적임
                continue;
            }

            // 2. 글자가 한가지만 다른 것을 찾음
            int k = 0;
            for (int j = 0; j < wordList[i].length(); j++) {
                if(originWord.charAt(j)==wordList[i].charAt(j)){
                    k++;
                }
            }
            if(k==originWord.length()-1){
                // 3. 개수가 단어의 개수 -1 즉 한 단어만 다를 때 그 단어 flag 처리
                visited[i]=false;
                // 이렇게 flag 처리를 해줘야만 해당 단어 넘기고 그 다음 단어부터 처리하게 됨
                DFS(wordList[i], finalWord, wordList, cnt++);
                visited[i]=true;
            }

        }


    }
}
