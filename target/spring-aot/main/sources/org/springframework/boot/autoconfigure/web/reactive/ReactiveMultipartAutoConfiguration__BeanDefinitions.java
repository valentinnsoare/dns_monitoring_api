package org.springframework.boot.autoconfigure.web.reactive;

import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.web.codec.CodecCustomizer;

/**
 * Bean definitions for {@link ReactiveMultipartAutoConfiguration}.
 */
public class ReactiveMultipartAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'reactiveMultipartAutoConfiguration'.
   */
  public static BeanDefinition getReactiveMultipartAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ReactiveMultipartAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(ReactiveMultipartAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'defaultPartHttpMessageReaderCustomizer'.
   */
  private static BeanInstanceSupplier<CodecCustomizer> getDefaultPartHttpMessageReaderCustomizerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<CodecCustomizer>forFactoryMethod(ReactiveMultipartAutoConfiguration.class, "defaultPartHttpMessageReaderCustomizer", ReactiveMultipartProperties.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(ReactiveMultipartAutoConfiguration.class).defaultPartHttpMessageReaderCustomizer(args.get(0)));
  }

  /**
   * Get the bean definition for 'defaultPartHttpMessageReaderCustomizer'.
   */
  public static BeanDefinition getDefaultPartHttpMessageReaderCustomizerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(CodecCustomizer.class);
    beanDefinition.setInstanceSupplier(getDefaultPartHttpMessageReaderCustomizerInstanceSupplier());
    return beanDefinition;
  }
}
