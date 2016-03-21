package ParticleEngine;

import org.lwjgl.Sys;
import org.lwjgl.util.vector.Vector3f;

import java.util.ArrayList;

/**
 * Created by Lance on 3/20/2016.
 */
public class PaticleEmitter {
   // Particle[] group = new Particle[10];
    ArrayList<Particle> group = new ArrayList<>();
    Vector3f position = new Vector3f();

    long time;

    public PaticleEmitter(Vector3f initPos) {
        position = initPos;
    }

    public PaticleEmitter(float x, float y, float z) {
        position.x = x;
        position.y = y;
        position.z = z;
    }

    public void init() {
        time = getTime();

        group.add(0,new Particle(position,null));
        for ( int i = 1; i < 20; i++) {
            group.add(i,new Particle(position,group.get(i-1)));
        }


        /*
        group[0] = new Particle(position, null);
        for(int i = 1; i < group.length; i++) {
            group[i] = new Particle(position, group[i-1]);
        }
        */
    }

    public void start() {
        group.get(0).spawn();
        for(int i = 0; i < group.size(); i++) {
            if (group.get(i).parent != null && group.get(i).isAlive == false) {
                if(group.get(i).parent.currentPos.y > group.get(i).currentPos.y + 10) {
                    group.get(i).spawn();
                }
            }
            if(group.get(i).isAlive == true) {
                group.get(i).currentPos.y += 1;
            }
            group.get(i).update();
            System.out.println("" + i +  " : " + group.get(i).currentPos.y + " " + group.get(i).isAlive);
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
