/*******************************************************************************
 * Copyright (C) 2021  Anvilclient and Contributors
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 *******************************************************************************/
package anvilclient.anvilclient.gui.config;

import anvilclient.anvilclient.features.FeatureCategory;
import anvilclient.anvilclient.gui.util.ClickOption;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.text.TranslationTextComponent;

public class MainGuiCategory extends ConfigScreen {

	public MainGuiCategory(Screen parentScreen) {
		super("anvilclient", parentScreen);
	}

	@Override
	protected void addOptions() {
		for (FeatureCategory category : FeatureCategory.values()) {
			this.optionsRowList.addOption(new ClickOption(category.getTranslationKey(),
					button -> Minecraft.getInstance().displayGuiScreen(new CategoryGui(category, this))));
		}
	}

	@Override
	protected void addButtons() {
		this.addButton(new Button(this.width / 2 - (BUTTON_WIDTH + 5), this.height - DONE_BUTTON_TOP_OFFSET,
				BUTTON_WIDTH, BUTTON_HEIGHT, new TranslationTextComponent(SortType.CATEGORY.getTranslationKey()),
				button -> this.changeScreen()));
		this.addButton(new Button(this.width / 2 - (BUTTON_WIDTH + 5) + BUTTON_WIDTH + 10,
				this.height - DONE_BUTTON_TOP_OFFSET, BUTTON_WIDTH, BUTTON_HEIGHT,
				new TranslationTextComponent("gui.done"), button -> this.closeScreen()));
	}

	private void changeScreen() {
		ConfigScreen.sortType.setValue(SortType.PLAIN);
		this.minecraft.displayGuiScreen(new MainGuiPlain(this.parentScreen));
	}

}
