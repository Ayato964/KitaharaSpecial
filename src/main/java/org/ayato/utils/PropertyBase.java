package org.ayato.utils;

import org.ayato.animation.AnimationState;
import org.ayato.animation.Properties;
import org.ayato.animation.PropertiesComponent;
import org.ayato.animation.TextProperties;
import org.ayato.util.PropertiesSupplier;

import java.awt.*;
import java.util.function.Supplier;

public class PropertyBase {
    public static final PropertiesSupplier<TextProperties> TEMPLATE = (x, y) ->
         PropertiesComponent.ofText(x, y)
                .font("", Font.PLAIN, 1.5f)
                .color(Color.WHITE);
    public static final Supplier<AnimationState> STATE = ()-> new AnimationState(
            Color.WHITE,
            Color.BLUE,
            Color.RED,
            new Color(0,10, 0, 30),
            new Color(0,10, 0, 30),
            new Color(0,10, 0, 30)
    );
}