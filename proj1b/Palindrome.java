import java.util.Deque;

public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> res = (Deque<Character>) new LinkedListDeque<Character>();
        for(int i = 0; i < word.length(); i++) {
            res.addLast(word.charAt(i));
        }
        return res;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> res = (Deque<Character>) new LinkedListDeque<Character>();
        for (int i = 0; i < word.length(); i++) {
            if (res.size() == 0 || res.getLast() != word.charAt(i)) {
                res.addLast(word.charAt(i));
            } else {
                res.removeLast();
            }
        }
        return res.size() == 0;
    }
}