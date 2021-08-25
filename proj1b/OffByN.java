public class OffByN implements CharacterComparator {
    private int n = 0;

    public OffByN(int pn) {
        n = pn;
    }

    /**
     * Returns true if characters are equal by the rules of
     * the implementing class.
     * @param x
     * @param y
     */
    @Override
    public boolean equalChars(char x, char y) {
        return (x == y + n) || (x + n == y);
    }
}
