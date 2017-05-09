package bStat.ims.com.resources;

import bStat.ims.com.Request.StoreRequest;
import bStat.ims.com.controllers.*;
import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import io.dropwizard.hibernate.UnitOfWork;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by prashant170392 on 01/05/2017
 */

@Path("/ims")
@Produces(MediaType.APPLICATION_JSON)
public class IMSResource {

    @Inject
    private StoresController storesController;

    private static final Logger logger = LoggerFactory.getLogger(IMSResource.class);

    //Add a new store entry
    @POST
    @Path("/new/store")
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @Timed
    @ExceptionMetered
    public Response addStore(StoreRequest storeRequest) {
        try {
            storesController.addNewStore(storeRequest);
        } catch (Exception e) {
            logger.error("Add New Store Exception", e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
        return Response.ok().build();
    }

    //Get all stores
    //Add a new Raw Material Entry
    //Get all raw materials
    //Get stocks in store X
    //Get stock in All stores

    //Get Product Inventory of Product X
    //Get Raw Material Inventory of Raw Material X
}