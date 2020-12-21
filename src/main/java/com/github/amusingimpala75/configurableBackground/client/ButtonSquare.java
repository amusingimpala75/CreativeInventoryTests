package com.github.amusingimpala75.configurableBackground.client;

import com.github.amusingimpala75.configurableBackground.mixin.ButtonRenderAccessor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.Button;

public class ButtonSquare extends Button {

    public ButtonSquare(int buttonId, int x, int y) {
        super(buttonId, x, y, 16, 16, "");
        //((ButtonRenderAccessor)this).setField_942(true);
    }

    @Override
    public void method_599(MinecraftClient minecraftClient, int i, int j) {
        super.method_599(minecraftClient, i, j);
    }
}
