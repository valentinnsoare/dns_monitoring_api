package org.springdoc.webflux.core.configuration;

import java.util.List;
import java.util.Optional;
import org.springdoc.core.customizers.SpringDocCustomizers;
import org.springdoc.core.discoverer.SpringDocParameterNameDiscoverer;
import org.springdoc.core.properties.SpringDocConfigProperties;
import org.springdoc.core.providers.ActuatorProvider;
import org.springdoc.core.providers.SpringDocProviders;
import org.springdoc.core.providers.SpringWebProvider;
import org.springdoc.core.service.AbstractRequestService;
import org.springdoc.core.service.GenericParameterService;
import org.springdoc.core.service.GenericResponseService;
import org.springdoc.core.service.OperationService;
import org.springdoc.core.service.RequestBodyService;
import org.springdoc.core.utils.PropertyResolverUtils;
import org.springdoc.webflux.api.OpenApiWebfluxResource;
import org.springdoc.webflux.core.service.RequestService;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.autoconfigure.web.ServerProperties;

/**
 * Bean definitions for {@link SpringDocWebFluxConfiguration}.
 */
public class SpringDocWebFluxConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'springDocWebFluxConfiguration'.
   */
  public static BeanDefinition getSpringDocWebFluxConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SpringDocWebFluxConfiguration.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(SpringDocWebFluxConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'openApiResource'.
   */
  private static BeanInstanceSupplier<OpenApiWebfluxResource> getOpenApiResourceInstanceSupplier() {
    return BeanInstanceSupplier.<OpenApiWebfluxResource>forFactoryMethod(SpringDocWebFluxConfiguration.class, "openApiResource", ObjectFactory.class, AbstractRequestService.class, GenericResponseService.class, OperationService.class, SpringDocConfigProperties.class, SpringDocProviders.class, SpringDocCustomizers.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SpringDocWebFluxConfiguration.class).openApiResource(args.get(0), args.get(1), args.get(2), args.get(3), args.get(4), args.get(5), args.get(6)));
  }

  /**
   * Get the bean definition for 'openApiResource'.
   */
  public static BeanDefinition getOpenApiResourceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(OpenApiWebfluxResource.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(getOpenApiResourceInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'requestBuilder'.
   */
  private static BeanInstanceSupplier<RequestService> getRequestBuilderInstanceSupplier() {
    return BeanInstanceSupplier.<RequestService>forFactoryMethod(SpringDocWebFluxConfiguration.class, "requestBuilder", GenericParameterService.class, RequestBodyService.class, OperationService.class, Optional.class, SpringDocParameterNameDiscoverer.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SpringDocWebFluxConfiguration.class).requestBuilder(args.get(0), args.get(1), args.get(2), args.get(3), args.get(4)));
  }

  /**
   * Get the bean definition for 'requestBuilder'.
   */
  public static BeanDefinition getRequestBuilderBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RequestService.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(getRequestBuilderInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'responseBuilder'.
   */
  private static BeanInstanceSupplier<GenericResponseService> getResponseBuilderInstanceSupplier() {
    return BeanInstanceSupplier.<GenericResponseService>forFactoryMethod(SpringDocWebFluxConfiguration.class, "responseBuilder", OperationService.class, List.class, SpringDocConfigProperties.class, PropertyResolverUtils.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SpringDocWebFluxConfiguration.class).responseBuilder(args.get(0), args.get(1), args.get(2), args.get(3)));
  }

  /**
   * Get the bean definition for 'responseBuilder'.
   */
  public static BeanDefinition getResponseBuilderBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(GenericResponseService.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(getResponseBuilderInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'springWebProvider'.
   */
  private static BeanInstanceSupplier<SpringWebProvider> getSpringWebProviderInstanceSupplier() {
    return BeanInstanceSupplier.<SpringWebProvider>forFactoryMethod(SpringDocWebFluxConfiguration.class, "springWebProvider")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(SpringDocWebFluxConfiguration.class).springWebProvider());
  }

  /**
   * Get the bean definition for 'springWebProvider'.
   */
  public static BeanDefinition getSpringWebProviderBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SpringWebProvider.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(getSpringWebProviderInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link SpringDocWebFluxConfiguration.SpringDocWebFluxActuatorConfiguration}.
   */
  public static class SpringDocWebFluxActuatorConfiguration {
    /**
     * Get the bean definition for 'springDocWebFluxActuatorConfiguration'.
     */
    public static BeanDefinition getSpringDocWebFluxActuatorConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(SpringDocWebFluxConfiguration.SpringDocWebFluxActuatorConfiguration.class);
      beanDefinition.setInstanceSupplier(SpringDocWebFluxConfiguration.SpringDocWebFluxActuatorConfiguration::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'actuatorProvider'.
     */
    private static BeanInstanceSupplier<ActuatorProvider> getActuatorProviderInstanceSupplier() {
      return BeanInstanceSupplier.<ActuatorProvider>forFactoryMethod(SpringDocWebFluxConfiguration.SpringDocWebFluxActuatorConfiguration.class, "actuatorProvider", ServerProperties.class, SpringDocConfigProperties.class, Optional.class, Optional.class, Optional.class, Optional.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SpringDocWebFluxConfiguration.SpringDocWebFluxActuatorConfiguration.class).actuatorProvider(args.get(0), args.get(1), args.get(2), args.get(3), args.get(4), args.get(5)));
    }

    /**
     * Get the bean definition for 'actuatorProvider'.
     */
    public static BeanDefinition getActuatorProviderBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(ActuatorProvider.class);
      beanDefinition.setLazyInit(false);
      beanDefinition.setInstanceSupplier(getActuatorProviderInstanceSupplier());
      return beanDefinition;
    }
  }
}
