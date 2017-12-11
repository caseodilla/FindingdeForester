package edu.elon.ai.renderers;
/**
 * @author James Greenwell & Casey Hayes
 * 
 * This class uses code from:
 * https://bedrockminer.jimdo.com/modding-tutorials/
 */

import edu.elon.ai.Reference;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
//This class is solely for rendering the EntityAIPlayer
@SuppressWarnings("rawtypes")
public class RenderAIPlayer extends RenderBiped{

	protected ResourceLocation aiPlayerTexture;
	
	public RenderAIPlayer(RenderManager rendermanagerIn, ModelBiped model, float shadowsizeIn) {
		super(rendermanagerIn, model, shadowsizeIn);
		setEntityTexture();
	}
	
	protected void setEntityTexture(){

		aiPlayerTexture = new ResourceLocation(Reference.MOD_ID + ":textures/entity/aiplayer/predator2.png");
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return aiPlayerTexture;
	}

}
