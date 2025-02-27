package utils;

import java.util.Arrays;
import java.util.Optional;

public enum Platforms {
    DESKTOP_WEB(),
    BS_DESKTOP_WEB(),
    ANDROID("android", "lc android", "local android"),
    IOS("ios", "lc ios", "local ios"),
    BS_ANDROID("bs android"),
    BS_IOS("bs ios");

    private String[] text;

    Platforms(String... text) {
        this.text = text;
    }

    public static Platforms fromText(String text) {
        Optional<Platforms> temp = Arrays.stream(values())
                .filter(ru -> Arrays.stream(ru.text).anyMatch(x -> x.equalsIgnoreCase(text)))
                .findFirst();
        return temp.get();
    }

    public String[] getText() {
        return this.text;
    }
}
