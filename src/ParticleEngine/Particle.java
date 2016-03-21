package ParticleEngine;

import org.lwjgl.util.vector.Vector3f;

import static org.lwjgl.opengl.GL11.*;

/**
 * Created by Lance on 3/20/2016.
 */
public class Particle {
    public Vector3f startPosition = new Vector3f();
    public Vector3f currentPos;
    public boolean isAlive = false;
    Particle parent;

    Particle(float x, float y, float z) {
        startPosition.x = x;
        startPosition.y = y;
        startPosition.z = z;
        currentPos = startPosition;
    }
    public Particle(Vector3f position, Particle pt) {
        currentPos = new Vector3f(400,300,1);
        startPosition = position;
     //   currentPos = startPosition;
        parent = pt;
    }

    public void update() {
        if(parent != null && (isAlive == false)) {
            if(parent.currentPos.y > currentPos.y + 10) {
                spawn();
            }
        }
        if (isAlive == true) {
              render();
          //  this.rise();
        }
        if (currentPos.y > 600) {
            die();
        }
    }

    public void rise() {
        currentPos.y += 0.1f;
    }

    public void spawn() {
        isAlive = true;
    }

    public void die() {
        isAlive = false;
    }

    private void render() {
        glDisable(GL_TEXTURE_2D);
        glPushMatrix();
        glTranslatef(currentPos.x	, currentPos.y, currentPos.z);
        glRotatef(0, 0, 0, 1);
        glPointSize(4);
        glColor4f(1, 1, 1, 1);
        glBegin(GL_POINTS);
        glVertex2f(0, 0);
        glEnd();
        glPopMatrix();
    }
}
