package org.springframework.boot.autoconfigure.web.reactive;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.autoconfigure.web.ServerProperties;

/**
 * Bean definitions for {@link ReactiveWebServerFactoryAutoConfiguration}.
 */
public class ReactiveWebServerFactoryAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'reactiveWebServerFactoryAutoConfiguration'.
   */
  public static BeanDefinition getReactiveWebServerFactoryAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ReactiveWebServerFactoryAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(ReactiveWebServerFactoryAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'reactiveWebServerFactoryCustomizer'.
   */
  private static BeanInstanceSupplier<ReactiveWebServerFactoryCustomizer> getReactiveWebServerFactoryCustomizerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ReactiveWebServerFactoryCustomizer>forFactoryMethod(ReactiveWebServerFactoryAutoConfiguration.class, "reactiveWebServerFactoryCustomizer", ServerProperties.class, ObjectProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(ReactiveWebServerFactoryAutoConfiguration.class).reactiveWebServerFactoryCustomizer(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'reactiveWebServerFactoryCustomizer'.
   */
  public static BeanDefinition getReactiveWebServerFactoryCustomizerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ReactiveWebServerFactoryCustomizer.class);
    beanDefinition.setInstanceSupplier(getReactiveWebServerFactoryCustomizerInstanceSupplier());
    return beanDefinition;
  }
}
