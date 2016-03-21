package ParticleEngine;

import org.lwjgl.util.vector.Vector3f;

import java.util.Random;

import static org.lwjgl.opengl.GL11.*;

/**
 * Created by Lance on 3/20/2016.
 */
public class Particle {
    public Vector3f startPosition = new Vector3f();
    public Vector3f currentPos;
    float angle = 0;
    float length = 0;
    public boolean isAlive = false;
    public boolean hasDied = false;
    Particle parent;

    Particle(float x, float y, float z) {
        startPosition.x = x;
        startPosition.y = y;
        startPosition.z = z;
        currentPos = startPosition;
    }
    public Particle(Vector3f position, Particle pt) {
        currentPos = new Vector3f(400,75,1);
        startPosition = position;
     //   currentPos = startPosition;
        Random r = new Random();
        length = r.nextInt(20);
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
            flutter();
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
        hasDied = true;
    }

    private void flutter() {
        Random r = new Random();
        angle = r.nextInt(90);
        currentPos.x += (float)Math.cos(angle)*length;
        currentPos.y += (float)Math.sin(angle)*length;
    }

    private void render() {
        Random r = new Random();
        int a = r.nextInt(4);
        float rot = r.nextInt(90);
        float red = r.nextFloat();
        float green = r.nextFloat();
        float blue = r.nextFloat();
        glDisable(GL_TEXTURE_2D);
        glPushMatrix();
        glTranslatef(currentPos.x	, currentPos.y, currentPos.z);
        glRotatef(rot, rot, 0, 1);
        glPointSize(a);
        glColor4f(red, green, blue, 1);
        glBegin(GL_POINTS);
        glVertex2f(0, 0);
        glVertex2f(-2, -2);
        glVertex2f(2, 2);
        glVertex2f(-2, 1);
        glEnd();
        glPopMatrix();
    }
}
