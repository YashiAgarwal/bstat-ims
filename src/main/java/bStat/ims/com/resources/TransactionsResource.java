package bStat.ims.com.resources;

import bStat.ims.com.controllers.*;
import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import io.dropwizard.hibernate.UnitOfWork;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by prashant.agarwal on 09/05/17.
 */

@Path("/transact")
@Api("Transactions Resource")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TransactionsResource {

    @Inject
    ProductTransactionsController productTransactionsController;

    private static final Logger logger = LoggerFactory.getLogger(TransactionsResource.class);

    //Add a Raw Material Transaction
    @POST
    @Path("/rawMat/add")
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @Timed
    @ExceptionMetered
    @ApiOperation(value = "rawMaterialTransaction", response = Response.class)
    public Response rawMaterialTransaction() {
        try {
            //productTransactionsController.
        } catch (Exception e) {
            logger.error("Add New Store Exception", e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
        return Response.ok().build();
    }

    //Add a Product Transaction
    //Get Product Transactions based on parameter (time, last X, All- paginate this)
    //Get Raw Material Transactions based on parameter (time, last X, All - paginate this)
    //Get Product transactions of Seller/Worker/Customer X
    //Get transactions of Product X
    //Get Raw Material transactions of Seller/Worker X
}
