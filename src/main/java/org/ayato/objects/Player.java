package org.ayato.objects;

import org.ayato.component.ToonObject;
import org.ayato.component.Transform;

import java.awt.*;

public class Player extends ToonObject {
    private final String name;
    public Player(Transform transform, String name) {
        super(transform);
        this.name = name;
    }

    @Override
    protected void display(Graphics2D graphics2D, int i, int i1) {
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(i, i1, 200, 200);
    }

    @Override
    protected void tick(Transform transform) {

    }
}
