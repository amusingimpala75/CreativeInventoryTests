package com.github.amusingimpala75.configurableBackground;
import com.github.amusingimpala75.configurableBackground.item.SpawnEgg;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;

public class ConfigBackground implements ModInitializer {
	public static Item spawnEgg = new SpawnEgg(73);
	@Override
	public void onInitialize() {
		System.out.println("Hello Fabric world!");

	}
}
