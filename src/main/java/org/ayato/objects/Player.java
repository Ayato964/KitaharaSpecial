package org.ayato.objects;

import org.ayato.animation.PropertiesComponent;
import org.ayato.animation.image.ImageMaker;
import org.ayato.component.Transform;
import org.ayato.guns.NormalGuns;
import org.ayato.system.ToonMaster;
import org.ayato.util.BaseScene;
import org.ayato.util.KeyInputs;
import org.ayato.utils.PropertyBase;

import java.awt.*;
import java.awt.event.KeyEvent;

public final class Player extends BaseShooter {
    public final String name;
    public int level = 1;
    public int EXP = 0, MAX_EXP = 2;
    private final ImageMaker image = new ImageMaker("objects", "player");

    public Player(Transform transform, String name, BaseScene scene) {
        super(transform, scene, 20);
        this.name = name;
        guns.add(new NormalGuns());

    }

    @Override
    protected void display(Graphics2D graphics2D, int i, int i1, int masX, int masY) {
        graphics2D.drawImage(image.get(), 0, 0, masX, masY, null);
    }

    protected void move(Transform transform) {
        if (KeyInputs.get(KeyEvent.VK_LEFT))
            transform.position.setX(transform.position.getNormalX() - 0.5f);
        if (KeyInputs.get(KeyEvent.VK_RIGHT))
            transform.position.setX(transform.position.getNormalX() + 0.5f);
        if (KeyInputs.get(KeyEvent.VK_UP))
            transform.position.setY(transform.position.getNormalY() - 0.5f);
        if (KeyInputs.get(KeyEvent.VK_DOWN))
            transform.position.setY(transform.position.getNormalY() + 0.5f);
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void death() {
        ToonMaster.getINSTANCE().addAnimation("GAME OVER", PropertiesComponent.ofText(50, 40)
                .color(Color.WHITE)
                .font("", 0, 5)
                .fadeIn(200));
    }

    public void addEXP(int exp) {
        EXP += exp;
        if(EXP >= MAX_EXP) {
            levelUp();
            addEXP(0);
        }
    }
    public void levelUp(){
        level++;
        EXP -= MAX_EXP;
        MAX_EXP *= 1.5;
        addHP(mhp / 3);
    }
}
