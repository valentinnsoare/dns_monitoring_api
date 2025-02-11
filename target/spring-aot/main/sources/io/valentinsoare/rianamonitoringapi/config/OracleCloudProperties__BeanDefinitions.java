package io.valentinsoare.rianamonitoringapi.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link OracleCloudProperties}.
 */
public class OracleCloudProperties__BeanDefinitions {
  /**
   * Get the bean definition for 'oracleCloudProperties'.
   */
  public static BeanDefinition getOracleCloudPropertiesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(OracleCloudProperties.class);
    beanDefinition.setTargetType(OracleCloudProperties.class);
    ConfigurationClassUtils.initializeConfigurationClass(OracleCloudProperties.class);
    beanDefinition.setInstanceSupplier(OracleCloudProperties$$SpringCGLIB$$0::new);
    return beanDefinition;
  }
}
