package edu.elon.ai.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
//This item is not in use in the final mod
public class SpawnEggItem extends Item{
	public SpawnEggItem(String unlocalizedName){
		super();
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(CreativeTabs.MISC);
	}
}
