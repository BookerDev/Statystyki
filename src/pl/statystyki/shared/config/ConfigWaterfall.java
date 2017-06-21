package pl.statystyki.shared.config;

import java.io.File;
import java.io.IOException;

import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import pl.statystyki.waterfall.MainWaterfall;

public class ConfigWaterfall {

	public static Configuration loadConfig() {
		try {
			return ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(MainWaterfall.getInst().getDataFolder(), "config.yml"));
		} catch(IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}