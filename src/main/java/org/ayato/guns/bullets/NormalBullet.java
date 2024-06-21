package org.ayato.guns.bullets;

import org.ayato.component.ToonObject;
import org.ayato.component.Transform;

import java.awt.*;

public class NormalBullet extends BaseBullet{
    protected NormalBullet(Transform transform, ToonObject parent) {
        super(transform, parent);
    }

    @Override
    protected void move(Transform transform, ToonObject parent) {

    }

    @Override
    protected void display(Graphics2D graphics2D, int i, int i1) {

    }
}
