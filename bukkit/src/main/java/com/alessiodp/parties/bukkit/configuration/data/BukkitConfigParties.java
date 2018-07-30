package com.alessiodp.parties.bukkit.configuration.data;

import com.alessiodp.parties.common.PartiesPlugin;
import com.alessiodp.parties.common.configuration.adapter.ConfigurationAdapter;
import com.alessiodp.parties.common.configuration.data.ConfigParties;

import java.util.ArrayList;
import java.util.List;

public class BukkitConfigParties extends ConfigParties {
	// Additional settings
	public static boolean		FRIENDLYFIRE_ENABLE;
	public static boolean		FRIENDLYFIRE_WARNONFIGHT;
	public static List<String> FRIENDLYFIRE_LISTWORLDS;
	public static boolean		FRIENDLYFIRE_CRACKSHOT_ENABLE;
	
	public static boolean		HOME_ENABLE;
	public static int			HOME_DELAY;
	public static boolean		HOME_HIT;
	public static boolean		HOME_MOVING;
	public static int			HOME_DISTANCE;
	
	public static boolean		KILLS_ENABLE;
	public static boolean		KILLS_MOB_NEUTRAL;
	public static boolean		KILLS_MOB_HOSTILE;
	public static boolean		KILLS_MOB_PLAYERS;
	
	public static boolean		TELEPORT_ENABLE;
	public static int			TELEPORT_COOLDOWN;
	
	
	public BukkitConfigParties(PartiesPlugin instance) {
		super(instance);
	}
	
	@Override
	public void loadDefaults() {
		super.loadDefaults();
		// Bukkit configurations
		// Additional settings
		FRIENDLYFIRE_ENABLE = true;
		FRIENDLYFIRE_WARNONFIGHT = true;
		FRIENDLYFIRE_LISTWORLDS = new ArrayList<>();
		FRIENDLYFIRE_CRACKSHOT_ENABLE = false;
		
		HOME_ENABLE = false;
		HOME_DELAY = 0;
		HOME_HIT = true;
		HOME_MOVING = true;
		HOME_DISTANCE = 3;
		
		KILLS_ENABLE = false;
		KILLS_MOB_NEUTRAL = false;
		KILLS_MOB_HOSTILE = false;
		KILLS_MOB_PLAYERS = true;
		
		TELEPORT_ENABLE = false;
		TELEPORT_COOLDOWN = 60;
	}
	
	@Override
	public void loadConfiguration(ConfigurationAdapter confAdapter) {
		super.loadConfiguration(confAdapter);
		
		// Bukkit configuration
		// Additional settings
		FRIENDLYFIRE_ENABLE = confAdapter.getBoolean("additional.friendly-fire.enable-protection", FRIENDLYFIRE_ENABLE);
		FRIENDLYFIRE_WARNONFIGHT = confAdapter.getBoolean("additional.friendly-fire.warn-players-on-fight", FRIENDLYFIRE_WARNONFIGHT);
		FRIENDLYFIRE_LISTWORLDS = confAdapter.getStringList("additional.friendly-fire.list-worlds", FRIENDLYFIRE_LISTWORLDS);
		FRIENDLYFIRE_CRACKSHOT_ENABLE = confAdapter.getBoolean("additional.friendly-fire.crackshot.enable", FRIENDLYFIRE_CRACKSHOT_ENABLE);
		
		HOME_ENABLE = confAdapter.getBoolean("additional.home.enable", HOME_ENABLE);
		HOME_DELAY = confAdapter.getInt("additional.home.delay", HOME_DELAY);
		HOME_HIT = confAdapter.getBoolean("additional.home.cancel.hit", HOME_HIT);
		HOME_MOVING = confAdapter.getBoolean("additional.home.cancel.moving", HOME_MOVING);
		HOME_DISTANCE = confAdapter.getInt("additional.home.cancel.distance", HOME_DISTANCE);
		
		KILLS_ENABLE = confAdapter.getBoolean("additional.kills.enable", KILLS_ENABLE);
		KILLS_MOB_NEUTRAL = confAdapter.getBoolean("additional.kills.which-save.neutral-mobs", KILLS_MOB_NEUTRAL);
		KILLS_MOB_HOSTILE = confAdapter.getBoolean("additional.kills.which-save.hostile-mobs", KILLS_MOB_HOSTILE);
		KILLS_MOB_PLAYERS = confAdapter.getBoolean("additional.kills.which-save.players", KILLS_MOB_PLAYERS);
		
		TELEPORT_ENABLE = confAdapter.getBoolean("additional.teleport.enable", TELEPORT_ENABLE);
		TELEPORT_COOLDOWN = confAdapter.getInt("additional.teleport.cooldown", TELEPORT_COOLDOWN);
	}
	
	@Override
	public String getFileName() {
		return "parties.yml";
	}
	
	@Override
	public String getResourceName() {
		return "bukkit/parties.yml";
	}
}
