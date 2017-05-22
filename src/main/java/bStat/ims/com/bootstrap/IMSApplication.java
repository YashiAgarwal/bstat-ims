package bStat.ims.com.bootstrap;

import bStat.ims.com.common.models.tables.*;
import bStat.ims.com.common.utils.GuiceInjector;
import bStat.ims.com.config.IMSConfiguration;
import bStat.ims.com.resources.HelloWorldResource;
import com.codahale.metrics.JmxReporter;
import com.codahale.metrics.MetricRegistry;
import bStat.ims.com.resources.*;
import com.google.inject.Guice;
import com.google.inject.Injector;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Validator;

/**
 * Created by prashant170392 on 01/05/2017
 */
public class IMSApplication extends Application<IMSConfiguration> {

    private static final Logger logger = LoggerFactory.getLogger(IMSApplication.class);

    public static void main(String[] args) throws Exception {
        new IMSApplication().run(args);
    }

    private final HibernateBundle<IMSConfiguration> hibernate = new HibernateBundle<IMSConfiguration>(RawMaterials.class,
            ProductsInventory.class, StockInStore.class, Store.class, RawMaterialsInventory.class, RawMaterialTransactions.class,
            ProductsTransactions.class, Address.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(IMSConfiguration imsConfiguration) {
            logger.info("Configuring database ...");
            return imsConfiguration.getDatabase();
        }
    };


    @Override
    public void initialize(Bootstrap<IMSConfiguration> bootstrap) {
        bootstrap.addBundle(hibernate);

        bootstrap.addBundle(new SwaggerBundle<IMSConfiguration>() {
            @Override
            public SwaggerBundleConfiguration getSwaggerBundleConfiguration(IMSConfiguration configuration) {
                return configuration.getSwagger();
            }
        });
    }

    @Override
    public void run(IMSConfiguration config, Environment environment) throws Exception {
        logger.info("Starting Up the bStat IMS Application ... ");
        Validator validator = environment.getValidator();

        // ---------- register metrics ---------
        MetricRegistry metricRegistry = environment.metrics();
        MetricsService.setRegistry(metricRegistry);
        JmxReporter.forRegistry(environment.metrics()).build().start();

        Injector injector = Guice.createInjector(new IMSModule(hibernate, config, validator, metricRegistry));
        GuiceInjector.assignInjector(injector);

        //------- registering app resources -----------
        environment.jersey().register(injector.getInstance(DataResource.class));
        environment.jersey().register(injector.getInstance(HelloWorldResource.class));

        environment.lifecycle().manage(injector.getInstance(IMSManagedService.class));
    }
}