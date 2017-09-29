package entities;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import entities.FPSCameraController;

public class FPSSystem extends ApplicationAdapter {
	
	   public static PerspectiveCamera camera;
	   FPSCameraController cameraController;
	   
	   @Override
	   public void create() {
		   camera = new PerspectiveCamera(75, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
				      
		   cameraController = new FPSCameraController(camera);
		   Gdx.input.setInputProcessor(cameraController);

		   camera.position.set(0f,0,0f);
		   
		   camera.lookAt(0f,0f,0f);
		   camera.near = 0.1f; 
		   camera.far = 300.0f;
	   }
	   @Override
	   public void render() {
		   cameraController.setVelocity(1.5f);
		   cameraController.update();
		   camera.update();
	   }
}
