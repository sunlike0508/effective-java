package chapter01.Item1.solution2;

public class Character {

    private char value;

    private String color;

    private Font font;
    //    private String fontFamily; // 폰트 종류
    //    private int fontSize; // 글자 크기

    public Character(char value, String color, Font font) {
        this.value = value;
        this.color = color;
        this.font = font;
    }

//    public Character(char value, String color, String fontFamily, int fontSize) {
//        this.value = value;
//        this.color = color;
//        this.fontFamily = fontFamily;
//        this.fontSize = fontSize;
//    }
}
