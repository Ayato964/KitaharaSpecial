package org.ayato.objects;

import org.ayato.component.ToonObject;
import org.ayato.component.Transform;
import org.ayato.guns.Gun;
import org.ayato.guns.NormalGuns;
import org.ayato.util.BaseScene;
import org.ayato.util.KeyInputs;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public abstract sealed class BaseShooter extends ToonObject permits Player {
    private final ArrayList<Gun> guns = new ArrayList<>();
    private int haveGunNumber = 0;
    private final BaseScene scene;
    protected BaseShooter(Transform transform, BaseScene scene) {
        super(transform);
        this.scene = scene;
        guns.add(new NormalGuns());
    }

    @Override
    protected void tick(Transform transform) {
        trigger(transform);
        move(transform);
    }

    private void trigger(Transform transform) {
        if(KeyInputs.get(KeyEvent.VK_SPACE))
            guns.get(haveGunNumber).pushTrigger(this, scene);
    }
    protected abstract void move(Transform transform);
}
