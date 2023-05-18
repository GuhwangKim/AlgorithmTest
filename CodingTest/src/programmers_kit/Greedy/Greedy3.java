package CodingTest.src.programmers_kit.Greedy;

public class Greedy3 {
    static int answer = 0;
    static int visited[];

    public static void main(String[] args) {
        Greedy3 g = new Greedy3();
        int[][] dun = {{80,20},{50,40},{30,10}};
        g.solution(80, dun);
    }
    public int solution(int k, int[][] dungeons) {
        visited = new int[dungeons.length];
        // 현재 피로도와 2차 배열, 깊이를 넘김

        DFS(k, dungeons, answer);

        return answer;
    }

    public void DFS (int currentT, int[][] array, int maxDepth){
        if(maxDepth>=array.length){
            return;
        }

        for (int i = 0; i < array.length; i++) {
            if(visited[i]!=1 && currentT>=array[i][0]){
                currentT -=array[i][1];
                visited[i]=1;
                DFS(currentT, array, maxDepth+1);
                answer = Math.max(maxDepth, answer);
                visited[i]=0;
            }

        }
    }
}
