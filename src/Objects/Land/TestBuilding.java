package Objects.Land;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glPopMatrix;

/**
 * Created by Lance on 3/26/2016.
 */
public class TestBuilding extends StaticEntity {

    public float x_mapCoord = 0;
    public float y_mapCoord = 0;


    public TestBuilding() {
        setScaleX(60);
        setScaleY(60);
    }

    public void update(Ground grnd) {
        setX(grnd.getX()+x_mapCoord);
        setY(grnd.getY()+y_mapCoord);
     //   setY(400);
        setZ(.8f);
        draw();
    }

    private void draw() {
        glEnable(GL_DEPTH_TEST);
     //  glEnable(GL_TEXTURE_2D);
        glDisable(GL_TEXTURE_2D);
        glEnable(GL_BLEND);
  //      glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
//        glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);


        glPushMatrix();

        glTranslatef(getX(), getY(), getZ());
        glRotatef(getRot()-90, 0, 0, 1);
        glScalef(getScaleX(), getScaleY(), 0);
        glColor4f(1, 1, 1, 1);


    //    texture.bind();


        glBegin(GL_QUADS);
        glTexCoord2f(0, 0);
        glVertex3f(-.5f, .5f, 0);

        glTexCoord2f(.15f, 0);
        glVertex3f(.5f, .5f, 0);

        glTexCoord2f(.15f, .395f);
        glVertex3f(.5f, -.5f, 0);

        glTexCoord2f(0, .395f);
        glVertex3f(-.5f, -.5f, 0);

        glEnd();

        glPopMatrix();

    }
}
