package edu.elon.ai.proxy;
/**
 * @author James Greenwell & Casey Hayes
 * 
 * This class uses code from:
 * https://bedrockminer.jimdo.com/modding-tutorials/
 */
import edu.elon.ai.event.EventHandlerCommon;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
//A common proxy to be used on both the client and server side of things
public class CommonProxy{
	
    public void preInit(FMLPreInitializationEvent e) {

    }

    public void init(FMLInitializationEvent e) {
    	MinecraftForge.EVENT_BUS.register(new EventHandlerCommon());
    }

    public void postInit(FMLPostInitializationEvent e) {

    }
}
