package bStat.ims.com.controllers;

import bStat.ims.com.FeedObjects.AddressDTO;
import bStat.ims.com.FeedObjects.RawMaterialDTO;
import bStat.ims.com.common.dao.AddressDao;
import bStat.ims.com.common.dao.RawMaterialsDao;
import bStat.ims.com.common.dao.StoresDao;
import bStat.ims.com.common.models.tables.Address;
import bStat.ims.com.common.models.tables.RawMaterials;
import bStat.ims.com.common.models.tables.Store;
import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import bStat.ims.com.FeedObjects.StoreDTO;

import java.util.Date;

/**
 * Created by prashant.agarwal on 09/05/17.
 */
public class DataController {
    private static final Logger logger = LoggerFactory.getLogger(DataController.class);

    @Inject
    private StoresDao storesDao;
    @Inject
    private AddressDao addressDao;
    @Inject
    private RawMaterialsDao rawMaterialsDao;

    @Inject
    public DataController(StoresDao storesDao,
                          AddressDao addressDao) {
        this.storesDao = storesDao;
        this.addressDao = addressDao;
    }

    public void addNewStore(StoreDTO storeDTO) {
        Store store = new Store(storeDTO.getAddressId(), storeDTO.getStoreName(),
                storeDTO.getPhone_number(), storeDTO.getInchargePerson());
        storesDao.save(store);
    }

    public void addNewAddress(AddressDTO addressDTO) {
        Address address = new Address(addressDTO.getAddressLine1(), addressDTO.getAddressLine2(), addressDTO.getState(),
                addressDTO.getCity(), addressDTO.getCountry(), addressDTO.getPincode(),
                addressDTO.getLandmark(), new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()));
        addressDao.save(address);
    }

    public void addNewRawMaterial(RawMaterialDTO rawMaterialDTO) {
        RawMaterials rawMaterials = new RawMaterials(rawMaterialDTO.getName(), rawMaterialDTO.getUnitOfMeasurement(),
                rawMaterialDTO.getDescription(), new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()));
        rawMaterialsDao.save(rawMaterials);
    }
}
