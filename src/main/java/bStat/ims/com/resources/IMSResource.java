package bStat.ims.com.resources;

import bStat.com.utils.*;
import bStat.ims.com.utils.HttpService;
import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by prashant170392 on 01/05/2017
 */

@Path("/ndr")
@Produces(MediaType.APPLICATION_JSON)
public class IMSResource {

    @Inject
    private HttpService httpService;

    private static final Logger logger = LoggerFactory.getLogger(IMSResource.class);


}