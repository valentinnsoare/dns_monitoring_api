package org.springframework.boot.actuate.autoconfigure.observation.web.reactive;

import io.micrometer.core.instrument.config.MeterFilter;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties;

/**
 * Bean definitions for {@link WebFluxObservationAutoConfiguration}.
 */
public class WebFluxObservationAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'webFluxObservationAutoConfiguration'.
   */
  public static BeanDefinition getWebFluxObservationAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(WebFluxObservationAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(WebFluxObservationAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'metricsHttpServerUriTagFilter'.
   */
  private static BeanInstanceSupplier<MeterFilter> getMetricsHttpServerUriTagFilterInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<MeterFilter>forFactoryMethod(WebFluxObservationAutoConfiguration.class, "metricsHttpServerUriTagFilter", MetricsProperties.class, ObservationProperties.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(WebFluxObservationAutoConfiguration.class).metricsHttpServerUriTagFilter(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'metricsHttpServerUriTagFilter'.
   */
  public static BeanDefinition getMetricsHttpServerUriTagFilterBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MeterFilter.class);
    beanDefinition.setInstanceSupplier(getMetricsHttpServerUriTagFilterInstanceSupplier());
    return beanDefinition;
  }
}
