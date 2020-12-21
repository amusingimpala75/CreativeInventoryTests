package com.github.amusingimpala75.configurableBackground.client;

import com.github.amusingimpala75.configurableBackground.ConfigBackground;
import net.minecraft.block.Block;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.storage.Inventory;

import java.util.ArrayList;
import java.util.List;

import static net.minecraft.block.Block.*;
import static net.minecraft.item.Item.*;

public class CreativeInventory implements Inventory {

    private CreativeInventoryScreen myScreen;

    public CreativeInventory(CreativeInventoryScreen screen) {
        this.myScreen = screen;
    }

    public static List buildingBlocks = new ArrayList();
    public static List decorationBlocks = new ArrayList();
    public static List nonRelated = new ArrayList();
    public static List tools = new ArrayList();
    public static List food = new ArrayList();
    public static List combat = new ArrayList();
    public static List misc = new ArrayList();

    public static List[] groups = {buildingBlocks, decorationBlocks, nonRelated, tools, food, combat, misc};

    @Override
    public int size() {
        return buildingBlocks.size()+decorationBlocks.size()+nonRelated.size()+tools.size()+food.size()+combat.size()+misc.size();
    }

    @Override
    public ItemStack get(int slot) {
        //return (ItemStack) groups[myScreen.currentItemGroup].get(slot);
        if (slot < groups[myScreen.currentItemGroup].size() && slot >= 0) {
            Object thing = groups[myScreen.currentItemGroup].get(slot);
            return thing instanceof Item ? new ItemStack((Item)thing) : new ItemStack((Block) thing);
        } else {
            return new ItemStack(DIRT);
        }
    }

    @Override
    public ItemStack damage(int slot, int amount) {
        //return null;
        if (slot < groups[myScreen.currentItemGroup].size() && slot >= 0) {
            Object thing = groups[myScreen.currentItemGroup].get(slot);
            return thing instanceof Item ? new ItemStack((Item)thing) : new ItemStack((Block) thing);
        } else {
            return new ItemStack(DIRT);
        }
    }

    @Override
    public void set(int slot, ItemStack stack) {

    }

    @Override
    public String getName() {
        return "Creative Inventory";
    }

    @Override
    public int method_294() {
        return 64;
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
        decorationBlocks.add(Item.SIGN);
        decorationBlocks.add(LADDER);
        decorationBlocks.add(PAINTING);

        //Formerly liquid
        nonRelated.add(WATER);
        nonRelated.add(FLOWING_WATER);
        nonRelated.add(LAVA);
        nonRelated.add(FLOWING_LAVA);

        //Formerly redstone
        nonRelated.add(TNT);
        nonRelated.add(Item.DOOR);

        //Formerly Transportation
        nonRelated.add(RAIL);

        //Unsure Where else
        nonRelated.add(FIRE);
        nonRelated.add(GEAR);
        nonRelated.add(Block.WHEAT);
        //nonRelated.add(ConfigBackground.spawnEgg);

        //Formerly Transportation
        nonRelated.add(MINECART);

        tools.add(IRON_SHOVEL);
        tools.add(IRON_PICKAXE);
        tools.add(IRON_AXE);
        tools.add(FLINT_AND_STEEL);
        tools.add(WOOD_SHOVEL);
        tools.add(WOOD_PICKAXE);
        tools.add(WOOD_AXE);
        tools.add(STONE_SHOVEL);
        tools.add(STONE_PICKAXE);
        tools.add(STONE_AXE);
        tools.add(DIAMOND_SHOVEL);
        tools.add(DIAMOND_PICKAXE);
        tools.add(DIAMOND_AXE);
        tools.add(GOLD_SHOVEL);
        tools.add(GOLD_PICKAXE);
        tools.add(GOLD_AXE);
        tools.add(WOOD_HOE);
        tools.add(STONE_HOE);
        tools.add(IRON_HOE);
        tools.add(GOLD_HOE);
        tools.add(DIAMOND_HOE);

        food.add(APPLE);
        food.add(MUSHROOM_STEW);
        food.add(BREAD);
        food.add(RAW_PORKCHOP);
        food.add(COOKED_PORKCHOP);
        food.add(GOLDEN_APPLE);

        combat.add(BOW);
        combat.add(ARROW);
        combat.add(IRON_SWORD);
        combat.add(WOOD_SWORD);
        combat.add(STONE_SWORD);
        combat.add(DIAMOND_SWORD);
        combat.add(GOLD_SWORD);
        combat.add(CLOTH_HELMET);
        combat.add(CLOTH_CHESTPLATE);
        combat.add(CLOTH_BOOTS);
        combat.add(CLOTH_LEGGINGS);
        combat.add(CHAIN_CHESTPLATE);
        combat.add(CHAIN_BOOTS);
        combat.add(CHAIN_HELMET);
        combat.add(CHAIN_LEGGINGS);
        combat.add(IRON_HELMET);
        combat.add(IRON_CHESTPLATE);
        combat.add(IRON_LEGGINGS);
        combat.add(IRON_BOOTS);
        combat.add(DIAMOND_HELMET);
        combat.add(DIAMOND_CHESTPLATE);
        combat.add(DIAMOND_LEGGINGS);
        combat.add(DIAMOND_BOOTS);
        combat.add(GOLD_HELMET);
        combat.add(GOLD_CHESTPLATE);
        combat.add(GOLD_LEGGINGS);
        combat.add(GOLD_BOOTS);

        misc.add(COAL);
        misc.add(DIAMOND);
        misc.add(IRON_INGOT);
        misc.add(GOLD_INGOT);
        misc.add(STICK);
        misc.add(BOWL);
        misc.add(STRING);
        misc.add(FEATHER);
        misc.add(GUNPOWDER);
        misc.add(SEEDS);
        misc.add(Item.WHEAT);
        misc.add(FLINT);
        misc.add(BUCKET);
        misc.add(LAVA_BUCKET);
        misc.add(WATER_BUCKET);
    }
}
