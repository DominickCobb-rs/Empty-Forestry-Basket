package com.ForestryBasketBankSwap;

import com.google.inject.Provides;

import net.runelite.api.ItemID;
import net.runelite.api.MenuEntry;
import net.runelite.api.events.MenuOpened;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "Empty Forestry Basket",
	description = "Changes \"Use\" to \"Empty\" when banking the Forestry Basket",
	tags = {"forestry","basket","use","empty"},
	enabledByDefault = true
)
public class EmptyForestryBasket extends Plugin 
{
	@Subscribe
	public void onMenuOpened(MenuOpened event)
	{
		final MenuEntry[] entries = event.getMenuEntries();
		if (entries[1].getItemId() == ItemID.FORESTRY_BASKET || entries[1].getItemId() == ItemID.OPEN_FORESTRY_BASKET) 
		{
			boolean inBank = false;
			int useIndex = -1;
			for (int idx = entries.length - 1; idx >= 0; --idx) 
			{
				final MenuEntry entry = entries[idx];
				if (entry.getOption().contains("Deposit")) 
				{
					inBank = true;
				}

				if (entry.getOption().contains("Use")) {
					useIndex = idx;
				}
			}

			if (inBank && useIndex != -1) {
				entries[useIndex].setOption(entries[useIndex].getOption().replace("Use", "Empty"));
			}
		}
	}
}
