package Objects.Land;

import Logic.MsgManager;
import Objects.Soldier;

/**
 * Created by Lance on 3/25/2016.
 */
public class Map {
    MsgManager msgManager;
    Ground grnd;
    TestBuilding[] buildings = new TestBuilding[10];

    public Map(Soldier player, Ground grnd, MsgManager manager) {
        this.msgManager = manager;
        this.grnd = grnd;
        /*
        buildings[0] =  new TestBuilding();
        buildings[0].x_mapCoord = 100;
        buildings[0].y_mapCoord = 200;
        buildings[1] = new TestBuilding();
        buildings[1].x_mapCoord = 100;
        buildings[1].y_mapCoord = 500;
        */
        float offset = 0;
        for(int i = 0; i < 10; i++) {
            buildings[i] = new TestBuilding();
            buildings[i].x_mapCoord = 100 + offset;
            buildings[i].y_mapCoord = 200 + offset;
            msgManager.RECIEVER.addBuilding(buildings[i]);
            offset += 150;
        }
        /*
        msgManager.RECIEVER.addBuilding(buildings[0]);
        msgManager.RECIEVER.addBuilding(buildings[1]);
        */
        msgManager.RECIEVER.setPlayer(player);

    }

    public void update(int delta) {
        grnd.update(delta);
        /*
        buildings[0].update(grnd);
        buildings[1].update(grnd);
        */
        for(TestBuilding b : buildings) {
            b.update(grnd);
        }


    }

    public Ground getGround() {
        return grnd;
    }

    public void setGround(Ground ground) {
        this.grnd = ground;
    }
}
