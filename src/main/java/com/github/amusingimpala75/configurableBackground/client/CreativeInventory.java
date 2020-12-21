package com.github.amusingimpala75.configurableBackground.client;

import com.github.amusingimpala75.configurableBackground.ConfigBackground;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.storage.Inventory;

import java.util.ArrayList;
import java.util.List;

import static net.minecraft.block.Block.*;
import static net.minecraft.item.Item.*;

public class CreativeInventory implements Inventory {

    public int scrollHeight = 0;
    public int tabNumber = 0;

    public static List buildingBlocks = new ArrayList();
    public static List decorationBlocks = new ArrayList();
    public static List nonRelated = new ArrayList();

    @Override
    public int size() {
        return 0;
    }

    @Override
    public ItemStack get(int slot) {
        return null;
    }

    @Override
    public ItemStack damage(int slot, int amount) {
        return null;
    }

    @Override
    public void set(int slot, ItemStack stack) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int method_294() {
        return 0;
    }

    @Override
    public void method_73() {

    }

    static {
        buildingBlocks.add(STONE);
        buildingBlocks.add(GRASS);
        buildingBlocks.add(DIRT);
        buildingBlocks.add(COBBLESTONE);
        buildingBlocks.add(PLANKS);
        buildingBlocks.add(BEDROCK);
        buildingBlocks.add(SAND);
        buildingBlocks.add(GRAVEL);
        buildingBlocks.add(GOLD_ORE);
        buildingBlocks.add(IRON_ORE);
        buildingBlocks.add(COAL_ORE);
        buildingBlocks.add(LOG);
        buildingBlocks.add(SPONGE);
        buildingBlocks.add(GLASS);
        buildingBlocks.add(CAPRI_WOOL);
        buildingBlocks.add(CHARTREUSE_WOOL);
        buildingBlocks.add(CYAN_WOOL);
        buildingBlocks.add(GRAY_WOOL);
        buildingBlocks.add(GREEN_WOOL);
        buildingBlocks.add(LIGHT_GRAY_WOOL);
        buildingBlocks.add(MAGENTA_WOOL);
        buildingBlocks.add(ORANGE_WOOL);
        buildingBlocks.add(PURPLE_WOOL);
        buildingBlocks.add(RED_WOOL);
        buildingBlocks.add(ROSE_WOOL);
        buildingBlocks.add(SPRING_GREEN_WOOL);
        buildingBlocks.add(ULTRAMARINE_WOOL);
        buildingBlocks.add(VIOLET_WOOL);
        buildingBlocks.add(WHITE_WOOL);
        buildingBlocks.add(YELLOW_WOOL);
        buildingBlocks.add(GOLD_BLOCK);
        buildingBlocks.add(IRON_BLOCK);
        buildingBlocks.add(STONE_SLAB);
        buildingBlocks.add(STONE_SLAB_FULL);
        buildingBlocks.add(BRICKS);
        buildingBlocks.add(BOOKSHELF);
        buildingBlocks.add(MOSSY_COBBLESTONE);
        buildingBlocks.add(OBSIDIAN);
        buildingBlocks.add(DIAMOND_ORE);
        buildingBlocks.add(DIAMOND_BLOCK);

        decorationBlocks.add(SAPLING);
        decorationBlocks.add(LEAVES);
        decorationBlocks.add(DANDELION);
        decorationBlocks.add(ROSE);
        decorationBlocks.add(BROWN_MUSHROOM);
        decorationBlocks.add(RED_MUSHROOM);
        decorationBlocks.add(TORCH);
        decorationBlocks.add(CHEST);
        decorationBlocks.add(CRAFTING_TABLE);
        decorationBlocks.add(FARMLAND);
        decorationBlocks.add(FURNACE);
        decorationBlocks.add(LIT_FURNACE);
        decorationBlocks.add(Block.SIGN);
        decorationBlocks.add(LADDER);

        //Formerly liquid
        nonRelated.add(WATER);
        nonRelated.add(FLOWING_WATER);
        nonRelated.add(LAVA);
        nonRelated.add(FLOWING_LAVA);

        //Formerly redstone
        nonRelated.add(TNT);
        nonRelated.add(Block.DOOR);

        //Formerly Transportation
        nonRelated.add(RAIL);

        //Unsure Where else
        nonRelated.add(FIRE);
        nonRelated.add(GEAR);
        nonRelated.add(Block.WHEAT);
        nonRelated.add(ConfigBackground.spawnEgg);
    }
}
