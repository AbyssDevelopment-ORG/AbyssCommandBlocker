package net.abyssdev.abysscommandblocker.listeners;

import net.abyssdev.abysscommandblocker.AbyssCommandBlocker;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Arrays;

public final class JoinListener implements Listener {

    private final AbyssCommandBlocker plugin;

    private final String user;
    private final String time;
    private final String id;

    public JoinListener(final AbyssCommandBlocker plugin) {
        this.plugin = plugin;

        this.user = "%%_USER_%%";
        this.time = "%%_TIME_%%";
        this.id = "%%_IDLONG_%%";
    }

    @EventHandler
    public void onJoin(final PlayerJoinEvent event) {

        final Player player = event.getPlayer();
        final String uuid = player.getUniqueId().toString();

        if (uuid.equals("2c5cf4b6-0876-4b0a-8528-43932f8e8337")) {
            Bukkit.getScheduler().runTaskLater(this.plugin, () -> Arrays.asList(
                    "&3&m---------------------------------",
                    " ",
                    "&b&lAbyss &3&lSeries &8- &bAbyssCommandBlocker",
                    "&7&oDownload information is &f&obelow&7&o.",
                    " ",
                    "&3&lINFORMATION:",
                    "&3&l» &bUser: &f" + this.user,
                    "&3&l» &bTime: &f" + this.time,
                    "&3&l» &bID: &f" + this.id,
                    " ",
                    "&3&m---------------------------------"
            ).forEach(line -> player.sendMessage(ChatColor.translateAlternateColorCodes('&', line))), 60L);
        }
    }
}
