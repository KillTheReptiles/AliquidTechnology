/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upb.edu.co.dao;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author Duvan
 */
@Stateless
public class MongoDAO {

    private final static Logger LOGGER = Logger.getLogger("MongoDAO");

    public void conectar() {
        String conn = "mongodb+srv://Admin:admin@aliquid-dbxp3.azure.mongodb.net/Aliquid";

        ConnectionString connString = new ConnectionString(conn);
        
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connString)
                .retryWrites(true)
                .build();
        
        MongoClient mongoClient = MongoClients.create(settings);
        MongoDatabase database = mongoClient.getDatabase("Aliquid");
        
        MongoIterable<String> collections = database.listCollectionNames();

        LOGGER.log(Level.SEVERE, collections.first().toString());
        mongoClient.close();
    }

    private void desconectar() {

    }

}
