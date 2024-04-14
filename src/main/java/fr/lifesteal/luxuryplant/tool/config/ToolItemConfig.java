package fr.lifesteal.luxuryplant.tool.config;

import fr.lifesteal.luxuryplant.api.registry.IRegistryObject;
import fr.lifesteal.luxuryplant.item.config.ItemGroupConfig;
import fr.lifesteal.luxuryplant.tool.CustomItemTier;
import fr.lifesteal.luxuryplant.tool.SwordItemBase;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ToolItemConfig {

    private final ItemGroupConfig itemGroupConfig;

    public ToolItemConfig(ItemGroupConfig itemGroupConfig) {
        this.itemGroupConfig = itemGroupConfig;
    }

    public List<IRegistryObject<Item>> getPluginTools() {
        return new ArrayList<IRegistryObject<Item>>() {{
            add(new SwordItemBase("strawberry_sword",
                    CustomItemTier.STRAWBERRY,
                    5,
                    5.0F,
                    new Item.Properties()
                            .defaultDurability(20)
                            .tab(itemGroupConfig.getPluginItemGroup())));
        }};
    }
}
