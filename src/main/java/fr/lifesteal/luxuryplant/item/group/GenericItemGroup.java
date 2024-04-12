package fr.lifesteal.luxuryplant.item.group;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import java.util.function.Supplier;

public class GenericItemGroup extends ItemGroup {
    private final Supplier<ItemStack> iconSupplier;

    public GenericItemGroup(String label, Supplier<ItemStack> iconSupplier) {
        super(label);
        this.iconSupplier = iconSupplier;
    }

    @Override
    public ItemStack makeIcon() {
        return this.iconSupplier.get();
    }
}
