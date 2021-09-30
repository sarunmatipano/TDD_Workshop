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

    public int startNumber() {
        return Integer.parseInt(input.substring(1,2));
    }

    public int endNumber() {
        return Integer.parseInt(input.substring(3,4));
    }

}
