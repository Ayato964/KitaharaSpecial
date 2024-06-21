package org.ayato.guns;

import org.ayato.objects.BaseShooter;
import org.ayato.util.BaseScene;

public abstract class Gun {
    private final int rate, multiBurstNum, maxBulletNum;

    protected Gun(int rate, int multiBurstNum, int maxBulletNum) {
        this.rate = rate;
        this.multiBurstNum = multiBurstNum;
        this.maxBulletNum = maxBulletNum;
    }
    public final void pushTrigger(BaseShooter parent, BaseScene scene){
        pushTrigger(parent, scene, rate, multiBurstNum, maxBulletNum);
    }
    public abstract void pushTrigger(BaseShooter parent, BaseScene scene, int rate, int multiBurstNum, int maxBulletNum);
}
