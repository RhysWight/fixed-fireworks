package com.example.fireworkshow.util;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.projectile.FireworkRocketEntity;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.item.FireworkRocketItem;
import net.minecraft.world.level.Level;

import java.util.Random;

public final class FireworkUtil {
    private static final Random RANDOM = new Random();

    public static void spawnRandomFirework(Level level, BlockPos launcherPos) {
        ItemStack fireworkStack = new ItemStack(Items.FIREWORK_ROCKET);

        CompoundTag fireworksTag = new CompoundTag();
        fireworksTag.putByte("Flight", (byte) 2);

        ListTag explosions = new ListTag();
        CompoundTag explosion = new CompoundTag();
        explosion.putByte("Type", (byte) RANDOM.nextInt(5));
        explosion.putBoolean("Trail", true);
        explosion.putBoolean("Flicker", RANDOM.nextBoolean());

        int[] colors = randomColors(RANDOM.nextInt(3) + 2);
        explosion.putIntArray("Colors", colors);
        explosion.putIntArray("FadeColors", randomColors(2));

        explosions.add(explosion);
        fireworksTag.put("Explosions", explosions);

        fireworkStack.getOrCreateTagElement("Fireworks").merge(fireworksTag);

        FireworkRocketEntity rocket = new FireworkRocketEntity(level,
                fireworkStack, launcherPos.getX() + 0.5, launcherPos.getY() + 0.9,
                launcherPos.getZ() + 0.5, true);
        level.addFreshEntity(rocket);
    }

    private static int[] randomColors(int count) {
        DyeColor[] dyes = DyeColor.values();
        int[] out = new int[count];
        for (int i = 0; i < count; i++) {
            out[i] = dyes[RANDOM.nextInt(dyes.length)].getFireworkColor();
        }
        return out;
    }
}
