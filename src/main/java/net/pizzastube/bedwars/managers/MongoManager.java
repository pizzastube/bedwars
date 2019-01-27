package net.pizzastube.bedwars.managers;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Arrays;
import java.util.Collections;

public class MongoManager {

    private final String hostname;
    private final int port;

    private MongoClient client;
    private MongoDatabase database;

    private MongoCollection<Document> games;
    private MongoCollection<Document> players;

    public MongoManager(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public void connect(String username, String password, String database) {
        this.client = new MongoClient(new ServerAddress(hostname, port), Collections.singletonList(MongoCredential.createCredential(username, database, password.toCharArray())));
        this.database = this.client.getDatabase("bedwars");
        this.games = this.database.getCollection("games");
        this.players = this.database.getCollection("players");
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public MongoCollection<Document> getGames() {
        return games;
    }

    public MongoCollection<Document> getPlayers() {
        return players;
    }
}
