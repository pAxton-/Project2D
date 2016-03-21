package ParticleSystem;

import org.lwjgl.Sys;
import org.lwjgl.util.vector.Vector3f;

import java.util.Random;

import static org.lwjgl.opengl.GL11.*;

/* *
 * Created by pAxton on 3/20/2016.
 */
public class ParticleEmitter {

  //  Particles part = new Particles(Particles.SHAPE.POINT, Particles.COLORTYPE.COLORBLENDING);
    Particles[] parts = new Particles[50];
    long time;

    private Vector3f position;

    public ParticleEmitter(Vector3f position) {

        this.position = position;
        for(int i = 0; i < parts.length; i++) {
            parts[i] =  new Particles(this.position,Particles.SHAPE.POINT, Particles.COLORTYPE.COLORBLENDING);
            parts[i].setPosition(position);

        }
        time = getTime();

    }
    public void update() {
        // I AM GOING ABOUT THIS ALL WRONG
      for(int i = 0; i < 50; i++){
          if(getTime() > time+100 ){
              new Particles(this.position,Particles.SHAPE.POINT, Particles.COLORTYPE.COLORBLENDING).update(.5f,.4f,0.5f,12f);
              time = getTime();
          }
      }
/*
        for(Particles pt : parts) {
           if(getTime() > time )
          pt.update(.5f,.4f,0.5f,12f);

          time = getTime();
        }
        */
      //  time = getTime();
    }

    public Vector3f getPosition() {
        return position;
    }

    public void setPosition(Vector3f position) {
        this.position = position;
    }
    public long getTime() {

        return (Sys.getTime() * 1000) / Sys.getTimerResolution();

    }

}
