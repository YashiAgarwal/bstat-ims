package bStat.ims.com.Validators;

import bStat.ims.com.FeedObjects.StoreDTO;
import bStat.ims.com.common.dao.AddressDao;
import bStat.ims.com.common.exceptions.ApiException;
import bStat.ims.com.common.exceptions.ResponseErrorMsg;
import bStat.ims.com.common.models.tables.Address;
import com.google.inject.Inject;

import javax.ws.rs.core.Response;

/**
 * Created by prashant.agarwal on 13/05/17.
 */
public class AddRequestValidators {

    @Inject
    AddressDao addressDao;

    @Inject
    public AddRequestValidators(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    public void validateAddStore(StoreDTO storeDTO) throws ApiException {
        Address addressWithAddressId = addressDao.getAddressWithAddressId(storeDTO.getAddressId());
        if (addressWithAddressId == null)
            throw new ApiException(Response.Status.BAD_REQUEST, ResponseErrorMsg.VALIDATION_ERROR, "Address Id not found");
    }
}
