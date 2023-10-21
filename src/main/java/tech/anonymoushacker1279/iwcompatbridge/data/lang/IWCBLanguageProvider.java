package tech.anonymoushacker1279.iwcompatbridge.data.lang;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public abstract class IWCBLanguageProvider extends LanguageProvider {

	public IWCBLanguageProvider(PackOutput output, String id) {
		super(output, id, "en_us");
	}

	public void addJEICategory(String name, String translation) {
		add("gui.jei.category." + name, translation);
	}

	public void addJEICategory(String name, String translation, String note) {
		add("gui.jei.category." + name, translation);
		add("gui.jei.category." + name + ".note", note);
	}

	public void addWTHITTooltip(String name, String translation) {
		add("iwcompatbridge.wthit." + name, translation);
	}
}