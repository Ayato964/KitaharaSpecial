package org.ayato.objects;

import org.ayato.component.Transform;
import org.ayato.util.BaseScene;

import java.awt.*;

public non-sealed class Enemy extends BaseShooter{
    public Enemy(Transform transform, BaseScene scene) {
        super(transform, scene);
    }

    @Override
    protected void move(Transform transform) {
        transform.position.setY(transform.position.getNormalY() + 0.2f);
    }

    @Override
    protected void display(Graphics2D graphics2D, int i, int i1, int i2, int i3) {
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillOval(0, 0, i2, i3);
    }
}
