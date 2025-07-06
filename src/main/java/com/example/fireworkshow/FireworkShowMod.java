package com.example.fireworkshow;

import com.example.fireworkshow.registry.ModBlocks;
import com.example.fireworkshow.registry.ModBlockEntities;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(FireworkShowMod.MOD_ID)
public final class FireworkShowMod {
    public static final String MOD_ID = "fireworkshow";

    public FireworkShowMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModBlocks.BLOCKS.register(bus);
        ModBlockEntities.BLOCK_ENTITIES.register(bus);
    }
}
