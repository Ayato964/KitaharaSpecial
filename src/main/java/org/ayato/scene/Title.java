package org.ayato.scene;

import org.ayato.system.ToonMaster;
import org.ayato.util.BaseScene;

import java.awt.*;

public class Title extends BaseScene {
    @Override
    public void tick() {

    }

    @Override
    public void display(Graphics graphics) {

    }

    @Override
    public void createUI(ToonMaster toonMaster) {
        toonMaster.BACKGROUND.mode.setColor(Color.BLACK);
    }
}
