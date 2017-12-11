package edu.elon.ai.proxy;

import edu.elon.ai.AIMod;
import edu.elon.ai.event.EventHandlerCommon;
import edu.elon.ai.items.ModItems;
import edu.elon.ai.ui.ModGUIHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
//A common proxy to be used on both the client and server side of things
public class CommonProxy{
	
    public void preInit(FMLPreInitializationEvent e) {

    }

    public void init(FMLInitializationEvent e) {
    	MinecraftForge.EVENT_BUS.register(new EventHandlerCommon());
    	NetworkRegistry.INSTANCE.registerGuiHandler(AIMod.instance, new ModGUIHandler());
    }

    public void postInit(FMLPostInitializationEvent e) {

    }
}
