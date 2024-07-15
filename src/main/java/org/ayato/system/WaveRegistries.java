package org.ayato.system;

import org.ayato.util.RegistoryList;
import org.ayato.util.RegistoryObject;

import java.util.function.Supplier;

public class WaveRegistries {
    public static final RegistoryList<Wave, Supplier<Wave>> WAVES =
            RegistoryList.create("wave");
    public static final RegistoryObject<Wave, Supplier<Wave>> NORMAL_MULTI =
            WAVES.create(NormalMultiWave::new, "normal.multi.wave");
    public static final RegistoryObject<Wave, Supplier<Wave>> NORMAL_SINGLE =
            WAVES.create(NormalSingleWave::new, "normal.single");
}
