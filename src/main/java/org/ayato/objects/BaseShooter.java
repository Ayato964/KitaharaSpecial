package org.ayato.objects;

import org.ayato.component.ToonObject;
import org.ayato.component.Transform;
import org.ayato.guns.Gun;
import org.ayato.guns.NormalGuns;
import org.ayato.system.ToonMaster;
import org.ayato.util.BaseScene;
import org.ayato.util.KeyInputs;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public abstract sealed class BaseShooter extends ToonObject permits Enemy, Player {
    public final ArrayList<Gun> guns = new ArrayList<>();
    public int haveGunNumber = 0;
    private final BaseScene scene;
    protected int hp, mhp;
    private final Transform pos;


    protected BaseShooter(Transform transform, BaseScene scene, int mhp) {
        super(transform);
        pos = transform;
        this.scene = scene;
        this.mhp = mhp;
        hp = mhp;
    }

    public int getHp() {
        return hp;
    }

    public int getMhp() {
        return mhp;
    }

    @Override
    protected void tick(Transform transform) {
        trigger(transform);
        move(transform);
    }

    public Transform getTransform() {
        return pos;
    }

    private void trigger(Transform transform) {
        if(!guns.isEmpty()) {
            if (KeyInputs.get(KeyEvent.VK_SPACE))
                guns.get(haveGunNumber).pushTrigger(this, scene);
            else
                guns.get(haveGunNumber).unTrigger();
        }
    }
    public void damaged(int atk) {
        hp -= atk;
        if(hp <= 0)
            ToonMaster.getINSTANCE().MY_SCENE.deleteObject(this);
    }
    protected abstract void move(Transform transform);
}
