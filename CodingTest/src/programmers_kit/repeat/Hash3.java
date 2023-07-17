package programmers_kit.repeat;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Hash3 {

	class Album {
		int play;
		int playTotal;

		public int getGenre() {
			return play;
		}

		public void setGenre(int genre) {
			this.play = genre;
		}

		public int getPlayTotal() {
			return playTotal;
		}

		public void setPlayTotal(int playTotal) {
			this.playTotal = playTotal;
		}

		public Album(int genre, int playTotal) {
			this.play = genre;
			this.playTotal = playTotal;
		}

	}

	public List<Integer> solution(String[] genres, int[] plays) {
		List<Integer> answer= new LinkedList<Integer>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < plays.length; i++) {
			map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
			// 장르별 play 횟수를 계속해서 더해줌
		}
		/**
		 * 1. genre의 이름은 map의 키 값으로만 쓰임 
		 * 2. play 활용이 주 (key마다 더한 value의 값으로 정렬 , 다시 play가 클래스의 필드로) 
		 * */
		List<String> genreMax = new LinkedList<String>(map.keySet());
		genreMax.sort((o1, o2) -> map.get(o2) - map.get(o1)); // 내림차순 정렬

		for (int i = 0; i < genreMax.size(); i++) {
			List<Album> playarr = new LinkedList<>();
			for (int j = 0; j < genres.length; j++) {
				if (genres[j].equals(genreMax.get(i))) {
					playarr.add(new Album(plays[j], j));
					// 횟수와 그때의 인덱스를 담음
				} else {
					continue;
				}
			}
			playarr.sort((o1, o2) -> o2.getGenre()-o1.getGenre());
			// play가 많이 된 것들로 정렬
			
			answer.add(playarr.get(0).playTotal);
			if(playarr.size()>1) {
				answer.add(playarr.get(1).playTotal);
			}
		}
		
		

		return null;

	}

}
