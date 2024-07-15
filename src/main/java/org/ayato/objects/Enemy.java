package org.ayato.objects;

import org.ayato.component.ToonObject;
import org.ayato.component.Transform;
import org.ayato.scene.GameScene;
import org.ayato.system.ToonMaster;
import org.ayato.util.BaseScene;

import java.awt.*;

public abstract non-sealed class Enemy extends BaseShooter{
    int bodyATK = 1;
    int bodyWaitingTimeMax = 200;
    int bodyWaitingTime = bodyWaitingTimeMax;
    int haveEXP;

    public Enemy(Transform transform, BaseScene scene, int hp) {
        super(transform, scene, hp);
        haveEXP = hp / 2;
    }

    @Override
    protected void death() {
        if(scene instanceof GameScene s){
            s.player.addEXP(haveEXP);
        }
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

    @Override
    protected abstract void move(Transform transform);
}
