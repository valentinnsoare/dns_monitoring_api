package io.valentinsoare.rianamonitoringapi.controller;

import io.valentinsoare.rianamonitoringapi.service.DnsQueryServiceImpl;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link DnsQueryController}.
 */
public class DnsQueryController__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'dnsQueryController'.
   */
  private static BeanInstanceSupplier<DnsQueryController> getDnsQueryControllerInstanceSupplier() {
    return BeanInstanceSupplier.<DnsQueryController>forConstructor(DnsQueryServiceImpl.class)
            .withGenerator((registeredBean, args) -> new DnsQueryController(args.get(0)));
  }

  /**
   * Get the bean definition for 'dnsQueryController'.
   */
  public static BeanDefinition getDnsQueryControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DnsQueryController.class);
    beanDefinition.setInstanceSupplier(getDnsQueryControllerInstanceSupplier());
    return beanDefinition;
  }
}
