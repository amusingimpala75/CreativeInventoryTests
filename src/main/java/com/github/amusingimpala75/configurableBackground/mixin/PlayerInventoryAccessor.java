package com.github.amusingimpala75.configurableBackground.mixin;

import net.minecraft.client.gui.screen.PlayerInventoryScreen;
import net.minecraft.storage.Inventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(PlayerInventoryScreen.class)
public interface PlayerInventoryAccessor {
    @Accessor
    Inventory getPlayerInventory();
}
