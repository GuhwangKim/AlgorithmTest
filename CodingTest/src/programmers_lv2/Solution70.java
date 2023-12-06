package CodingTest.src.programmers_lv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution70 {

    class Order {
        String direction;
        String name;

        public Order (String direction, String name){
            this.direction = direction;
            this.name = name;
        }
    }
    public String[] solution(String[] record) {
        String[] answer = {};

        Map<String, Order> map = new HashMap<>();

        for (String rec : record){
            String[] arr = rec.split(" ");
            map.put(arr[1], new Order(arr[0], arr[2]));
        }

        for (int i = 0; i < map.size(); i++) {
            if(map.get(i).direction.startsWith("E")){
                // enter
                answer[i] = map.get(i).name + "님이 입장하였습니다.";
                // 아이디가 중복되는지를 확인하고 싶음 
                
                check(map, answer);

            } else if (map.get(i).direction.startsWith("L")) {
                // leave
                answer[i] = map.get(i).name + "님이 나갔습니다.";

            } else {
                // change

            }
        }


        return answer;
    }

    private void check(Map<String, Order> map, String[] answer) {
    	

    }
}
