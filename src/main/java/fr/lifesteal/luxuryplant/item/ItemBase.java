package fr.lifesteal.luxuryplant.item;

import net.minecraft.item.Item;

import java.util.function.Supplier;

public class ItemBase extends Item implements IRegistryObject<Item> {

    private final String name;
    private final Properties itemProperties;

    public ItemBase(String name, Properties itemProperties) {
        super(itemProperties);
        this.name = name;
        this.itemProperties = itemProperties;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Supplier<Item> getSupplier() {
        return () -> new ItemBase(this.name, this.itemProperties);
    }
}
