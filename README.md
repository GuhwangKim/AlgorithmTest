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

