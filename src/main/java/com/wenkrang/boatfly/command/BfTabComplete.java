package com.wenkrang.boatfly.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.command.TabExecutor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BfTabComplete implements TabCompleter {
    //插件补全器
    //用于补全命令
    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        switch (strings.length) {
            case 1:
                //第一项补全
                return Arrays.asList("help", "getbook","upgrade");
            default:
                return Collections.emptyList();
        }
    }
}
