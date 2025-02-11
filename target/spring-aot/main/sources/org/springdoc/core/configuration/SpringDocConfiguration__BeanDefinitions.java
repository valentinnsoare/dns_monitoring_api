package org.springdoc.core.configuration;

import java.util.Optional;
import org.springdoc.core.converters.AdditionalModelsConverter;
import org.springdoc.core.converters.FileSupportConverter;
import org.springdoc.core.converters.ModelConverterRegistrar;
import org.springdoc.core.converters.PolymorphicModelConverter;
import org.springdoc.core.converters.ResponseSupportConverter;
import org.springdoc.core.converters.SchemaPropertyDeprecatingConverter;
import org.springdoc.core.converters.WebFluxSupportConverter;
import org.springdoc.core.customizers.GlobalOpenApiCustomizer;
import org.springdoc.core.customizers.GlobalOperationCustomizer;
import org.springdoc.core.customizers.SpringDocCustomizers;
import org.springdoc.core.discoverer.SpringDocParameterNameDiscoverer;
import org.springdoc.core.parsers.ReturnTypeParser;
import org.springdoc.core.properties.SpringDocConfigProperties;
import org.springdoc.core.providers.ObjectMapperProvider;
import org.springdoc.core.providers.SpringDataWebPropertiesProvider;
import org.springdoc.core.providers.SpringDocProviders;
import org.springdoc.core.providers.WebConversionServiceProvider;
import org.springdoc.core.service.GenericParameterService;
import org.springdoc.core.service.OpenAPIService;
import org.springdoc.core.service.OperationService;
import org.springdoc.core.service.RequestBodyService;
import org.springdoc.core.service.SecurityService;
import org.springdoc.core.utils.PropertyResolverUtils;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointProperties;
import org.springframework.context.MessageSource;

/**
 * Bean definitions for {@link SpringDocConfiguration}.
 */
public class SpringDocConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'springDocConfiguration'.
   */
  public static BeanDefinition getSpringDocConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SpringDocConfiguration.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(SpringDocConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean definition for 'springdocBeanFactoryPostProcessor'.
   */
  public static BeanDefinition getSpringdocBeanFactoryPostProcessorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SpringDocConfiguration.class);
    beanDefinition.setTargetType(BeanFactoryPostProcessor.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(BeanInstanceSupplier.<BeanFactoryPostProcessor>forFactoryMethod(SpringDocConfiguration.class, "springdocBeanFactoryPostProcessor").withGenerator((registeredBean) -> SpringDocConfiguration.springdocBeanFactoryPostProcessor()));
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'localSpringDocParameterNameDiscoverer'.
   */
  private static BeanInstanceSupplier<SpringDocParameterNameDiscoverer> getLocalSpringDocParameterNameDiscovererInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SpringDocParameterNameDiscoverer>forFactoryMethod(SpringDocConfiguration.class, "localSpringDocParameterNameDiscoverer")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(SpringDocConfiguration.class).localSpringDocParameterNameDiscoverer());
  }

  /**
   * Get the bean definition for 'localSpringDocParameterNameDiscoverer'.
   */
  public static BeanDefinition getLocalSpringDocParameterNameDiscovererBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SpringDocParameterNameDiscoverer.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(getLocalSpringDocParameterNameDiscovererInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'additionalModelsConverter'.
   */
  private static BeanInstanceSupplier<AdditionalModelsConverter> getAdditionalModelsConverterInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<AdditionalModelsConverter>forFactoryMethod(SpringDocConfiguration.class, "additionalModelsConverter", ObjectMapperProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SpringDocConfiguration.class).additionalModelsConverter(args.get(0)));
  }

  /**
   * Get the bean definition for 'additionalModelsConverter'.
   */
  public static BeanDefinition getAdditionalModelsConverterBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AdditionalModelsConverter.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(getAdditionalModelsConverterInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'fileSupportConverter'.
   */
  private static BeanInstanceSupplier<FileSupportConverter> getFileSupportConverterInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<FileSupportConverter>forFactoryMethod(SpringDocConfiguration.class, "fileSupportConverter", ObjectMapperProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SpringDocConfiguration.class).fileSupportConverter(args.get(0)));
  }

  /**
   * Get the bean definition for 'fileSupportConverter'.
   */
  public static BeanDefinition getFileSupportConverterBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(FileSupportConverter.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(getFileSupportConverterInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'responseSupportConverter'.
   */
  private static BeanInstanceSupplier<ResponseSupportConverter> getResponseSupportConverterInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ResponseSupportConverter>forFactoryMethod(SpringDocConfiguration.class, "responseSupportConverter", ObjectMapperProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SpringDocConfiguration.class).responseSupportConverter(args.get(0)));
  }

  /**
   * Get the bean definition for 'responseSupportConverter'.
   */
  public static BeanDefinition getResponseSupportConverterBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ResponseSupportConverter.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(getResponseSupportConverterInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'schemaPropertyDeprecatingConverter'.
   */
  private static BeanInstanceSupplier<SchemaPropertyDeprecatingConverter> getSchemaPropertyDeprecatingConverterInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SchemaPropertyDeprecatingConverter>forFactoryMethod(SpringDocConfiguration.class, "schemaPropertyDeprecatingConverter")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(SpringDocConfiguration.class).schemaPropertyDeprecatingConverter());
  }

  /**
   * Get the bean definition for 'schemaPropertyDeprecatingConverter'.
   */
  public static BeanDefinition getSchemaPropertyDeprecatingConverterBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SchemaPropertyDeprecatingConverter.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(getSchemaPropertyDeprecatingConverterInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'polymorphicModelConverter'.
   */
  private static BeanInstanceSupplier<PolymorphicModelConverter> getPolymorphicModelConverterInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<PolymorphicModelConverter>forFactoryMethod(SpringDocConfiguration.class, "polymorphicModelConverter", ObjectMapperProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SpringDocConfiguration.class).polymorphicModelConverter(args.get(0)));
  }

  /**
   * Get the bean definition for 'polymorphicModelConverter'.
   */
  public static BeanDefinition getPolymorphicModelConverterBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PolymorphicModelConverter.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(getPolymorphicModelConverterInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'openAPIBuilder'.
   */
  private static BeanInstanceSupplier<OpenAPIService> getOpenAPIBuilderInstanceSupplier() {
    return BeanInstanceSupplier.<OpenAPIService>forFactoryMethod(SpringDocConfiguration.class, "openAPIBuilder", Optional.class, SecurityService.class, SpringDocConfigProperties.class, PropertyResolverUtils.class, Optional.class, Optional.class, Optional.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SpringDocConfiguration.class).openAPIBuilder(args.get(0), args.get(1), args.get(2), args.get(3), args.get(4), args.get(5), args.get(6)));
  }

  /**
   * Get the bean definition for 'openAPIBuilder'.
   */
  public static BeanDefinition getOpenAPIBuilderBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(OpenAPIService.class);
    beanDefinition.setScope("prototype");
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(getOpenAPIBuilderInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'modelConverterRegistrar'.
   */
  private static BeanInstanceSupplier<ModelConverterRegistrar> getModelConverterRegistrarInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ModelConverterRegistrar>forFactoryMethod(SpringDocConfiguration.class, "modelConverterRegistrar", Optional.class, SpringDocConfigProperties.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SpringDocConfiguration.class).modelConverterRegistrar(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'modelConverterRegistrar'.
   */
  public static BeanDefinition getModelConverterRegistrarBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ModelConverterRegistrar.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(getModelConverterRegistrarInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'operationBuilder'.
   */
  private static BeanInstanceSupplier<OperationService> getOperationBuilderInstanceSupplier() {
    return BeanInstanceSupplier.<OperationService>forFactoryMethod(SpringDocConfiguration.class, "operationBuilder", GenericParameterService.class, RequestBodyService.class, SecurityService.class, PropertyResolverUtils.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SpringDocConfiguration.class).operationBuilder(args.get(0), args.get(1), args.get(2), args.get(3)));
  }

  /**
   * Get the bean definition for 'operationBuilder'.
   */
  public static BeanDefinition getOperationBuilderBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(OperationService.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(getOperationBuilderInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'propertyResolverUtils'.
   */
  private static BeanInstanceSupplier<PropertyResolverUtils> getPropertyResolverUtilsInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<PropertyResolverUtils>forFactoryMethod(SpringDocConfiguration.class, "propertyResolverUtils", ConfigurableBeanFactory.class, MessageSource.class, SpringDocConfigProperties.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SpringDocConfiguration.class).propertyResolverUtils(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'propertyResolverUtils'.
   */
  public static BeanDefinition getPropertyResolverUtilsBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PropertyResolverUtils.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(getPropertyResolverUtilsInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'requestBodyBuilder'.
   */
  private static BeanInstanceSupplier<RequestBodyService> getRequestBodyBuilderInstanceSupplier() {
    return BeanInstanceSupplier.<RequestBodyService>forFactoryMethod(SpringDocConfiguration.class, "requestBodyBuilder", GenericParameterService.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SpringDocConfiguration.class).requestBodyBuilder(args.get(0)));
  }

  /**
   * Get the bean definition for 'requestBodyBuilder'.
   */
  public static BeanDefinition getRequestBodyBuilderBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RequestBodyService.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(getRequestBodyBuilderInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'securityParser'.
   */
  private static BeanInstanceSupplier<SecurityService> getSecurityParserInstanceSupplier() {
    return BeanInstanceSupplier.<SecurityService>forFactoryMethod(SpringDocConfiguration.class, "securityParser", PropertyResolverUtils.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SpringDocConfiguration.class).securityParser(args.get(0)));
  }

  /**
   * Get the bean definition for 'securityParser'.
   */
  public static BeanDefinition getSecurityParserBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SecurityService.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(getSecurityParserInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'genericReturnTypeParser'.
   */
  private static BeanInstanceSupplier<ReturnTypeParser> getGenericReturnTypeParserInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ReturnTypeParser>forFactoryMethod(SpringDocConfiguration.class, "genericReturnTypeParser")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(SpringDocConfiguration.class).genericReturnTypeParser());
  }

  /**
   * Get the bean definition for 'genericReturnTypeParser'.
   */
  public static BeanDefinition getGenericReturnTypeParserBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ReturnTypeParser.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(getGenericReturnTypeParserInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'parameterBuilder'.
   */
  private static BeanInstanceSupplier<GenericParameterService> getParameterBuilderInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<GenericParameterService>forFactoryMethod(SpringDocConfiguration.class, "parameterBuilder", PropertyResolverUtils.class, Optional.class, Optional.class, ObjectMapperProvider.class, Optional.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SpringDocConfiguration.class).parameterBuilder(args.get(0), args.get(1), args.get(2), args.get(3), args.get(4)));
  }

  /**
   * Get the bean definition for 'parameterBuilder'.
   */
  public static BeanDefinition getParameterBuilderBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(GenericParameterService.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(getParameterBuilderInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'springDocProviders'.
   */
  private static BeanInstanceSupplier<SpringDocProviders> getSpringDocProvidersInstanceSupplier() {
    return BeanInstanceSupplier.<SpringDocProviders>forFactoryMethod(SpringDocConfiguration.class, "springDocProviders", Optional.class, Optional.class, Optional.class, Optional.class, Optional.class, Optional.class, Optional.class, ObjectMapperProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SpringDocConfiguration.class).springDocProviders(args.get(0), args.get(1), args.get(2), args.get(3), args.get(4), args.get(5), args.get(6), args.get(7)));
  }

  /**
   * Get the bean definition for 'springDocProviders'.
   */
  public static BeanDefinition getSpringDocProvidersBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SpringDocProviders.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(getSpringDocProvidersInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'springdocObjectMapperProvider'.
   */
  private static BeanInstanceSupplier<ObjectMapperProvider> getSpringdocObjectMapperProviderInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ObjectMapperProvider>forFactoryMethod(SpringDocConfiguration.class, "springdocObjectMapperProvider", SpringDocConfigProperties.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SpringDocConfiguration.class).springdocObjectMapperProvider(args.get(0)));
  }

  /**
   * Get the bean definition for 'springdocObjectMapperProvider'.
   */
  public static BeanDefinition getSpringdocObjectMapperProviderBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ObjectMapperProvider.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(getSpringdocObjectMapperProviderInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'springDocCustomizers'.
   */
  private static BeanInstanceSupplier<SpringDocCustomizers> getSpringDocCustomizersInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SpringDocCustomizers>forFactoryMethod(SpringDocConfiguration.class, "springDocCustomizers", Optional.class, Optional.class, Optional.class, Optional.class, Optional.class, Optional.class, Optional.class, Optional.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SpringDocConfiguration.class).springDocCustomizers(args.get(0), args.get(1), args.get(2), args.get(3), args.get(4), args.get(5), args.get(6), args.get(7)));
  }

  /**
   * Get the bean definition for 'springDocCustomizers'.
   */
  public static BeanDefinition getSpringDocCustomizersBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SpringDocCustomizers.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(getSpringDocCustomizersInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link SpringDocConfiguration.OpenApiResourceAdvice}.
   */
  public static class OpenApiResourceAdvice {
    /**
     * Get the bean instance supplier for 'org.springdoc.core.configuration.SpringDocConfiguration$OpenApiResourceAdvice'.
     */
    private static BeanInstanceSupplier<SpringDocConfiguration.OpenApiResourceAdvice> getOpenApiResourceAdviceInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<SpringDocConfiguration.OpenApiResourceAdvice>forConstructor()
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SpringDocConfiguration.class).new OpenApiResourceAdvice());
    }

    /**
     * Get the bean definition for 'openApiResourceAdvice'.
     */
    public static BeanDefinition getOpenApiResourceAdviceBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(SpringDocConfiguration.OpenApiResourceAdvice.class);
      beanDefinition.setInstanceSupplier(getOpenApiResourceAdviceInstanceSupplier());
      return beanDefinition;
    }
  }

  /**
   * Bean definitions for {@link SpringDocConfiguration.SpringDocSpringDataWebPropertiesProvider}.
   */
  public static class SpringDocSpringDataWebPropertiesProvider {
    /**
     * Get the bean definition for 'springDocSpringDataWebPropertiesProvider'.
     */
    public static BeanDefinition getSpringDocSpringDataWebPropertiesProviderBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(SpringDocConfiguration.SpringDocSpringDataWebPropertiesProvider.class);
      beanDefinition.setInstanceSupplier(SpringDocConfiguration.SpringDocSpringDataWebPropertiesProvider::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'springDataWebPropertiesProvider'.
     */
    private static BeanInstanceSupplier<SpringDataWebPropertiesProvider> getSpringDataWebPropertiesProviderInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<SpringDataWebPropertiesProvider>forFactoryMethod(SpringDocConfiguration.SpringDocSpringDataWebPropertiesProvider.class, "springDataWebPropertiesProvider", Optional.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SpringDocConfiguration.SpringDocSpringDataWebPropertiesProvider.class).springDataWebPropertiesProvider(args.get(0)));
    }

    /**
     * Get the bean definition for 'springDataWebPropertiesProvider'.
     */
    public static BeanDefinition getSpringDataWebPropertiesProviderBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(SpringDataWebPropertiesProvider.class);
      beanDefinition.setLazyInit(false);
      beanDefinition.setInstanceSupplier(getSpringDataWebPropertiesProviderInstanceSupplier());
      return beanDefinition;
    }
  }

  /**
   * Bean definitions for {@link SpringDocConfiguration.WebConversionServiceConfiguration}.
   */
  public static class WebConversionServiceConfiguration {
    /**
     * Get the bean definition for 'webConversionServiceConfiguration'.
     */
    public static BeanDefinition getWebConversionServiceConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(SpringDocConfiguration.WebConversionServiceConfiguration.class);
      beanDefinition.setInstanceSupplier(SpringDocConfiguration.WebConversionServiceConfiguration::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'webConversionServiceProvider'.
     */
    private static BeanInstanceSupplier<WebConversionServiceProvider> getWebConversionServiceProviderInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<WebConversionServiceProvider>forFactoryMethod(SpringDocConfiguration.WebConversionServiceConfiguration.class, "webConversionServiceProvider")
              .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(SpringDocConfiguration.WebConversionServiceConfiguration.class).webConversionServiceProvider());
    }

    /**
     * Get the bean definition for 'webConversionServiceProvider'.
     */
    public static BeanDefinition getWebConversionServiceProviderBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(WebConversionServiceProvider.class);
      beanDefinition.setLazyInit(false);
      beanDefinition.setInstanceSupplier(getWebConversionServiceProviderInstanceSupplier());
      return beanDefinition;
    }
  }

  /**
   * Bean definitions for {@link SpringDocConfiguration.SpringDocActuatorConfiguration}.
   */
  public static class SpringDocActuatorConfiguration {
    /**
     * Get the bean definition for 'springDocActuatorConfiguration'.
     */
    public static BeanDefinition getSpringDocActuatorConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(SpringDocConfiguration.SpringDocActuatorConfiguration.class);
      beanDefinition.setInstanceSupplier(SpringDocConfiguration.SpringDocActuatorConfiguration::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'actuatorCustomizer'.
     */
    private static BeanInstanceSupplier<GlobalOperationCustomizer> getActuatorCustomizerInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<GlobalOperationCustomizer>forFactoryMethod(SpringDocConfiguration.SpringDocActuatorConfiguration.class, "actuatorCustomizer", SpringDocConfigProperties.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SpringDocConfiguration.SpringDocActuatorConfiguration.class).actuatorCustomizer(args.get(0)));
    }

    /**
     * Get the bean definition for 'actuatorCustomizer'.
     */
    public static BeanDefinition getActuatorCustomizerBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(GlobalOperationCustomizer.class);
      beanDefinition.setLazyInit(false);
      beanDefinition.setInstanceSupplier(getActuatorCustomizerInstanceSupplier());
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'actuatorOpenApiCustomizer'.
     */
    private static BeanInstanceSupplier<GlobalOpenApiCustomizer> getActuatorOpenApiCustomizerInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<GlobalOpenApiCustomizer>forFactoryMethod(SpringDocConfiguration.SpringDocActuatorConfiguration.class, "actuatorOpenApiCustomizer", WebEndpointProperties.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SpringDocConfiguration.SpringDocActuatorConfiguration.class).actuatorOpenApiCustomizer(args.get(0)));
    }

    /**
     * Get the bean definition for 'actuatorOpenApiCustomizer'.
     */
    public static BeanDefinition getActuatorOpenApiCustomizerBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(GlobalOpenApiCustomizer.class);
      beanDefinition.setLazyInit(false);
      beanDefinition.setInstanceSupplier(getActuatorOpenApiCustomizerInstanceSupplier());
      return beanDefinition;
    }
  }

  /**
   * Bean definitions for {@link SpringDocConfiguration.SpringDocWebFluxSupportConfiguration}.
   */
  public static class SpringDocWebFluxSupportConfiguration {
    /**
     * Get the bean definition for 'springDocWebFluxSupportConfiguration'.
     */
    public static BeanDefinition getSpringDocWebFluxSupportConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(SpringDocConfiguration.SpringDocWebFluxSupportConfiguration.class);
      beanDefinition.setInstanceSupplier(SpringDocConfiguration.SpringDocWebFluxSupportConfiguration::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'webFluxSupportConverter'.
     */
    private static BeanInstanceSupplier<WebFluxSupportConverter> getWebFluxSupportConverterInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<WebFluxSupportConverter>forFactoryMethod(SpringDocConfiguration.SpringDocWebFluxSupportConfiguration.class, "webFluxSupportConverter", ObjectMapperProvider.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SpringDocConfiguration.SpringDocWebFluxSupportConfiguration.class).webFluxSupportConverter(args.get(0)));
    }

    /**
     * Get the bean definition for 'webFluxSupportConverter'.
     */
    public static BeanDefinition getWebFluxSupportConverterBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(WebFluxSupportConverter.class);
      beanDefinition.setLazyInit(false);
      beanDefinition.setInstanceSupplier(getWebFluxSupportConverterInstanceSupplier());
      return beanDefinition;
    }
  }
}
