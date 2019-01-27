package net.pizzastube.bedwars;

import net.pizzastube.bedwars.managers.MongoManager;
import org.bson.Document;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;

public class BedWars extends JavaPlugin {

    private static BedWars instance;
    private String prefix = "§7[§bBedWars§7]§f ";
    private MongoManager mongoManager;

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage("§eBedWars wird initialisiert...");
        long start = System.currentTimeMillis();
        instance = this;
        loadDatabase();
        registerCommands();
        registerListener();

        UUID uuid = UUID.randomUUID();
        Document document = new Document("UUID", uuid).append("Name", uuid.getMostSignificantBits());
        getMongoManager().getPlayers().insertOne(document);

        getServer().getConsoleSender().sendMessage("§aBedWars in " + (System.currentTimeMillis() - start) + "ms initialisiert.");
    }

    private void loadDatabase() {
        this.mongoManager = new MongoManager("127.0.0.1", 27017);
        this.mongoManager.connect("bedwars-game", "bedwars-game", "bedwars");
    }

    private void registerListener() {

    }

    private void registerCommands() {

    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    public static BedWars getInstance() {
        return instance;
    }

    public MongoManager getMongoManager() {
        return mongoManager;
    }
}
