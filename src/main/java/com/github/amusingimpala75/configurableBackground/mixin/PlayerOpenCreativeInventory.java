package com.github.amusingimpala75.configurableBackground.mixin;

import com.github.amusingimpala75.configurableBackground.client.CreativeInventoryScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.living.player.Player;
import net.minecraft.entity.player.ClientPlayer;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayer.class)
public abstract class PlayerOpenCreativeInventory extends Player {

    @Shadow private MinecraftClient client;

    public PlayerOpenCreativeInventory(World var1) {
        super(var1);
    }
    @Inject(at=@At("HEAD"), method = "openCraftingScreen", cancellable = true)
    public void redirectToCreativeInventory(CallbackInfo info) {
        if (true) {     //Replace this with your creative checking method
            this.client.showScreen(new CreativeInventoryScreen(this.inventory));
            info.cancel();
        }
    }
}
