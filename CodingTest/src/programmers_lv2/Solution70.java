package CodingTest.src.programmers_lv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution70 {

<<<<<<< HEAD
   
=======
    class Order {
        String direction;
        String id;
        String name;

        public Order (String direction, String id, String name){
            this.direction = direction;
            this.id = id;
            this.name = name;
        }
    }
>>>>>>> branch 'master' of https://github.com/GuhwangKim/AlgorithmTest.git
    public String[] solution(String[] record) {
<<<<<<< HEAD
    	Map<String, String> idMap = new HashMap<String, String>();
    	// id - nickname => id ���� �ߺ��Ǹ� ���� ������ nickname���� ����� 
    	
    	int count = 0 ; // change�ϋ��� ī��Ʈ �� 
    	
    	for (int i = 0; i < record.length; i++) {
			String[] info = record[i].split(" ");
			
			if(info[0].equals("Leave")) {
				// ������ ��쿡�� ���̻� �г��� ����� �� �����Ƿ� �ȴ�Ƶ� �� 
				continue;
			} else if (info[0].equals("Enter")) {
				idMap.put(info[1], info[2]); // id �г��� 
			} else {
				idMap.put(info[1], info[2]);
				count++; // ������ ���� ī��Ʈ �� 
			}
		}
    	
    	String[] answer = new String[record.length - count];
    	int idx = 0;
    	
    	for (int i = 0; i < record.length; i++) {
			String[] info = record[i].split(" ");
			String nickname = idMap.get(info[1]);
			// ���̵� ���� ���� �ֱ� �г��� ���� ���� 
			
			if(info[0].equals("Enter")) {
				answer[idx++] = nickname + "���� ���Խ��ϴ�.";
			}else if (info[0].equals("Leave")) {
				answer[idx++] = nickname +"���� �������ϴ�.";
			}
		}
=======
        String[] answer = {};

        Map<String, Order> map = new HashMap<>();

        for (String rec : record){
            String[] arr = rec.split(" ");
            map.put(arr[1], new Order(arr[0], arr[1], arr[2]));
        }

        for (int i = 0; i < map.size(); i++) {
            if(map.get(i).direction.startsWith("E")){
                // enter
                answer[i] = map.get(i).name + "���� �����Ͽ����ϴ�.";
                check(map, answer, );

            } else if (map.get(i).direction.startsWith("L")) {
                // leave
                answer[i] = map.get(i).name + "���� �������ϴ�.";

            } else {
                // change

            }
        }


>>>>>>> branch 'master' of https://github.com/GuhwangKim/AlgorithmTest.git
        return answer;
    }

<<<<<<< HEAD
=======
    private void check(Map<String, Order> map) {

    }
>>>>>>> branch 'master' of https://github.com/GuhwangKim/AlgorithmTest.git
}
