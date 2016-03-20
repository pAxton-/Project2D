package Objects;


/* *
 * Created by pAxton on 3/19/2016.
 */
public class Armature {

    private Armature parent;
    private Joint[] joints = new Joint[2];
    private Joint jointA   = new Joint();
    private Joint jointB   = new Joint();
    private float length;


    public void setConstraint(Joint joint) {
        joint.setIsConstraint(true);
    }

    public void rotate(float angle) {

        if(jointA.isConstraint()) {
            jointA.setX((float)Math.cos(angle)*length);
            jointA.setY((float)Math.sin(angle)*length);
        }
        if(jointB.isConstraint()) {
            jointB.setX((float)Math.cos(angle)*length);
            jointB.setY((float)Math.sin(angle)*length);
        }
    }

    public void connectToA(Joint joint){
        getJointA().setX(joint.getX());
        getJointA().setY(joint.getY());
        getJointA().setZ(joint.getZ());
    }

    public void connectToB(Joint joint) {
        getJointB().setX(joint.getX());
        getJointB().setY(joint.getY());
        getJointB().setZ(joint.getZ());
    }

    public void setParent(Armature parent) {
        this.parent = parent;
    }

    public Armature getParent() {
        return parent;
    }

    public Joint[] getJoints() {
        return  joints;
    }

    public Joint getJointA() {
        return jointA;
    }

    public void setJointA(Joint a) {
        this.jointA = a;
    }

    public Joint getJointB() {
        return jointB;
    }

    public void setJointB(Joint b) {
        this.jointB = b;
    }

    public void setJoints(Joint[] joints) {
        this.joints = joints;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }


}
