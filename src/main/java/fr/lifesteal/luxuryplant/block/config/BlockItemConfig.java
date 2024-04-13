package fr.lifesteal.luxuryplant.block.config;

import fr.lifesteal.luxuryplant.api.registry.IRegistryObject;
import fr.lifesteal.luxuryplant.block.BlockItemBase;
import fr.lifesteal.luxuryplant.item.config.ItemGroupConfig;
import fr.lifesteal.luxuryplant.registry.GenericRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class BlockItemConfig {
    private final GenericRegistry<Block> blockRegistry;
    private final ItemGroupConfig itemGroupConfig;

    public BlockItemConfig(GenericRegistry<Block> blockRegistry, ItemGroupConfig itemGroupConfig) {
        this.blockRegistry = blockRegistry;
        this.itemGroupConfig = itemGroupConfig;
    }

    public List<IRegistryObject<Item>> getPluginBlockItems() {
        return new ArrayList<IRegistryObject<Item>>() {{
            add(new BlockItemBase("strawberry_bush", new Item.Properties().tab(itemGroupConfig.getPluginItemGroup()), () -> blockRegistry.getRegisterItemByName("strawberry_bush").get()));
        }};
    }
}
