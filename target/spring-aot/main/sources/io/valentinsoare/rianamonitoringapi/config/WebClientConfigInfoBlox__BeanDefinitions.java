package io.valentinsoare.rianamonitoringapi.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link WebClientConfigInfoBlox}.
 */
public class WebClientConfigInfoBlox__BeanDefinitions {
  /**
   * Get the bean definition for 'webClientConfigInfoBlox'.
   */
  public static BeanDefinition getWebClientConfigInfoBloxBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(WebClientConfigInfoBlox.class);
    beanDefinition.setTargetType(WebClientConfigInfoBlox.class);
    ConfigurationClassUtils.initializeConfigurationClass(WebClientConfigInfoBlox.class);
    InstanceSupplier<WebClientConfigInfoBlox> instanceSupplier = InstanceSupplier.using(WebClientConfigInfoBlox$$SpringCGLIB$$0::new);
    instanceSupplier = instanceSupplier.andThen(WebClientConfigInfoBlox__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
