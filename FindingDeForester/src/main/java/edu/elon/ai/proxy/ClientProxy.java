package edu.elon.ai.proxy;

import edu.elon.ai.entities.EntityAI;
import edu.elon.ai.items.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy{
   
	@SuppressWarnings("deprecation")
	@Override
    public void preInit(FMLPreInitializationEvent e) {
		RenderingRegistry.registerEntityRenderingHandler(EntityAI.class, new RenderPlayer(Minecraft.getMinecraft().getRenderManager()));
        super.preInit(e);
        
    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }
}
