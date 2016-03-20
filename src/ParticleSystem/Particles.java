package ParticleSystem;

import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;

import java.util.Random;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glPopMatrix;

/* *
 * Created by pAxton on 3/20/2016.
 */
public class Particles {

    private Vector3f position;
    private Vector4f color;
    private float    angle;
    private float    speed;
    private COLORTYPE cType;
    private SHAPE     type;
    float changer = 0;
    Random rand = new Random(1234);
    Render render;

    public enum COLORTYPE {
        COLORBLENDING, SINGLECOLOR, TEXTURED;
    }

    public enum SHAPE {
        QUAD, POINT, TRIANGLE, POLYGON;
    }

    public Particles(SHAPE type, COLORTYPE cType) {
        this.cType = cType;
        this.type  = type;
        render = new Render();
    }
    public void update(Vector3f position, float angle, float speed, float fadeSpeed, float length) {
      // this.position = position;
        this.angle    = angle;
        this.speed    = speed;
        colorBlender(fadeSpeed,length);
        rotating();
        render.drawPoly();
    }
    public void update(Vector3f position,Vector4f color, float angle, float speed) {
      this.position = position;
      this.color    = color;
      this.angle    = angle;
      this.speed    = speed;
    }

    public void rotating() {
        float flutter = rand.nextInt(10);
        this.position.x = this.position.x +(float)Math.cos(changer*flutter) *speed;
        this.position.y = this.position.y  +(float)Math.sin(changer*flutter) *speed;
        this.position.y += 0.01f;
      //  this.position.x = this.position.x + (float)Math.atan2(this.position.y*flutter,this.position.x+flutter) * flutter;
    }

    public void colorBlender(float fadeSpeed, float length) {

        float r = (float)Math.cos(changer) * length;
        float g = (float)(Math.sin(changer * 0.5f)) * length*.075f;
        float b = (float)(Math.sin(changer)*0.4f) * length*.06f;
        float a = 1;

        this.color = new Vector4f(r,g,b,a);
        changer += fadeSpeed;
    }

    public Vector3f getPosition() {
        return position;
    }

    public void setPosition(Vector3f position) {
        this.position = position;
    }

    public Vector4f getColor() {
        return color;
    }

    public void setColor(Vector4f color) {
        this.color = color;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
    private class Render {

        public void drawPoly(){
            glDisable(GL_TEXTURE_2D);

            glPushMatrix();

            glTranslatef(getPosition().getX(), getPosition().getY(), 1);
            // glRotatef(rot, 0, 0, 1);
            // glScalef(scale.x, scale.y, 0);
            glPointSize(4);
            glColor4f(getColor().getX(), getColor().getY(), getColor().getZ(), 1);

            glBegin(GL_POINTS);

            glVertex2f(0, 0);

            glEnd();


            glPopMatrix();


        }

    }
}
