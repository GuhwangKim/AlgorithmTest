package CodingTest.src.programmers_lv2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution100 {
    
    boolean[] visited; // 방문 채크 
    int len;
    int cnt;

    Set<String> list = new HashSet<>(); // back tracking 한 데이터
    List<String> list2 = new ArrayList<>(); // 정답을 담음
    
    public int solution(String[][] relation) {
        int answer = 0;

        len = relation[0].length; //컬럼의 개수 attribute
        cnt = relation.length; // 행의 개수 tupled
        visited = new boolean[len];

        for (int i = 1; i <= len; i++) {
            comb(0, i, relation);
            unique(relation);
            list.clear();
        }

        return list2.size();
    }

    private void unique(String[][] relation) {
        // 유일성 판단
        for (String data : list) {
            String[] temp = data.split("");
            int[] arr = new int[temp.length];
            for (int i = 0; i < temp.length; i++) {
                int c = Integer.parseInt(temp[i]);
                arr[i] = c;
            }

            // 유일성 판단하기 위한 set
            Set<String> set = new HashSet<>();
            for (int i = 0; i < cnt; i++) {
                String cdd = "";
                for (String data2 : temp) {
                    int c = Integer.parseInt(data2);
                    cdd += relation[i][c];
                }
                set.add(cdd);
            }

            // 유일성 이후 최소성 검사
            if (set.size() == cnt) {
                boolean flag = false;
                for (String data3 : list2) {
                    int cnt = 0;
                    String[] temp3 = data3.split("");
                    for (String data4 : temp3) {
                        if (data.contains(data4)) {
                            cnt++;
                        }
                    }
                    if (cnt == data3.length()) {
                        flag = true;
                    }
                }
                if (!flag) {
                    list2.add(data);
                }
            }
        }
    }

    private void comb(int start, int row, String[][] relation) {
        // 조합하는 부분 
        // 
        if (row == 0) {
            String temp = "";
            for (int i = 0; i < len; i++) {
                if (visited[i]) {
                    temp+=i; // 조합 한칸 더 감 
                }
            }
            list.add(temp);
        }
        
        // 뒤에서부터 1개씩 줄어들면저 조합 만들어냄
        // 4, 3, 2, 1 
        for (int i = start; i < len; i++) {
            if (!visited[i]) {
                // 방문 안함 
                visited[i]  = true;
                comb(start + 1, row - 1, relation);
                visited[i] = false;
            }
        }
        
    }
}
