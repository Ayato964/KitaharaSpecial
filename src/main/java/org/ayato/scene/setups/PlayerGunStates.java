package org.ayato.scene.setups;

import org.ayato.animation.Animation;
import org.ayato.component.Transform;
import org.ayato.component.Vector2D;
import org.ayato.guns.Gun;
import org.ayato.objects.Player;
import org.ayato.system.Tick;
import org.ayato.system.ToonMaster;
import org.ayato.util.Display;
import org.ayato.util.Setup;
import org.ayato.utils.PropertyBase;

import java.awt.*;
import java.util.ArrayList;
import java.util.function.Supplier;

public class PlayerGunStates implements Setup, Display, Tick {
    private final Player player;
    private final Transform trans;
    private int haveGunV;
    private final ArrayList<Animation<String>> gunStates = new ArrayList<>();
    public PlayerGunStates(Player player, Transform transform){
        this.player = player;
        this.trans = transform;
        haveGunV = player.guns.size();
        ToonMaster.getINSTANCE().SCENE.addDisplay(this);
        ToonMaster.getINSTANCE().TICK.add(this);
    }
    @Override
    public void createUI(ToonMaster toonMaster) {
        for(Gun g: player.guns) {
            gunStates.add(
                    toonMaster.addAnimation((Supplier<String>) () ->
                                    g.name + "  " + (g.maxBulletNum - g.blast) + "/" + g.maxBulletNum,
                            PropertyBase.TEMPLATE.of(10, 10)
                                    .parent(trans.position)));
        }
    }

    @Override
    public void display(Graphics graphics) {
        Vector2D vec = trans.getPosition();
        graphics.setColor(new Color(255,255,255,30));
        graphics.fillRect(vec.x(), vec.y(), trans.getW(), trans.getH());
        graphics.setColor(new Color(255,255,255));
        graphics.drawRect(vec.x(), vec.y(), trans.getW(), trans.getH());
    }

    @Override
    public void tick() {
    }

    @Override
    public long getSerialID() {
        return 0;
    }
}
