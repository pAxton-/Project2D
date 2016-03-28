package Objects.Weapons;

import Logic.MsgType;
import org.lwjgl.input.Keyboard;

import java.util.LinkedList;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glPopMatrix;

/**
 * Created by Lance on 3/26/2016.
 */
public class TestWeapon extends Weapon{

    int coolDown = 5;
    LinkedList<Projectile> mag = new LinkedList<Projectile>();
    Projectile bullet;

    public TestWeapon() {
        setX(0);
        setY(0);
        setZ(1f);
        setScaleX(30);
        setScaleY(30);
        setMagCapacity(30);

    }

    public void updateBullets() {
        for(int i = 0; i < mag.size();i++) {
            bullet = mag.get(i);

               bullet.update();

        }
        for(int i = 0 ; i < mag.size(); i++) {
            if(mag.get(i).getX() > mag.get(i).initX + 1700 || mag.get(i).getX() < mag.get(i).initX - 1700  ||
                    mag.get(i).getY() > mag.get(i).initY + 1700 || mag.get(i).getY() < mag.get(i).initY - 1700) {
                removeBullet(mag.get(i));
            }
        }
    }

    public Projectile fireBullet(Projectile bullet) {
        mag.add(bullet);
        return bullet;
    }

    public void removeBullet(Projectile bul) {
        mag.remove(bul);
    }

    public void update() {
        setX(getParent().getX()+getOffset());
        setY(getParent().getY()+2);
        setRot(parent.getRot());
        updateBullets();

        draw();


    }

    private void draw() {
        glEnable(GL_DEPTH_TEST);
       // glEnable(GL_TEXTURE_2D);
        glDisable(GL_TEXTURE_2D);
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
      //  glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);


        glPushMatrix();

        glTranslatef(getX(), getY(), getZ());
        glRotatef(getRot()-90, 0, 0, 1);
        glScalef(getScaleX(), getScaleY(), 0);
        glColor4f(1, 1, 1, 1);
        //texture.bind();

        glLineWidth(4);
        glBegin(GL_LINES);
        glTexCoord2f(0, 0);
        glColor4f(0.2f, .2f, .2f, 1);
        glVertex3f(.5f, 1, 0);
        glVertex3f(.5f,0,0);

        glEnd();

        glPopMatrix();
    }
}
