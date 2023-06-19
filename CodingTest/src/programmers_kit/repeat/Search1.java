package CodingTest.src.programmers_kit.repeat;

import java.util.HashSet;
import java.util.Set;

public class Search1 {
    boolean[] visited;
    int answer = Integer.MIN_VALUE;
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        String[] numArr = new String[numbers.length()];
        Set<String> answerSet = new HashSet<>();
        for (int i = 0; i < numbers.length(); i++) {
            numArr[i]=String.valueOf(numbers.charAt(i));
        }

        for (int i = 0; i < numArr.length; i++) {
           DFS(numArr, numArr[i], "", 0, answerSet);
        }

        return 0;
    }

    public void DFS(String[] numberArray, String startNode, String currentAnswer, int level, Set<String> answer){

        if(level==numberArray.length){
            return;
        }else{
            for (int i = 0; i < numberArray.length; i++) {
                if(!visited[i]) {
                    if(startNode.equals("0")){
                        visited[i] = true;
                        DFS(numberArray, numberArray[i + 1], currentAnswer, level + 1, answer);
                        visited[i]=false;
                    } else{
                        visited[i]=true;
                        currentAnswer+=numberArray[i];
                        if(isPrime(Integer.parseInt(currentAnswer))){
                            answer.add(currentAnswer);
                        }

                        DFS(numberArray, startNode, currentAnswer, level+1, answer);
                        visited[i]=false;
                    }


                }
            }
        }
    }

    public static boolean isPrime(int num) {
        if(num==1||num==0) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
