package org.ayato.guns.bullets;

import org.ayato.component.ToonObject;
import org.ayato.component.Transform;
import org.ayato.objects.BaseShooter;

import java.awt.*;

public class NormalBullet extends BaseBullet{
    public NormalBullet(Transform transform, BaseShooter parent) {
        super(transform, parent, 1);
    }

    @Override
    protected void move(Transform transform, ToonObject parent) {
        transform.position.setY(transform.position.getNormalY() - 1);

    }

    @Override
    protected void display(Graphics2D graphics2D, int i, int i1, int masX, int masY) {
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillOval(0, 0, masX, masY);

    }
}
