package org.ayato.system;

import org.ayato.component.Transform;
import org.ayato.objects.Enemy;
import org.ayato.objects.EnemyRegistries;
import org.ayato.objects.Player;
import org.ayato.scene.GameScene;

import java.util.Random;
import java.util.function.Supplier;

public class NormalSingleWave implements Wave{

    @Override
    public void action(GameScene scene, Player player) {
        Random rand = new Random();
        scene.addObject(EnemyRegistries.NORMAL.getSup().get(
                new Transform(rand.nextInt(300) + 5, 10, 20, 20),
                scene,
                rand.nextInt(player.level) + 2));
    }
}
