package com.EmptyForestryBasket;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class EmptyForestryBasketTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(EmptyForestryBasket.class);
		RuneLite.main(args);
	}
}