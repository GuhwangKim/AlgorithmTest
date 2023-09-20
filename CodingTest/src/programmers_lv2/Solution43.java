package CodingTest.src.programmers_lv2;

public class Solution43 {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length]; // 같은 경우 0, 다른 경우 1 : 1개만 다른 경우 1, 2개만 다른 경우 2 
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i]%2 == 0){
                // 짝수인 경우
                answer[i] = numbers[i]+1;
            } else{
                // 홀수인 경우
                StringBuilder builder = new StringBuilder();
                String longByte = Long.toBinaryString(numbers[i]);
                if(!longByte.contains("0")){
                    // 0을 포함하고 있지 않은 경우
                    builder.append("10");
                    builder.append(longByte.substring(1).replace("0", "1"));
                    // 1자리 부터 추출하면서 0을 1로 변경함
                } else{
                    int lastIdx = longByte.lastIndexOf("0");
                    int firstOneIdx = longByte.indexOf("1", lastIdx);

                    // 마지막 0을 1로 수정 
                    builder.append(longByte, 0, lastIdx).append("1");
                    
                    // 마지막으로 나오는 0을 1로 수정 
                    builder.append("0");
                    
                    builder.append(longByte.substring(firstOneIdx+1));
                    
                }
                answer[i] = Long.parseLong(builder.toString(),2);
            }
        }

        return answer;
    }
}
