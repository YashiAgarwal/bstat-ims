package bStat.ims.com.resources;

import bStat.ims.com.FeedObjects.AddressDTO;
import bStat.ims.com.FeedObjects.StoreDTO;
import bStat.ims.com.Response.SuccessResponse;
import bStat.ims.com.Validators.AddRequestValidators;
import bStat.ims.com.common.dao.StoresDao;
import bStat.ims.com.common.exceptions.ApiException;
import bStat.ims.com.common.models.tables.Store;
import bStat.ims.com.controllers.StoresController;
import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Timed;
import com.google.gson.Gson;
import com.google.inject.Inject;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import io.dropwizard.hibernate.UnitOfWork;
import org.eclipse.jetty.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by prashant170392 on 01/05/2017
 */

@Path("/ims")
@Api("IMS Resource")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class IMSResource {

    @Inject
    private StoresController storesController;
    @Inject
    private StoresDao storesDao;
    @Inject
    private AddRequestValidators addRequestValidators;

    private static final Logger logger = LoggerFactory.getLogger(IMSResource.class);

    //Add a new store entry
    @POST
    @Path("/new/store")
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @Timed
    @ExceptionMetered
    @ApiOperation(value = "addStore", response = Response.class)
    public Response addStore(@Valid StoreDTO storeDTO){
        try {
            addRequestValidators.validateAddStore(storeDTO);
            storesController.addNewStore(storeDTO);
            logger.info("New Store added successfully: " + storeDTO.getStoreName());
            return Response.ok(new SuccessResponse(HttpStatus.OK_200, "New Store added successfully")).build();
        }
        catch (ApiException ae){
            logger.error("Add New Store Exception", ae.getMessage(), ae);
            return Response.status(ae.getStatus()).entity(new Gson().toJson(ae)).build();
        } catch (Exception e) {
            logger.error("Add New Store Exception", e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Add New Store Exception" + e.getMessage()).build();
        }
    }

    //Add a new address entry
    @POST
    @Path("/new/address")
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @Timed
    @ExceptionMetered
    @ApiOperation(value = "addAddress", response = Response.class)
    public Response addAddress(@Valid AddressDTO addressDTO) throws ApiException {
        try {
            storesController.addNewAddress(addressDTO);
            logger.info("New Address added successfully: " + addressDTO.getAddressLine1());
            return Response.ok(new SuccessResponse(HttpStatus.OK_200, "Address added successfully")).build();
        } catch (Exception e) {
            logger.error("Add New Store Exception", e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Add New Store Exception" + e.getMessage()).build();
        }
    }

    //Get all stores
    @GET
    @Path("/stores")
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @Timed
    @ExceptionMetered
    @ApiOperation(value = "getAllStores", response = Response.class)
    public List<Store> getAllStores() throws ApiException {
        try {
            return storesDao.getAllStores();
        } catch (Exception e) {
            logger.error("GetAllStores Exception", e.getMessage(), e);
            throw new ApiException(Response.Status.INTERNAL_SERVER_ERROR, "GetAllStores Exception");
        }
    }



    //Add a new Raw Material Entry
    //Get all raw materials
    //Get stocks in store X
    //Get stock in All stores

    //Get Product Inventory of Product X
    //Get Raw Material Inventory of Raw Material X
}