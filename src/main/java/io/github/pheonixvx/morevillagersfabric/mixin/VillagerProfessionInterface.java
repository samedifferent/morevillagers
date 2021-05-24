package io.github.pheonixvx.morevillagersfabric.mixin;

import net.minecraft.sound.SoundEvent;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(VillagerProfession.class)
public interface VillagerProfessionInterface {

    @Invoker
    static VillagerProfession callRegister(String id, PointOfInterestType workStation, @Nullable SoundEvent workSound) {
        throw new AssertionError();
    }
}
