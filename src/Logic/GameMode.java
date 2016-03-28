package Logic;

import Objects.Land.Ground;
import Objects.Land.Map;
import Objects.Land.TestBuilding;
import Objects.PlayableEntity;
import Objects.Land.StaticEntity;
import Objects.Soldier;
import Objects.Weapons.Projectile;
import Objects.Weapons.TestWeapon;
import ParticleEngine.Particle;
import org.lwjgl.input.Keyboard;

/**
 * Created by Lance on 3/25/2016.
 */
public class GameMode {

    MsgManager msgManager = new MsgManager();
    Map map;
    public Ground ground;
    Soldier player;
    TestWeapon tw = new TestWeapon();
    int l = 0;
    boolean fire = false;
    boolean reArm = false;



    public GameMode(float w, float h){
        ground = new Ground();
        player = new Soldier(ground);
        tw.setParent(player);
        player.setY(h);
        player.setX(w);
        player.setZ(.9f);
        player.init(1);
        player.setInputEnabled(true);
        map = new Map(player, ground, msgManager);


    }

    public void update(int delta) {
        map.update(delta);
        player.update(delta);
        player.receiveMsg(msgManager.SENDER.collisionMsg());


        tw.update();
        if(!Keyboard.isKeyDown(Keyboard.KEY_D)) {
            reArm = true;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_D)) {
            if(reArm) {
                fire = true;
                reArm = false;
            }
        }
        if(fire) {
         msgManager.RECIEVER.addBullets(tw.fireBullet(new Projectile(tw.getX(),tw.getY(),player.localRot)));
            fire = false;
        }
      msgManager.SENDER.prujectileMsg();




    }
}
