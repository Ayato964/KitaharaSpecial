package org.ayato;

import org.ayato.scene.Title;
import org.ayato.system.ToonMaster;

public class Main {
    public static void main(String[] args) {
        ToonMaster.create("Kitahara Special", true);
        ToonMaster.getINSTANCE().changeScene(new Title());
        ToonMaster.getINSTANCE().setVisible(true);
    }
}