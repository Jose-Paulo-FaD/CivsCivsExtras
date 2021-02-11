package io.github.jotafad.civsextras;

import io.github.jotafad.civsextras.config.ConfigManager;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

public class KeyBinding implements Listener
{
    private final CivsExtras plugin;

    public KeyBinding(CivsExtras plugin)
    {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerSwapHandItems(PlayerSwapHandItemsEvent event)
    {
        if (!ConfigManager.config.getString("f-key-command").equals("") && event.getOffHandItem().getType().equals(Material.AIR) && !event.getPlayer().isSneaking())
        {
            event.getPlayer().performCommand(ConfigManager.config.getString("f-key-command"));
            event.setCancelled(true);
        }
    }
}
