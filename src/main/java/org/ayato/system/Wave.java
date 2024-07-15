package org.ayato.system;

import org.ayato.objects.Player;
import org.ayato.scene.GameScene;

public interface Wave {
    public void action(GameScene scene, Player player);
}
