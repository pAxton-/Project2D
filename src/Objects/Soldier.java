package Objects;

import Objects.Land.Ground;
import Objects.Weapons.TestWeapon;
import Util.ImgLoader;
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
    float cyc = 0;
    private float localRot;
    Ground ground;


    public Soldier(Ground ground, TestWeapon weap) {
        super(ground, weap);
        this.ground = ground;
        texture = il.loadTexture("src/res/soldier.png", "PNG");
        setScaleX(50);
        setScaleY(50);
        //setRot(0);
        setDirByMouse(true);


    }
    public void update(int delta) {
        updateKeyState();
        if(isDirByMouse()) {
            dx = getX() - Mouse.getX();
            dy = getY() - Mouse.getY();
            localRot = (float)Math.atan2(Mouse.getY()-getY(), Mouse.getX()-getX());
            float rot = (float)Math.toDegrees(localRot);
            setRot(rot);
        }

        moveOnXAxis(0.15f, localRot , delta);
        moveOnYAxis(0.15f, localRot, delta);
        draw();
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

        glTexCoord2f(.15f, .35f);
        glVertex3f(.5f, -.5f, 0);

        glTexCoord2f(0, .35f);
        glVertex3f(-.5f, -.5f, 0);

        glEnd();

        glPopMatrix();

    }
}
