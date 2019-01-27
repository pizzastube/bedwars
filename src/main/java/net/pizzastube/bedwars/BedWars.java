package net.pizzastube.bedwars;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import org.bukkit.plugin.java.JavaPlugin;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Set;

public class BedWars extends JavaPlugin {

    private static BedWars instance;
    private String prefix = "§7[§bBedWars§7]§f ";

    @Override
    public void onEnable() {
        instance = this;
        loadDatabase();
        registerCommands();
        registerListener();
    }

    private void loadDatabase() {
        try {
            //Mongo Connection
            MongoClient mongoClient = new MongoClient("localhost", 27017);

            //Mongo Authentification
            DB db = mongoClient.getDB("bedwars");
            boolean auth = db.authenticate("bedwars-game", "bedwars-game".toCharArray());

            //Mongo Database display
            List<String> dbs = mongoClient.getDatabaseNames();
            dbs.forEach(System.out::println);

            //Mongo Collection
            DBCollection table = db.getCollection("test");
            Set<String> tables = db.getCollectionNames();
            tables.forEach(System.out::println);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
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
}
