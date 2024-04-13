package fr.lifesteal.luxuryplant.block;

import fr.lifesteal.luxuryplant.api.registry.IRegistryObject;
import net.minecraft.block.Block;
import net.minecraft.block.CakeBlock;

import java.util.function.Supplier;

public class CakeBlockBase extends CakeBlock implements IRegistryObject<Block> {
    private final String name;
    private final Properties blockProperties;

    public CakeBlockBase(String name, Properties blockProperties) {
        super(blockProperties);
        this.name = name;
        this.blockProperties = blockProperties;
    }

    @Override
    public String getRegistryObjectName() {
        return this.name;
    }

    @Override
    public Supplier<Block> getSupplier() {
        return () -> new CakeBlockBase(this.name, this.blockProperties);
    }
}
