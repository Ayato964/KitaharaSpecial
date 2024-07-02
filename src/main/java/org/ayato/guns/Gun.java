package org.ayato.guns;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.ayato.objects.BaseShooter;
import org.ayato.util.BaseScene;

public abstract class Gun {
    private final int rate, multiBurstNum, maxBulletNum, keepValueTime;
    private int rate_num = 0;
    private int blast = 0;
    private int wait = 0;
    private int keepTime = 0;
    protected Gun(int rate, int multiBurstNum, int maxBulletNum, int keepValueTime) {
        this.rate = rate;
        this.multiBurstNum = multiBurstNum;
        this.maxBulletNum = maxBulletNum;
        this.keepValueTime = keepValueTime;
    }
    public final void pushTrigger(BaseShooter parent, BaseScene scene){
        wait = 0;
        if(rate_num >= rate && blast <= maxBulletNum ) {
            pushTrigger(parent, scene, multiBurstNum);
            rate_num = 0;
            blast ++;
        }
        rate_num ++;
        System.out.println(blast);
    }

    public void unTrigger(){
        wait ++;
        if(wait >= 2000){
            keepTime ++;
            if(keepTime >= keepValueTime){
                keepTime = 0;
                rate_num = 0;
                if(blast > 0)
                    blast --;
            }
        }
    }
    public abstract void pushTrigger(BaseShooter parent, BaseScene scene, int multiBurstNum);
}
