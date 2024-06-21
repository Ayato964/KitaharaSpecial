package org.ayato.objects;

import org.ayato.animation.image.ImageMaker;
import org.ayato.component.ToonObject;
import org.ayato.component.Transform;
import org.ayato.util.KeyInputs;
import org.ayato.util.MouseInputs;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class Player extends ToonObject {
    private final String name;
    private final ImageMaker image = new ImageMaker("objects","player");
    public Player(Transform transform, String name) {
        super(transform);
        this.name = name;
    }

    @Override
    protected void display(Graphics2D graphics2D, int i, int i1) {
        graphics2D.drawImage(image.get(), i, i1, null);
    }

    @Override
    protected void tick(Transform transform) {
        move(transform);
    }
    private void move(Transform transform){
        if(KeyInputs.get(KeyEvent.VK_LEFT))
            transform.position.setX(transform.position.getNormalX() - 1);
    }

}
