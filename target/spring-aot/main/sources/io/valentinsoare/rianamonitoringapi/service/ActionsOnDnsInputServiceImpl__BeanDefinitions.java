package io.valentinsoare.rianamonitoringapi.service;

import io.valentinsoare.rianamonitoringapi.util.QueryCache;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ActionsOnDnsInputServiceImpl}.
 */
public class ActionsOnDnsInputServiceImpl__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'actionsOnDnsInputServiceImpl'.
   */
  private static BeanInstanceSupplier<ActionsOnDnsInputServiceImpl> getActionsOnDnsInputServiceImplInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ActionsOnDnsInputServiceImpl>forConstructor(QueryCache.class, DnsQueryService.class, InputOptionsAsArgumentsService.class)
            .withGenerator((registeredBean, args) -> new ActionsOnDnsInputServiceImpl(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'actionsOnDnsInputServiceImpl'.
   */
  public static BeanDefinition getActionsOnDnsInputServiceImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ActionsOnDnsInputServiceImpl.class);
    beanDefinition.setInstanceSupplier(getActionsOnDnsInputServiceImplInstanceSupplier());
    return beanDefinition;
  }
}
