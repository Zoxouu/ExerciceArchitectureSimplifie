package me.zoxouu.exercice.service;

import org.bson.Document;
import org.bukkit.entity.Player;

public class PlayerService {
    private final DatabaseService databaseService;

    public PlayerService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public void doSomething(Player player) {
        Document document = new Document("player_name", player.getName())
                .append("action", "custom_action");
        databaseService.insertDocument("player_actions", document);
    }
}