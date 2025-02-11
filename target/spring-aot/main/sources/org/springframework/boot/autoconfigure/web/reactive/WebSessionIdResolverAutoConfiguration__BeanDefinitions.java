package org.springframework.boot.autoconfigure.web.reactive;

import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.web.server.session.WebSessionIdResolver;

/**
 * Bean definitions for {@link WebSessionIdResolverAutoConfiguration}.
 */
public class WebSessionIdResolverAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'org.springframework.boot.autoconfigure.web.reactive.WebSessionIdResolverAutoConfiguration'.
   */
  private static BeanInstanceSupplier<WebSessionIdResolverAutoConfiguration> getWebSessionIdResolverAutoConfigurationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<WebSessionIdResolverAutoConfiguration>forConstructor(ServerProperties.class, WebFluxProperties.class)
            .withGenerator((registeredBean, args) -> new WebSessionIdResolverAutoConfiguration(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'webSessionIdResolverAutoConfiguration'.
   */
  public static BeanDefinition getWebSessionIdResolverAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(WebSessionIdResolverAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(getWebSessionIdResolverAutoConfigurationInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'webSessionIdResolver'.
   */
  private static BeanInstanceSupplier<WebSessionIdResolver> getWebSessionIdResolverInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<WebSessionIdResolver>forFactoryMethod(WebSessionIdResolverAutoConfiguration.class, "webSessionIdResolver")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(WebSessionIdResolverAutoConfiguration.class).webSessionIdResolver());
  }

  /**
   * Get the bean definition for 'webSessionIdResolver'.
   */
  public static BeanDefinition getWebSessionIdResolverBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(WebSessionIdResolver.class);
    beanDefinition.setInstanceSupplier(getWebSessionIdResolverInstanceSupplier());
    return beanDefinition;
  }
}
