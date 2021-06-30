package com.automation.Utility;

import java.util.HashMap;
import java.util.Map;

import org.bson.Document;
import org.testng.annotations.Test;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;

public class TestMongoConnection {

	@Test(priority = 0)
	public void getDataFromMongoDB() {
		try {

			MongoConnectionManager mongoConnectionManager = new MongoConnectionManager();
			mongoConnectionManager.connect("mongodb://URL");
			MongoDatabase database = mongoConnectionManager.connectToDatabase("<dbname>");
			MongoQueryManager mongoQueryManager = new MongoQueryManager();
			FindIterable<Document> allDocuments = mongoQueryManager.getAllDocuments(database, "<collection name>");
			Map<String, String> fields = new HashMap<>();
			fields.put("<field name>", "<field value>");
			FindIterable<Document> wheredocuments = mongoQueryManager.getDocumentsWithFields(database,
					"<collection name>", fields);
			// wheredocuments.sort()
			mongoQueryManager.printDocuments(wheredocuments);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
//robomongo