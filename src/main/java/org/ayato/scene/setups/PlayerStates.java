package org.ayato.scene.setups;

import org.ayato.component.Transform;
import org.ayato.component.Vector2D;
import org.ayato.objects.Player;
import org.ayato.system.ToonMaster;
import org.ayato.util.Display;
import org.ayato.util.Setup;
import org.ayato.utils.PropertyBase;

import java.awt.*;
import java.util.Random;
import java.util.function.Supplier;

public class PlayerStates implements Setup, Display {
    private final long serial = new Random().nextLong(0, 1000000);
    private final Player player;
    private final Transform trans;
    public PlayerStates(Player player, Transform position){
        this.player = player;
        this.trans = position;
        ToonMaster.getINSTANCE().SCENE.addDisplay(this);
    }
    @Override
    public void createUI(ToonMaster toonMaster) {
        toonMaster.addAnimation(player.name == null ? "Player" : player.name,
                PropertyBase.TEMPLATE.of(10, 0)
                .parent(trans.position));
        toonMaster.addAnimation((Supplier<String>) ()->"Level:" + player.level, PropertyBase.TEMPLATE.of(10, 20)
                .parent(trans.position));
        toonMaster.addAnimation((Supplier<String>) ()->"Have guns value:" + player.guns.size(), PropertyBase.TEMPLATE.of(10, 30)
                .parent(trans.position));
        toonMaster.addAnimation("HP / Max HP", PropertyBase.TEMPLATE.of(10, 40)
                .parent(trans.position));
        toonMaster.addAnimation((Supplier<String>) ()->player.getHp() +"/" + player.getMhp(),
                PropertyBase.TEMPLATE.of(25, 50)
                        .color(Color.BLACK)
                .parent(trans.position));

        toonMaster.addAnimation("EXP:", PropertyBase.TEMPLATE.of(10, 60)
                .parent(trans.position));

    }

    @Override
    public void display(Graphics graphics) {
        Vector2D vec = trans.getPosition();
        graphics.setColor(new Color(255,255,255,30));
        graphics.fillRect(vec.x(), vec.y(), trans.getW(), trans.getH());
        graphics.setColor(new Color(255,255,255));
        graphics.drawRect(vec.x(), vec.y(), trans.getW(), trans.getH());

        graphics.setColor(Color.RED);
        graphics.fillRect(vec.x() + 10, vec.y() + 210, trans.getW() - 20, 20);
        graphics.setColor(Color.GREEN);
        graphics.fillRect(vec.x() + 10, vec.y() + 210,
                (int) ((trans.getW() - 20) * ((float)(player.getHp()) / (float) player.getMhp())), 20);

        graphics.setColor(Color.WHITE);
        graphics.drawRect(vec.x() + 10, vec.y() + 280, trans.getW() - 20, 20);
        graphics.setColor(Color.ORANGE);
        graphics.fillRect(vec.x() + 10, vec.y() + 280,
                (int) ((trans.getW() - 20) * ((float)(player.EXP) / (float) player.MAX_EXP)),
                20);


    }

    @Override
    public long getSerialID() {
        return serial;
    }
}
