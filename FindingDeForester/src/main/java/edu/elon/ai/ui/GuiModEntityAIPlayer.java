package edu.elon.ai.ui;

import java.io.IOException;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class GuiModEntityAIPlayer extends GuiScreen{
	
	private GuiButton chop_trees;
	private GuiButton exit_gui;
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
	    super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	public boolean doesGuiPauseGame() {
	    return false;
	}
	
	public void initGui() {
		
	    this.buttonList.add(this.chop_trees = new GuiButton(0, this.width / 2 - 100, this.height / 2 - 24, "This is button a"));
	    this.buttonList.add(this.exit_gui = new GuiButton(1, this.width / 2 - 100, this.height / 2 + 4, "This is button b"));
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		if(button == this.chop_trees) {
			
		}
		
		if(button == this.exit_gui) {
	        this.mc.displayGuiScreen(null);
	        if (this.mc.currentScreen == null)
	            this.mc.setIngameFocus();
		}
	}
}
