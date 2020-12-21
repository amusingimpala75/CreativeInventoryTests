package com.github.amusingimpala75.configurableBackground.mixin;

import com.github.amusingimpala75.configurableBackground.Duck1;
import com.github.amusingimpala75.configurableBackground.client.CreativeInventoryScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.CraftingScreen;
import net.minecraft.client.gui.screen.PlayerInventoryScreen;
import net.minecraft.client.gui.screen.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public abstract class MCClientMixin {
    @Shadow public abstract void showScreen(Screen screen);

    @Inject(at=@At("HEAD"), method = "showScreen", cancellable = true)
    public void checkForInv(Screen screen, CallbackInfo info) {
        if (screen instanceof PlayerInventoryScreen) {
            if (true) {     //Put your own check here
                this.showScreen(new CreativeInventoryScreen(((Duck1) screen).invGet()));
                info.cancel();
            }
        }
    }
}
