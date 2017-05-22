package bStat.ims.com.resources;

import bStat.ims.com.FeedObjects.AddressDTO;
import bStat.ims.com.FeedObjects.RawMaterialDTO;
import bStat.ims.com.FeedObjects.StoreDTO;
import bStat.ims.com.Response.SuccessResponse;
import bStat.ims.com.Validators.AddRequestValidators;
import bStat.ims.com.common.dao.AddressDao;
import bStat.ims.com.common.dao.RawMaterialsDao;
import bStat.ims.com.common.dao.StoresDao;
import bStat.ims.com.common.exceptions.ApiException;
import bStat.ims.com.common.models.tables.Address;
import bStat.ims.com.common.models.tables.RawMaterials;
import bStat.ims.com.common.models.tables.Store;
import bStat.ims.com.controllers.DataController;
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
@Api("Data Resource")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DataResource {

    @Inject
    private DataController dataController;
    @Inject
    private StoresDao storesDao;
    @Inject
    private AddressDao addressDao;
    @Inject
    private AddRequestValidators addRequestValidators;
    @Inject
    private RawMaterialsDao rawMaterialsDao;

    private static final Logger logger = LoggerFactory.getLogger(DataResource.class);

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
            dataController.addNewStore(storeDTO);
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

    //delete a store row given the store id
    @GET
    @Path("/del/store")
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @Timed
    @ExceptionMetered
    @ApiOperation(value = "deleteStore")
    public void deleteStore(@QueryParam("storeId") long storeId) throws ApiException {
        try {
            storesDao.deleteStoreRowWithTxn(storeId);
        } catch (Exception e) {
            logger.error("Delete Store Exception", e.getMessage(), e);
            throw new ApiException(Response.Status.INTERNAL_SERVER_ERROR, "Delete Store Exception");
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
            dataController.addNewAddress(addressDTO);
            logger.info("New Address added successfully: " + addressDTO.getAddressLine1());
            return Response.ok(new SuccessResponse(HttpStatus.OK_200, "Address added successfully")).build();
        } catch (Exception e) {
            logger.error("Add New Store Exception", e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Add New Store Exception" + e.getMessage()).build();
        }
    }

    //Get all addresses
    @GET
    @Path("/addresses")
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @Timed
    @ExceptionMetered
    @ApiOperation(value = "getAllAddresses", response = Response.class)
    public List<Address> getAllAddresses() throws ApiException {
        try {
            return addressDao.getAllAddresses();
        } catch (Exception e) {
            logger.error("GetAllAddresses Exception", e.getMessage(), e);
            throw new ApiException(Response.Status.INTERNAL_SERVER_ERROR, "GetAllAddresses Exception");
        }
    }

    //delete an address row given an address id
    @GET
    @Path("/del/address")
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @Timed
    @ExceptionMetered
    @ApiOperation(value = "deleteAddress")
    public void deleteAddress(@QueryParam("addressId") long addressId) throws ApiException {
        try {
            addressDao.deleteAddressRowWithTxn(addressId);
        } catch (Exception e) {
            logger.error("Delete Address Exception", e.getMessage(), e);
            throw new ApiException(Response.Status.INTERNAL_SERVER_ERROR, "Delete Address Exception");
        }
    }


    //Add a new Raw Material Entry
    @POST
    @Path("/new/rawMaterial")
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @Timed
    @ExceptionMetered
    @ApiOperation(value = "addRawMaterial", response = Response.class)
    public Response addRawMaterial(@Valid RawMaterialDTO rawMaterialDTO) throws ApiException {
        try {
            dataController.addNewRawMaterial(rawMaterialDTO);
            logger.info("New Raw Material added successfully: " + rawMaterialDTO.getName());
            return Response.ok(new SuccessResponse(HttpStatus.OK_200, "Address added successfully")).build();
        } catch (Exception e) {
            logger.error("Add New Raw Material Exception", e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Add New Raw Material Exception" + e.getMessage()).build();
        }
    }

    //Get all raw materials
    @GET
    @Path("/rawMaterials")
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @Timed
    @ExceptionMetered
    @ApiOperation(value = "getAllRawMaterials", response = Response.class)
    public List<RawMaterials> getAllRawMaterials() throws ApiException {
        try {
            return rawMaterialsDao.getAllRawMaterials();
        } catch (Exception e) {
            logger.error("GetAllRawMaterials Exception", e.getMessage(), e);
            throw new ApiException(Response.Status.INTERNAL_SERVER_ERROR, "GetAllRawMaterials Exception");
        }
    }

    //delete a raw material row given the raw material id
    @GET
    @Path("/del/rawMaterial")
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @Timed
    @ExceptionMetered
    @ApiOperation(value = "deleteRawMaterial")
    public void deleteRawMaterial(@QueryParam("rawMaterialId") long rawMaterialId) throws ApiException {
        try {
            rawMaterialsDao.deleteRawMaterialRowWithTxn(rawMaterialId);
        } catch (Exception e) {
            logger.error("Delete RawMaterial Exception", e.getMessage(), e);
            throw new ApiException(Response.Status.INTERNAL_SERVER_ERROR, "Delete RawMaterial Exception");
        }
    }

    //Get stocks in store X
    //Get a stock in All stores

}