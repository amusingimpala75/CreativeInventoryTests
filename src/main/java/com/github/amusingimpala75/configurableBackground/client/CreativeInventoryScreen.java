package com.github.amusingimpala75.configurableBackground.client;

import net.minecraft.class_224;
import net.minecraft.client.gui.Button;
import net.minecraft.client.gui.screen.GameplayScreen;
import net.minecraft.client.resource.TextureManager;
import net.minecraft.storage.Inventory;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class CreativeInventoryScreen extends GameplayScreen {

    private int currentItemGroup = 1;
    private int scrollHeight;
    private Inventory playerInv;
    private boolean debugMode = false;
    private Inventory creativeInv = new CreativeInventory();

    public CreativeInventoryScreen(Inventory playerInv) {
        //To Show player inventory
        setUpPlayerHotbar(playerInv);
        this.playerInv = playerInv;
    }

    public void setUpPlayerHotbar(Inventory playerInv) {
        for(int i = 0; i < 9; ++i) {
            this.field_894.add(new class_224(this, playerInv, i, 8 + i * 18, 142-20));
        }
    }

    //TODO: Fix window size changes
    @Override
    public void init() {
        this.screenItems.add(new ButtonSquare(1, 130, 35));
        this.screenItems.add(new ButtonSquare(2, 155, 35));
        this.screenItems.add(new ButtonSquare(3, 180, 35));
        this.screenItems.add(new Button(0, 0,0, "Debug Mode"));
    }

    @Override
    protected void onButtonClicked(Button var1) {
        if (var1.id != 0) {
            currentItemGroup = var1.id;
            System.out.println(var1.id);
        } else {
            debugMode = !debugMode;
        }
    }

    //TODO: Fix window size changes
    @Override
    protected void method_568() {
        int var1 = this.mc.textureManager.getTextureId("/assets/configbackground/crafting.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        TextureManager.bindTexture(var1);
        this.method_594(125, 55, 0, 0, 176, 128);
        if (!this.debugMode) {
            //Group 1 corresponds to button w/ id=1
            if (currentItemGroup == 1) {
                this.method_594(125, 33, 199, 76, 23, 26);
            } else {
                this.method_594(125, 33, 176, 76, 23, 26);
            }
            if (currentItemGroup == 2) {
                this.method_594(150, 33, 199, 102, 23, 25);
            } else {
                method_594(150, 33, 176, 102, 23, 25);
            }
            if (currentItemGroup == 3) {
                this.method_594(175, 33, 199, 102, 23, 25);
            } else {
                this.method_594(175, 33, 176, 102, 23, 25);
            }
        }
    }

    @Override
    public void render(int mouseX, int mouseY, float delta) {
        //super.render(mouseX, mouseY, delta);
        for (Object screenItem : this.screenItems) {
            ((Button) screenItem).method_599(this.mc, mouseX, mouseY);
        }
        super.render(mouseX,mouseY,delta);
    }

    @Override
    protected void method_575(int i, int j, int k) {
        super.method_575(i, j, k);
        if (k == 0) {
            for(k = 0; k < this.screenItems.size(); ++k) {
                Button var4;
                if ((var4 = (Button)this.screenItems.get(k)).method_598(i, j)) {
                    this.mc.soundManager.playSound("random.click", 1.0F, 1.0F);
                    this.onButtonClicked(var4);
                }
            }
        }
    }

}
