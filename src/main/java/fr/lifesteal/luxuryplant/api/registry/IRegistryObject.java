package fr.lifesteal.luxuryplant.api.registry;

import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.function.Supplier;

public interface IRegistryObject<T extends IForgeRegistryEntry<T>> {
    String getRegistryObjectName();
    Supplier<T> getSupplier();
}
