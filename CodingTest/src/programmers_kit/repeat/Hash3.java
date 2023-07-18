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
			// �帣�� play Ƚ���� ����ؼ� ������
		}
		/**
		 * 1. genre�� �̸��� map�� Ű �����θ� ���� 
		 * 2. play Ȱ���� �� (key���� ���� value�� ������ ���� , �ٽ� play�� Ŭ������ �ʵ��) 
		 * */
		List<String> genreMax = new LinkedList<String>(map.keySet());
		genreMax.sort((o1, o2) -> map.get(o2) - map.get(o1)); // �������� ����

		for (int i = 0; i < genreMax.size(); i++) {
			List<Album> playarr = new LinkedList<>();
			for (int j = 0; j < genres.length; j++) {
				if (genres[j].equals(genreMax.get(i))) {
					playarr.add(new Album(plays[j], j));
					// Ƚ���� �׶��� �ε����� ����
				} else {
					continue;
				}
			}
			playarr.sort((o1, o2) -> o2.getGenre()-o1.getGenre());
			// play�� ���� �� �͵�� ����
			
			answer.add(playarr.get(0).playTotal);
			if(playarr.size()>1) {
				answer.add(playarr.get(1).playTotal);
			}
		}
		
		

		return null;

	}

}
