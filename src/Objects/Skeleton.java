package Objects;

/**
 * Created by pAxton on 3/19/2016.
 */
public class Skeleton {

    private Armature[] bones;
    private Armature head, spine, arm_l, arm_r, leg_l, leg_r;

    public Skeleton() {

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
