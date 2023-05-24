package CodingTest.src.programmers_kit.Heap;

import java.util.*;

public class Heap4 {

    static class Music {
        int playsCnt;
        int idx;

        public Music (int playsCnt, int idx){
            this.playsCnt = playsCnt;
            this.idx = idx;
        }
    }

    public List<Integer> solution (String[] genres, int[] plays){
        List<Integer> answer = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        // 1. 장르별 최대값을 구한 해시

        for (int i = 0; i < plays.length; i++) {
            // 장르별로 값이 더해짐
            map.put(genres[i], map.getOrDefault(genres[i], 0)+plays[i]);
        }

        // 2. map 에서 더 큰 값을 뽑아내야함 map을 value 값으로 정렬
        List<String> listMax = new ArrayList<>(map.keySet());
        listMax.sort((o1, o2) -> map.get(o2)-map.get(o1));

        // 3. 장르별 plays 횟수 정렬 후 배열 담기 2개
        for (int i = 0; i < listMax.size(); i++) {
            List<Music> playsMaxArranged = new LinkedList<>();
            for (int j = 0; j < genres.length; j++) {
                if(genres[j].equals(listMax.get(i))){
                    // 4. 정렬한 리스트에서 가장 먼저 나와있는 장르와 갔다면
                    playsMaxArranged.add(new Music(plays[j], j));
                } else{
                    // 5. 아니라면 건너뜀
                    continue;
                }
            }
            // 6. 다 담은 list 값은 정렬함 (내림차순)
            Collections.sort(playsMaxArranged,(o1, o2) -> o2.playsCnt-o1.playsCnt);
            // 7. 최대 2 값만 담아줌
            answer.add(playsMaxArranged.get(0).idx);
            if(playsMaxArranged.size()>1){
                answer.add(playsMaxArranged.get(1).idx);

            }
        }
        return answer;
    }

}
