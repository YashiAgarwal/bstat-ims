package bStat.ims.com.resources;

import bStat.ims.com.Validators.AddRequestValidators;
import bStat.ims.com.common.dao.StoresDao;
import bStat.ims.com.controllers.DataController;
import com.google.inject.Inject;
import com.wordnik.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by prashant170392 on 01/05/2017
 */

@Path("/stock")
@Api("Inventory Resource")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InventoryResource {

    @Inject
    private DataController dataController;
    @Inject
    private StoresDao storesDao;
    @Inject
    private AddRequestValidators addRequestValidators;

    private static final Logger logger = LoggerFactory.getLogger(InventoryResource.class);

    //Get Product Inventory of Product X
    //Get Raw Material Inventory of Raw Material X
}