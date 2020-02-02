package org.pixeltime.eeapidemo;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.pixeltime.enchantmentsenhance.api.API;

public class Main extends JavaPlugin implements Listener {
    private API enhanceAPI;

    @Override
    public void onEnable() {
        this.enhanceAPI = org.pixeltime.enchantmentsenhance.Main.getApi();
        this.getServer().getPluginManager().registerEvents(this, this);
        super.onEnable();
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        new BukkitRunnable() {
            @Override
            public void run() {
                int failstack = enhanceAPI.getFailstack(player.getName());
                player.sendMessage(
                        String.format("You currently have %d failstack.", failstack)
                );
            }
        }.runTaskLater(this, 20L);
    }

}