package CodingTest.src.sample;

public class Sample {
    int answer = 0;
    int move = name.length() - 1;

    // 1) 위 아래로 움직임 원리 : 해당 글자의 - A / 전체에서 (해당글 - A) 더 짧은 쪽으로 올라감
    // 2) 인덱스 안의 값 중에, 그 다음값이 A 인 경우

		for (int i = 0; i < name.length(); i++) {
        answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i)+1);

        // 그 다음수가 A 라면 A의 마지막 위치 찾음
        int idxNext = i + 1;
        while (idxNext < name.length() && name.charAt(idxNext) == 'A') {
            idxNext++;
        }
        // i 지금까지 간 만큼 + 돌아감 + 가장 끝 - A의 마지막 만큼 감 +
        // 최종 모든 문자열까지 한다면 그때 최종 값이 나옴
        move = Math.min(move, i + Math.min(i,name.length() - idxNext) + (name.length() - idxNext));

    }

        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
    int answer = 1;
    int standard = routes[0][1];
		for (int i = 0; i < routes.length; i++) {
        if (standard >= routes[i][0]) {
            continue;
        } else {
            standard = routes[i][1];
            answer++;
        }
    }
		return answer;

}

    private String check(String p) {
        if (p.length()==0) {
            // 입력값이 빈 문자열이라면
            return "";
            // 빈문자열 반환함
        }
        int left = 0;
        String strLeft = "";
        int right = 0;
        String strRight = "";

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == ')') {
                left++;
            } else {
                right++;

            }
            strLeft += p.charAt(i); // 왼쪽에 쌓임
            if (left == right) {
                // 개수가 같을 떄 멈춤 오른쪽을
                strRight += p.substring(i+1);
                break;
            }
        }

        if (isCorrect(strLeft)) {
            // 올바른 문자열
            return strLeft + check(strRight);
        } else {
            // 올바른 문자열이 아님
            String temp = "(";
            temp += check(strRight);
            temp += ")";
            String fbrmvd = strLeft.substring(1, strLeft.length() - 1);
            String result = "";
            for (int i = 0; i < fbrmvd.length(); i++) {
                if (fbrmvd.charAt(i) == ')') {
                    result += '(';
                } else {
                    result += ')';
                }
            }
            return  temp += result;
        }

    }

    private boolean isCorrect(String strLeft) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < strLeft.length(); i++) {
            if(strLeft.charAt(i)=='(') {
                // 올바른 경우
                stack.push('(');
            }else {
                if(stack.isEmpty() || stack.peek()==')') {
                    return false;
                }else {
                    stack.pop();
                }
            }
        }
        return true;
    }
