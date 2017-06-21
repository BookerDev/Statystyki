package pl.statystyki.waterfall;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import net.md_5.bungee.api.plugin.Plugin;
import pl.statystyki.shared.utils.FindClass;

public class MainWaterfall extends Plugin {

	private static MainWaterfall pl;
	
	public void onEnable() {
		if(FindClass.isSpigotOrWaterfall() == true) {
			pl = this;
			if (!getDataFolder().exists())
				getDataFolder().mkdir();
			File file = new File(getDataFolder(), "config.yml");
			if (!file.exists()) {
				try (InputStream in = getResourceAsStream("config.yml")) {
					Files.copy(in, file.toPath());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static MainWaterfall getInst() {
		return pl;
	}
}