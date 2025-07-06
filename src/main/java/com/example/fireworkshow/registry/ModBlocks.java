package com.example.fireworkshow.registry;

import com.example.fireworkshow.FireworkShowMod;
import com.example.fireworkshow.content.FireworkLauncherBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, FireworkShowMod.MOD_ID);

    public static final RegistryObject<Block> FIREWORK_LAUNCHER =
            BLOCKS.register("firework_launcher",
                    () -> new FireworkLauncherBlock(BlockBehaviour.Properties.of()
                            .strength(1.5F)
                            .requiresCorrectToolForDrops()
                            .noOcclusion()));
}
