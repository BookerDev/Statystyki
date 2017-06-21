package pl.statystyki.spigot;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

import pl.statystyki.shared.utils.FindClass;

public class MainSpigot extends JavaPlugin {

	private static MainSpigot pl;
	
	public void onEnable() {
		if(FindClass.isSpigotOrWaterfall() == true) {
			pl = this;	
			File config = new File(getDataFolder(), "config.yml");
			if(!config.exists()) {
				this.saveDefaultConfig();
			}
		}
	}
	
	public static MainSpigot getInst() {
		return pl;
	}
}