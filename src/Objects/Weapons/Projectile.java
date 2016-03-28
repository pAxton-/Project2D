package Objects.Weapons;

import Logic.MsgType;
import Objects.BaseEntity;
import org.lwjgl.Sys;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glPopMatrix;

/**
 * Created by Lance on 3/27/2016.
 */
public class Projectile extends BaseEntity {
    float angle = 0;
    public float initX;
    public float initY;
    private long time;
    public boolean isAlive = false;
    MsgType msg;
    float r = 0.2f, g = 0.2f, b = 0.2f, pSize = 4;

    public Projectile(float x, float y, float angle) {
        msg = null;
        isAlive = true;
        initX = x;
        initY = y;
        setScaleX(10);
        setScaleY(10);
        setX(x);
        setY(y);
        this.angle = angle;
    }



    public void update() {
      if(isAlive) {
        System.out.println(msg);
        if(msg == null && isAlive) {
            setX(getX() + (float) Math.cos(angle) * 20);
            setY(getY() + (float) Math.sin(angle) * 20);
            draw();
        }
        if(msg == MsgType.COLLIDED) {
            isAlive = false;
            r = 1;
            b = 0;
            g = 0;
            pSize = 20;
            draw();
        }
         }

    }

    public void setMsg() {
        msg = MsgType.COLLIDED;
    }

    private void draw() {
        glEnable(GL_DEPTH_TEST);
        // glEnable(GL_TEXTURE_2D);
        glDisable(GL_TEXTURE_2D);
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        //  glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);


        glPushMatrix();

        glTranslatef(getX(), getY(), 1);
        glRotatef(0, 0, 0, 1);
        glScalef(1, 1, 0);
        glColor4f(r, g, b, 1);
        //texture.bind();

        glPointSize(pSize);
        glBegin(GL_POINTS);
        glVertex3f(1, 0, 0);


        glEnd();

        glPopMatrix();
    }

    public long getTime() {
        return (Sys.getTime() * 1000) / Sys.getTimerResolution();
    }
}
