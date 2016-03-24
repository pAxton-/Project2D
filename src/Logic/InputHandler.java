package Logic;

import Objects.PlayableEntity;
import org.lwjgl.input.Keyboard;
import sun.security.util.DisabledAlgorithmConstraints;

/**
 * Created by Lance on 3/22/2016.
 */
public class InputHandler  {

    static PlayableEntity player;

    private boolean keyPressed = false;
    private boolean keyReleased = false;

    public InputHandler(PlayableEntity player) {
        this.player = player;
    }

    public void run() {


    }


    public void X_Axis(float speed, int delta ) {
        player.setX(player.getX()+speed*delta);
        System.out.println("speed : " + speed );
    }


    public void Y_Axis() {

    }


    public void Action1() {

    }


    public void Action2() {

    }


    public void Action3() {

    }
}
