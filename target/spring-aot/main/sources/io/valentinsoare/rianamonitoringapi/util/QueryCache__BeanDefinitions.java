package io.valentinsoare.rianamonitoringapi.util;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link QueryCache}.
 */
public class QueryCache__BeanDefinitions {
  /**
   * Get the bean definition for 'queryCache'.
   */
  public static BeanDefinition getQueryCacheBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(QueryCache.class);
    beanDefinition.setInitMethodNames("init");
    beanDefinition.setInstanceSupplier(QueryCache::new);
    return beanDefinition;
  }
}
