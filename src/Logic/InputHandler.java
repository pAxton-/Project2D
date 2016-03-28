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

    public InputHandler(Ground ground) {
        this.ground = ground;
    }

    public void run() {


    }


    public void X_Axis(float speed, float angle, int delta ) {
        ground.setX(ground.getX()-(float)Math.cos(angle) * speed*delta);

    }


    public void Y_Axis(float speed, float angle, int delta) {
        ground.setY(ground.getY()+(float)Math.sin(-angle)*speed*delta);

    }


    public void Action1() {

    }


    public void Action2() {

    }


    public void Action3() {

    }
}
