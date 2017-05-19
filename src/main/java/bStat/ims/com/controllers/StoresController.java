package bStat.ims.com.controllers;

import bStat.ims.com.FeedObjects.AddressDTO;
import bStat.ims.com.common.dao.AddressDao;
import bStat.ims.com.common.dao.StoresDao;
import bStat.ims.com.common.models.tables.Address;
import bStat.ims.com.common.models.tables.Store;
import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import bStat.ims.com.FeedObjects.StoreDTO;

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

    public void addNewStore(StoreDTO storeDTO) {
        Store store = new Store(storeDTO.getAddressId(), storeDTO.getStoreName(),
                storeDTO.getPhone_number(), storeDTO.getInchargePerson());
        storesDao.save(store);
    }

    public void addNewAddress(AddressDTO addressDTO) {
        Address address = new Address(addressDTO.getAddressLine1(), addressDTO.getAddressLine2(), addressDTO.getState(),
                addressDTO.getCity(), addressDTO.getCountry(), addressDTO.getPincode(),
                addressDTO.getLandmark(), addressDTO.getCreationDate(), addressDTO.getLastModified());
        addressDao.save(address);
    }
}
