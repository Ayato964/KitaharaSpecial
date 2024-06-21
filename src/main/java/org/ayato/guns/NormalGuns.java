package org.ayato.guns;

import org.ayato.objects.BaseShooter;
import org.ayato.util.BaseScene;

public class NormalGuns extends Gun{

    public NormalGuns() {
        super(1000, 1, 50);
    }


    @Override
    public void pushTrigger(BaseShooter parent, BaseScene scene, int rate, int multiBurstNum, int maxBulletNum) {

    }
}
