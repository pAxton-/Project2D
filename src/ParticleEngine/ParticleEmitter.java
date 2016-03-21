package ParticleEngine;

import org.lwjgl.Sys;
import org.lwjgl.util.vector.Vector3f;

import java.util.ArrayList;

/**
 * Created by Lance on 3/20/2016.
 */
public class ParticleEmitter {
   // Particle[] group = new Particle[10];
    ArrayList<Particle> group = new ArrayList<>();
    Vector3f position = new Vector3f();
    public int amount = 1;
    public float gravity = 1;

    long time;

    public ParticleEmitter(Vector3f initPos) {
        position = initPos;
    }

    public ParticleEmitter(float x, float y, float z) {
        position.x = x;
        position.y = y;
        position.z = z;
    }

    public void init() {
        time = getTime();

        group.add(0,new Particle(position,null));
        for ( int i = 1; i < amount; i++) {
            group.add(i,new Particle(position,group.get(i-1)));
        }


        /*
        group[0] = new Particle(position, null);
        for(int i = 1; i < group.length; i++) {
            group[i] = new Particle(position, group[i-1]);
        }
        */
    }

    public void addMore() {
        int i = group.size();
        group.add(new Particle(position,group.get(i-1)));
    }

    public void start() {
        group.get(0).spawn();
        for(int i = 0; i < group.size(); i++) {
            if (group.get(i).parent != null && group.get(i).isAlive == false) {
                if(group.get(i).parent.currentPos.y > group.get(i).currentPos.y + 2) {
                    group.get(i).spawn();
                }
            }
            if(group.get(i).isAlive == true )  {

                group.get(i).currentPos.y += gravity;
            }
            group.get(i).update();

            if(group.get(i).hasDied){
                group.get(i).currentPos = new Vector3f(400,75,1);
                group.get(i).hasDied = false;
                group.get(i).isFalling = false;
            }
        }

        /*
        group[0].spawn();
        for(int i = 0; i < group.length; i++) {
            if(group[i].parent != null && group[i].isAlive == false) {
                if (group[i].parent.currentPos.y > group[i].currentPos.y + 10) {
                    group[i].spawn();
                }
            }
            if(group[i].isAlive == true) {
                group[i].currentPos.y += 0.2f;
            }
            group[i].update();
            System.out.println("" + i +  " : " + group[i].currentPos.y + " " + group[i].isAlive);
        }
        */
    }

    public long getTime() {
        return (Sys.getTime() * 1000) / Sys.getTimerResolution();
    }
}
