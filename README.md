# 알고리즘 테스트 풀이 

### Level.2

<details>
  <summary><b>줄서는 방법</b></summary>
  <div markdown="1">
    <ul>
       (2024.07.31)
      <li> 재귀를 이용하면 된다고 생각했지만, 구현을 하지 못함</li>

    public int[] solution(int n, long k) {
      int[] answer = {};
      int[] temp = new int[n];
      total = n;
      for (int i = 1; i <= n; i++) {
          boolean[] visited = new boolean[total];
          DFS(i,visited, temp);
      }
    
        return answer;
    }
      
      public void DFS(int ord, boolean[] visited, int[] temp) {
          if(temp.length==3){
              return;
          }
          for (int i = 1; i <= total ; i++) {
              if (!visited[i - 1]) {
                  // 방문하지 않았다면
                  visited[ord-1] = true;
                  temp[ord-1] = i;
                  DFS(ord++, )
      
              }
          }
      }

✅ 메인 메소드에 루프 존재하지 않음

✅ 방문 여부 메소드는 전역으로 선언한 후, 루프의 순서를 담음 (≠ 깊이)

✅ 변수로 넘기는 것은 depth (배열의 순서가 됨)

☑️ 깊이가 총 길이랑 같은 경우 return 

☑️ 찾는 순서라면 그땐 answer 에 담아주고 끝냄

    public int[] solution(int n, long k) {
      answer = new int[n];
      int[] temp = new int[n];
      visited = new boolean[n]; // 방문한 배열은 전역으로 설정
      DFS(0,temp, k);
      return answer;
    }
    public void DFS(int ord, int[] temp, long k) {
      if(ord == temp.length){
          // 가장 마지막 깊이까지 옴
          cnt++; // 조건에 만족하는 배열의 개수 더해주기 
          if (cnt == k) {
              // 해당하는 순서라면
              for (int i = 0; i < temp.length; i++) {
                  answer[i] = temp[i];
              }
          }
          return;
      }
      for (int i = 0; i < temp.length ; i++) {
          if (!visited[i]) {
              // 방문하지 않았다면
              visited[i] = true;
              temp[ord] = i+1;// 깊이 대로 값이 바뀌어 넣어짐 
              DFS(ord + 1, temp, k);
              visited[i] = false;
    
          }
      }
    }

  이렇게 하면 시간초과 발생함 
  </ul>
  </div>
</details>

<details>
  <summary><b>숫자의 표현</b></summary>
  <div markdown="1">
    <ul>
       (2024.08.07)
      <li>Trial_1 문제에 나와있는 걸 그대로 코드에 구현함 </li>

    int givenNum = 0;
    int answer = 0;
    boolean numberOne = false;
    public int solution(int n) {
        givenNum = n;
        answer = 0;
        // 더해서 해당 값이 나오는 경우의 수를 구함
        // 연속해서 값을 더하려면 일단 무조건 그 숫자의 절반 값은 확보함
        // 그 다음 가능성은 그 절반 값보다 작은 경우
        // -> 그때의 값이 1보다 작으면 끝
        // 그 값이 n 이 되면 더하고, n보다 크면 넘어감
        // -> 1까지 내려오면 더이상 더 할 수 없는 옵션 없음
    
        if (n <= 2) {
            // 1경우만 존재함
            return 1;
        }
    
        int half = n/2;
        if (n % 2 != 0) {
            half += 1; // 1개 더함
        }
    
        for (int i = half; i >=1 ; i--) {
            sum(i);
            if (numberOne) {
                // 끝까지 온 경우 끝내야함
                break;
            }
        }
        return answer+1;
    }
    
    private void sum(int i) {
        int total = i;
        int idx = 1;
    
        while (total + (i-idx) <= givenNum) {
            if (i-idx == 1) {
                // 끝까지 왔다는 것
                numberOne = true;
            }
            // 합이 주어진 숫자보다 작을 때까지 더함
            total += (i-idx);
            if (total == givenNum) {
                // 연속된 합이 같을 때임
                answer++;
                return; // 루프 빠져서 다시 돌아감
            }
            idx++;
        }
    
    }

✅ 반으로 먼저 쪼갠 후에, 하나씩 빼면서 루프를 돌리는 로직 

✅ 말그대로 하나씩 돌리기 때문에 -> 시간 초과 발생함 

☑️ 정수론 정리 : 주어진 수의 홀수 약수의 개수와 같다 


    public int solution(int n) {
        int answer = 0;

        for(int i = 1; i <= n; i+=2){
            if(n % i == 0) answer++;
        }   

        return answer;
    }

  </ul>
  </div>
</details>


<details>
  <summary><b>배달</b></summary>
  <div markdown="1">
    <ul>
       (2024.08.19)
      <li>Trial_1 DFS로 depth를 주고, 끝까지 탐색하는 방법 생각,,, 그러나 완결을 못냄 </li>

    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        // 각각 모든 조합을 넣을 수 있는 배열 생성
        int[][] directions = new int[N+1][N+1];
        for (int[] each : road) {
            directions[each[0]][each[1]] = each[2];
            directions[each[1]][each[2]] = each[2];
        }

        for (int i = 1; i <= N ; i++) { // level
            for (int j = 1; j <= N; j++) { // row
                if (directions[i][j] == 0) {
                    continue; // 값이 없으면 건너띄고
                }else{
                    DFS(i, j, directions[i][j]);
                }
            }
        }


        return answer;
    }



    public int solution(int N, int[][] road, int K) {
        int answer = 1;
        // 1번에서 시작하면, 1번 마을은 무조건 방문 가능
        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            // 빈 공간을 만듦
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < road.length; i++) {
            // Node들의 list가 list의 값임
            list.get(road[i][0]).add(new Node(road[i][0], road[i][1], road[i][2]));
            list.get(road[i][1]).add(new Node(road[i][1], road[i][0], road[i][2]));
            // 양쪽에 모두 다 같은 2의 값을 넣어줌
        }

        Queue<Node> queue = new LinkedList<>();
        int[] visited = new int[N + 1];
        for (int i = 2; i < visited.length; i++) {
            visited[i] = Integer.MAX_VALUE;
            // 방문 배열을 모두 max의 값으로 집어넣음
        }
        // 처음 값을 담음
        queue.addAll(list.get(1));

        // 반복 - DFS
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            if (visited[n.x] <= visited[n.y] + n.v) {
                // 여기서 왜 y + v를 하는 건지?
                continue;
            }
            visited[n.x] = visited[n.y] + n.v;
            queue.addAll(list.get(n.x));
        }
        for (int i = 2; i < visited.length; i++) {
            if (visited[i] <= K) {
                answer++;
            }
        }
        return answer;
    }


    static class Node {
        int x, y, v;

        public Node(int x, int y, int v) {
            this.x = y;
            this.y = x;
            this.v = v;
        }
    }

  </ul>
  </div>
</details>

<details>
  <summary><b>멀리뛰기</b></summary>
  <div markdown="1">
    <ul>
       (2024.08.27)
      <li>Trial_1 2로 나눈 몫과 그 외에 1들의 경우의 수 곱 </li>

    public long solution(int n) {
        long answer = 0;
        int divide = n/2;
        int total = 0;
        for (int i = 0; i <= divide; i++) {
            System.out.println("total : " + total);
            total += ((n-2*i)*i+1);
        }
        answer = total%1234567;

        return answer;
    }

☑️ 처음 몇가지 사례는 성공하지만, 나머지 사례는 에러    
✅ 실제로 값을 만들필요 없음    
✅ 경우의 수가 중요한 것 (앞 + 앞앞 = 현재): 피보나치 수열     

    public long solution(int n) {
        long[] answer = new long[2001];
        answer[1] = 1;
        answer[2] = 2;
        for (int i = 3; i < 2001; i++) {
            answer[i] = (answer[i-1]+answer[i-2])%1234567;
        }
        return answer[n];
    }

  </ul>
  </div>
</details>
<details>
  <summary><b>다음큰숫자</b></summary>
  <div markdown="1">
    <ul>
       (2024.09.10)
      <li>Trial_1 단순하게 loop를 돌린 후 2진수/값비교 </li>

    public int solution(int n) {
        String currentBi = Integer.toBinaryString(n);
        long cntI = currentBi.chars().filter(value -> value == '1').count();

        for (int i = n+1; i <= 1000000; i++) {
            String loopBi = Integer.toBinaryString(i);
            long loopI = loopBi.chars().filter(value -> value == '1').count();

            if (loopI == cntI) {
                return i;
            }
        }
        return n;
    }
☑️ 효율성에서 에러가 뜸     
✅ Integer.bitCount 라는 내장함수를 이용하여 시간을 단축    

    int cntI = Integer.bitCount(n);

    while (true) {
        n++;
        if (cntI == Integer.bitCount(n)) {
            return n;
        }
    }

  </ul>
  </div>
</details>
<details>
  <summary><b>가장 큰 정사각형</b></summary>
  <div markdown="1">
    <ul>
       (2024.09.10)
      <li>Trial_1 1이 나올때 startIdx와 endIdx를 가지고 다시 루프 돌리는 메서드 </li>

     public int solution(int [][]board) {
        int answer = 1;

        // 연결된 1이 가로로 1이 연속된 경우 오른쪽 값을 기억함 , 시작과 끝 기억 (몇개인지)
        // 1 1 , 1 2
        // 따로 메소드
        // 왼쪽+1 ( 몇개 -1)  / 시작과 끝 1이다

        for (int j = 0; j < board.length; j++) {
            // 2차원 배열 1로우씩 뺌
            int startIdx = 0;
            int endIdx = 0;
            for (int i = 0; i < board[j].length; i++) {
                if (board[j][i] == 1 && startIdx == 0) {
                    // 가장 처음
                    startIdx = i;
                }
                if (board[j][i] == 1 && startIdx != 0) {
                    // 그 다음부턴 끝에 값으로
                    endIdx = i;
                }
            }

            // 아래로 더이상 내려갈 수가 없는 경우 (가로>세로)
            int continueOne = endIdx - startIdx;
            if (continueOne > board[0].length - j) {
                continue;
            }else{
                // 확인 메소드 호출
                int tmp = check(startIdx, endIdx, answer, board, j);
                answer = Math.max(tmp * tmp, answer * answer);
            }

        }
        return answer;
    }

    private int check(int startIdx, int endIdx, int answer, int[][] board, int rowIdx) {

        for (int i = rowIdx + 1; i < board.length; i++) {
            // 세로
            for (int j = startIdx; j <= endIdx; j++) {
                // 가로
                if (board[i][j] != 1) {
                    // 하나라도 1이 아니면 예외 케이스
                    return 1;
                }
            }
        }
        return endIdx-startIdx;

    }
☑️ 방법 측면에서 잘 못 된 듯      
✅ 빈 2차원 배열을 만들고, 각 배열의 값에 넓이를 넣어주는 방법   

        int answer = 1;
        int[][] map = new int[board.length][board[0].length];
        // 하나 더 크게 해서 만듦

        int maxLen = 0;

        for (int i = 1; i <= board.length; i++) {
            for (int j = 1; j <= board[0].length; j++) {
                if (board[i - 1][j - 1] != 0) {
                    int min = Math.min(Math.min(map[i - 1][j], map[i][j - 1]), map[i - 1][j - 1]);
                    // 대각선, 왼, 위 값이 1이면 정사각형
                    map[i][j] = min + 1;
                    // board에 해당하는 현재 위치 

                    maxLen = Math.max(maxLen, min + 1);
                }
            }    
        }
    return maxLen*maxLen;

  </ul>
  </div>
</details>
<details>
  <summary><b>가장 긴 팰린드롬</b></summary>
  <div markdown="1">
    <ul>
       (2024.10.08)
      <li>Trial_1 1이 나올때 startIdx와 endIdx를 가지고 다시 루프 돌리는 메서드 </li>

       public int solution(String s)
        {
            int answer = 1;
    
            if (s.length() == 1) {
                return 1;
            } else if (s.length() == 2) {
                if (s.charAt(0) == s.charAt(1)) {
                    return 2;
                }else{
                    return 1;
                }
            }
    
            // 3이상
            int divide = s.length() / 2;
            
            // 앞으로 비교 
            for (int i = divide; i >0 ; i--) {
                int tmp = check(i, s);
                answer = Math.max(answer, tmp);
                
                // divide 위치 바뀜 
            }
            if (answer == s.length()) {
                // 가장 최대값
                return answer;
            }
            // 뒤로 비교 
            for (int i = divide+1; i < s.length()-1; i++) {
                int tmp = check(i, s);
                answer = Math.max(answer, tmp);
            }
            return answer;
        }
    
        private int check(int index, String s) {
            int i = 1;
            int answer = 1;
            while (index - i > 0 && index < s.length()) {
                if (s.charAt(index - 1) == s.charAt(index + 1)) {
                    answer += 2;
                    i++;
                }else{
                    break;
                }
            }
            return answer;
        }
☑️ 최대값을 구하는 것이기 때문에 우선 반으로 나누어서 반에서 시작한 후 왼쪽(1까지만) 오른쪽(길이 -1) 으로 탐색  
☑️ 홀수 일 때 나눈 몫에서 시작 / 짝수 일 때 몫과 몫 -1 에서 시작 => 앞과 뒤의 숫자를 비교한 후, 같으면 그 더하고 다르면 빠져나옴 그 다음 인덱스로
<br>
✅ 맨앞, 맨끝에서 포인트를 잡고  
✅ 값이 다르면 앞에서 한개씩 줄이고 -> 뒤에서 한개씩 줄이고<br> 
✅ 값이 같으면 같은 루프에서 앞, 뒤에서 한개씩 줄여가며 범위를 줄임    

        public int solution(String s)
        {
            int answer = 1;
            int n = s.length();
            loop:
            for (int i = n; i >= 1; i--) {
                // 가장 긴 길이부터
                for (int j = 0; j <= n - 1; j++) {
                    // 가장 작은 길이
                    boolean flag = true;
                    int start = j; // 시작 인덱스
                    int end = j+i-1; // 끝 인덱스
    
                    while (start < end) {
                        if (s.charAt(start) != s.charAt(end)) {
                            // 같을 때까지 반복
                            flag = false;
                            break; // while을 빠져나감
                        }
                        start++;
                        end--;
                    }
                    if (flag) {
                        answer = i;
                        break loop;
                    }
                }
            }
            return answer;
        }

  </ul>
  </div>
</details>
<details>
  <summary><b>거스름돈</b></summary>
  <div markdown="1">
    <ul>
       (2024.10.14)
      <li>Trial_1 문제에 나와있는 걸 그대로 코드에 구현함 </li>

    public int solution(int n, int[] money) {

        // 몫과 나머지를 구하고
        // 몫이 1일 때까지 같은 메서드를
        for (int i = money.length - 1; i >= 0; i--) {
            // money에 있는 값은 n보다는 작거나 같아야 함
            if (money[i] > n) {
                continue;
            }

            // 같은 수라면 더하고 패스
            if (money[i] == n) {
                answer++;
                continue;
            }

            // 작은 수
            // 몫
            int share = n / money[i]; // 2
            // 나머지를 구함
            int rest = n % money[i]; // 1

            // 나머지가 money 배열에 존재하는지
            // 1 ~ share 만큼 곱해가면서 확인
            check(share, rest, i, money, n);

        }




        return answer;
    }

    private void check(int share, int rest, int currentIdx, int[] money, int n) {
        for (int i = 1; i <= share; i++) {
            // 배수로 값을 만들어봄
            int temp = money[currentIdx] * i;


        }
    }

☑️ 나머지가 나오고 그 나머지로 값을 구할 수 있는지의 로직이 반복되는 것 같은데, 이 부분을 공통코드로 못 빼놓겠음  

✅ 동적계획법  


    private int[][] dp;

    public int solution(int n, int[] money) {
        // 2차원 배열에서 돈의 개수 X 나와야 하는 금액
        // 자기 자신이 나올 때 1 추가
        dp = new int[money.length][n + 1]; // 해당 금액이 표에 나와야하기 때문
        for (int i = 1; i <= money.length; i++) {
            for (int j = 0; j <= n; j++) { // 가로로 가는 개념임
                if (j == 0) {
                    dp[i][j] = 1; // 맨 첫번 째 열은 1로 초기화
                } else if (j - money[i - 1] >= 0) {
                    // 돈보다 작거나 같은 경우
                    dp[i][j] = (dp[i-1][j] + dp[i][j-money[i-1]])%10000007;
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[money.length][n];
    }

  </ul>
  </div>
</details>
<details>
  <summary><b>2 x n 타일링</b></summary>
  <div markdown="1">
    <ul>
       (2024.10.16)
      <li>Trial_1  </li>

    public int solution(int n) {
          int answer = 0;
          int twoCnt = 0;
          int plus = 1;
          if (n % 2 == 0) {
              // 짝수일 때
              plus = 2;
          }
  
          while (2 * twoCnt <= n) {
              int tmp = twoCnt * (n-(2*twoCnt));
              if (tmp == 0) {
                  answer += 1;
              }else{
                  answer += tmp + plus;
              }
              twoCnt++;
          }
          return answer;
      }

☑️ 규칙을 못 찾겠음 

✅ DP 알고리즘 - 이전전 + 이전 의 개수를 합하면 = 현재  


    public int solution(int n) {
        int answer = 0;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10000007;
        }
        return answer;
    }

  </ul>
  </div>
</details>
<details>
  <summary><b>124나라</b></summary>
  <div markdown="1">
    <ul>
       (2024.10.16)
      <li>Trial_1 규칙 발견 못함  </li>

    public String solution(int n) {
        String answer = "";
        String[] numbers = {"4", "1", "2"};

        // 3으로 우선 나눈 후
        // 나머지는 뒤에 붙여주고 앞자리는 루프
        // 나머지가 0인 경우 4
        int num = n;
        // 가장 끝 자리수
        while (num > 0) {
            // 계속해서 이어 붙임
            int remain = num % 3; // 나머지
            num /= 3;// 몫
            if (remain == 0) {
                num--;
            }
            answer = numbers[remain] + answer;

        }
        return answer;
    }

☑️ 나머지와 몫을 통해 규칙을 찾음, 나머지가 0인 경우 기존 숫자를 -1 한 값으로 다시 계산 

  </ul>
  </div>
</details>
<details>
  <summary><b>연속된 부분집합</b></summary>
  <div markdown="1">
    <ul>
       (2024.10.23)
      <li>Trial_1 단순한 이중 루프 돌림</li>
      
☑️ 시작과 끝점을 이중 루프를 돌려서 끝-시작 의 길이를 계속해서 현행화 해서 짧은 값 리턴 

☑️ 모든 sequence를 끝까지 돌려야 하므로 시간초과 에러가 뜸 

    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int[] temp = new int[2];
        int length = Integer.MAX_VALUE;
        for (int i = 0; i < sequence.length; i++) {
            int value = sequence[i];
            if (value == k) {
                answer[0] = i;
                answer[1] = i;
                return answer;//최단
            }

            for (int j = i + 1; j < sequence.length; j++) {
                value += sequence[j];
                if (value == k) {
                    if (length > j - i) {
                        length = j - i;
                        temp[0] = i;
                        temp[1] = j;
                        answer = temp;
                    }
                }
            }
        }
        return answer;
    }
☑️ 기존 답을 참고 하였으나, index boundary exception 뜸 
        
    public int[] solution(int[] sequence, int k) {
        int leftIdx = 0; // 시작
        int rightIdx = 0; // 끝
        int curSum = sequence[0];

        int length = sequence.length;
        List<Integer> list = new ArrayList<>();
        // 합이 같은 연속된 값들이 여러개일 수가 있기 때문에 list

        while (true) {
            if (curSum == k) {
                // 합이 같을 떄
                list.add(leftIdx);
                list.add(rightIdx);
            }

            if (list.size() == 4) {
                // 2. 합이 같은 값이 복수다
                // 길이가 짧은 것이 답이다
                if (list.get(1) - list.get(0) < list.get(3) - list.get(2)) {
                    // 앞으로 당겨짐
                    list.remove(2);
                    list.remove(2);
                } else if (list.get(1) - list.get(0) > list.get(3) - list.get(2)) {
                    // 맨 앞엔 것을 빼면 또 앞으로 당겨짐
                    list.remove(0);
                    list.remove(0);
                }else{
                    // 길이도 같다면 먼저
                    list.remove(2);
                    list.remove(2);
                }
            }
            if (leftIdx == length && rightIdx == length) {
                // 가장 끝
                break;
            }

            if (curSum <= k && rightIdx < length) {
                // 아직 갈 떄가 남음
                rightIdx++;
                // 한칸 더 가봄
                curSum += sequence[rightIdx];
            }else{
                // 부분합이 넣어가거나 더이상 오른쪽으로 이동이 안되는 경우
                if (leftIdx < length) {
                    curSum -= sequence[leftIdx];
                    leftIdx++;
                }
            }
        }
        return new int[]{list.get(0), list.get(1)};
    }

✅ **두 포인터**를 잡고, 끝으로 가는 for 문을 만들어봄 
      
✅ while문 현재의 합이 주어진 값보다 큰 경우 -> 왼쪽 포인터를 한칸씩 이동하고 값 제외

       
      int[] answer = new int[2];
      int leftIdx = 0; // 시작
      int curSum = 0;
      int curSize = sequence.length;

      for (int rightIdx = 0; rightIdx < sequence.length; rightIdx++) {
          curSum += sequence[rightIdx];
          while (rightIdx < sequence.length && curSum > k) {
              // 왼쪽에서 뒤로 이동함
              curSum -= sequence[leftIdx];
              leftIdx++;
          }
          if (curSum == k) {
              // 찾으려고 하는 값
              if (curSize > rightIdx - leftIdx) {
                  curSize = rightIdx - leftIdx;
                  answer[0] = leftIdx;
                  answer[1] = rightIdx;
              }
          }
      }

      return answer;
  </ul>
  </div>
</details>
<details>
  <summary><b>과제진행하기</b></summary>
  <div markdown="1">
    <ul>
       (2024.10.28)
      <li>Trial_1 대기 Queue를 만들어서 시작과 종료일시를 비교하는 로직 </li>
      ☑️ NullPointerException

    public class Solution2 {
      public String[] solution(String[][] plans) {
          String[] answer = new String[plans.length];
  
          // 순서를 변경해줄 예정이므로 linkedlist
          List<Assignment> list = new ArrayList<>();
  
          // 재조립
          for (String[] plan : plans) {
              String[] separated = plan[1].split(":");
              long startHour = Long.valueOf(separated[0]) * 60 + Long.valueOf(separated[1]);
              // 시작 시간 변환
              Assignment assignment = new Assignment(plan[0], startHour, startHour + Long.valueOf(plan[2]));
              list.add(assignment);
          }
  
          // 시작 시간 순으로 정렬
          Collections.sort(list, new StartComprator());
  
          // 대기 큐
          Queue<Assignment> queue = new LinkedList<>();
          for (Assignment assign : list) {
              queue.add(assign);
          }
          int idx = 0;
          // 시작
          while (!queue.isEmpty()) {
              Assignment currentAssign = queue.poll();
              // 현재 assginment 정보
  
              if (currentAssign.getEnd() > queue.peek().getStart()) {
                  // next의 시작이 curr end 보다 작으면 next가 시작임
                  // next의 값을 집어넣음
                  queue.add(currentAssign);
                  // 현재 하고 있는 값을 queue에서 뺴서 집어넣음
              }else{
                  answer[idx] = currentAssign.getSubject();
                  idx++;
              }
          }
          return answer;
      }
  
      class Assignment {
          private String subject;
          private long start;
          private long end;
  
          public Assignment(String subject, long start, long end) {
              this.subject = subject;
              this.start = start;
              this.end = end;
          }
  
          public String getSubject() {
              return subject;
          }
  
          public long getStart() {
              return start;
          }
  
          public long getEnd() {
              return end;
          }
      }
  
      class StartComprator implements Comparator<Assignment> {
          @Override
          public int compare(Assignment o1, Assignment o2) {
              if (o1.getStart() < o2.getStart()) {
                  return 1;
              } else if (o1.getStart() > o2.getStart()) {
                  return -1;
              }
              return 0;
          }
        }
    }

☑️ 남아있는 과제가 있는 경우, 가장 먼저 집어넣진 값 부터 실행된다는 것을 간과함 
      
☑️ Stack 만들어서 구현하고, 시간 변환도 메서드로 따로 빼서 정의함 


    public String[] solution(String[][] plans) {
        // 잠시 멈춘 과제가 있으면 -> 최근에 멈춘 것 부터 진행 (Stack)

        String[] answer = new String[plans.length];
        int idx = 0;
        LinkedList<Assignment> tasks = new LinkedList<>();
        for (String[] plan : plans) {
            tasks.offer(new Assignment(plan[0], convertToMinute(plan[1]), Integer.parseInt(plan[2])));
        }
        // 정렬
        tasks.sort((o1, o2) -> o1.start - o2.start);
        
        // 남은 일
        Stack<Assignment> stopTasks = new Stack<>();

        Assignment currentAssign = tasks.poll();
        int time = currentAssign.start;

        while (!tasks.isEmpty()) {
            // 과제 돌림 
            // 시작 시간 + 남아있는 시간  = 총 업무 시간 
            time += currentAssign.left;
            // 그 다음 일
            Assignment next = tasks.peek();

            if (time > next.start) {
                // 해당 일감 초과 함
                currentAssign.left = time - next.start; // 남은시간
                stopTasks.push(currentAssign); // 남은 일 
            } else {
                answer[idx] = currentAssign.subject;
                idx++;
                if (!stopTasks.empty()) {
                    // 남아있는게 있으면 ** 우선 남아있는 것 우선 
                    currentAssign = stopTasks.pop();
                    continue;
                }
            }
            currentAssign = tasks.poll(); // while 문 바깥에서 설정했으므로 
            time = currentAssign.start;
        }
        
        // 마지막 과제 
        answer[idx] = currentAssign.subject;
        
        // 마지막 남아있는 과제들 싹 집어넣음
        while (!stopTasks.isEmpty()) {
            answer[idx] = stopTasks.pop().subject;
            idx++;
        }
        
        return answer;
    }

    class Assignment {
        private String subject;
        private int start;
        private int left;

        public Assignment(String subject, int start, int left) {
            this.subject = subject;
            this.start = start;
            this.left = left;
        }
    }

    private int convertToMinute(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }

  </ul>
  </div>
</details>
<details>
  <summary><b>광물캐기 - 완벽하게 이해하지 못함 </b></summary>
  <div markdown="1">
    <ul>
       (2024.11.15)
      <li>Trial_1 picks에 조합에 따라 광물을 만났을 때 소모되는 체력을 더하고, 그 최소값을 반납  </li>
      ☑️ picks의 조합을 구하는 방법을 모르겠음 
        
      public int solution(int[] picks, String[] minerals) {
        pick 에서 숫자가 넘겨짐
        int answer = Integer.MAX_VALUE;
        String[] tools = new String[3];

        // 경우의 수를 넣은 배열 (총 6개)


        // 현재 피로도
        int currentTired = 0;

        for (int i = 0; i < picks.length; i++) {
            // bfs (3개까지 갔을 때 check function level,
            bfs(0, i, tools);

        }

        answer = Math.min(answer, currentTired);

        return answer;
    }

    private void bfs(int level, int index, String[] tools) {
        if (level > 3) {
            // 최종 단계까지 옴
            return;
        }
        Queue<Integer> queue = new LinkedList<>();

        queue.add(index);
        // 첫번쨰 인덱스를 담았음

        while (queue.isEmpty()) {
            String currentPicksPower = "";
            int currentIdx = queue.poll();

            if (index == 0) {
                currentPicksPower = "diamond";
            } else if (index == 1) {
                currentPicksPower = "iron";
            } else{
                currentPicksPower = "stone";
            }
            tools[level] = currentPicksPower;
        }
    }

    private int check (int currentPick, String currentPicksPower) {
        for (int i = 0; i < minerals.length; i++) {
            String mineral = minerals[i];
            while (currentPick > 0) {
                if (currentPicksPower.equals("diamond")) {
                    currentTired++; // 1만 추가

                } else if (currentPicksPower.equals("iron")) {
                    if (mineral.equals("diamond")) {
                        currentTired += 5;
                    }else{
                        currentTired++;
                    }
                }else{
                    if (mineral.equals("diamond")) {
                        currentTired += 25;
                    } else if (mineral.equals("iron")) {
                        currentTired += 5;
                    }else{
                        currentTired++;
                    }
                }
            }
            currentPick--;
        }
    }

☑️ 미네랄을 중심으로 for문 + 5개씩 같은 걸로만 캔다고 생각하고 section 2차원 배열 생성 
      
☑️ 돌을 중심으로 피로도 높은 순서대로 정렬 (** 이해가 안됨 **)   


    static int[][] section;
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        // 최소한의 피로도 (모든게 다아이몬드로만 채취 가능 vs 도구의 종류에 맞게 광물이 있을 경우)
        int cnt = Math.min(minerals.length / 5 + 1, picks[0] + picks[1] + picks[2]);

        section = new int[cnt][3]; // 5개씩 묶어서 picks 안에 있는 광물별 피로도
        int dp=0, ip=0, sp = 0;
        int idx = 0;

        // 곡괭이 개수 만큼 세기
        for (int i = 0; i < minerals.length; i += 5) {
            if(i/5==cnt){
                break;
            }
            for (int j = i; j < i + 5; j++) {
                String m = minerals[j];
                if(m.equals("diamond")){
                    dp += 1;
                    ip += 5;
                    sp += 25;
                }
                else if(m.equals("iron")){
                    dp += 1;
                    ip += 1;
                    sp += 5;
                }
                else{
                    dp += 1;
                    ip += 1;
                    sp += 1;
                }
                if (j == minerals.length - 1) {
                    break;
                }
            }

            // 각각 미네랄 5개씩 쪼갠 후 모든 걸 한 광물씩
            section[i / 5][0] = dp;
            section[i / 5][1] = ip;
            section[i / 5][2] = sp;
            dp = ip = sp = 0; // 초기화
        }

        // [이해 안됨] 돌로 캤을 때 피로도가 가장 높은 순으로 내림차순
        Arrays.sort(section, (o1, o2) -> o2[2] - o1[2]);

        // 다이아 -> 철 -> 돌로 순서대로 캠
        for (int i = 0; i < cnt; i++) {
            if (picks[0] != 0) {
                // 다이아로 캠
                answer += section[i][0];
                picks[0]--; // 하나 제외 시킴 (5개까지)
            } else if (picks[1] != 0) {
                answer += section[i][1];
                picks[1]--;
            } else if (picks[2] != 0) {
                answer += section[i][2];
                picks[2]--;
            }
        }
        return answer;
    }

  </ul>
  </div>
</details>
<details>
  <summary><b>리코챗 로봇 </b></summary>
  <div markdown="1">
    <ul>
       (2024.11.15)
      <li>Trial_1 dfs 메서드를 만들어서 상하좌우 이동, 조건에 만족하면 return / 더 이동할 수 있으면 한 방향으로만 이동  </li>

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    String[][] boardArr;
    int temp = Integer.MAX_VALUE;
    public int solution(String[] board) {
        int answer = -1;
        int rFirstRowIdx = 0;
        int rFristColIdx = 0;

        boardArr = new String[board.length][board[0].length()];

        // 2차원 배열에 담기
        for (int i = 0; i < board.length; i++) {
            String boardStr = board[i];
            for (int j = 0; j < boardStr.length(); j++) {
                // R의 위치
                if (String.valueOf(boardStr.charAt(j)) == "R") {
                    rFirstRowIdx = i;
                    rFristColIdx = j;
                }
                boardArr[i][j] = String.valueOf(boardStr.charAt(j));
            }
        }

        // R의 시점에서 시작함
        // 상하좌우
        dfs(rFirstRowIdx, rFristColIdx, 0);

        if (temp != Integer.MAX_VALUE) {
            return temp;
        }
        return -1;
    }

    private void dfs(int currentRowIdx, int currentColIdx, int count) {

        for (int i = 0; i < 4; i++) {
            int nextRowIdx = currentRowIdx + dx[i];
            int nextColIdx = currentColIdx + dy[i];
            if (boardArr[nextRowIdx][nextColIdx].equals("G")) {
                // 목표 접근
                return;
            }
            while(nextRowIdx>=0 && nextRowIdx<boardArr.length
                    && nextColIdx>=0 && nextColIdx<boardArr[0].length
                    && boardArr[nextRowIdx][nextColIdx] == "."){
                // 같은 방향일 떄
                nextRowIdx += dx[i];
                nextRowIdx += dy[i];
            }
            // 다른 방향일 때 차수 증가
            count ++;
            dfs(nextRowIdx, nextColIdx, count);
            // 한 차례 돌리고 나서 비교
            temp = Math.min(temp, count);
        }
    }

✅ BFS 를 사용해야 한다고 함   </br>
✅ 굳이 Math.min 하지 않아도 BFS 로 하는 경우, 가장 먼저 반납되는 값이 가장 작은 값임 


      public int solution(String[] board) {
        int answer = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        boolean[][] visited = new boolean[board.length][board[0].length()];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length(); j++) {
                if (board[i].charAt(j) == 'R') {
                    // 시작 위치
                    queue.offer(new int[]{i, j, 0}); // x, y 좌표를 담아둠
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int x = tmp[0]; // x
            int y = tmp[1];
            int count = tmp[2];

            // 반복하다가 만족하면 여기서 반납 (제일 먼저 반납한다는 건 제일 빠르다는 뜻)
            if (board[x].charAt(y) == 'G') {
                answer = count;
                return answer;
            }

            for (int i = 0; i < 4; i++) {
                // 상하좌우
                int nx = x;
                int ny = y;

                while (nx >= 0 && nx < board.length
                        && ny >= 0 && ny < board[0].length()
                        && board[nx].charAt(ny) != 'D'
                ) {
                    // 계속해서 이동하는 경우
                    nx += dx[i];
                    ny += dy[i];
                }

                // ** 장애물 만나면 직전으로 수정 **
                nx -= dx[i];
                ny -= dy[i];

                // ** 장애물 만나기 직전으로 옮겨짐 방문했거나 또는 같은 위치라면 **
                // 상하좌우 기존 값에서 이동해하므로
                if (visited[nx][ny] || (x == nx && y == ny)) {
                    continue;
                }

                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny, count + 1});
            }
        }
        answer = -1;
        return answer;
    }

  </ul>
  </div>
</details>

---
### Level.3
<details>
  <summary><b>야근지수</b></summary>
  <div markdown="1">
    <ul>
      (2024.07.31-2024.08.05)
      <li>Trial 1_몫과 나머지를 이용해서 각각 1씩 빼주면, 즉 모든 값이 동일하게 작아져야 거듭제곱의 최소값이 되려나?</li>
      
     public long solution(int n, int[] works) {
        long answer = 0;
        int amount;
        // 제급곱의 합은 모든 수가 가장 작을 때
        // 몫에 대한 값을 배열에 모든 수에게 빼준 후에
        // 나머지 값 그 길이만큼 배열에서 값을 빼주면?
        if (n >= works.length) {
            // 남은 작업량이 각 업무보다 큰 경우
            amount = n / works.length;
        } else {
            amount = 0;
        }
        int rest = n % works.length;

        Arrays.stream(works).map(s -> s - amount);
        for (int i = 0; i < rest; i++) {
            works[i] -= -1;
        }
        answer = Arrays.stream(works).map(s -> s*s).sum();
        return answer;
    }

  💥 답 잘 안나옴</br>
  💥 접근법이 다른 듯 
  <li>Trial 2_주어진 예제만을 생각해서 연산으로 풀려고 했지만, 다른 모든 예제에 대해서 실패가 뜸 </li>
  
      public long solution(int n, int[] works) {
        long answer = 0;
        int amount;
        // 제급곱의 합은 모든 수가 가장 작을 때
        // 몫에 대한 값을 배열에 모든 수에게 빼준 후에
        // 나머지 값 그 길이만큼 배열에서 값을 빼주면?
        Arrays.sort(works); // 큰 값 부터 빼줘야하므로 배열 정렬
        int sum = Arrays.stream(works).sum();

        if (n < sum) {
            // 남은 작업량이 각 업무보다 큰 경우
            amount = n/works.length;
        } else {
            // 남은 작업양이 없음
            return 0;
        }

        if (amount > 0) { // 몫이 존재하면 몫 부터 빼고 나머지 // 존재하지 않으면 나머지만
            for (int i = works.length-1; i >= 0; i--) {
                works[i] -= amount;
            }
        }

        int rest = n%works.length;
        for (int i = works.length-1; i >rest; i--) {
            works[i] -= 1;
        }

        answer = Arrays.stream(works).map(s -> s*s).sum();
        return answer;
    }

  <li>Example_PriorityQueue를 반대로 선언</li>

      public long solution(int n, int[] works) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        // 높은 숫자 우선

        for (int work : works) {
            queue.add(work);
            // queue에 일을 집어넣음
        }

        for (int i = 0; i < n; i++) {
            int max = queue.poll();
            // 현재의 가장 큰 수
            if (max <= 0) {
                // 가장 큰수가 0이라면 N에서 다 할당 된 것
                break;
            } else {
                // max에 수가 남음
                queue.add(max - 1);
                // 일 하나를 제거하고 넣음
            }
        }

        return sum(queue);
    }

    private long sum(PriorityQueue<Integer> queue) {
        long sum = 0;
        while (!queue.isEmpty()) {
            sum += Math.pow(queue.poll(), 2);
        }
        return sum;
    }
    
  ✅ PriorityQueue로 큰 숫자를 기준으로 정렬함

✅ 가장 큰 숫자가 0이 될때까지 1씩 빼면서 다시 queue 에 담음

✅ 0이 되거나 아니면 n 이 끝날 때까지 반복한 배열의 거듭제곱을 구함
  </ul>
  </div>
</details>

<details>
  <summary><b>순위</b></summary>
  <div markdown="1">
    <ul>
       (2024.08.08)
      <li>Trial_1 문제에 나와있는 걸 그대로 코드에 구현함 </li>

    int givenNum = 0;
    int answer = 0;
    boolean numberOne = false;
    public int solution(int n) {
        givenNum = n;
        answer = 0;
        // 더해서 해당 값이 나오는 경우의 수를 구함
        // 연속해서 값을 더하려면 일단 무조건 그 숫자의 절반 값은 확보함
        // 그 다음 가능성은 그 절반 값보다 작은 경우
        // -> 그때의 값이 1보다 작으면 끝
        // 그 값이 n 이 되면 더하고, n보다 크면 넘어감
        // -> 1까지 내려오면 더이상 더 할 수 없는 옵션 없음
    
        if (n <= 2) {
            // 1경우만 존재함
            return 1;
        }
    
        int half = n/2;
        if (n % 2 != 0) {
            half += 1; // 1개 더함
        }
    
        for (int i = half; i >=1 ; i--) {
            sum(i);
            if (numberOne) {
                // 끝까지 온 경우 끝내야함
                break;
            }
        }
        return answer+1;
    }
    
    private void sum(int i) {
        int total = i;
        int idx = 1;
    
        while (total + (i-idx) <= givenNum) {
            if (i-idx == 1) {
                // 끝까지 왔다는 것
                numberOne = true;
            }
            // 합이 주어진 숫자보다 작을 때까지 더함
            total += (i-idx);
            if (total == givenNum) {
                // 연속된 합이 같을 때임
                answer++;
                return; // 루프 빠져서 다시 돌아감
            }
            idx++;
        }
    
    }



<li>Trial_2 숫자를 비교하는 2차원 배열을 만들어서, 각각 행과 열에 -1, 0, 1 넣음</li>
✅ 그래프 배열을 만들어서 

    int[][] graph = new int[n + 1][n + 1];
      // 배열에 들어간 숫자는 1부터 이므로
      
    for (int[] edge : results) {
        graph[edge[0]][edge[1]] = 1;
        // 이긴 표시
        graph[edge[1]][edge[0]] = -1;
        // 진 표시
    }

✅ 주어진 배열에 1 / 그 반대에 -1

✅ 결과 값이 주어진 배열에 사이에 있는 숫자를 넣어서 같은 값이라면 그 숫자의 승부 결과다 같음을 이용

    for (int i = 1; i <= n; i++) {
    // 도착
      for (int j = 1; j <= n; j++) {
          // 거쳐감
          for (int k = 1; k <= n; k++) {
              // i, j 의 매칭의 결과로 결과가 확정되는 값
              if (graph[i][k] == 1 && graph[k][j] == 1) {
                  graph[i][j] = 1;
                  graph[j][i] = -1;
              }
              if (graph[i][k] == -1 && graph[k][j] == -1) {
                  graph[i][j] = -1;
                  graph[j][i] = 1;
              }
  
          }
        }
    }


✅ 한 행의 0이 아닌 모든 결과 값이 있는 경우 → 순위가 정해지는 경우 

    for (int i = 1; i <= n ; i++) {
      int cnt = 0;
      for (int j = 1; j <= n; j++) {
          if (graph[i][j] != 0) {
              cnt++;
          }
      }
      if (cnt == n - 1) {
          answer++;
      }
    }



  </ul>
  </div>
</details>

