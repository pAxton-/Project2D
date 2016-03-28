package Logic;

import Objects.BaseEntity;
import Objects.Land.StaticEntity;
import Objects.Soldier;
import Objects.Weapons.Projectile;

import java.util.ArrayList;

/**
 * Created by Lance on 3/26/2016.
 */
public class MsgManager {

    public final Reciever RECIEVER  = new Reciever();
    public final Sender   SENDER    = new Sender();
    ArrayList<BaseEntity> buildings = new ArrayList<>();
    ArrayList<Projectile> bullets   = new ArrayList<>();
    BaseEntity player;
    float[] playerPos = new float[2];

    public MsgType sendMsg() {
       return SENDER.collisionMsg();
    }

    public class Reciever {


        public void setPlayer(BaseEntity playr) {
            player = playr;
        }

        public void addBuilding(BaseEntity building) {
            buildings.add( building);
        }

        public void addBullets(Projectile bul) { bullets.add(bul);}

    }

    public class Sender {
        public MsgType collisionMsg() {
            for(BaseEntity t : buildings) {
                if (player.getBottomSide() < t.getTopSide()
                        && player.getTopSide() > t.getBottomSide()
                        && player.getRightSide() > t.getLeftSide()
                        && player.getLeftSide() < t.getRightSide()) {
                    return MsgType.COLLIDED;
                }
            }
            return null;
        }

        public Projectile prujectileMsg() {
            for(Projectile b : bullets) {
                for (BaseEntity t : buildings) {
                    if (b.getBottomSide() < t.getTopSide()
                            && b.getTopSide() > t.getBottomSide()
                            && b.getRightSide() > t.getLeftSide()
                            && b.getLeftSide() < t.getRightSide()) {
                        b.setMsg();
                        bullets.remove(b);
                        return b;
                    }
                }
            }
            return null;
        }
    }
}
