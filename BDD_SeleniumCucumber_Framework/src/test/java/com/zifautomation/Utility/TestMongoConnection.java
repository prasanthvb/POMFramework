package com.zifautomation.Utility;

import com.zifautomation.Utility.MongoConnectionManager;
import com.zifautomation.Utility.MongoQueryManager;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class TestMongoConnection {

    @Test(priority = 0)
    public void getDataFromMongoDB(){
        try {

            MongoConnectionManager mongoConnectionManager=new MongoConnectionManager();
            mongoConnectionManager.connect("mongodb://10.1.0.7:27017");
            MongoDatabase database =mongoConnectionManager.connectToDatabase("<dbname>");
            MongoQueryManager mongoQueryManager=new MongoQueryManager();
            FindIterable<Document> allDocuments=mongoQueryManager.getAllDocuments(database,"<collection name>");
            Map<String,String> fields=new HashMap<>();
            fields.put("<field name>","<field value>");
            FindIterable<Document> wheredocuments= mongoQueryManager.getDocumentsWithFields(database,"<collection name>",fields);
            //wheredocuments.sort()
            mongoQueryManager.printDocuments(wheredocuments);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
//robomongo