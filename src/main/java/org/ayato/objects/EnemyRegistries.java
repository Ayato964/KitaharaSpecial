package org.ayato.objects;

import org.ayato.component.Transform;
import org.ayato.util.BaseScene;
import org.ayato.util.RegistoryList;
import org.ayato.util.RegistoryObject;

import java.util.function.Supplier;

public class EnemyRegistries {
    public static final RegistoryList<Enemy, GetEnemy<?>> ENEMIES =
            RegistoryList.create("enemies");

    public static final RegistoryObject<Enemy, GetEnemy<?>> NORMAL =
            ENEMIES.create(NormalEnemy::new, "enemies");

    public static final RegistoryObject<Enemy, GetEnemy<?>> SERCHING_ENEMY =
            ENEMIES.create(SerchingEnemy::new, "");

    public interface GetEnemy<T extends Enemy> extends Supplier<Enemy>{
        default T get(){
            return (T) this;
        }

        T get(Transform transform, BaseScene scene, int hp);
    }
}
