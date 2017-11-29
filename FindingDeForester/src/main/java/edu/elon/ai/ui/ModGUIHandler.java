package edu.elon.ai.ui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class ModGUIHandler implements IGuiHandler{

	public static final int MOD_ENTITY_AI_PLAYER_GUI = 0;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == MOD_ENTITY_AI_PLAYER_GUI) {
			return new GuiModEntityAIPlayer();
		}
		return null;
	}

}
