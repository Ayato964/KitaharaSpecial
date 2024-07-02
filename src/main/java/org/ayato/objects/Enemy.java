package org.ayato.objects;

import org.ayato.component.ToonObject;
import org.ayato.component.Transform;
import org.ayato.system.ToonMaster;
import org.ayato.util.BaseScene;

import java.awt.*;

public non-sealed class Enemy extends BaseShooter{
    int bodyATK = 1;
    int bodyWaitingTimeMax = 200;
    int bodyWaitingTime = bodyWaitingTimeMax;
    public Enemy(Transform transform, BaseScene scene, int hp) {
        super(transform, scene, hp);
    }

    @Override
    protected void move(Transform transform) {
        transform.position.setY(transform.position.getNormalY() + 0.1f);
    }

    @Override
    protected void tick(Transform transform) {
        super.tick(transform);
        for(ToonObject o : ToonMaster.getINSTANCE().MY_SCENE.getObjects())
            if(o instanceof Player p) {
                if (transform.isCollision(p.transform)) {
                    if(bodyWaitingTime >= bodyWaitingTimeMax) {
                        p.damaged(bodyATK);
                        bodyWaitingTime = 0;
                    }
                    bodyWaitingTime ++;
                }
            }
    }

    @Override
    protected void display(Graphics2D graphics2D, int i, int i1, int i2, int i3) {
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillOval(0, 0, i2, i3);
        graphics2D.setColor(Color.BLACK);
        graphics2D.setFont(new Font("", Font.PLAIN, 128));
        graphics2D.drawString(String.valueOf(hp), i, (i1));
    }
}
