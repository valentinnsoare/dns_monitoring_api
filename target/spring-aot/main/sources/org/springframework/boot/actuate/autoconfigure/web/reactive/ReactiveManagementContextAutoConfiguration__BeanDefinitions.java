package org.springframework.boot.actuate.autoconfigure.web.reactive;

import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.actuate.autoconfigure.web.ManagementContextFactory;

/**
 * Bean definitions for {@link ReactiveManagementContextAutoConfiguration}.
 */
public class ReactiveManagementContextAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'reactiveManagementContextAutoConfiguration'.
   */
  public static BeanDefinition getReactiveManagementContextAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ReactiveManagementContextAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(ReactiveManagementContextAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean definition for 'reactiveWebChildContextFactory'.
   */
  public static BeanDefinition getReactiveWebChildContextFactoryBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ReactiveManagementContextAutoConfiguration.class);
    beanDefinition.setTargetType(ManagementContextFactory.class);
    beanDefinition.setInstanceSupplier(BeanInstanceSupplier.<ManagementContextFactory>forFactoryMethod(ReactiveManagementContextAutoConfiguration.class, "reactiveWebChildContextFactory").withGenerator((registeredBean) -> ReactiveManagementContextAutoConfiguration.reactiveWebChildContextFactory()));
    return beanDefinition;
  }
}
