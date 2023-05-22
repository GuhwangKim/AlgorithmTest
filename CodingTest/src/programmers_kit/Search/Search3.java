package CodingTest.src.programmers_kit.Search;

public class Search3 {
    static int answer = 0;
    static int visited[];

    public static void main(String[] args) {
        Search3 g = new Search3();
        int[][] dun = {{80,20},{50,40},{30,10}};
        g.solution(80, dun);
    }
    public int solution(int k, int[][] dungeons) {
        visited = new int[dungeons.length];
        // �쁽�옱 �뵾濡쒕룄�� 2李� 諛곗뿴, 源딆씠瑜� �꽆源�

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
