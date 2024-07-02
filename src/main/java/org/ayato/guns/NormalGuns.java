package org.ayato.guns;

import org.ayato.component.Position;
import org.ayato.component.Scale;
import org.ayato.component.Transform;
import org.ayato.guns.bullets.NormalBullet;
import org.ayato.objects.BaseShooter;
import org.ayato.system.ToonMaster;
import org.ayato.util.BaseScene;

public class NormalGuns extends Gun{

    public NormalGuns() {
        super( 100, 1, 40, 20, "NormalGun");
    }
    @Override
    public void pushTrigger(BaseShooter parent, BaseScene scene, int multiBurstNum) {
        ToonMaster.getINSTANCE().MY_SCENE.addObject(new NormalBullet(
                new Transform((int) parent.getTransform().position.getNormalX(),
                        (int) parent.getTransform().position.getNormalY(),
                        5, 5)
                , parent));
    }
}
