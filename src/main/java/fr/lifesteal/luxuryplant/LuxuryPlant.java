package fr.lifesteal.luxuryplant;

import fr.lifesteal.luxuryplant.block.config.BlockConfig;
import fr.lifesteal.luxuryplant.block.config.BlockItemConfig;
import fr.lifesteal.luxuryplant.item.config.ItemConfig;
import fr.lifesteal.luxuryplant.item.config.ItemGroupConfig;
import fr.lifesteal.luxuryplant.registry.GenericRegistry;
import fr.lifesteal.luxuryplant.tool.CustomItemTier;
import fr.lifesteal.luxuryplant.tool.config.ToolItemConfig;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod("luxuryplant")
public class LuxuryPlant
{
    public static final String MOD_ID = "luxuryplant";
    private final IEventBus MOD_EVENT_BUS = FMLJavaModLoadingContext.get().getModEventBus();
    private final GenericRegistry<Item> itemRegistry = new GenericRegistry<>(DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID));
    private final GenericRegistry<Block> blockRegistry = new GenericRegistry<>(DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID));
    private final BlockConfig blockConfig = new BlockConfig(this.itemRegistry);

    public LuxuryPlant() {
        setupItemTiers();
        this.setupRegistries();
        MOD_EVENT_BUS.addListener(this::setup);
        MOD_EVENT_BUS.addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setupItemTiers() {
        CustomItemTier.setItemRegistry(this.itemRegistry);
    }

    private void setupRegistries() {
        ItemGroupConfig itemGroupConfig = new ItemGroupConfig(this.itemRegistry);
        setupBlockRegistry();
        setupItemRegistry(itemGroupConfig);
    }

    private void setupBlockRegistry() {
        this.blockRegistry.registerObjects(this.blockConfig.getPluginBlocks());
        this.blockRegistry.init(MOD_EVENT_BUS);
    }

    private void setupItemRegistry(ItemGroupConfig itemGroupConfig) {
        ItemConfig itemConfig = new ItemConfig(itemGroupConfig);
        ToolItemConfig toolItemConfig = new ToolItemConfig(itemGroupConfig);
        BlockItemConfig blockItemConfig = new BlockItemConfig(this.blockRegistry, itemGroupConfig);

        this.itemRegistry.registerObjects(itemConfig.getPluginItems());
        this.itemRegistry.registerObjects(blockItemConfig.getPluginBlockItems());
        this.itemRegistry.registerObjects(toolItemConfig.getPluginTools());

        this.itemRegistry.init(MOD_EVENT_BUS);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        this.blockRegistry.getAll().forEach(block -> RenderTypeLookup.setRenderLayer(block.get(), RenderType.cutout()));
    }
}
