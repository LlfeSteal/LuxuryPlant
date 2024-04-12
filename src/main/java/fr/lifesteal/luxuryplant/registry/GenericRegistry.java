package fr.lifesteal.luxuryplant.registry;

import fr.lifesteal.luxuryplant.item.IRegistryObject;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.List;

public class GenericRegistry<T extends IForgeRegistryEntry<T>> {
    private final DeferredRegister<T> deferredRegister;

    public GenericRegistry(DeferredRegister<T> deferredRegister) {
        this.deferredRegister = deferredRegister;
    }

    public void init(IEventBus eventBus) {
        deferredRegister.register(eventBus);
    }

    public void registerObjects(List<IRegistryObject<T>> objects) {
        for (IRegistryObject<T> object : objects) {
            deferredRegister.register(object.getName(), object.getSupplier());
        }
    }
}
