package net.nu11une.bobberbegone;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BobberBegone implements ClientModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("bobberbegone");
	@Override
	public void onInitializeClient() { LOGGER.info("[Bobber Begone] Mod Initialized"); }
}
