package org.ayato.scene;

import org.ayato.system.ToonMaster;
import org.ayato.util.BaseScene;
import org.ayato.utils.PropertyBase;

import java.awt.*;

public class Title extends BaseScene {
    private String name;

    @Override
    public void tick() {

    }

    @Override
    public void display(Graphics graphics) {

    }

    @Override
    public void createUI(ToonMaster toonMaster) {
        toonMaster.BACKGROUND.mode.setColor(Color.BLACK);
        toonMaster.addAnimation("Kitahara Special", PropertyBase.TEMPLATE.of(20, 20));
        toonMaster.HANDLER.addInputModule("input name here", action->{
            name = action;
        }, 80, 20, PropertyBase.TEMPLATE.of(40, 10).center());
        toonMaster.addAnimation("Start", PropertyBase.TEMPLATE.of(20, 120)
                .button(0, 0, 50, 10, PropertyBase.STATE.get(),
                        ac->toonMaster.changeScene(new GameScene(name))));

    }
}
