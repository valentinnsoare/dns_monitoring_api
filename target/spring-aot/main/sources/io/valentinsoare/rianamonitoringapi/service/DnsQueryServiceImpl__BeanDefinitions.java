package io.valentinsoare.rianamonitoringapi.service;

import io.valentinsoare.rianamonitoringapi.config.OracleCloudProperties;
import io.valentinsoare.rianamonitoringapi.config.WebClientConfigGoogle;
import io.valentinsoare.rianamonitoringapi.config.WebClientConfigInfoBlox;
import io.valentinsoare.rianamonitoringapi.util.QueryCache;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link DnsQueryServiceImpl}.
 */
public class DnsQueryServiceImpl__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'dnsQueryServiceImpl'.
   */
  private static BeanInstanceSupplier<DnsQueryServiceImpl> getDnsQueryServiceImplInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<DnsQueryServiceImpl>forConstructor(QueryCache.class, WebClientConfigGoogle.class, WebClientConfigInfoBlox.class, OracleCloudProperties.class)
            .withGenerator((registeredBean, args) -> new DnsQueryServiceImpl(args.get(0), args.get(1), args.get(2), args.get(3)));
  }

  /**
   * Get the bean definition for 'dnsQueryServiceImpl'.
   */
  public static BeanDefinition getDnsQueryServiceImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DnsQueryServiceImpl.class);
    beanDefinition.setInstanceSupplier(getDnsQueryServiceImplInstanceSupplier());
    return beanDefinition;
  }
}
