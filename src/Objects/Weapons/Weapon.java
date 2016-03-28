package Objects.Weapons;

import Objects.BaseEntity;
import Objects.PhysicsType;
import Objects.Soldier;
import org.lwjgl.Sys;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glPopMatrix;

/**
 * Created by Lance on 3/26/2016.
 */
public abstract class Weapon extends BaseEntity {
    Soldier parent;
    float magCapacity;
    private float offset = 0;
    public PhysicsType type = PhysicsType.TRIGGER;
    private Muzzle muzzle;
    private long time;

    public Soldier getParent() {
        return parent;
    }

    public void setParent(Soldier parent) {
        this.parent = parent;
        setX(parent.getX()+offset);
        setY(parent.getY());
        muzzle = new Muzzle(this);
        setMuzzle(muzzle);
        time = getTime();

    }

    public void load() {

    }



    public float getOffset() {
        return offset;
    }

    public void setOffset(float offset) {
        this.offset = offset;
    }

    public float getMagCapacity() {
        return magCapacity;
    }

    public void setMagCapacity(float magCapacity) {
        this.magCapacity = magCapacity;
    }

    public Muzzle getMuzzle() {
        return muzzle;
    }

    public void setMuzzle(Muzzle muzzle) {
        this.muzzle = muzzle;
    }

    private class Muzzle {
        float x;
        float y;
        Muzzle(Weapon weap) {
            this.x = weap.getX();
            this.y = weap.getY()+5;
        }

        public float getX() {
            return x;
        }

        public void setX(float x) {
            this.x = x;
        }

        public float getY() {
            return y;
        }

        public void setY(float y) {
            this.y = y;
        }
    }

    public long getTime() {
        return (Sys.getTime() * 1000) / Sys.getTimerResolution();
    }

}
