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

public class ClientProxy extends CommonProxy{
   
	@Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e); 
    }

    @Override
    public void init(FMLInitializationEvent e) {
    	RenderingRegistry.registerEntityRenderingHandler(EntityAIPlayer.class, new RenderAIPlayer(Minecraft.getMinecraft().getRenderManager(),new ModelBiped(1.0F,0.0F,64,64),0.5F));
        super.init(e);
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }
    //Client side GUI stuff
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return null;
	}
    
}
