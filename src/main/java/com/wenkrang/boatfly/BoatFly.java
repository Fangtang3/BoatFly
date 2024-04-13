package com.wenkrang.boatfly;

import com.wenkrang.boatfly.Data.MainData;
import com.wenkrang.boatfly.Loader.LoadCommand;
import com.wenkrang.boatfly.Loader.LoadEvent;
import com.wenkrang.boatfly.Loader.LoadRecipe;
import com.wenkrang.boatfly.UpgradeSystem.CheckReloadFile;
import com.wenkrang.boatfly.UpgradeSystem.UpgradeCentre;
import com.wenkrang.boatfly.event.GUI.book.PlayerInteract;
import com.wenkrang.boatfly.event.VehicleExit;
import com.wenkrang.boatfly.lib.ConsoleLoger;
import org.bukkit.Bukkit;
import org.bukkit.plugin.InvalidDescriptionException;
import org.bukkit.plugin.InvalidPluginException;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.bukkit.Bukkit.getScheduler;
import static org.bukkit.Bukkit.getServer;


public final class BoatFly extends JavaPlugin {

    @Override
    public void onEnable() {
        MainData.plugin = getPlugin(BoatFly.class);
        MainData.PluginFile = getFile();
        // Plugin startup logic
        if (getName().equalsIgnoreCase("BoatFly")) {
            init.boot();
        }else {
            if (!getFile().toPath().toString().contains("version")) {
                try {
                    if (!new File("./plugins/BoatFly/SetupName").exists()) {
                        init.init();
                        File file = new File("./plugins/BoatFly/SetupName");
                        FileReader fr = new FileReader(file);
                        BufferedReader br = new BufferedReader(fr);
                        String s = br.readLine();
                        ConsoleLoger.info("./plugins/BoatFly/version/" + s);
                        Plugin plugin = Bukkit.getServer().getPluginManager().loadPlugin(new File("./plugins/BoatFly/version/" + s));
                        ConsoleLoger.info(plugin.toString());
                        Bukkit.getServer().getPluginManager().enablePlugin(plugin);
                        getServer().getPluginManager().registerEvents(new CheckReloadFile(), BoatFly.getPlugin(BoatFly.class));
                    }else {
                        if (true) {
                            File file = new File("./plugins/BoatFly/SetupNumber");
                            FileReader fr = new FileReader(file);
                            BufferedReader br = new BufferedReader(fr);
                            String s = br.readLine();

                            int i = Integer.parseInt(s);

                            if (MainData.Number > i) {
                                init.upgrade();
                            }
                        }
                        File file = new File("./plugins/BoatFly/SetupName");
                        FileReader fr = new FileReader(file);
                        BufferedReader br = new BufferedReader(fr);
                        String s = br.readLine();

                        Plugin plugin = Bukkit.getServer().getPluginManager().loadPlugin(new File("./plugins/BoatFly/version/" + s));

                        ConsoleLoger.info(plugin.toString());
                        Bukkit.getServer().getPluginManager().enablePlugin(plugin);
                        getServer().getPluginManager().registerEvents(new CheckReloadFile(), BoatFly.getPlugin(BoatFly.class));
                    }

                } catch (IOException | InvalidPluginException | InvalidDescriptionException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        MainData.IsShutDown = true;
        ConsoleLoger.info("正在关闭 BoatFly ...");
    }
}
