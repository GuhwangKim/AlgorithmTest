package CodingTest.src.programmers_kit.Search;

public class Search4 {
    static int currentWires = 1;
    boolean[] visited;
    static int answer;
    public int solution(int n, int[][] wires) {
        answer = wires.length;
        visited = new boolean[wires.length];
        visited[0] = true;
        DFS(wires[0][1], wires, n, currentWires);
        return answer;
    }
    public void DFS(int backNum, int[][] wires, int cntWires, int currentWires){

        for (int i = 1; i < wires.length; i++) {
            // 1. 뒷값과 앞에 값이 같은 경우 즉 전선이 연결된 경우
            if(!visited[i] && backNum==wires[i][0]){
                visited[i]=true;
                //2. 계속해서 연결함, 연결하는 전선의 개수를 더해줌
                DFS(wires[i][1], wires, cntWires, currentWires+1);
                // 3. 해당 끝 노드에서 비교
            }
            answer = Math.min(answer, Math.abs((cntWires-1)-2*(currentWires)));
        }
    }


}
