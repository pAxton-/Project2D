package Objects;

import Logic.MsgType;
import Objects.Land.Ground;
import Objects.Weapons.TestWeapon;
import Util.ImgLoader;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.opengl.Texture;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glPopMatrix;

/**
 * Created by Lance on 3/26/2016.
 */
public class Soldier extends PlayableEntity {

    Texture texture;
    ImgLoader il = new ImgLoader();
    float speed = 0.15f;
    float cx = 0;
    float cy = 0;
    public float localRot;
    Ground ground;
    boolean debug = false;
    MsgType crrntMsg = null;


    public Soldier(Ground ground) {
        super(ground);
        this.ground = ground;
        texture = il.loadTexture("src/res/soldier.png", "PNG");
        setScaleX(50);
        setScaleY(50);
        //setRot(0);
        setDirByMouse(true);


    }
    public void update(int delta) {
        updateKeyState();

        if (crrntMsg == MsgType.COLLIDED) {
            setInputEnabled(false);
            setDirByMouse(false);
            if(upPressed){
                speed = -0.09f;
            }
            if(downPressed) {
                speed = 0.09f;
            }
           // dx = getX() - Mouse.getX();
           // dy = getY() - Mouse.getY();
            localRot = (float) Math.atan2(Mouse.getY() - getY(), Mouse.getX() - getX());
            float rot = (float) Math.toDegrees(localRot);
            setRot(rot);
            IH.Y_Axis(speed, localRot+45, delta);
            IH.X_Axis(speed, localRot+45, delta);

        } else {
            setInputEnabled(true);
            setDirByMouse(true);
            cx = getX();
            cy = getY();
            speed = 0.15f;
        }
        if(isDirByMouse() && !Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
            dx = getX() - Mouse.getX();
            dy = getY() - Mouse.getY();
            localRot = (float) Math.atan2(Mouse.getY() - getY(), Mouse.getX() - getX());
            float rot = (float) Math.toDegrees(localRot);
            setRot(rot);


            moveOnXAxis(speed, localRot, delta);
            moveOnYAxis(speed, localRot, delta);
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
            dx = getX() - Mouse.getX();
            dy = getY() - Mouse.getY();
            localRot = (float) Math.atan2(Mouse.getY() - getY(), Mouse.getX() - getX());
            float rot = (float) Math.toDegrees(localRot);
            setRot(rot);
           move(speed, localRot,delta);

        }
        if(debug) {
            drawOrigin();
        }
        draw();
    }

    public void receiveMsg(MsgType msg) {
        crrntMsg = msg;
    }

    public void draw() {

        glEnable(GL_DEPTH_TEST);
        glEnable(GL_TEXTURE_2D);
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);


        glPushMatrix();

        glTranslatef(getX(), getY(), getZ());
        glRotatef(getRot()-90, 0, 0, 1);
        glScalef(getScaleX(), getScaleY(), 0);
        glColor4f(1, 1, 1, 1);


        texture.bind();


        glBegin(GL_QUADS);
        glTexCoord2f(0, 0);
        glVertex3f(-.5f, .5f, 0);

        glTexCoord2f(.15f, 0);
        glVertex3f(.5f, .5f, 0);

        glTexCoord2f(.15f, .395f);
        glVertex3f(.5f, -.5f, 0);

        glTexCoord2f(0, .395f);
        glVertex3f(-.5f, -.5f, 0);

        glEnd();

        glPopMatrix();

    }
}
