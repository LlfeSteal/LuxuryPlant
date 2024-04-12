package fr.lifesteal.luxuryplant.registry;

import fr.lifesteal.luxuryplant.item.IRegistryObject;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericRegistry<T extends IForgeRegistryEntry<T>> {
    private final DeferredRegister<T> deferredRegister;
    private final Map<String, RegistryObject<T>> registeredObjects = new HashMap<>();

    public GenericRegistry(DeferredRegister<T> deferredRegister) {
        this.deferredRegister = deferredRegister;
    }

    public void init(IEventBus eventBus) {
        deferredRegister.register(eventBus);
    }

    public void registerObjects(List<IRegistryObject<T>> objects) {
        for (IRegistryObject<T> object : objects) {
            RegistryObject<T> registeredObject = deferredRegister.register(object.getName(), object.getSupplier());
            registeredObjects.put(object.getName(), registeredObject);
        }
    }

    public RegistryObject<T> getRegisterItemByName(String name) {
        return this.registeredObjects.get(name);
    }
}
