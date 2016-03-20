package Objects;

import org.lwjgl.util.vector.Vector3f;

/* *
 * Created by pAxton on 3/19/2016.
 */
public class Joint {

        private Vector3f position = new Vector3f();
        private float x,y,z;
        private boolean isConstraint = false;

        public Joint() {

        }

        public Joint(float x, float y, float z) {
            setX(x);
            setY(y);
            setZ(z);
        }

        public Joint(Vector3f vector) {
            setPosition(vector);
        }

        public boolean isConstraint() {
            return isConstraint;
        }

        public void setIsConstraint(boolean isConstraint) {
            this.isConstraint = isConstraint;
        }

        public float getX() {
            return x;
        }

        public void setX(float x) {
            this.x = x;
        }

        public float getY() {
            return y;
        }

        public void setY(float y) {
            this.y = y;
        }

        public float getZ() {
            return z;
        }

        public void setZ(float z) {
            this.z = z;
        }

        public Vector3f getPosition() {
            return position;
        }

        public void setPosition(Vector3f position) {
            this.position = position;
        }
    }


