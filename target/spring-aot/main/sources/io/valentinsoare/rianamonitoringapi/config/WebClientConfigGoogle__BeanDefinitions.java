package io.valentinsoare.rianamonitoringapi.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link WebClientConfigGoogle}.
 */
public class WebClientConfigGoogle__BeanDefinitions {
  /**
   * Get the bean definition for 'webClientConfigGoogle'.
   */
  public static BeanDefinition getWebClientConfigGoogleBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(WebClientConfigGoogle.class);
    beanDefinition.setTargetType(WebClientConfigGoogle.class);
    ConfigurationClassUtils.initializeConfigurationClass(WebClientConfigGoogle.class);
    InstanceSupplier<WebClientConfigGoogle> instanceSupplier = InstanceSupplier.using(WebClientConfigGoogle$$SpringCGLIB$$0::new);
    instanceSupplier = instanceSupplier.andThen(WebClientConfigGoogle__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
