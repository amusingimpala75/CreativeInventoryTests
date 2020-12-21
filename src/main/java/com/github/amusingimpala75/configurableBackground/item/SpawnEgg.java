package com.github.amusingimpala75.configurableBackground.item;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.living.*;
import net.minecraft.entity.living.player.Player;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class SpawnEgg extends Item {

    private static List<Class> entities = new ArrayList<Class>();

    private int entityId;

    public SpawnEgg(int id) {
        super(id);
    }

    @Override
    public boolean useOnBlock(ItemStack itemStack, Player player, World world, int x, int y, int z, int usedBlockId) {
        Class klass = entities.get(entityId);
        if (usedBlockId == 0) {
            --y;
        }

        if (usedBlockId == 1) {
            ++y;
        }

        if (usedBlockId == 2) {
            --z;
        }

        if (usedBlockId == 3) {
            ++z;
        }

        if (usedBlockId == 4) {
            --x;
        }

        if (usedBlockId == 5) {
            ++x;
        }

        if (world.getBlockAtPosition(x, y, z) == 0) {
            //world.playSound((double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, "fire.ignite", 1.0F, RANDOM.nextFloat() * 0.4F + 0.8F);
            //world.method_258(x, y, z, Block.FIRE.id);
            try {
                world.spawnEntity((Entity) klass.newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                System.out.println("Could not instantiate Entity from egg!");
                e.printStackTrace();
                throw new NullPointerException("Could not instantiate Entity from egg!");
            }
        }

        //var1.damage(1);
        //return true;
        return super.useOnBlock(itemStack, player, world, x, y, z, usedBlockId);
    }

    @Override
    public ItemStack use(ItemStack itemStack, World world, Player player) {
        if (this.entityId < entities.size()) {
            entityId++;
        } else {
            entityId = 0;
        }
        return super.use(itemStack, world, player);
    }

    static {
        entities.add(Creeper.class);
        entities.add(Giant.class);
        entities.add(Pig.class);
        entities.add(Sheep.class);
        entities.add(Skeleton.class);
        entities.add(Spider.class);
        entities.add(Zombie.class);
    }
}
