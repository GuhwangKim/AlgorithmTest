package CodingTest.src.sample;

public class Sample {
    int answer = 0;

		Arrays.sort(people);
    int max = people.length - 1;
    int min = 0;
		for (int i = max; i >= min; i--) {
        int peopleCount = people[i]+people[min];

        if(peopleCount<=limit) {
            min++;
        }
        answer++;
    }
}
