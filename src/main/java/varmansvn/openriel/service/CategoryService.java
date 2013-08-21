/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package varmansvn.openriel.service;
import varmansvn.openriel.web.*;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.sitebricks.client.transport.Json;
import com.google.sitebricks.headless.Reply;
import com.google.sitebricks.headless.Request;
import com.google.sitebricks.http.Post;
import java.util.logging.Level;

import java.util.logging.Logger;
import varmansvn.openriel.model.Category;

/**
 *
 * @author varmansvn
 */
public class CategoryService {
  
  private static final Logger logger = Logger.getLogger(CategoryPage.class.getName());
      
  @Post
  public Reply<Category> createCategory(Request request) {
                  
      Category category = new Category(request.param("name"), request.param("desc"));
      
      Key categoryKey = KeyFactory.createKey("Category", category.getName());       
      Entity entity = new Entity("Category", categoryKey);
      entity.setProperty("name", category.getName());
      entity.setProperty("desc", category.getDesc());     
      DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
      datastore.put(entity);
      
      return Reply.with(category).as(Json.class);
      
  }
  
}
