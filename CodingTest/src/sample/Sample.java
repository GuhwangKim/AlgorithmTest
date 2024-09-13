package CodingTest.src.sample;

public class Sample {
    int answer = 0;
    int move = name.length() - 1;

    // 1) �� �Ʒ��� ������ ���� : �ش� ������ - A / ��ü���� (�ش�� - A) �� ª�� ������ �ö�
    // 2) �ε��� ���� �� �߿�, �� �������� A �� ���

		for (int i = 0; i < name.length(); i++) {
        answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i)+1);

        // �� �������� A ��� A�� ������ ��ġ ã��
        int idxNext = i + 1;
        while (idxNext < name.length() && name.charAt(idxNext) == 'A') {
            idxNext++;
        }
        // i ���ݱ��� �� ��ŭ + ���ư� + ���� �� - A�� ������ ��ŭ �� +
        // ���� ��� ���ڿ����� �Ѵٸ� �׶� ���� ���� ����
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
            // �Է°��� �� ���ڿ��̶��
            return "";
            // ���ڿ� ��ȯ��
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
            strLeft += p.charAt(i); // ���ʿ� ����
            if (left == right) {
                // ������ ���� �� ���� ��������
                strRight += p.substring(i+1);
                break;
            }
        }

        if (isCorrect(strLeft)) {
            // �ùٸ� ���ڿ�
            return strLeft + check(strRight);
        } else {
            // �ùٸ� ���ڿ��� �ƴ�
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
                // �ùٸ� ���
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
