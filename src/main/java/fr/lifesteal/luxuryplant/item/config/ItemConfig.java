package fr.lifesteal.luxuryplant.item.config;

import fr.lifesteal.luxuryplant.item.IRegistryObject;
import fr.lifesteal.luxuryplant.item.ItemBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

import java.util.ArrayList;
import java.util.List;

public final class ItemConfig {
    public static final List<IRegistryObject<Item>> PLUGIN_ITEMS = new ArrayList<>();

    static {
        PLUGIN_ITEMS.add(new ItemBase("strawberry", new Item.Properties().tab(ItemGroup.TAB_FOOD)));
    }
}
