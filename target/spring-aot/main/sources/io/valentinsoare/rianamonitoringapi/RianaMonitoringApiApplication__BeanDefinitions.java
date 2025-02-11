package io.valentinsoare.rianamonitoringapi;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link RianaMonitoringApiApplication}.
 */
public class RianaMonitoringApiApplication__BeanDefinitions {
  /**
   * Get the bean definition for 'rianaMonitoringApiApplication'.
   */
  public static BeanDefinition getRianaMonitoringApiApplicationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RianaMonitoringApiApplication.class);
    beanDefinition.setTargetType(RianaMonitoringApiApplication.class);
    ConfigurationClassUtils.initializeConfigurationClass(RianaMonitoringApiApplication.class);
    beanDefinition.setInstanceSupplier(RianaMonitoringApiApplication$$SpringCGLIB$$0::new);
    return beanDefinition;
  }
}
