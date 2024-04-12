package fr.lifesteal.luxuryplant;

import fr.lifesteal.luxuryplant.item.config.ItemConfig;
import fr.lifesteal.luxuryplant.item.config.ItemGroupConfig;
import fr.lifesteal.luxuryplant.registry.GenericRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("luxuryplant")
public class LuxuryPlant
{
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "luxuryplant";
    private final IEventBus MOD_EVENT_BUS = FMLJavaModLoadingContext.get().getModEventBus();
    private final GenericRegistry<Item> itemRegistry = new GenericRegistry<>(DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID));

    public LuxuryPlant() {
        MOD_EVENT_BUS.addListener(this::setup);
        MOD_EVENT_BUS.addListener(this::doClientStuff);

        this.setupRegistries();

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setupRegistries() {
        ItemGroupConfig itemGroupConfig = new ItemGroupConfig(this.itemRegistry);
        ItemConfig itemConfig = new ItemConfig(itemGroupConfig);

        this.itemRegistry.registerObjects(itemConfig.getPluginItems());
        this.itemRegistry.init(MOD_EVENT_BUS);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().options);
    }
}
