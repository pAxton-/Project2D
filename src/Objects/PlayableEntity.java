package Objects;

import Logic.InputHandler;
import Logic.InputListener;
import org.lwjgl.input.Keyboard;

import java.awt.event.MouseListener;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glPopMatrix;

/**
 * Created by Lance on 3/21/2016.
 */
public class PlayableEntity extends BaseEntity  {

    InputHandler IH;
    private static boolean inputEnabled = false;
    private Keyboard kb;
    private boolean upPressed = Keyboard.isKeyDown(Keyboard.KEY_W);
    private boolean downPressed = Keyboard.isKeyDown(Keyboard.KEY_S);
    private boolean rightPressed = Keyboard.isKeyDown(Keyboard.KEY_D);
    private boolean leftPressed = Keyboard.isKeyDown(Keyboard.KEY_A);

    public PlayableEntity() {
       IH =  new InputHandler(this);
    }

    public void init(float g) {

    }

    public void update(int delta) {
        updateKeyState();
        moveRightOnKeyPressed(0.5f, delta);
        moveLeftOnKeyPressed(0.5f, delta);

        draw();
    }
    public boolean isInputEnabled() {
        return inputEnabled;
    }

    public void setInputEnabled(boolean inputEnabled) {
        this.inputEnabled = inputEnabled;
    }

    public void moveRightOnKeyPressed(float speed, int delta) {
        if (Keyboard.isKeyDown(Keyboard.KEY_D) && inputEnabled) {
            IH.X_Axis(speed, delta);
        }
    }
    public void moveLeftOnKeyPressed(float speed, int delta) {
        if(Keyboard.isKeyDown(Keyboard.KEY_A) && inputEnabled) {
            IH.X_Axis(-speed, delta );
        }
    }

    private void updateKeyState() {
        upPressed = Keyboard.isKeyDown(Keyboard.KEY_W);
        downPressed = Keyboard.isKeyDown(Keyboard.KEY_S);
        rightPressed = Keyboard.isKeyDown(Keyboard.KEY_D);
        leftPressed = Keyboard.isKeyDown(Keyboard.KEY_A);

    }
    private void draw() {

        glDisable(GL_TEXTURE_2D);
        glPushMatrix();
        glTranslatef(getX(), getY(), 0);
        glRotatef(0, 0, 0, 1);
        glPointSize(5);

        // glColor4f((float)Math.cos(angle)*.625f, (float)Math.sin(angle)*0.625f, (float)Math.sin(angle)*.625f, color.w);
        glBegin(GL_POINTS);
        glVertex3f(0.0f,0.0f,0.0f);
        glEnd();
        glPopMatrix();

    }


}
