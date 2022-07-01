import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class DisableNicksPlugin extends JavaPlugin implements Listener {
	
	private Pattern p;
	private String mes;
	
	public void onEnable() {
		this.saveDefaultConfig();
		Bukkit.getPluginManager().registerEvents(this, this);
		p = Pattern.compile(getConfig().getString("pattern"));
		mes = ChatColor.translateAlternateColorCodes('&', getConfig().getString("disable"));
	}
	
	@EventHandler
	public void a(PlayerJoinEvent e) {
		Matcher m = p.matcher(e.getPlayer().getName());
		if (m.find())
			e.getPlayer().kickPlayer(mes);
	}

}
