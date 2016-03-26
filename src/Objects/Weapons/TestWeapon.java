package Objects.Weapons;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glPopMatrix;

/**
 * Created by Lance on 3/26/2016.
 */
public class TestWeapon extends Weapon{

    public TestWeapon() {
        setX(0);
        setY(0);
        setZ(1f);
        setScaleX(20);
        setScaleY(20);
    }

    public void update() {
        setX(getParent().getX()+getOffset());
        setY(getParent().getY()+2);
        setRot(parent.getRot());
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

        glLineWidth(2);
        glBegin(GL_LINES);
        glTexCoord2f(0, 0);
        glColor4f(0, 1, 0, 1);
        glVertex3f(0, 1, 0);

        glTexCoord2f(.15f, 0);
        glVertex3f(0, 0, 0);
        glColor4f(1, 0, 0, 1);
        glTexCoord2f(.15f, .35f);
        glVertex3f(0, 0, 0);

        glTexCoord2f(0, .35f);
        glVertex3f(1, 0, 0);

        glEnd();

        glPopMatrix();
    }
}
