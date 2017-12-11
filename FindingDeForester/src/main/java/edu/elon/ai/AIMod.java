package edu.elon.ai;
/**
 * @author James Greenwell & Casey Hayes
 * 
 * This class uses code from:
 * https://bedrockminer.jimdo.com/modding-tutorials/
 */
import edu.elon.ai.entities.ModEntities;
import edu.elon.ai.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/*
 * Hey Shannon! All of the stuff in this class was based on tutorials on this web page:
 * https://bedrockminer.jimdo.com/modding-tutorials/
 * These and a bunch of other classes are just setup classes for a Minecraft Mod
 */

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS)
public class AIMod
{
	@Instance
	public static AIMod instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		ModEntities.registerEntities();
		proxy.preInit(event);
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event){
		proxy.init(event);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		proxy.postInit(event);
	}
	

}

