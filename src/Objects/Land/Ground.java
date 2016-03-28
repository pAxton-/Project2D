package Objects.Land;

import Logic.InputHandler;
import Objects.BaseEntity;
import Util.ImgLoader;
import org.lwjgl.input.Keyboard;
import org.newdawn.slick.opengl.Texture;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glPopMatrix;

/**
 * Created by Lance on 3/26/2016.
 */
public class Ground extends BaseEntity {
    InputHandler IH;
    private static boolean inputEnabled = false;
    private Keyboard kb;
    private boolean upPressed = Keyboard.isKeyDown(Keyboard.KEY_W);
    private boolean downPressed = Keyboard.isKeyDown(Keyboard.KEY_S);
    private boolean rightPressed = Keyboard.isKeyDown(Keyboard.KEY_D);
    private boolean leftPressed = Keyboard.isKeyDown(Keyboard.KEY_A);

    Texture texture;
    ImgLoader il = new ImgLoader();

    public Ground() {
        texture = il.loadTexture("src/res/grass.png", "PNG");
        setScaleX(10000);
        setScaleY(10000);

    }
    public void init(float g) {


    }

    public void update( int delta) {
        //updateKeyState();
        //moveRightOnKeyPressed(0.12f, delta);
        //moveLeftOnKeyPressed(0.12f, delta);
        draw();
    }
    public boolean isInputEnabled() {
        return inputEnabled;
    }

    public void setInputEnabled(boolean inputEnabled) {
        this.inputEnabled = inputEnabled;
    }

    public void moveRightOnKeyPressed(float speed, float angle, int delta) {
        if (rightPressed && inputEnabled) {
            IH.X_Axis(-speed,angle, delta);
        }
    }
    public void moveLeftOnKeyPressed(float speed, float angle, int delta) {
        if(leftPressed && inputEnabled) {
            IH.X_Axis(speed, angle, delta );
        }
    }

    private void updateKeyState() {
        upPressed = Keyboard.isKeyDown(Keyboard.KEY_W);
        downPressed = Keyboard.isKeyDown(Keyboard.KEY_S);
        rightPressed = Keyboard.isKeyDown(Keyboard.KEY_D);
        leftPressed = Keyboard.isKeyDown(Keyboard.KEY_A);

    }
    private void draw() {


        glEnable(GL_DEPTH_TEST);
        glEnable(GL_TEXTURE_2D);
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);


        glPushMatrix();

        glTranslatef(getX(), getY(), getZ());
        glRotatef(0, 0, 0, 1);
        glScalef(getScaleX(), getScaleY(), 0);
        glColor4f(1, 1, 1, 1);


        texture.bind();


        glBegin(GL_QUADS);
        glTexCoord2f(0, 0);
        //glVertex3f(-0.5f, -0.5f, 0);
        glVertex3f(-.5f, .5f, 0);
        glTexCoord2f(15, 0);
        //glVertex3f(-0.5f, 0.5f, 0);
        glVertex3f(.5f, .5f, 0);
        glTexCoord2f(15, 15);
        //glVertex3f(0.5f, 0.5f, 0);
        glVertex3f(.5f, -.5f, 0);
        glTexCoord2f(0, 15);
        //glVertex3f(0.5f, -0.5f, 0);
        glVertex3f(-.5f, -.5f, 0);
        glEnd();

        glPopMatrix();
    }


}
