package fr.lifesteal.luxuryplant.block;

import fr.lifesteal.luxuryplant.api.registry.IRegistryObject;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

import java.util.function.Supplier;

public class BlockItemBase implements IRegistryObject<Item> {

    private final String name;
    private final Item.Properties blockItemProperties;
    private final Supplier<Block> blockSupplier;

    public BlockItemBase(String name, Item.Properties blockItemProperties, Supplier<Block> blockSupplier) {
        this.name = name;
        this.blockItemProperties = blockItemProperties;
        this.blockSupplier = blockSupplier;
    }

    @Override
    public String getRegistryObjectName() {
        return this.name;
    }

    @Override
    public Supplier<Item> getSupplier() {
        return () -> new BlockItem(this.blockSupplier.get(), this.blockItemProperties);
    }
}
