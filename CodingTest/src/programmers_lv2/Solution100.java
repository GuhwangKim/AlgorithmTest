package CodingTest.src.programmers_lv2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution100 {
    
    boolean[] visited; // �湮 äũ 
    int len;
    int cnt;

    Set<String> list = new HashSet<>(); // back tracking �� ������
    List<String> list2 = new ArrayList<>(); // ������ ����
    
    public int solution(String[][] relation) {
        int answer = 0;

        len = relation[0].length; //�÷��� ���� attribute
        cnt = relation.length; // ���� ���� tupled
        visited = new boolean[len];

        for (int i = 1; i <= len; i++) {
            comb(0, i, relation);
            unique(relation);
            list.clear();
        }

        return list2.size();
    }

    private void unique(String[][] relation) {
        // ���ϼ� �Ǵ�
        for (String data : list) {
            String[] temp = data.split("");
            int[] arr = new int[temp.length];
            for (int i = 0; i < temp.length; i++) {
                int c = Integer.parseInt(temp[i]);
                arr[i] = c;
            }

            // ���ϼ� �Ǵ��ϱ� ���� set
            Set<String> set = new HashSet<>();
            for (int i = 0; i < cnt; i++) {
                String cdd = "";
                for (String data2 : temp) {
                    int c = Integer.parseInt(data2);
                    cdd += relation[i][c];
                }
                set.add(cdd);
            }

            // ���ϼ� ���� �ּҼ� �˻�
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
        // �����ϴ� �κ� 
        // 
        if (row == 0) {
            String temp = "";
            for (int i = 0; i < len; i++) {
                if (visited[i]) {
                    temp+=i; // ���� ��ĭ �� �� 
                }
            }
            list.add(temp);
        }
        
        // �ڿ������� 1���� �پ����� ���� ����
        // 4, 3, 2, 1 
        for (int i = start; i < len; i++) {
            if (!visited[i]) {
                // �湮 ���� 
                visited[i]  = true;
                comb(start + 1, row - 1, relation);
                visited[i] = false;
            }
        }
        
    }
}
