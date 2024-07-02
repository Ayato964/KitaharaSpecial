package org.ayato.scene;

import org.ayato.system.BaseBackground;
import org.ayato.system.Layer;
import org.ayato.system.ToonMaster;
import org.ayato.util.BaseScene;
import org.ayato.utils.PropertyBase;

import java.awt.*;
import java.util.ArrayList;

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
        toonMaster.setBackground(new BaseBackground() {
            @Override
            public void setLayer(ArrayList<Layer> arrayList) {
                arrayList.add(((graphics2D, i, i1) ->{
                    graphics2D.setColor(Color.BLACK);
                    graphics2D.fillRect(0, 0, i, i1);
                }));
            }
        });
        toonMaster.addAnimation("Kitahara Special", PropertyBase.TEMPLATE.of(20, 20).center());
        toonMaster.HANDLER.addInputModule("input name here", action->{
            name = action;
        }, 80, 20, PropertyBase.TEMPLATE.of(40, 10).center());
        toonMaster.addAnimation("Start", PropertyBase.TEMPLATE.of(20, 120).center()
                .button(0, 0, 50, 10, PropertyBase.STATE.get(),
                        ac->toonMaster.changeScene(new GameScene(name))));

    }
}
