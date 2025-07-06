package com.example.fireworkshow.content;

import com.example.fireworkshow.util.FireworkUtil;
import com.example.fireworkshow.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class FireworkLauncherBlockEntity extends BlockEntity {
    private int cooldown = 0;
    private static final int COOLDOWN_TICKS = 40;

    public FireworkLauncherBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.FIREWORK_LAUNCHER_BE.get(), pos, state);
    }

    public void armAndLaunch() {
        if (cooldown == 0) {
            FireworkUtil.spawnRandomFirework(level, worldPosition);
            cooldown = COOLDOWN_TICKS;
        }
    }

    public void serverTick() {
        if (cooldown > 0) cooldown--;
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putInt("cooldown", cooldown);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        cooldown = tag.getInt("cooldown");
    }
}
