package edu.elon.ai.renderers;

import java.io.File;
import java.io.IOException;

import edu.elon.ai.Reference;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderAIPlayer extends RenderLiving{

	protected ResourceLocation aiPlayerTexture;
	
	public RenderAIPlayer(RenderManager rendermanagerIn, ModelBiped model, float shadowsizeIn) {
		super(rendermanagerIn, model, shadowsizeIn);
		setEntityTexture();
	}
	
	protected void setEntityTexture(){

		aiPlayerTexture = new ResourceLocation(Reference.MOD_ID + ":textures/entity/aiplayer/predator2.png");
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return aiPlayerTexture;
	}

}
