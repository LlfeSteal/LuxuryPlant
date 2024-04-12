package fr.lifesteal.luxuryplant.item.config;

import fr.lifesteal.luxuryplant.item.IRegistryObject;
import fr.lifesteal.luxuryplant.item.ItemBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

import java.util.ArrayList;
import java.util.List;

public class ItemConfig {
    public final List<IRegistryObject<Item>> PLUGIN_ITEMS = new ArrayList<>();

    private final ItemGroupConfig itemGroupConfig;


    public ItemConfig(ItemGroupConfig itemGroupConfig) {
        this.itemGroupConfig = itemGroupConfig;
    }

    public List<IRegistryObject<Item>> getPluginItems() {
        return new ArrayList<IRegistryObject<Item>>()
        {{
            add(new ItemBase("strawberry", new Item.Properties().tab(itemGroupConfig.getPluginItemGroup())));
        }};
    }

}
