package fr.lifesteal.luxuryplant.block;

import fr.lifesteal.luxuryplant.api.registry.IRegistryObject;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;

import java.util.function.Supplier;

public class BushBlockBase<T extends Item> extends SweetBerryBushBlock implements IRegistryObject<Block>, IGrowable, IPlantable {
    private final String name;
    private final Properties blockProperty;
    private final Supplier<T> itemSupplier;

    public BushBlockBase(String name, Properties blockProperty, Supplier<T> itemSupplier) {
        super(blockProperty);
        this.name = name;
        this.blockProperty = blockProperty;
        this.itemSupplier = itemSupplier;
    }

    @Override
    public String getRegistryObjectName() {
        return this.name;
    }

    @Override
    public Supplier<Block> getSupplier() {
        return () -> new BushBlockBase<>(this.getRegistryObjectName(), this.blockProperty, this.itemSupplier);
    }

    @Override
    public ActionResultType use(BlockState blockState, World world, BlockPos blockPos, PlayerEntity player, Hand hand, BlockRayTraceResult traceResult) {
        int age = getAge(blockState);
        if (age < 3) {
            return ActionResultType.PASS;
        }

        if (world.isClientSide) {
            return ActionResultType.SUCCESS;
        }

        world.setBlock(blockPos, getAgeState(1), 1);
        popResource(world, blockPos, new ItemStack(itemSupplier.get(), 1));

        return ActionResultType.SUCCESS;
    }

    public BlockState getAgeState(int age) {
        return this.defaultBlockState().setValue(AGE, age);
    }

    private int getAge(BlockState blockState) {
        return blockState.getValue(AGE);
    }
}
