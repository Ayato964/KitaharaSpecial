package org.ayato.guns.bullets;

import org.ayato.component.ToonObject;
import org.ayato.component.Transform;
import org.ayato.component.Vector2D;
import org.ayato.objects.BaseShooter;
import org.ayato.system.ToonMaster;

public abstract class BaseBullet extends ToonObject {
    private final ToonObject parent;
    protected BaseBullet(Transform transform, BaseShooter parent) {
        super(transform);
        this.parent = parent;
    }
    @Override
    protected void tick(Transform transform) {
        move(transform, parent);
        deleteConfig(transform);
        collision(transform);
    }

    private void collision(Transform transform) {

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
