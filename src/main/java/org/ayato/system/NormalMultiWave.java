package org.ayato.system;

import org.ayato.component.Transform;
import org.ayato.objects.Enemy;
import org.ayato.objects.EnemyRegistries;
import org.ayato.objects.Player;
import org.ayato.scene.GameScene;

import java.util.Random;
import java.util.function.Supplier;

public class NormalMultiWave implements Wave {
    private Random rand = new Random();
    private boolean isChecked = false;
    GameScene game;
    Player p;

    private final Supplier<Enemy> enemy = ()-> EnemyRegistries.NORMAL.getSup().get(
            new Transform(rand.nextInt(300) + 5, 10, 20, 20),
            game,
            rand.nextInt(p.level) + 2);
    int enemyCount = 0, enemyMax = 3;
    public NormalMultiWave(){
    }
    @Override
    public void action(GameScene scene, Player player) {
        game = scene;
        p = player;
        new Thread(this::timeTick).start();
    }

    public void timeTick() {
        while (enemyCount <= enemyMax){

            enemyCount ++;
            game.addObject(enemy.get());
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        enemyCount = 0;
    }
}
