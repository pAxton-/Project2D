package ParticleSystem;

import org.lwjgl.util.vector.Vector3f;

import static org.lwjgl.opengl.GL11.*;

/**
 * Created by pAxton on 3/20/2016.
 */
public class ParticleEmitter {

    private Vector3f position;

    public ParticleEmitter(Vector3f position) {
        this.position = position;
    }

    public Vector3f getPosition() {
        return position;
    }

    public void setPosition(Vector3f position) {
        this.position = position;
    }

    private class Render {

        public void drawPoly(){
            glDisable(GL_TEXTURE_2D);

            glPushMatrix();
            glTranslatef(position.x, position.y, position.z);
           // glRotatef(rot, 0, 0, 1);
           // glScalef(scale.x, scale.y, 0);
           // glColor4f(color.x, color.y, color.z, color.w);

            glBegin(GL_POLYGON);

            glVertex2f(-0.5f, -0.5f);

            glVertex2f(0.5f, -0.5f);

            glVertex2f(0.5f, 0.5f);

            glVertex2f(-0.5f, 0.5f);


            glEnd();
            glPopMatrix();


        }

    }
}
