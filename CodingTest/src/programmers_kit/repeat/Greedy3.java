package CodingTest.src.programmers_kit.repeat;

import java.util.PriorityQueue;

public class Greedy3 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int person : people){
            queue.add(person);
        }
        while(!queue.isEmpty()){
            int peopleSum = queue.poll(); //50
            answer++;
            while(peopleSum<=limit && queue.size()>0){
                System.out.println("peopleSum: "+peopleSum);
                if(peopleSum+queue.peek()>limit){
                    break;
                }else{
                    peopleSum+=queue.poll(); //100
                }
            }

        }
        return answer;
    }
}
