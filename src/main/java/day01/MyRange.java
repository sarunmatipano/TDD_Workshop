package day01;

public class MyRange {

    private String input;

    public MyRange(String input) {
        this.input = input;
    }

    public boolean isStartWithInClude() {
        return input.startsWith("[");
    }

    public boolean isEndWithInClude() {
        return input.endsWith("]");
    }

    public boolean isStartWithParentheses() {
        return input.startsWith("(");
    }

    public boolean isEndWithParentheses() {
        return input.endsWith(")");
    }

    public int getStart() {
        char start = input.charAt(1);
        if(isStartWithInClude()) {
            return start - 48;
        }
        return start - 47;
    }

}
