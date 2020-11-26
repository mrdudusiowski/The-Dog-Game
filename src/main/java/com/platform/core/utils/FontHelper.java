package com.platform.core.utils;

import java.awt.*;
import java.io.File;
import java.net.URI;
import java.net.URL;

public class FontHelper {
    public static Font createFont(URL url, float size){
        Font customFont = null;
        try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            customFont = Font.createFont(Font.TRUETYPE_FONT, url.openStream()).deriveFont(size);
            ge.registerFont(customFont);
        } catch (Exception ex) {
            System.out.println("[FONTHELPER][FONT] Problem z załadowaniem czcionki: " + ex.getMessage());
        }
        return  customFont;
    }
}
