package edu.elon.ai.proxy;

import edu.elon.ai.entities.EntityAIPlayer;
import edu.elon.ai.items.ModItems;
import edu.elon.ai.renderers.RenderAIPlayer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
//This is a proxy for the client side of things
public class ClientProxy extends CommonProxy{
   
	@Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e); 
    }

    @Override
    public void init(FMLInitializationEvent e) {
    	//set the renderer for EntityAIPlayer
    	RenderingRegistry.registerEntityRenderingHandler(EntityAIPlayer.class, new RenderAIPlayer(Minecraft.getMinecraft().getRenderManager(),new ModelBiped(1.0F,0.0F,64,64),0.5F));
        super.init(e);
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }
    
}
