package CodingTest.src.programmers_kit.repeat;

public class Hash1 {
    public boolean solution(String[] phone_book) {
       String compareNum = phone_book[0];

        for (int i = 1; i < phone_book.length; i++) {
            if(phone_book[i].contains(compareNum)&&compareNum.length()<=phone_book[i].length()){
                return false;
            }
        }
        return true;
    }
}
