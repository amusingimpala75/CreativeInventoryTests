package com.github.amusingimpala75.configurableBackground.mixin;

import net.minecraft.client.gui.Button;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Button.class)
public interface ButtonRenderAccessor {
    @Accessor
    boolean getField_942();

    @Accessor
    void setField_942(boolean value);
}
