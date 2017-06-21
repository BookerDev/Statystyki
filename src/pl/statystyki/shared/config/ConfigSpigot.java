package pl.statystyki.shared.config;

import java.io.File;
import org.bukkit.configuration.file.YamlConfiguration;

import pl.statystyki.spigot.MainSpigot;

public class ConfigSpigot {

	private static File config = new File(MainSpigot.getInst().getDataFolder(), "config.yml");
	
	public static YamlConfiguration loadConfig() {
		if(config.exists()) {
			return YamlConfiguration.loadConfiguration(config);
		} else {
			MainSpigot.getInst().saveDefaultConfig();
			return YamlConfiguration.loadConfiguration(config);
		}
	}
}