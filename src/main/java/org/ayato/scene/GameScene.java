package org.ayato.scene;

import org.ayato.component.*;
import org.ayato.objects.Enemy;
import org.ayato.objects.Player;
import org.ayato.system.ToonMaster;
import org.ayato.util.BaseScene;

import java.awt.*;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Supplier;

public class GameScene extends BaseScene {
    public final Player player;
    public int level = 1;
    public Supplier<Integer> wait_sup = ()-> Math.max(new Random().nextInt(0, 1000- level * 10), 100);
    public int wait_time = 0, wait_time_max = wait_sup.get();
    public GameScene(String name){
        player = new Player(new Transform(
                new Position(100, 100),
                new Scale(50, 50),
                new Rotate(0)
        ), name, this);
    }

    @Override
    protected void setToonObjects(CopyOnWriteArrayList<ToonObject> to) {
        to.add(player);
    }
    public void levelUp(){
        level ++;
    }

    @Override
    public void tick() {
        addEnemy();
        outSideEnemy();
    }

    private void outSideEnemy() {

    }

    public void addEnemy(){
        wait_time ++;
        if(wait_time >= wait_time_max){
            wait_time = 0;
            wait_time_max = wait_sup.get();
            addObject(new Enemy(
                    new Transform(new Random().nextInt(0, 300), 0, 40, 40),
                    ToonMaster.getINSTANCE().MY_SCENE
            ));
        }
    }

    @Override
    public void display(Graphics graphics) {

    }

    @Override
    public void createUI(ToonMaster toonMaster) {

    }
}
