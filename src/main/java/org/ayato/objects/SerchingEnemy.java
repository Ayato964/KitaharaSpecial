package org.ayato.objects;

import org.ayato.component.Transform;
import org.ayato.scene.GameScene;
import org.ayato.system.ToonMaster;
import org.ayato.util.BaseScene;

public class SerchingEnemy extends Enemy{
    public SerchingEnemy(Transform transform, BaseScene scene, int hp) {
        super(transform, scene, hp);
    }

    @Override
    protected void move(Transform transform) {
        if(ToonMaster.getINSTANCE().MY_SCENE instanceof GameScene base){
            Player player = base.player;
            if(transform.position.getX() >= player.transform.position.getX()){
                transform.position.setX(transform.position.getNormalX() - 0.3f);
            }else{
                transform.position.setX(transform.position.getNormalX() + 0.3f);
            }
            transform.position.setY(transform.position.getNormalY() + 0.3f);
        }
    }
}
