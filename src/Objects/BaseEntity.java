package Objects;


/**
 * Created by Lance on 3/21/2016.
 */
public abstract class BaseEntity {
    private float x;
    private float y;
    private float z;
    private float mass, health, rot;
    private float[] scale = new float[2];
    PhysicsType type;

    public float[] getScale() {
        return scale;
    }

    public void setScale(float[] scale) {
        this.scale = scale;
    }

    public PhysicsType getType() {
        return type;
    }

    public void setType(PhysicsType type) {
        this.type = type;
    }

    public float getLeftSide() {
        return x - getScaleX()/2;
    }

    public float getRightSide() {
        return x + getScaleX()/2;
    }

    public float getTopSide() {
        return y + getScaleY()/2;
    }

    public float getBottomSide() {
        return y - getScaleY()/2;
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

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float getMass() {
        return mass;
    }

    public void setMass(float mass) {
        this.mass = mass;
    }

    public float getScaleX() {
        return scale[0];
    }

    public void setScaleX(float scale) {
        this.scale[0] = scale;
    }

    public float getScaleY() {
        return scale[1];
    }

    public void setScaleY(float scale) {
        this.scale[1] = scale;
    }

    public float getRot() {
        return rot;
    }

    public void setRot(float rot) {
        this.rot = rot;
    }

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }
}
