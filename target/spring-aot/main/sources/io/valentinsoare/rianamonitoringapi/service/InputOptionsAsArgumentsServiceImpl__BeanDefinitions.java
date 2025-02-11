package io.valentinsoare.rianamonitoringapi.service;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link InputOptionsAsArgumentsServiceImpl}.
 */
public class InputOptionsAsArgumentsServiceImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'inputOptionsAsArgumentsServiceImpl'.
   */
  public static BeanDefinition getInputOptionsAsArgumentsServiceImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(InputOptionsAsArgumentsServiceImpl.class);
    beanDefinition.setInstanceSupplier(InputOptionsAsArgumentsServiceImpl::new);
    return beanDefinition;
  }
}
