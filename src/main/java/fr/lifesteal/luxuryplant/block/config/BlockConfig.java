package fr.lifesteal.luxuryplant.block.config;

import fr.lifesteal.luxuryplant.api.registry.IRegistryObject;
import fr.lifesteal.luxuryplant.block.BushBlockBase;
import fr.lifesteal.luxuryplant.registry.GenericRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class BlockConfig {

    private final GenericRegistry<Item> itemRegistry;
    private final List<IRegistryObject<Block>> pluginBlocks;
    public BlockConfig(GenericRegistry<Item> itemRegistry) {
        this.itemRegistry = itemRegistry;
        this.pluginBlocks = initPluginBlocks();
    }

    public List<IRegistryObject<Block>> getPluginBlocks() {
        return pluginBlocks;
    }

    private List<IRegistryObject<Block>> initPluginBlocks() {
        return new ArrayList<IRegistryObject<Block>>() {{
            add(new BushBlockBase<>("strawberry_bush",
                    AbstractBlock.Properties.of(Material.PLANT)
                            .noCollission()
                            .noOcclusion()
                            .dynamicShape()
                            .instabreak(), () -> itemRegistry.getRegisterItemByName("strawberry").get()));
        }};
    }
}
