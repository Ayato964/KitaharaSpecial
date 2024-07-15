package org.ayato.objects;

import org.ayato.component.Transform;
import org.ayato.util.BaseScene;

public class NormalEnemy extends Enemy{

    public NormalEnemy(Transform transform, BaseScene scene, int hp) {
        super(transform, scene, hp);
    }

    @Override
    protected void move(Transform transform) {
        transform.position.setY(transform.position.getNormalY() + 0.1f);
    }
}
