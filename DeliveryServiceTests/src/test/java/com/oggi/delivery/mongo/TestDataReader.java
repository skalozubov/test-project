package com.oggi.delivery.mongo;

import com.mongodb.*;
import com.oggi.delivery.Tests.ConfigInitializer;

import java.net.UnknownHostException;

public class TestDataReader {
    DBCollection collection;
    private static final String AUTOTESTS_DB = "autotestsData";

    public TestDataReader(String collectionName) {
        initMongoClient(collectionName);
    }

    private void initMongoClient(String collectionName) {
        MongoClient client = null;
        try {
            client = new MongoClient(new ServerAddress(ConfigInitializer.MONGO_HOST, ConfigInitializer.MONGO_PORT));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        DB database = client.getDB(AUTOTESTS_DB);
        collection = database.getCollection(collectionName);
    }

    public Object [][] getTestData() {
        Object[][] testDataArray = new Object[(int)collection.count()][];
        DBObject query = new BasicDBObject();
        DBObject projection = new BasicDBObject("_id", false);
        DBCursor cursor = collection.find(query, projection);
        try {
            int i = 0;
            while(cursor.hasNext()) {
                testDataArray[i] = cursor.next().toMap().values().toArray();
                i++;
            }
            return testDataArray;
        } finally {
            cursor.close();
        }
    }
}