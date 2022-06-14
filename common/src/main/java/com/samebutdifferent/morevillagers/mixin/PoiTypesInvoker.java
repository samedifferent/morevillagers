package com.samebutdifferent.morevillagers.mixin;

import net.minecraft.core.Holder;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.Map;
import java.util.Set;

@Mixin(PoiTypes.class)
public interface PoiTypesInvoker {
    @Accessor("TYPE_BY_STATE")
    static Map<BlockState, Holder<PoiType>> getTypeByState() {
        throw new AssertionError();
    }

    @Invoker("getBlockStates")
    static Set<BlockState> invokeGetBlockStates(Block block) {
        throw new AssertionError();
    }

    @Invoker("registerBlockStates")
    static void invokeRegisterBlockStates(Holder<PoiType> holder) {
        throw new AssertionError();
    }
}