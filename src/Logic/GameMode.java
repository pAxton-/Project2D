package Logic;

import Objects.Land.Ground;
import Objects.Land.Map;
import Objects.PlayableEntity;
import Objects.Land.StaticEntity;
import Objects.Soldier;
import Objects.Weapons.TestWeapon;

/**
 * Created by Lance on 3/25/2016.
 */
public class GameMode {

    MsgManager msgManager = new MsgManager();
    Ground map = new Ground();
    TestWeapon weap = new TestWeapon();
    Soldier player = new Soldier(map,weap);

    public GameMode(){
        map.setY(768/2);
        map.setX(1366/2);
        map.setZ(-.9f);
        map.init(1);
        player.setY(map.getY());
        player.setX(map.getX());
     //   weap.setX(map.getX()/2);
       // weap.setY(map.getY()/2+100);
        player.setZ(.9f);
        player.init(1);
        player.setInputEnabled(true);
        map.setInputEnabled(true);
        weap.setOffset(8);
        weap.setParent(player);


    }

    public void update(int delta) {
        map.update(delta);
        player.update(delta);
     //   weap.setX(map.getX()/2+1*delta);
      //  weap.setY(map.getY()/2+1*delta);
        System.out.println("Coords: " + weap.getX() + " " + weap.getY());
        System.out.println("PlayerCoords: " + player.getX() + " " + player.getY());
        weap.update();
    }
}
