package edu.elon.ai.proxy;

import edu.elon.ai.items.ModItems;
import net.minecraft.client.Minecraft;
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
        super.init(e);
        //ModItems.setupItems(Minecraft.getMinecraft().getRenderItem().getItemModelMesher());
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }
}
