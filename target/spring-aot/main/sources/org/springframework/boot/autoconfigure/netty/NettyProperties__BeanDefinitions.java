package org.springframework.boot.autoconfigure.netty;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link NettyProperties}.
 */
public class NettyProperties__BeanDefinitions {
  /**
   * Get the bean definition for 'nettyProperties'.
   */
  public static BeanDefinition getNettyPropertiesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(NettyProperties.class);
    beanDefinition.setInstanceSupplier(NettyProperties::new);
    return beanDefinition;
  }
}
