package org.springframework.boot.actuate.autoconfigure.health;

import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.actuate.endpoint.web.WebEndpointsSupplier;
import org.springframework.boot.actuate.endpoint.web.reactive.AdditionalHealthEndpointPathsWebFluxHandlerMapping;
import org.springframework.boot.actuate.health.HealthEndpointGroups;
import org.springframework.boot.actuate.health.ReactiveHealthContributorRegistry;
import org.springframework.boot.actuate.health.ReactiveHealthEndpointWebExtension;

/**
 * Bean definitions for {@link HealthEndpointReactiveWebExtensionConfiguration}.
 */
public class HealthEndpointReactiveWebExtensionConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'healthEndpointReactiveWebExtensionConfiguration'.
   */
  public static BeanDefinition getHealthEndpointReactiveWebExtensionConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(HealthEndpointReactiveWebExtensionConfiguration.class);
    beanDefinition.setInstanceSupplier(HealthEndpointReactiveWebExtensionConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'reactiveHealthEndpointWebExtension'.
   */
  private static BeanInstanceSupplier<ReactiveHealthEndpointWebExtension> getReactiveHealthEndpointWebExtensionInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ReactiveHealthEndpointWebExtension>forFactoryMethod(HealthEndpointReactiveWebExtensionConfiguration.class, "reactiveHealthEndpointWebExtension", ReactiveHealthContributorRegistry.class, HealthEndpointGroups.class, HealthEndpointProperties.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(HealthEndpointReactiveWebExtensionConfiguration.class).reactiveHealthEndpointWebExtension(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'reactiveHealthEndpointWebExtension'.
   */
  public static BeanDefinition getReactiveHealthEndpointWebExtensionBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ReactiveHealthEndpointWebExtension.class);
    beanDefinition.setInstanceSupplier(getReactiveHealthEndpointWebExtensionInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link HealthEndpointReactiveWebExtensionConfiguration.WebFluxAdditionalHealthEndpointPathsConfiguration}.
   */
  public static class WebFluxAdditionalHealthEndpointPathsConfiguration {
    /**
     * Get the bean definition for 'webFluxAdditionalHealthEndpointPathsConfiguration'.
     */
    public static BeanDefinition getWebFluxAdditionalHealthEndpointPathsConfigurationBeanDefinition(
        ) {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(HealthEndpointReactiveWebExtensionConfiguration.WebFluxAdditionalHealthEndpointPathsConfiguration.class);
      beanDefinition.setInstanceSupplier(HealthEndpointReactiveWebExtensionConfiguration.WebFluxAdditionalHealthEndpointPathsConfiguration::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'healthEndpointWebFluxHandlerMapping'.
     */
    private static BeanInstanceSupplier<AdditionalHealthEndpointPathsWebFluxHandlerMapping> getHealthEndpointWebFluxHandlerMappingInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<AdditionalHealthEndpointPathsWebFluxHandlerMapping>forFactoryMethod(HealthEndpointReactiveWebExtensionConfiguration.WebFluxAdditionalHealthEndpointPathsConfiguration.class, "healthEndpointWebFluxHandlerMapping", WebEndpointsSupplier.class, HealthEndpointGroups.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(HealthEndpointReactiveWebExtensionConfiguration.WebFluxAdditionalHealthEndpointPathsConfiguration.class).healthEndpointWebFluxHandlerMapping(args.get(0), args.get(1)));
    }

    /**
     * Get the bean definition for 'healthEndpointWebFluxHandlerMapping'.
     */
    public static BeanDefinition getHealthEndpointWebFluxHandlerMappingBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(AdditionalHealthEndpointPathsWebFluxHandlerMapping.class);
      beanDefinition.setInstanceSupplier(getHealthEndpointWebFluxHandlerMappingInstanceSupplier());
      return beanDefinition;
    }
  }
}
