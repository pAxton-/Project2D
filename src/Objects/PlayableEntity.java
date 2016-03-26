package Objects;

import Logic.InputHandler;
import Objects.Land.Ground;
import Objects.Weapons.TestWeapon;
import org.lwjgl.input.Keyboard;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glPopMatrix;

/**
 * Created by Lance on 3/21/2016.
 */
public class PlayableEntity extends BaseEntity  {

    InputHandler IH;
    private boolean inputEnabled = false;
    private boolean dirByarrows = false;
    private boolean dirByMouse = true;
    private Keyboard kb;
    private boolean upPressed = Keyboard.isKeyDown(Keyboard.KEY_W);
    private boolean downPressed = Keyboard.isKeyDown(Keyboard.KEY_S);
    private boolean rightPressed = Keyboard.isKeyDown(Keyboard.KEY_D);
    private boolean leftPressed = Keyboard.isKeyDown(Keyboard.KEY_A);

    float dx, dy;


    public PlayableEntity(Ground ground, TestWeapon weap) {
       IH =  new InputHandler(ground, weap);
    }

    public void init(float g) {

    }

    public void update(int delta) {
        updateKeyState();

        draw();
    }
    public boolean isInputEnabled() {
        return inputEnabled;
    }

    public void setInputEnabled(boolean inputEnabled) {
        this.inputEnabled = inputEnabled;
    }

    public void moveOnXAxis(float speed, float angle, int delta) {
        if (rightPressed && inputEnabled && !upPressed && !downPressed) {
            IH.X_Axis(-speed, angle, delta);
            if(dirByarrows) {
                setRot(-90);
            }
        }
        if(leftPressed && inputEnabled && !upPressed && !downPressed) {
            IH.X_Axis(speed, angle, delta );
            if (dirByarrows) {
                setRot(90);
            }
        }
    }

    public void moveOnYAxis(float speed, float angle, int delta) {
        if(upPressed && inputEnabled  && !rightPressed && !leftPressed) {
            IH.Y_Axis(speed, angle, delta);
            IH.X_Axis(speed, angle, delta);
            if(dirByarrows) {
                setRot(0);
            }
        }
        if(downPressed && inputEnabled & !rightPressed && !leftPressed) {
            IH.X_Axis(-speed, angle, delta);
            IH.Y_Axis(-speed, angle, delta);
            if(dirByarrows) {
                setRot(180);
            }
        }
    }

    public void move(float angle, int delta) {
        if(rightPressed) {
            setX(getX() + 0.1f * delta);
            setRot(0);
        }
        if(leftPressed) {
            setX(getX()- 0.1f*delta);
            setRot(-180);
        }
        if(upPressed) {
            setX(getX()+(float)Math.cos(angle) * 0.2f*delta);
            setY(getY()+(float)Math.sin(angle)* 0.2f*delta);
           // setY(getY()+0.1f*delta);
            //setRot(90);
        }
        if(downPressed) {
            setY(getY()-0.1f*delta);
            setRot(-90);
        }
    }

    public void updateKeyState() {
        upPressed    = Keyboard.isKeyDown(Keyboard.KEY_W);
        downPressed  = Keyboard.isKeyDown(Keyboard.KEY_S);
        rightPressed = Keyboard.isKeyDown(Keyboard.KEY_D);
        leftPressed  = Keyboard.isKeyDown(Keyboard.KEY_A);

    }
    private void draw() {

        glDisable(GL_TEXTURE_2D);
      //  glDisable(GL_BLEND);
        glPushMatrix();
        glTranslatef(getX(), getY(), 1);
        glRotatef(0, 0, 0, 1);
        glPointSize(15);

        glColor4f(1, 1, 1, 1);
        glBegin(GL_POINTS);
        glVertex3f(0.0f,0.0f,0.0f);
        glEnd();
        glPopMatrix();

    }

    public boolean isDirByarrows() {
        return dirByarrows;
    }

    public void setDirByarrows(boolean dirByarrows) {
        this.dirByarrows = dirByarrows;
    }

    public boolean isDirByMouse() {
        return dirByMouse;
    }

    public void setDirByMouse(boolean dirByMouse) {
        this.dirByMouse = dirByMouse;
    }
}
