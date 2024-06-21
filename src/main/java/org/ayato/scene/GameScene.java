package org.ayato.scene;

import org.ayato.component.*;
import org.ayato.objects.Player;
import org.ayato.system.ToonMaster;
import org.ayato.util.BaseScene;

import java.awt.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class GameScene extends BaseScene {
    public final Player player;
    public GameScene(String name){
        player = new Player(new Transform(
                new Position(100, 100),
                new Scale(100, 100),
                new Rotate(0)
        ), name);
    }
    @Override
    protected void setToonObjects(CopyOnWriteArrayList<ToonObject> to) {
        to.add(player);
    }

    @Override
    public void tick() {

    }

    @Override
    public void display(Graphics graphics) {

    }

    @Override
    public void createUI(ToonMaster toonMaster) {

    }
}
