package ParticleSystem;

import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;

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

    public enum COLORTYPE {
        COLORBLENDING, SINGLECOLOR, TEXTURED;
    }

    public enum SHAPE {
        QUAD, POINT, TRIANGLE, POLYGON;
    }

    public Particles(SHAPE type, COLORTYPE cType) {
        this.cType = cType;
        this.type  = type;
    }

    public void update(Vector3f position, Vector4f color, float angle, float speed) {
      this.position = position;
      this.color    = color;
      this.angle    = angle;
      this.speed    = speed;

    }

    public void colorBlender(float fadeSpeed, Vector4f[] colors) {

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
}
