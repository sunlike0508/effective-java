package chapter01.Item1.solution2;

public class Font {

    private String fontFamily; // 폰트 종류
    private int fontSize; // 글자 크기

    private Font(String fontFamily, int fontSize) {
        this.fontFamily = fontFamily;
        this.fontSize = fontSize;
    }

    public static Font of(String fontFamily, int fontSize) {
        return new Font(fontFamily, fontSize);
    }
}