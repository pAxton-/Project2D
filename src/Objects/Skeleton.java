package Objects;

import org.lwjgl.util.vector.Vector3f;

/* *
 * Created by pAxton on 3/19/2016.
 */
public class Skeleton {
    private Armature head, spine, arm_l, arm_r, leg_l, leg_r;
    private Armature[] bones;
    private Vector3f position = new Vector3f(300,300,1);

    public Skeleton() {
        bones = new Armature[]{head, spine, arm_l, arm_r, leg_l, leg_r};
        //head parents with top of spine
        head.setConstraint(head.getJointB());
        head.setParent(spine);
        head.connectToB(spine.getJointA());//this may work backwards to how it sounds
        head.setLength(10);
        //spine has no parents, will be the bone that gets input
        spine.setConstraint(spine.getJointB());
        spine.setLength(20);
        spine.getJointB().setPosition(position);
        spine.getJointA().setPosition(position.x + spine.getLength(), position.y + spine.getLength(),position.z);
        //arm_l parents to spine
        arm_l.setConstraint(arm_l.getJointB());
        arm_l.setParent(spine);
        arm_l.connectToB(spine.getJointA());
        arm_l.setLength(10);
        //arm_r parents to spine
        arm_r.setConstraint(arm_r.getJointB());
        arm_r.setParent(spine);
        arm_r.connectToB(spine.getJointA());
        arm_r.setLength(10);
        //leg_l parents to spine
        leg_l.setConstraint(leg_l.getJointB());
        leg_l.setParent(spine);
        leg_l.connectToB(spine.getJointB());
        leg_l.setLength(20);
        //leg_r parents to spine
        leg_r.setConstraint(leg_r.getJointB());
        leg_r.setParent(spine);
        leg_r.connectToB(spine.getJointB());
        leg_r.setLength(20);

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
