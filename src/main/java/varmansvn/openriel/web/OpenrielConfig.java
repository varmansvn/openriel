/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package varmansvn.openriel.web;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;

import com.google.inject.Guice;

import com.google.inject.Module;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import com.google.inject.Injector;

import com.google.inject.servlet.GuiceServletContextListener;
import com.google.sitebricks.SitebricksModule;
import varmansvn.openriel.service.CategoryService;

/**
 *
 * @author varmansvn
 */
public class OpenrielConfig extends GuiceServletContextListener {

    @Override
    protected Injector getInjector() {
       Module module = new SitebricksModule() {
            @Override
            protected void configureSitebricks() {
                
                at("/admin/category").show(CategoryPage.class).in(Scopes.SINGLETON);
                at("/admin/service/category").serve(CategoryService.class).in(Scopes.SINGLETON);
            }
                       
        };
        
        Injector injector = Guice.createInjector(module);
        return injector;
    }
}
