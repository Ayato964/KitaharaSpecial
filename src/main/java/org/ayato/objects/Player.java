package org.ayato.objects;

import org.ayato.animation.image.ImageMaker;
import org.ayato.component.Transform;
import org.ayato.util.BaseScene;
import org.ayato.util.KeyInputs;

import java.awt.*;
import java.awt.event.KeyEvent;

public non-sealed class Player extends BaseShooter {
    private final String name;
    private final ImageMaker image = new ImageMaker("objects", "player");
    public Player(Transform transform, String name, BaseScene scene) {
        super(transform, scene);
        this.name = name;

    }

    @Override
    protected void display(Graphics2D graphics2D, int i, int i1) {
        graphics2D.drawImage(image.get(), i, i1, null);
    }

    protected void move(Transform transform) {
        if (KeyInputs.get(KeyEvent.VK_LEFT))
            transform.position.setX(transform.position.getNormalX() - 1);
        if (KeyInputs.get(KeyEvent.VK_RIGHT))
            transform.position.setX(transform.position.getNormalX() + 1);
        if (KeyInputs.get(KeyEvent.VK_UP))
            transform.position.setY(transform.position.getNormalY() - 1);
        if (KeyInputs.get(KeyEvent.VK_DOWN))
            transform.position.setY(transform.position.getNormalY() + 1);
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
