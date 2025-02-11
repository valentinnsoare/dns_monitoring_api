package org.springframework.boot.actuate.autoconfigure.web.mappings;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.actuate.web.mappings.MappingsEndpoint;
import org.springframework.boot.actuate.web.mappings.reactive.DispatcherHandlersMappingDescriptionProvider;
import org.springframework.context.ApplicationContext;

/**
 * Bean definitions for {@link MappingsEndpointAutoConfiguration}.
 */
public class MappingsEndpointAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'mappingsEndpointAutoConfiguration'.
   */
  public static BeanDefinition getMappingsEndpointAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MappingsEndpointAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(MappingsEndpointAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'mappingsEndpoint'.
   */
  private static BeanInstanceSupplier<MappingsEndpoint> getMappingsEndpointInstanceSupplier() {
    return BeanInstanceSupplier.<MappingsEndpoint>forFactoryMethod(MappingsEndpointAutoConfiguration.class, "mappingsEndpoint", ApplicationContext.class, ObjectProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(MappingsEndpointAutoConfiguration.class).mappingsEndpoint(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'mappingsEndpoint'.
   */
  public static BeanDefinition getMappingsEndpointBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MappingsEndpoint.class);
    beanDefinition.setInstanceSupplier(getMappingsEndpointInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link MappingsEndpointAutoConfiguration.ReactiveWebConfiguration}.
   */
  public static class ReactiveWebConfiguration {
    /**
     * Get the bean definition for 'reactiveWebConfiguration'.
     */
    public static BeanDefinition getReactiveWebConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(MappingsEndpointAutoConfiguration.ReactiveWebConfiguration.class);
      beanDefinition.setInstanceSupplier(MappingsEndpointAutoConfiguration.ReactiveWebConfiguration::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'dispatcherHandlerMappingDescriptionProvider'.
     */
    private static BeanInstanceSupplier<DispatcherHandlersMappingDescriptionProvider> getDispatcherHandlerMappingDescriptionProviderInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<DispatcherHandlersMappingDescriptionProvider>forFactoryMethod(MappingsEndpointAutoConfiguration.ReactiveWebConfiguration.class, "dispatcherHandlerMappingDescriptionProvider")
              .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(MappingsEndpointAutoConfiguration.ReactiveWebConfiguration.class).dispatcherHandlerMappingDescriptionProvider());
    }

    /**
     * Get the bean definition for 'dispatcherHandlerMappingDescriptionProvider'.
     */
    public static BeanDefinition getDispatcherHandlerMappingDescriptionProviderBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(DispatcherHandlersMappingDescriptionProvider.class);
      beanDefinition.setInstanceSupplier(getDispatcherHandlerMappingDescriptionProviderInstanceSupplier());
      return beanDefinition;
    }
  }
}
