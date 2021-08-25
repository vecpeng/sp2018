import java.util.Deque;

public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> res = new LinkedListDeque<Character>();
        for (int i = 0; i < word.length(); i++) {
            res.addLast(word.charAt(i));
        }
        return res;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> res = new LinkedListDeque<Character>();
        int l = 0;
        int r = word.length() - 1;
        while (l < r) {
            if (word.charAt(l) == word.charAt(r)) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> res = new LinkedListDeque<Character>();
        int l = 0;
        int r = word.length() - 1;
        while (l < r) {
            if (cc.equalChars(word.charAt(l), word.charAt(r))) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }
}
