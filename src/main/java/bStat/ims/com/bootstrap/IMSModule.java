package bStat.ims.com.bootstrap;

import bStat.ims.com.Validators.AddRequestValidators;
import bStat.ims.com.common.dao.StoresDao;
import bStat.ims.com.config.IMSConfiguration;
import bStat.ims.com.controllers.ProductTransactionsController;
import bStat.ims.com.controllers.StoresController;
import com.codahale.metrics.MetricRegistry;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import io.dropwizard.hibernate.HibernateBundle;
import org.hibernate.SessionFactory;

import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by prashant170392 on 01/05/2017
 */
public class IMSModule extends AbstractModule {

    private HibernateBundle<IMSConfiguration> bundle;
    private IMSConfiguration config;
    private Validator validator;
    private List<String> buckets;
    private final MetricRegistry metricRegistry;

    public IMSModule(HibernateBundle<IMSConfiguration> bundle, IMSConfiguration config, Validator validator,
                     final MetricRegistry metricRegistry) {
        this.bundle = bundle;
        this.config = config;
        this.validator = validator;
        this.metricRegistry = metricRegistry;
    }

    @Override
    protected void configure() {
        bind(HibernateBundle.class).toInstance(bundle);
        bind(IMSConfiguration.class).toInstance(config);
        bind(Validator.class).toInstance(validator);
        bind(SessionFactory.class).toInstance(bundle.getSessionFactory());
        buckets = new ArrayList<String>();
        buckets.add(this.config.getConfigParams().getBucket());
    }

    @Provides
    @Singleton
    public StoresController provideStoresController(StoresDao storesDao) {
        return new StoresController(storesDao);
    }

    @Provides
    @Singleton
    public ProductTransactionsController provideProductTransactionsController() {
        return new ProductTransactionsController();
    }

    @Provides
    @Singleton
    public AddRequestValidators provideAddRequestValidators() {
        return new AddRequestValidators();
    }
}
