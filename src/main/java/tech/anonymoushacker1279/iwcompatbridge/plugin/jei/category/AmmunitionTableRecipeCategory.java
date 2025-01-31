package tech.anonymoushacker1279.iwcompatbridge.plugin.jei.category;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.*;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import tech.anonymoushacker1279.immersiveweapons.init.BlockRegistry;
import tech.anonymoushacker1279.immersiveweapons.item.crafting.AmmunitionTableRecipe;
import tech.anonymoushacker1279.iwcompatbridge.IWCompatBridge;
import tech.anonymoushacker1279.iwcompatbridge.plugin.jei.JEIPluginHandler;

public class AmmunitionTableRecipeCategory implements IRecipeCategory<AmmunitionTableRecipe> {

	private static final ResourceLocation GUI_TEXTURE = ResourceLocation.fromNamespaceAndPath(IWCompatBridge.MOD_ID,
			"textures/gui/jei/ammunition_table.png");
	private final IDrawable background;
	private final IDrawable icon;

	public AmmunitionTableRecipeCategory(IGuiHelper guiHelper) {
		icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK,
				new ItemStack(BlockRegistry.AMMUNITION_TABLE.get()));

		background = guiHelper.createDrawable(GUI_TEXTURE, 0, 0, 105, 36);
	}

	@Override
	public RecipeType<AmmunitionTableRecipe> getRecipeType() {
		return JEIPluginHandler.AMMUNITION_TABLE;
	}

	@Override
	public Component getTitle() {
		return Component.translatable("gui.jei.category.ammunition_table");
	}

	@Override
	public IDrawable getBackground() {
		return background;
	}

	@Override
	public IDrawable getIcon() {
		return icon;
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, AmmunitionTableRecipe recipe, IFocusGroup focuses) {
		NonNullList<ItemStack> ingredients = NonNullList.create();
		ingredients.addAll(recipe.getIngredients().stream().map(ingredient -> ingredient.getItems()[0]).toList());

		builder.addSlot(RecipeIngredientRole.INPUT, 1, 1)
				.addIngredients(VanillaTypes.ITEM_STACK, ingredients);

		builder.addSlot(RecipeIngredientRole.OUTPUT, 84, 10)
				.addItemStack(recipe.getResultItem(RegistryAccess.EMPTY));
	}
}