package fr.lifesteal.luxuryplant.tool;

import fr.lifesteal.luxuryplant.registry.GenericRegistry;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;

public enum CustomItemTier implements IItemTier {
    STRAWBERRY(3, 800, 7.0F, 3.0F, 12, "strawberry");

    private static GenericRegistry<Item> itemRegistry;

    private final int level;
    private final int uses;
    private final float speed;
    private final float attackDamageBonus;
    private final int enchantmentValue;
    private final String repairIngredientName;

    CustomItemTier(int level, int uses, float speed, float attackDamageBonus, int enchantmentValue, String repairIngredientName) {
        this.level = level;
        this.uses = uses;
        this.speed = speed;
        this.attackDamageBonus = attackDamageBonus;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredientName = repairIngredientName;
    }

    public static void setItemRegistry(GenericRegistry<Item> itemRegistry) {
        CustomItemTier.itemRegistry = itemRegistry;
    }

    @Override
    public int getUses() {
        return uses;
    }

    @Override
    public float getSpeed() {
        return speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return attackDamageBonus;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(itemRegistry.getRegisterItemByName(this.repairIngredientName).get());
    }
}