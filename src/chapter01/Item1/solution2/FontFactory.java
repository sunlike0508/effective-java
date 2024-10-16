package chapter01.Item1.solution2;

import java.util.HashMap;
import java.util.Map;

public class FontFactory {

    private Map<String, Font> cache = new HashMap<>();

    public Font getFont(String fontName) {

        if(cache.containsKey(fontName)) {
            return cache.remove(fontName);
        } else {
            String[] split = fontName.split(":");

            Font font = Font.of(split[0], Integer.parseInt(split[1]));
            cache.put(fontName, font);
            return font;
        }
    }
}
