package org.ayato.scene;

import org.ayato.component.*;
import org.ayato.objects.Enemy;
import org.ayato.objects.Player;
import org.ayato.scene.setups.PlayerStates;
import org.ayato.system.ToonMaster;
import org.ayato.util.BaseScene;
import org.ayato.util.Setup;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Supplier;

public class GameScene extends BaseScene {
    private final Random rand = new Random();
    public final Player player;
    public Supplier<Integer> wait_sup;
    public int wait_time = 0, wait_time_max;
    public GameScene(String name){
        player = new Player(new Transform(
                new Position(100, 100),
                new Scale(50, 50),
                new Rotate(0)
        ), name, this);
        wait_sup = ()-> Math.max(rand.nextInt(Math.max(3000- player.level * 10, 1)), 100);
        wait_time_max = wait_sup.get();
    }

    @Override
    protected void setToonObjects(CopyOnWriteArrayList<ToonObject> to) {
        to.add(player);
    }
    public void levelUp(){
         player.level ++;
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

    @Override
    public void setupUIClass(ArrayList<Setup> setups) {
        setups.add(new PlayerStates(player, new Transform(
                new Position(400, 10),
                new Scale(90,40),
                new Rotate(0)
        )));
    }
}
