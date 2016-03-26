package Logic;

import Objects.Land.Ground;
import Objects.Weapons.TestWeapon;
import Objects.Weapons.Weapon;

/**
 * Created by Lance on 3/22/2016.
 */
public class InputHandler  {

    Ground ground;
    TestWeapon weap;

    private boolean keyPressed = false;
    private boolean keyReleased = false;

    public InputHandler(Ground ground, TestWeapon weapon) {
        this.ground = ground;
        this.weap = weapon;
    }

    public void run() {


    }


    public void X_Axis(float speed, float angle, int delta ) {
        ground.setX(ground.getX()-(float)Math.cos(angle) * speed*delta);
        weap.setX(weap.getX()-(float)Math.cos(angle) * speed*delta);
        System.out.println("speed : " + speed );
    }


    public void Y_Axis(float speed, float angle, int delta) {
        ground.setY(ground.getY()+(float)Math.sin(-angle)*speed*delta);
        weap.setY(weap.getY()+(float)Math.sin(-angle)*speed*delta);
        System.out.println("speed : " + speed );
    }


    public void Action1() {

    }


    public void Action2() {

    }


    public void Action3() {

    }
}
