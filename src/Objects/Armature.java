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
    private float angle = 0;


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

    private void rotateToA(Joint to) {
        float dx = to.getX() - jointA.getX();
        float dy = to.getY() - jointA.getY();
        angle = (float)Math.atan2(dy,dx);
    }

    private void rotateToB(Joint to) {
        float dx = to.getX() - jointB.getX();
        float dy = to.getY() - jointB.getY();
        angle = (float)Math.atan2(dy,dx);
    }

    public void connectToA(Joint joint){
        rotateToA(joint);
        getJointA().setX(joint.getX()-(float)Math.cos(angle)*length);
        getJointA().setY(joint.getY()-(float)Math.sin(angle)*length);
        getJointA().setZ(joint.getZ());
    }

    public void connectToB(Joint joint) {
        rotateToB(joint);
        getJointB().setX(joint.getX()-(float)Math.cos(angle)*length);
        getJointB().setY(joint.getY()-(float)Math.sin(angle)*length);
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
