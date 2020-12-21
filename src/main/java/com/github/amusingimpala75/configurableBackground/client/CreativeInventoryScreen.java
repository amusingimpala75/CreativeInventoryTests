package com.github.amusingimpala75.configurableBackground.client;

import net.minecraft.class_224;
import net.minecraft.client.gui.Button;
import net.minecraft.client.gui.screen.GameplayScreen;
import net.minecraft.client.resource.TextureManager;
import net.minecraft.storage.Inventory;
import org.lwjgl.opengl.GL11;

@SuppressWarnings("unchecked")
public class CreativeInventoryScreen extends GameplayScreen {

    public int currentItemGroup = 0;
    public int scrollHeight;
    private Inventory playerInv;
    private boolean debugMode = false;
    private Inventory creativeInv;
    private boolean debugMode2 = false;

    public CreativeInventoryScreen(Inventory playerInv) {
        //To Show player inventory
        //setUpPlayerHotbar(playerInv);
        this.playerInv = playerInv;
        this.creativeInv = new CreativeInventory(this);
        rerenderInventoryItems();
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
        this.screenItems.add(new ButtonSquare(4, 205, 35));
        this.screenItems.add(new ButtonSquare(5, 230, 35));
        this.screenItems.add(new ButtonSquare(6, 255, 35));
        this.screenItems.add(new ButtonSquare(7, 280, 35));
        this.screenItems.add(new ExtendedButton(100, 40, 40, 16, 12, ""));
        this.screenItems.add(new ExtendedButton(101, 20, 20, 16, 12, ""));
        this.screenItems.add(new Button(103, 0, 20, "Debug Mode 2"));
        this.screenItems.add(new Button(0, 0,0, "Debug Mode"));
    }

    @Override
    protected void onButtonClicked(Button buttonId) {
        if (buttonId.id != 0 && buttonId.id != 100 && buttonId.id != 101 && buttonId.id  != 103) {
            currentItemGroup = buttonId.id - 1;
            System.out.println(buttonId.id);
        } else if (buttonId.id == 0) {
            debugMode = !debugMode;
        } else if (buttonId.id == 103) {
            debugMode2 = !debugMode2;
        } else {
            scrollHeight = buttonId.id == 100 ? scrollHeight++ : scrollHeight > 0 ? scrollHeight-- : scrollHeight;
        }
        rerenderInventoryItems();
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
            if (currentItemGroup == 0) {
                this.method_594(125, 33, 199, 76, 23, 26);
            } else {
                this.method_594(125, 33, 176, 76, 23, 26);
            }
            if (currentItemGroup == 1) {
                this.method_594(150, 33, 199, 102, 23, 25);
            } else {
                method_594(150, 33, 176, 102, 23, 25);
            }
            if (currentItemGroup == 2) {
                this.method_594(175, 33, 199, 102, 23, 25);
            } else {
                this.method_594(175, 33, 176, 102, 23, 25);
            }
            if (currentItemGroup == 3) {
                this.method_594(200, 33, 199, 102, 23, 25);
            } else {
                this.method_594(200, 33, 176, 102, 23, 25);
            }
            if (currentItemGroup == 4) {
                this.method_594(225, 33, 199, 102, 23, 25);
            } else {
                this.method_594(225, 33, 176, 102, 23, 25);
            }
            if (currentItemGroup == 5) {
                this.method_594(250, 33, 199, 102, 23, 25);
            } else {
                this.method_594(250, 33, 176, 102, 23, 25);
            }
            if (currentItemGroup == 6) {
                this.method_594(275, 33, 199, 102, 23, 25);
            } else {
                this.method_594(275, 33, 176, 102, 23, 25);
            }
            this.method_594(40, 40, 222, 50, 18, 16);
            this.method_594(20, 20, 222, 66, 18, 16);
        }
    }

    @Override
    public void render(int mouseX, int mouseY, float delta) {
        //super.render(mouseX, mouseY, delta);
        //this.field_894.clear();
        //loadInventoryItems();
        if (!debugMode2) {
            for (Object screenItem : this.screenItems) {
                ((Button) screenItem).method_599(this.mc, mouseX, mouseY);
            }
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

    private void loadInventoryItems() {
        for (int k = 0; k < 5; k++) {
            for (int i = 0; i < 9; ++i) {
                int loc = (9*scrollHeight)+(i+(k*9));
                if (loc < CreativeInventory.groups[currentItemGroup].size()) {
                    this.field_894.add(new class_224(this, creativeInv, loc, 8 + ((i) * 18), (82 - 54) + ((k) * 18)));
                }
            }
        }
    }
    private void rerenderInventoryItems() {
        this.field_894.clear();
        setUpPlayerHotbar(this.playerInv);
        loadInventoryItems();
    }
}
