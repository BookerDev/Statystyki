package pl.statystyki.shared.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

public class FindClass {
	
	public static Class<?> getClass(String name) {
		return getCanonicalClass(name);
	}
	
	private static Class<?> getCanonicalClass(String canonicalName) {
		try {
			return Class.forName(canonicalName);
		} catch(ClassNotFoundException e) {
			throw new IllegalArgumentException("Nie moze znalezc " + canonicalName, e);
		}
	}
	
	public static boolean isSpigotOrWaterfall() {
		if(getClass("org.bukkit.plugin.java.JavaPlugin") != null) {
			Logger.getLogger("Minecraft").log(Level.SEVERE, "Twoj silnik jest obslugiwany przez plugin Statystyki");
			return true;
		} else if(getClass("net.md_5.bungee.api.plugin.Plugin") != null) {
			Logger.getLogger("Minecraft").log(Level.SEVERE, "Twoj silnik jest obslugiwany przez plugin Statystyki");
			return true;
		} else {
			Logger.getLogger("Minecraft").log(Level.SEVERE, "Twoj silnik nie jest obslugiwany przez plugin Statystyki!");
			return false;
		}
	}
}