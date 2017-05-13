package bStat.ims.com.resources;

import bStat.ims.com.Request.StoreRequest;
import bStat.ims.com.common.dao.StoresDao;
import bStat.ims.com.common.exceptions.ApiException;
import bStat.ims.com.common.exceptions.ResponseErrorMsg;
import bStat.ims.com.common.models.tables.Store;
import bStat.ims.com.controllers.*;
import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import io.dropwizard.hibernate.UnitOfWork;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by prashant170392 on 01/05/2017
 */

@Path("/ims")
@Produces(MediaType.APPLICATION_JSON)
public class IMSResource {

    @Inject
    private StoresController storesController;
    @Inject
    private StoresDao storesDao;

    private static final Logger logger = LoggerFactory.getLogger(IMSResource.class);

    //Add a new store entry
    @POST
    @Path("/new/store")
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @Timed
    @ExceptionMetered
    public Response addStore(@Valid StoreRequest storeRequest) throws ApiException {
        try {
            storesController.addNewStore(storeRequest);
            return Response.ok().build();
        } catch (Exception e) {
            logger.error("Add New Store Exception", e.getMessage(), e);
            throw new ApiException(Response.Status.INTERNAL_SERVER_ERROR, "Add New Store Exception");
            //Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }


    //Get all stores
    @GET
    @Path("/stores")
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @Timed
    @ExceptionMetered
    public List<Store> getAllStore() throws ApiException {
        try {
            return storesDao.getAllStores();
        } catch (Exception e) {
            logger.error("Add New Store Exception", e.getMessage(), e);
            throw new ApiException(Response.Status.INTERNAL_SERVER_ERROR, "Add New Store Exception");
        }
    }



    //Add a new Raw Material Entry
    //Get all raw materials
    //Get stocks in store X
    //Get stock in All stores

    //Get Product Inventory of Product X
    //Get Raw Material Inventory of Raw Material X
}