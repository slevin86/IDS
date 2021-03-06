/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.rest.application.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Davide
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        return getRestResourceClasses();
    }

    /**
     * Do not modify this method. It is automatically generated by NetBeans REST support.
     */
    private Set<Class<?>> getRestResourceClasses() {
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
        resources.add(service.GestionenoteFacadeREST.class);
        resources.add(service.GestionelineeprodottoFacadeREST.class);
        resources.add(service.OrdiniFacadeREST.class);
        resources.add(service.SchedatecnicaFacadeREST.class);
        resources.add(service.ModificheschedatecnicaFacadeREST.class);
        resources.add(service.CataloghiFacadeREST.class);
        resources.add(service.GestionetestataFacadeREST.class);
        resources.add(service.UnitaMisuraFacadeREST.class);
        resources.add(service.MaterialiFacadeREST.class);
        resources.add(service.ComponenteutenteFacadeREST.class);
        resources.add(service.CataloghiHasSchedatecnicaFacadeREST.class);
        resources.add(service.ComponenteprimarioFacadeREST.class);
        resources.add(service.UtenteFacadeREST.class);
        resources.add(service.ComponentesemilavoratoFacadeREST.class);
        try {
            Class<?> jacksonProvider = Class.forName("org.codehaus.jackson.jaxrs.JacksonJsonProvider");
            resources.add(jacksonProvider);
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return resources;
    }
    
}
