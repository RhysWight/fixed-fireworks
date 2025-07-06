package com.example.fireworkshow.registry;



import com.example.fireworkshow.FireworkShowMod;
import com.example.fireworkshow.content.FireworkLauncherBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, FireworkShowMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<FireworkLauncherBlockEntity>> FIREWORK_LAUNCHER_BE =
            BLOCK_ENTITIES.register("firework_launcher",
                    () -> BlockEntityType.Builder.of(FireworkLauncherBlockEntity::new,
                            ModBlocks.FIREWORK_LAUNCHER.get()).build(null));
}