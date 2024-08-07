package org.ayato.guns.bullets;

import org.ayato.component.ToonObject;
import org.ayato.component.Transform;
import org.ayato.component.Vector2D;
import org.ayato.objects.BaseShooter;
import org.ayato.system.ToonMaster;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class BaseBullet extends ToonObject {
    private final ToonObject parent;
    private final int atk;
    protected BaseBullet(Transform transform, BaseShooter parent, int atk) {
        super(transform);
        this.parent = parent;
        this.atk = atk;
    }
    @Override
    protected void tick(Transform transform) {
        move(transform, parent);
        deleteConfig(transform);
        collision(transform);
    }

    private void collision(Transform transform) {
        CopyOnWriteArrayList<ToonObject> objects =  ToonMaster.getINSTANCE().MY_SCENE.getObjects();
        for(ToonObject o : objects)
            if(o.transform.isCollision(transform) && o.getSerialID() != getSerialID() && o.getSerialID() != parent.getSerialID()) {
                if(o instanceof BaseShooter base)
                    base.damaged(atk);
                ToonMaster.getINSTANCE().MY_SCENE.deleteObject(this);
            }
    }

    protected void deleteConfig(Transform transform){
        Vector2D v = transform.getPosition();
        if(v.x() < 0 || v.x() >= ToonMaster.getINSTANCE().FRAME.DESCTOP_BOUNDS.width
            || v.y() < 0 || v.y() >= ToonMaster.getINSTANCE().FRAME.DESCTOP_BOUNDS.height
        ){
            ToonMaster.getINSTANCE().MY_SCENE.deleteObject(this);
        }
    }

    protected abstract void move(Transform transform, ToonObject parent);
}
