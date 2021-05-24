package io.github.pheonixvx.morevillagersfabric.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.world.poi.PointOfInterestType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.Set;

@Mixin(PointOfInterestType.class)
public interface PointOfInterestTypeInterface {

    @Invoker
    static Set<BlockState> callGetAllStatesOf(Block block) {
        throw new AssertionError();
    }

    @Invoker
    static PointOfInterestType callRegister(String id, Set<BlockState> workStationStates, int ticketCount, int searchDistance) {
        throw new AssertionError();
    }
}
