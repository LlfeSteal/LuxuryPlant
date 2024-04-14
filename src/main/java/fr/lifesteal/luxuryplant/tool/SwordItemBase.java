package fr.lifesteal.luxuryplant.tool;

import fr.lifesteal.luxuryplant.api.registry.IRegistryObject;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;

import java.util.function.Supplier;

public class SwordItemBase extends SwordItem implements IRegistryObject<Item> {

    private final String name;
    private final Properties toolProperty;
    private final int attackDamage;
    private final float speed;

    public SwordItemBase(String name, IItemTier tier, int attackDamage, float speed, Properties toolProperty) {
        super(tier, attackDamage, speed, toolProperty);
        this.name = name;
        this.toolProperty = toolProperty;
        this.attackDamage = attackDamage;
        this.speed = speed;
    }

    @Override
    public String getRegistryObjectName() {
        return this.name;
    }

    @Override
    public Supplier<Item> getSupplier() {
        return () -> new SwordItemBase(this.name, this.getTier(), this.attackDamage, this.speed, this.toolProperty);
    }
}
