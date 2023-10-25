package me.zoxouu.exercice.service;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.List;

public class DatabaseService {
    private MongoClient mongoClient;
    private MongoDatabase database;

    public DatabaseService(String ip, int port) {
        MongoCredential mongoCredential = MongoCredential.createCredential("root","exercice","****".toCharArray());
        this.mongoClient = MongoClients.create(MongoClientSettings.builder().credential(mongoCredential).applyToClusterSettings((b)-> {
            List<ServerAddress> hosts = new java.util.ArrayList<>();
            hosts.add(new ServerAddress(ip, port));
            b.hosts(hosts);
        }).build());
    }
    public MongoCollection<Document> getCollection(String collectionName) {
        return database.getCollection(collectionName);
    }

    public void insertDocument(String collectionName, Document document) {
        MongoCollection<Document> collection = getCollection(collectionName);
        collection.insertOne(document);
    }

    public Document findDocument(String collectionName, String fieldName, String value) {
        MongoCollection<Document> collection = getCollection(collectionName);
        return collection.find(new Document(fieldName, value)).first();
    }

    public void close() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }
}
