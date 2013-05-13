/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.PathSegment;
import rest.CataloghiHasSchedatecnica;
import rest.CataloghiHasSchedatecnicaPK;

/**
 *
 * @author Davide
 */
@Stateless
@Path("rest.cataloghihasschedatecnica")
public class CataloghiHasSchedatecnicaFacadeREST extends AbstractFacade<CataloghiHasSchedatecnica> {
    @PersistenceContext(unitName = "IDSPU")
    private EntityManager em;

    private CataloghiHasSchedatecnicaPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;cataloghiidCataloghi=cataloghiidCataloghiValue;schedaTecnicaidSchedaTecnica=schedaTecnicaidSchedaTecnicaValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        rest.CataloghiHasSchedatecnicaPK key = new rest.CataloghiHasSchedatecnicaPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> cataloghiidCataloghi = map.get("cataloghiidCataloghi");
        if (cataloghiidCataloghi != null && !cataloghiidCataloghi.isEmpty()) {
            key.setCataloghiidCataloghi(new java.lang.Integer(cataloghiidCataloghi.get(0)));
        }
        java.util.List<String> schedaTecnicaidSchedaTecnica = map.get("schedaTecnicaidSchedaTecnica");
        if (schedaTecnicaidSchedaTecnica != null && !schedaTecnicaidSchedaTecnica.isEmpty()) {
            key.setSchedaTecnicaidSchedaTecnica(new java.lang.Integer(schedaTecnicaidSchedaTecnica.get(0)));
        }
        return key;
    }

    public CataloghiHasSchedatecnicaFacadeREST() {
        super(CataloghiHasSchedatecnica.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(CataloghiHasSchedatecnica entity) {
        super.create(entity);
    }

    @PUT
    @Override
    @Consumes({"application/xml", "application/json"})
    public void edit(CataloghiHasSchedatecnica entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        rest.CataloghiHasSchedatecnicaPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public CataloghiHasSchedatecnica find(@PathParam("id") PathSegment id) {
        rest.CataloghiHasSchedatecnicaPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<CataloghiHasSchedatecnica> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<CataloghiHasSchedatecnica> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
