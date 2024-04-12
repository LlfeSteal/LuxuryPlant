package fr.lifesteal.luxuryplant.item;

import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.function.Supplier;

public interface IRegistryObject<T extends IForgeRegistryEntry<T>> {
    String getName();
    Supplier<T> getSupplier();
}
