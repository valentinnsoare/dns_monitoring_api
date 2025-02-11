package org.springframework.boot.autoconfigure.web.reactive;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory;
import org.springframework.http.client.ReactorResourceFactory;

/**
 * Bean definitions for {@link ReactiveWebServerFactoryConfiguration}.
 */
public class ReactiveWebServerFactoryConfiguration__BeanDefinitions {
  /**
   * Bean definitions for {@link ReactiveWebServerFactoryConfiguration.EmbeddedNetty}.
   */
  public static class EmbeddedNetty {
    /**
     * Get the bean definition for 'embeddedNetty'.
     */
    public static BeanDefinition getEmbeddedNettyBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(ReactiveWebServerFactoryConfiguration.EmbeddedNetty.class);
      beanDefinition.setInstanceSupplier(ReactiveWebServerFactoryConfiguration.EmbeddedNetty::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'nettyReactiveWebServerFactory'.
     */
    private static BeanInstanceSupplier<NettyReactiveWebServerFactory> getNettyReactiveWebServerFactoryInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<NettyReactiveWebServerFactory>forFactoryMethod(ReactiveWebServerFactoryConfiguration.EmbeddedNetty.class, "nettyReactiveWebServerFactory", ReactorResourceFactory.class, ObjectProvider.class, ObjectProvider.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(ReactiveWebServerFactoryConfiguration.EmbeddedNetty.class).nettyReactiveWebServerFactory(args.get(0), args.get(1), args.get(2)));
    }

    /**
     * Get the bean definition for 'nettyReactiveWebServerFactory'.
     */
    public static BeanDefinition getNettyReactiveWebServerFactoryBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(NettyReactiveWebServerFactory.class);
      beanDefinition.setInstanceSupplier(getNettyReactiveWebServerFactoryInstanceSupplier());
      return beanDefinition;
    }
  }
}
