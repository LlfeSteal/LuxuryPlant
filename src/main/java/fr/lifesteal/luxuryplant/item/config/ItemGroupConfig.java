package fr.lifesteal.luxuryplant.item.config;

import fr.lifesteal.luxuryplant.item.group.GenericItemGroup;
import fr.lifesteal.luxuryplant.registry.GenericRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ItemGroupConfig {

    private final GenericRegistry<Item> itemGenericRegistry;

    public ItemGroupConfig(GenericRegistry<Item> itemGenericRegistry) {
        this.itemGenericRegistry = itemGenericRegistry;
    }

    public ItemGroup getPluginItemGroup() {
        return new GenericItemGroup("LuxuryPlant", () -> new ItemStack(itemGenericRegistry.getRegisterItemByName("strawberry").get()));
    }
}
