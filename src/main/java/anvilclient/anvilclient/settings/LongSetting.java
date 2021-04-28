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
package anvilclient.anvilclient.settings;

public class LongSetting extends NumberSetting<Long> {

	public LongSetting(String name, String description, Long defaultValue, Long minValue, Long maxValue) {
		super(name, description, defaultValue, minValue, maxValue);
	}

	@Override
	public String valueToString() {
		return Long.toString(this.value);
	}

	@Override
	public Long stringToValue(String string) {
		return Long.parseLong(string);
	}

}
