package Logic;

import ParticleEngine.ParticleEmitter;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector2f;

import Objects.Camera;

import Util.ImgLoader;
import Util.Options;
import Util.Screen;


public class Game {
	

	static Game game;
	final String TITLE = "TITLE";
	final String VERSION = "0.0.1 pre-alpha";
	
	
	Options options = new Options();
	ImgLoader imgLoader = new ImgLoader();
    Sounds sound;
	Screen screen;
	Camera cam1;
	GameState gameState = GameState.MENU;
    ParticleEmitter pe;

	private long lastFrame;

    boolean closeProgram = false;

	public void updateOptions(){
		
		options.readFile("src/res/options.cfg");
		
		
	}
	
	public void init(){
		
		screen = new Screen(options.screenWidth, options.screenHeight, options.frameCap, options.fullscreen, options.vSync, TITLE+" - "+VERSION);
		cam1 = new Camera(new Vector2f(0,0), new Vector2f(options.screenWidth, options.screenHeight));
        pe = new ParticleEmitter(400,300,1);
      /*  sound = new Sounds();


        try {
            sound.init();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        */

    }
	
	public void mainLoop(){



        double currentTime = getTime();
        pe.init();
		while(!screen.isCloseRequested()){

            cam1.update();
            switch (gameState){

                case MENU:
                    pe.start();
                    break;
                case PLAYING:

                    break;
            }

            if (Keyboard.isKeyDown(Keyboard.KEY_UP)) {
                pe.gravity += 0.005f;
            }
            if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
                pe.gravity -= 0.005f;
            }
            if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
                pe.addMore();
            }
            if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
                pe.amount -= 1;
            }
            if(closeProgram){
				break;
			}
			screen.update();
		}
	}
	
	public void close(){
		//sound.destroy();
        screen.destroy();
	}

	
	public static void main(String[] args) {
		game = new Game();
		
		game.updateOptions();
		game.init();
		game.mainLoop();
		game.close();
	}
	public int getDelta() {
		long time = getTime();
		int delta = (int) (time - lastFrame);
		lastFrame = time;
		
		return delta;
		}
		 
	
		public long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
		}



}
