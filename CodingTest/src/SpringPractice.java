import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


class Solution {
    static class Assignment {
        private String name;
        private int start;
        private int time;

        public Assignment(String name, String start, String time) {
            this.name = name;
            this.start = timeToMinute(start);
            this.time = Integer.parseInt(time);
        }
        // �ð���ȯ �޼ҵ�
        public int timeToMinute(String start) {
            String[] arr = start.split(":");
            int hour = Integer.parseInt(arr[0]) * 60;
            int minute = Integer.parseInt(arr[1]);
            return hour + minute;
        }
    }

    public String[] solution(String[][] plans) {
        Assignment[] arr = new Assignment[plans.length];

        for (int i = 0; i < arr.length; i++) {
            Assignment ass = new Assignment(plans[i][0], plans[i][1], plans[i][2]);
            arr[i] = ass;
        }

        Arrays.sort(arr, (o1, o2) -> { // *** ���� �ð� �������� ����
            return o1.start - o2.start;
        });


        Stack<Assignment> stack = new Stack<>(); // �������� ����
        List<String> ans = new ArrayList<String>(); // ������ ���� ����

        int curTime = -1; // ����ð��ʱ�ȭ

        for (int i = 0; i < arr.length; i++) {
            if(stack.isEmpty()) {// ���� ���� ���
                stack.push(arr[i]);
                continue;
            }
            // �������� ������ ���ο� ������ �ִ� ���
            Assignment curAss = stack.peek();
            Assignment newAss = arr[i];

            // ���ο� ������ ���۽ð��� ������ ������ ����ð� ��
            curTime = curAss.start;

            // ���� ���� ���� �ð� + �۾��ð� <= ���ο� ���� ���� �ð�
            if(curTime+curAss.time<=newAss.start) {
                recursivePop(stack, newAss, curTime, ans);
            } else {
                // ���� �۾� �ߴ��ϰ� �۾��� �ð� ���� �� �� �۾� ����
                // ���ο� �۾� ���� �ð� - ���� �۾� ���� �ð�  = ���� �۾� ���� �ð�
                curAss.time -= newAss.start-curTime;
            }
            stack.push(newAss);
        }

        //����� ������ ���� ���� ���, ���� �ֱٿ� ���� �������� �����մϴ�.
        while(!stack.isEmpty()) {
            ans.add(stack.pop().name);
        }

        return ans.toArray(new String[0]);

    }

    private void recursivePop(Stack<Assignment> stack, Assignment newAss, int curTime, List<String> ans) {
        if(stack.isEmpty()) {
            return;
        }

        Assignment curAss = stack.peek();
        // ������ ����

        if(curTime+curAss.time<=newAss.start) {
            ans.add(stack.pop().name);
            // �������� ���� �����
            recursivePop(stack, newAss, curTime+curAss.time, ans);
            // �����߰��� + �ð�
        }else {
            curAss.time -= newAss.start-curTime;
        }
    }
}