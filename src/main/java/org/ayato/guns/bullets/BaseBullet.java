package org.ayato.guns.bullets;

import org.ayato.component.ToonObject;
import org.ayato.component.Transform;

public abstract class BaseBullet extends ToonObject {
    private final ToonObject parent;
    protected BaseBullet(Transform transform, ToonObject parent) {
        super(transform);
        this.parent = parent;
    }
    @Override
    protected void tick(Transform transform) {
        move(transform, parent);
    }

    protected abstract void move(Transform transform, ToonObject parent);
}
