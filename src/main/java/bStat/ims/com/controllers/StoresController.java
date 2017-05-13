package bStat.ims.com.controllers;

import bStat.ims.com.Request.AddressRequest;
import bStat.ims.com.common.dao.AddressDao;
import bStat.ims.com.common.dao.StoresDao;
import bStat.ims.com.common.models.tables.Address;
import bStat.ims.com.common.models.tables.Store;
import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import bStat.ims.com.Request.StoreRequest;

import java.io.Serializable;

/**
 * Created by prashant.agarwal on 09/05/17.
 */
public class StoresController {
    private static final Logger logger = LoggerFactory.getLogger(StoresController.class);

    @Inject
    private StoresDao storesDao;
    @Inject
    private AddressDao addressDao;

    @Inject
    public StoresController(StoresDao storesDao) {
        this.storesDao = storesDao;
    }

    public Serializable addNewStore(StoreRequest storeRequest) {
        Store store = new Store(storeRequest.getAddressId(), storeRequest.getStoreName(),
                storeRequest.getPhone_number(), storeRequest.getInchargePerson());
        return storesDao.save(store);
    }

    public Serializable addNewAddress(AddressRequest addressRequest) {
        Address address = new Address(addressRequest.getAddressLine1(), addressRequest.getAddressLine2(), addressRequest.getState(),
                addressRequest.getCity(), addressRequest.getCountry(), addressRequest.getPincode(),
                addressRequest.getLandmark(), addressRequest.getCreationDate(), addressRequest.getLastModified());
        return addressDao.save(address);
    }
}
