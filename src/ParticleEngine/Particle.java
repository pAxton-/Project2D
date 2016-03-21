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
    public boolean isFalling = false;
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
              renderPoint();
            flutter();
          if( currentPos.y > 300) {
                fall();
            }

        }
        if (currentPos.y > 600 || currentPos.y < 0) {
            die();
        }
    }

    public void fall() {
        isFalling = true;
        currentPos.y -= 1f;
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

    private void renderQuad() {
        Random r = new Random();
        int a = r.nextInt(20);
        float rot = r.nextInt(1000);
        float red = r.nextFloat();
        float green = r.nextFloat();
        float blue = r.nextFloat();
        glEnable(GL_BLEND);
        glEnable(GL_DEPTH_TEST);

        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glDisable(GL_TEXTURE_2D);
        glPushMatrix();
        glTranslatef(currentPos.x	, currentPos.y, currentPos.z);
        glRotatef(rot, 0, 0, 1);
        glPointSize(a);
        glScalef(a,a,a);
        glColor4f(red, green, blue, red);
        glBegin(GL_QUADS);
        glVertex2f(-0.5f, -0.5f);
        glVertex2f(-0.5f, 0.5f);
        glVertex2f(0.5f, 0.5f);
        glVertex2f(0.5f, -0.5f);
        glEnd();
        glPopMatrix();
    }

    private void renderPoint() {
        Random r = new Random();
        int a = r.nextInt(4);
        float rot = r.nextInt(1000);
        float red = r.nextFloat();
        float green = r.nextFloat();
        float blue = r.nextFloat();
        glEnable(GL_BLEND);
        glEnable(GL_DEPTH_TEST);

        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glDisable(GL_TEXTURE_2D);
        glPushMatrix();
        glTranslatef(currentPos.x	, currentPos.y, currentPos.z);
        glRotatef(rot, 0, 0, 1);
        glPointSize(a);
      //  glScalef(a,a,a);
        glColor4f(red, 0.1f,0.1f, 0.6f);
        glBegin(GL_POINTS);
        glVertex2f(-0.5f, -0.5f);

        glEnd();
        glPopMatrix();
    }
}
