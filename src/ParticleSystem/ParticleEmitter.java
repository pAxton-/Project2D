package ParticleSystem;

import org.lwjgl.util.vector.Vector3f;

import static org.lwjgl.opengl.GL11.*;

/* *
 * Created by pAxton on 3/20/2016.
 */
public class ParticleEmitter {

    Particles part = new Particles(Particles.SHAPE.POINT, Particles.COLORTYPE.COLORBLENDING);
    Particles[] parts = new Particles[50];

    private Vector3f position;

    public ParticleEmitter(Vector3f position) {

        this.position = position;
        for(int i = 0; i < parts.length; i++) {
            parts[i] =  new Particles(Particles.SHAPE.POINT, Particles.COLORTYPE.COLORBLENDING);
            parts[i].setPosition(position);
            System.out.println(i);
        }
        part.setPosition(position);
    }
    public void update() {
       parts[0].update(this.position, 0.2f, 4f, 1f, 2f);
      // parts[1].update(this.position,0.2f,4f,1f,2f);

      //  for(Particles pt : parts) {
      //      pt.update(this.position,5f,0.4f,1f,2f);

      //  }
    }

    public Vector3f getPosition() {
        return position;
    }

    public void setPosition(Vector3f position) {
        this.position = position;
    }


}
