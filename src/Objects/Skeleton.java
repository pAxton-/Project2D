package Objects;

import org.lwjgl.util.vector.Vector3f;

/**
 * Created by pAxton on 3/19/2016.
 */
public class Skeleton {
    private Armature head, spine, arm_l, arm_r, leg_l, leg_r;
    private Armature[] bones;
    private Vector3f position = new Vector3f(300,300,1);

    public Skeleton() {
        bones = new Armature[]{head, spine, arm_l, arm_r, leg_l, leg_r};
        //head parents with top of spine
        bones[0].setConstraint(bones[0].getJointB());
        bones[0].setParent(bones[1]);
        bones[0].connectToB(bones[1].getJointA());//this may work backwards to how it sounds
        //spine has no parents, will be the bone that gets input
        bones[1].setConstraint(bones[1].getJointB());
        //arm_l parents to spine
        bones[2].setConstraint(bones[2].getJointB());
        bones[2].setParent(bones[1]);
        bones[2].connectToB(bones[1].getJointA());
        //arm_r parents to spine
        bones[3].setConstraint(bones[3].getJointB());
        bones[3].setParent(bones[1]);
        bones[3].connectToB(bones[1].getJointA());
        //leg_l parents to spine
        bones[4].setConstraint(bones[4].getJointB());
        bones[4].setParent(bones[1]);
        bones[4].connectToB(bones[1].getJointB());
        //leg_r parents to spine
        bones[5].setConstraint(bones[4].getJointB());
        bones[5].setParent(bones[1]);
        bones[5].connectToB(bones[1].getJointB());

    }

    public Armature[] getBones() {
        return bones;
    }

    public void setBones(Armature[] bones) {
        this.bones = bones;
    }

    public Armature getHead() {
        return head;
    }

    public void setHead(Armature head) {
        this.head = head;
    }

    public Armature getSpine() {
        return spine;
    }

    public void setSpine(Armature spine) {
        this.spine = spine;
    }

    public Armature getArm_l() {
        return arm_l;
    }

    public void setArm_l(Armature arm_l) {
        this.arm_l = arm_l;
    }

    public Armature getArm_r() {
        return arm_r;
    }

    public void setArm_r(Armature arm_r) {
        this.arm_r = arm_r;
    }

    public Armature getLeg_l() {
        return leg_l;
    }

    public void setLeg_l(Armature leg_l) {
        this.leg_l = leg_l;
    }

    public Armature getLeg_r() {
        return leg_r;
    }

    public void setLeg_r(Armature leg_r) {
        this.leg_r = leg_r;
    }
}
