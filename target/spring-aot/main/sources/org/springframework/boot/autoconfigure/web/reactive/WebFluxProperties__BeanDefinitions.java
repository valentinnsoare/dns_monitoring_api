package org.springframework.boot.autoconfigure.web.reactive;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link WebFluxProperties}.
 */
public class WebFluxProperties__BeanDefinitions {
  /**
   * Get the bean definition for 'webFluxProperties'.
   */
  public static BeanDefinition getWebFluxPropertiesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(WebFluxProperties.class);
    beanDefinition.setInstanceSupplier(WebFluxProperties::new);
    return beanDefinition;
  }
}
