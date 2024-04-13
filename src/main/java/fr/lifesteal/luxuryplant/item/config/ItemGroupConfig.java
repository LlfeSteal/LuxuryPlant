package fr.lifesteal.luxuryplant.item.config;

import fr.lifesteal.luxuryplant.item.group.GenericItemGroup;
import fr.lifesteal.luxuryplant.registry.GenericRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ItemGroupConfig {

    private final GenericItemGroup pluginItemGroup;
    public ItemGroupConfig(GenericRegistry<Item> itemGenericRegistry) {
        pluginItemGroup = new GenericItemGroup("LuxuryPlant", () -> new ItemStack(itemGenericRegistry.getRegisterItemByName("strawberry").get()));
    }

    public ItemGroup getPluginItemGroup() {
        return pluginItemGroup;
    }
}
