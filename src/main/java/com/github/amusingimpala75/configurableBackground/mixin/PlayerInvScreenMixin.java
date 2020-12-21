package com.github.amusingimpala75.configurableBackground.mixin;

import com.github.amusingimpala75.configurableBackground.Duck1;
import net.minecraft.client.gui.screen.GameplayScreen;
import net.minecraft.client.gui.screen.PlayerInventoryScreen;
import net.minecraft.storage.Inventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerInventoryScreen.class)
public abstract class PlayerInvScreenMixin extends GameplayScreen implements Duck1 {
    public Inventory inv;
    @Inject(at=@At("TAIL"), method = "<init>")
    public void getInv(Inventory inv, CallbackInfo info) {
        this.inv = inv;
    }
    public Inventory invGet() {
        return inv;
    }
}
