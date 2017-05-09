package bStat.com.resources;

import bStat.com.common.dao.RawMaterialsDao;
import bStat.com.common.models.tables.Store;
import bStat.com.controllers.ProductTransactionsController;
import bStat.com.controllers.StoresController;
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
 * Created by prashant.agarwal on 09/05/17.
 */

@Path("/transact")
@Produces(MediaType.APPLICATION_JSON)

public class TransactionsResource {

    @Inject
    ProductTransactionsController productTransactionsController;

    private static final Logger logger = LoggerFactory.getLogger(TransactionsResource.class);

    //Add a Raw Material Transaction
    @POST
    @Path("/rm")
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @Timed
    @ExceptionMetered
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
