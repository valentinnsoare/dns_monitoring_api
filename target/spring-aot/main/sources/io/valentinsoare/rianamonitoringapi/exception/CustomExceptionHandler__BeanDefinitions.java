package io.valentinsoare.rianamonitoringapi.exception;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link CustomExceptionHandler}.
 */
public class CustomExceptionHandler__BeanDefinitions {
  /**
   * Get the bean definition for 'customExceptionHandler'.
   */
  public static BeanDefinition getCustomExceptionHandlerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(CustomExceptionHandler.class);
    beanDefinition.setInstanceSupplier(CustomExceptionHandler::new);
    return beanDefinition;
  }
}
