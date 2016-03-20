package Objects;

import org.lwjgl.util.vector.Vector3f;

/**
 * Created by pAxton on 3/19/2016.
 */
public class Armature {

    private Armature parent;
    private Joint[] joints = new Joint[2];
    private Joint jointA   = new Joint();
    private Joint jointB   = new Joint();
    private float length;

    public Armature(Armature parent, float length) {
        if(parent != null) {
            this.parent = parent;
        }
        this.length = length;
        joints[0]   = jointA;
        joints[1]   = jointB;
    }

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

    private class Joint {

        private Vector3f position = new Vector3f();
        private float x,y,z;
        private boolean isConstraint = false;

        public Joint() {

        }

        public Joint(float x, float y, float z) {
            setX(x);
            setY(y);
            setZ(z);
        }

        public Joint(Vector3f vector) {
            setPosition(vector);
        }

        public boolean isConstraint() {
            return isConstraint;
        }

        public void setIsConstraint(boolean isConstraint) {
            this.isConstraint = isConstraint;
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

        public Vector3f getPosition() {
            return position;
        }

        public void setPosition(Vector3f position) {
            this.position = position;
        }
    }

}
