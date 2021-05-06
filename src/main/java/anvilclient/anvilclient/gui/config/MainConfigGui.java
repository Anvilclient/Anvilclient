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

import anvilclient.anvilclient.features.Features;
import anvilclient.anvilclient.gui.util.ClickOption;
import net.minecraft.client.AbstractOption;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.settings.BooleanOption;

public final class MainConfigGui extends ConfigScreen {

	private AbstractOption[] fullbrightOptions = {
			new BooleanOption("anvilclient.configGui.fullbright.toggle",
					unused -> Features.FULLBRIGHT.isEnabled(),
					(unused, newValue) -> Features.FULLBRIGHT.setEnabled(newValue)),
			new ClickOption("anvilclient.configGui.fullbright.title",
					unused -> this.minecraft.displayGuiScreen(new FullbrightConfigGui(this)))
			};
	
	private AbstractOption[] coordinatesOptions = {
			new BooleanOption("anvilclient.configGui.coordinates.toggle",
					unused -> Features.COORDINATES.isEnabled(),
					(unused, newValue) -> Features.COORDINATES.setEnabled(newValue)),
			new ClickOption("anvilclient.configGui.coordinates.title",
					unused -> this.minecraft.displayGuiScreen(new CoordinatesConfigGui(this)))
			};
	
	private AbstractOption[] autoToolOptions = {
			new BooleanOption("anvilclient.configGui.autoTool.toggle",
					unused -> Features.AUTO_TOOL.isEnabled(),
					(unused, newValue) -> Features.AUTO_TOOL.setEnabled(newValue)),
			new ClickOption("anvilclient.configGui.autoTool.title",
					unused -> this.minecraft.displayGuiScreen(new AutoToolConfigGui(this)))
			};

	public MainConfigGui(Screen parentScreen) {
		super("anvilclient.mainConfigGui.title", parentScreen);
	}

	public MainConfigGui() {
		super("anvilclient.mainConfigGui.title");
	}

	@Override
	protected void addOptions() {
		this.optionsRowList.addOptions(fullbrightOptions);
		this.optionsRowList.addOptions(coordinatesOptions);
		this.optionsRowList.addOptions(autoToolOptions);
	}
}
