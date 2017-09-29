package rendering;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g3d.Attribute;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.Shader;
import com.badlogic.gdx.graphics.g3d.attributes.BlendingAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.loader.G3dModelLoader;
import com.badlogic.gdx.graphics.g3d.utils.AnimationController;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.utils.UBJsonReader;

import entities.FPSCameraController;

import entities.FPSSystem;

public class RenderingSystem extends ApplicationAdapter {
	
	   private ModelBatch modelBatch;

	   private Model skybox;
	   private ModelInstance skyboxInstance;
	   
	   private Model skyboxpart;
	   private ModelInstance skyboxpartInstance;
	   
	   private Model ground;
	   private ModelInstance groundInstance;

	   private Environment environment;
//	   private AnimationController animController;
	   static FPSSystem fpsSystem;

 
	   public void create() {
		   
		   	  modelBatch = new ModelBatch();
		     
		   	  environment = new Environment();
		      environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
		      //environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));
		   	  
		   	  UBJsonReader jsonReader = new UBJsonReader();
		   	  G3dModelLoader modelLoader = new G3dModelLoader(jsonReader);
		   	  ground = modelLoader.loadModel(Gdx.files.getFileHandle("models/ground.g3db", Files.FileType.Internal));
		   	  groundInstance = new ModelInstance(ground, 0, 0, 0);
		   	  groundInstance.transform.scale(0.4f, 0.4f, 0.4f);	
		   	 		      
		   	  skybox = modelLoader.loadModel(Gdx.files.getFileHandle("models/skybox.g3db", Files.FileType.Internal));
		   	  skyboxInstance = new ModelInstance(skybox, 0, 0, 0);
		   	  skyboxInstance.transform.scale(0.4f, 0.4f, 0.4f);	
		   
		   	 		   	  
		   	  skyboxpart = modelLoader.loadModel(Gdx.files.getFileHandle("models/skyboxpart.g3db", Files.FileType.Internal));
		   	  skyboxpartInstance = new ModelInstance(skyboxpart, 0, 0, 0);
		   	  skyboxpartInstance.transform.scale(0.4f, 0.4f, 0.4f);	
		   	  skyboxpartInstance.materials.get(0).set(new BlendingAttribute(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA));
		      
//            animController = new AnimationController(modelInstance);
//		      animController.setAnimation("Mixamo.com",-1);
		     
	   }
	   
	   @Override
	   public void dispose() {

	      modelBatch.dispose();
	      skybox.dispose();
	      skyboxpart.dispose();
	      ground.dispose();


	   }
	   
	   public void render() {
		   	  
//		   	  animController.update(Gdx.graphics.getDeltaTime());
		   	  FPSSystem.camera.update();
		   	  
		      
		      modelBatch.begin(FPSSystem.camera);
		      modelBatch.render(groundInstance, environment);
		      modelBatch.end();
		   	 
		      modelBatch.begin(FPSSystem.camera);
		      modelBatch.render(skyboxInstance, environment);
		      modelBatch.end();
		     
		      modelBatch.begin(FPSSystem.camera);
		      modelBatch.render(skyboxpartInstance, environment);
		      modelBatch.end();

		   	  skyboxpartInstance.transform.rotate(0, 1, 0, 0.8f);
		      
		   }
		   

}
