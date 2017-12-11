package edu.elon.ai.proxy;
/**
 * @author James Greenwell & Casey Hayes
 * 
 * This class uses code from:
 * https://bedrockminer.jimdo.com/modding-tutorials/
 */


import edu.elon.ai.entities.EntityAIPlayer;
import edu.elon.ai.renderers.RenderAIPlayer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
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

    @SuppressWarnings({ "deprecation", "unchecked" })
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
