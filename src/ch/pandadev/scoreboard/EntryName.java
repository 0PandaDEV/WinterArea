package ch.pandadev.scoreboard;

import org.bukkit.ChatColor;

public enum EntryName {

    ENTRY_0(0, ChatColor.DARK_PURPLE.toString()),
    ENTRY_1(1, ChatColor.DARK_GREEN.toString()),
    ENTRY_2(2, ChatColor.BOLD.toString()),
    ENTRY_3(3, ChatColor.DARK_RED.toString()),
    ENTRY_4(4, ChatColor.GRAY.toString()),
    ENTRY_5(5, ChatColor.GREEN.toString()),
    ENTRY_6(6, ChatColor.LIGHT_PURPLE.toString()),
    ENTRY_7(7, ChatColor.GOLD.toString()),
    ENTRY_8(8, ChatColor.UNDERLINE.toString()),
    ENTRY_9(9, ChatColor.AQUA.toString()),
    ENTRY_10(10, ChatColor.AQUA.toString()),
    ENTRY_11(11, ChatColor.AQUA.toString()),
    ENTRY_12(12, ChatColor.AQUA.toString()),
    ENTRY_13(13, ChatColor.AQUA.toString()),
    ENTRY_14(14, ChatColor.AQUA.toString()),
    ENTRY_15(15, ChatColor.AQUA.toString()),
    ENTRY_16(16, ChatColor.AQUA.toString()),
    ENTRY_17(17, ChatColor.AQUA.toString());

    private final int entry;
    private final String entryName;

    EntryName(int entry, String entryName) {
        this.entry = entry;
        this.entryName = entryName;
    }

    public int getEntry() {
        return entry;
    }

    public String getEntryName() {
        return entryName;
    }
}

