package org.springframework.boot.actuate.autoconfigure.endpoint.web.reactive;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.CorsEndpointProperties;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointProperties;
import org.springframework.boot.actuate.endpoint.web.EndpointMediaTypes;
import org.springframework.boot.actuate.endpoint.web.WebEndpointsSupplier;
import org.springframework.boot.actuate.endpoint.web.annotation.ControllerEndpointsSupplier;
import org.springframework.boot.actuate.endpoint.web.reactive.ControllerEndpointHandlerMapping;
import org.springframework.boot.actuate.endpoint.web.reactive.WebFluxEndpointHandlerMapping;
import org.springframework.core.env.Environment;

/**
 * Bean definitions for {@link WebFluxEndpointManagementContextConfiguration}.
 */
public class WebFluxEndpointManagementContextConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'webFluxEndpointManagementContextConfiguration'.
   */
  public static BeanDefinition getWebFluxEndpointManagementContextConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(WebFluxEndpointManagementContextConfiguration.class);
    beanDefinition.setInstanceSupplier(WebFluxEndpointManagementContextConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'webEndpointReactiveHandlerMapping'.
   */
  private static BeanInstanceSupplier<WebFluxEndpointHandlerMapping> getWebEndpointReactiveHandlerMappingInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<WebFluxEndpointHandlerMapping>forFactoryMethod(WebFluxEndpointManagementContextConfiguration.class, "webEndpointReactiveHandlerMapping", WebEndpointsSupplier.class, ControllerEndpointsSupplier.class, EndpointMediaTypes.class, CorsEndpointProperties.class, WebEndpointProperties.class, Environment.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(WebFluxEndpointManagementContextConfiguration.class).webEndpointReactiveHandlerMapping(args.get(0), args.get(1), args.get(2), args.get(3), args.get(4), args.get(5)));
  }

  /**
   * Get the bean definition for 'webEndpointReactiveHandlerMapping'.
   */
  public static BeanDefinition getWebEndpointReactiveHandlerMappingBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(WebFluxEndpointHandlerMapping.class);
    beanDefinition.setInstanceSupplier(getWebEndpointReactiveHandlerMappingInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'controllerEndpointHandlerMapping'.
   */
  private static BeanInstanceSupplier<ControllerEndpointHandlerMapping> getControllerEndpointHandlerMappingInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ControllerEndpointHandlerMapping>forFactoryMethod(WebFluxEndpointManagementContextConfiguration.class, "controllerEndpointHandlerMapping", ControllerEndpointsSupplier.class, CorsEndpointProperties.class, WebEndpointProperties.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(WebFluxEndpointManagementContextConfiguration.class).controllerEndpointHandlerMapping(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'controllerEndpointHandlerMapping'.
   */
  public static BeanDefinition getControllerEndpointHandlerMappingBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ControllerEndpointHandlerMapping.class);
    beanDefinition.setInstanceSupplier(getControllerEndpointHandlerMappingInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'serverCodecConfigurerEndpointObjectMapperBeanPostProcessor'.
   */
  private static BeanInstanceSupplier<WebFluxEndpointManagementContextConfiguration.ServerCodecConfigurerEndpointObjectMapperBeanPostProcessor> getServerCodecConfigurerEndpointObjectMapperBeanPostProcessorInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<WebFluxEndpointManagementContextConfiguration.ServerCodecConfigurerEndpointObjectMapperBeanPostProcessor>forFactoryMethod(WebFluxEndpointManagementContextConfiguration.class, "serverCodecConfigurerEndpointObjectMapperBeanPostProcessor", ObjectProvider.class)
            .withGenerator((registeredBean, args) -> WebFluxEndpointManagementContextConfiguration.serverCodecConfigurerEndpointObjectMapperBeanPostProcessor(args.get(0)));
  }

  /**
   * Get the bean definition for 'serverCodecConfigurerEndpointObjectMapperBeanPostProcessor'.
   */
  public static BeanDefinition getServerCodecConfigurerEndpointObjectMapperBeanPostProcessorBeanDefinition(
      ) {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(WebFluxEndpointManagementContextConfiguration.class);
    beanDefinition.setTargetType(WebFluxEndpointManagementContextConfiguration.ServerCodecConfigurerEndpointObjectMapperBeanPostProcessor.class);
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    beanDefinition.setInstanceSupplier(getServerCodecConfigurerEndpointObjectMapperBeanPostProcessorInstanceSupplier());
    return beanDefinition;
  }
}
