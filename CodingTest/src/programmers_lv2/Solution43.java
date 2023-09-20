package CodingTest.src.programmers_lv2;

public class Solution43 {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length]; // ���� ��� 0, �ٸ� ��� 1 : 1���� �ٸ� ��� 1, 2���� �ٸ� ��� 2 
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i]%2 == 0){
                // ¦���� ���
                answer[i] = numbers[i]+1;
            } else{
                // Ȧ���� ���
                StringBuilder builder = new StringBuilder();
                String longByte = Long.toBinaryString(numbers[i]);
                if(!longByte.contains("0")){
                    // 0�� �����ϰ� ���� ���� ���
                    builder.append("10");
                    builder.append(longByte.substring(1).replace("0", "1"));
                    // 1�ڸ� ���� �����ϸ鼭 0�� 1�� ������
                } else{
                    int lastIdx = longByte.lastIndexOf("0");
                    int firstOneIdx = longByte.indexOf("1", lastIdx);

                    // ������ 0�� 1�� ���� 
                    builder.append(longByte, 0, lastIdx).append("1");
                    
                    // ���������� ������ 0�� 1�� ���� 
                    builder.append("0");
                    
                    builder.append(longByte.substring(firstOneIdx+1));
                    
                }
                answer[i] = Long.parseLong(builder.toString(),2);
            }
        }

        return answer;
    }
}
