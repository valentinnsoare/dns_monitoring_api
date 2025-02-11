package org.springframework.boot.autoconfigure.web.reactive;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ReactiveMultipartProperties}.
 */
public class ReactiveMultipartProperties__BeanDefinitions {
  /**
   * Get the bean definition for 'reactiveMultipartProperties'.
   */
  public static BeanDefinition getReactiveMultipartPropertiesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ReactiveMultipartProperties.class);
    beanDefinition.setInstanceSupplier(ReactiveMultipartProperties::new);
    return beanDefinition;
  }
}
