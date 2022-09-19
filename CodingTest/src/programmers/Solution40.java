package programmers;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class Solution40 {
	class Solution {
	    public String solution(int a, int b) {
	        LocalDate date = LocalDate.of(2016, a, b);
	        DayOfWeek dayofweek= date.getDayOfWeek();
	                
	        return dayofweek.getDisplayName(TextStyle.SHORT, Locale.US).toUpperCase();
	    }
	}
	
	public static void main(String[] args) {
		
		int a = 5;
		int b = 24;
		
        
        LocalDate date = LocalDate.of(2016, a, b);
        
        DayOfWeek dayofweek= date.getDayOfWeek();
        
        
        System.out.println(dayofweek.getDisplayName(TextStyle.SHORT, Locale.US).toUpperCase());
        
		
	}

}
