package Objects.Weapons;

import Objects.BaseEntity;
import Objects.PhysicsType;
import Objects.Soldier;

/**
 * Created by Lance on 3/26/2016.
 */
public abstract class Weapon extends BaseEntity {
    Soldier parent;
    float magCapacity;
    private float offset = 0;
    public PhysicsType type = PhysicsType.TRIGGER;

    public Soldier getParent() {
        return parent;
    }

    public void setParent(Soldier parent) {
        this.parent = parent;
        setX(parent.getX()+offset);
        setY(parent.getY());
        setRot(parent.getRot());
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
}
