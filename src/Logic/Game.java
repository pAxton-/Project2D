package Logic;

import org.lwjgl.Sys;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;
import org.newdawn.slick.opengl.Texture;

import Objects.Camera;
import Objects.Entity;

import Objects.Entity.Type;
import Util.ImgLoader;
import Util.Options;
import Util.Screen;

import java.io.FileNotFoundException;
import java.util.Random;


public class Game {
	
	private static final Type PLAYER = null;
	static Game game;
	final String TITLE = "TITLE";
	final String VERSION = "0.0.1 pre-alpha";
	
	
	Options options = new Options();
	ImgLoader imgLoader = new ImgLoader();
    Sounds sound;
	Screen screen;
	Camera cam1;
	GameState gameState = GameState.MENU;

	Entity enty;
	Grid map;

	private long lastFrame;

    boolean closeProgram = false;
	private Grid amp2;
    Texture playerTex;
	private Grid map2;

	public void updateOptions(){
		
		options.readFile("src/res/options.cfg");
		
		
	}
	
	public void init(){
		
		screen = new Screen(options.screenWidth, options.screenHeight, options.frameCap, options.fullscreen, options.vSync, TITLE+" - "+VERSION);
		cam1 = new Camera(new Vector2f(0,0), new Vector2f(options.screenWidth, options.screenHeight));
        sound = new Sounds();
        enty =  new Entity(new Vector3f(screen.width/2,screen.height/2,5), new Vector2f(60,60), new Vector4f(1,1,1,1), PLAYER);
        playerTex = imgLoader.loadTexture("src/res/badgerSpreadSheet.png", "PNG");
        enty.texture = playerTex;
        map = new Grid(22,18.5f,options.screenWidth/5,25,40);


        try {
            sound.init();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
	
	public void mainLoop(){

        GridSquare[][] lgs = map2.getGridSquares();
        Random rand = new Random();

        double currentTime = getTime();

		while(!screen.isCloseRequested()){

            cam1.update();
            switch (gameState){

                case MENU:

                    break;
                case PLAYING:

                    break;
            }


            if(closeProgram){
				break;
			}
			screen.update();
		}
	}
	
	public void close(){
		sound.destroy();
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
