package org.springframework.web.reactive.config;

import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.core.ReactiveAdapterRegistry;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.validation.Validator;
import org.springframework.web.reactive.DispatcherHandler;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.accept.RequestedContentTypeResolver;
import org.springframework.web.reactive.function.server.support.HandlerFunctionAdapter;
import org.springframework.web.reactive.function.server.support.RouterFunctionMapping;
import org.springframework.web.reactive.function.server.support.ServerResponseResultHandler;
import org.springframework.web.reactive.resource.ResourceUrlProvider;
import org.springframework.web.reactive.result.SimpleHandlerAdapter;
import org.springframework.web.reactive.result.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.reactive.result.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.reactive.result.method.annotation.ResponseBodyResultHandler;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityResultHandler;
import org.springframework.web.reactive.result.view.ViewResolutionResultHandler;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;
import org.springframework.web.server.WebExceptionHandler;

/**
 * Bean definitions for {@link WebFluxConfigurationSupport}.
 */
public class WebFluxConfigurationSupport__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'webHandler'.
   */
  private static BeanInstanceSupplier<DispatcherHandler> getWebHandlerInstanceSupplier() {
    return BeanInstanceSupplier.<DispatcherHandler>forFactoryMethod(WebFluxConfigurationSupport.class, "webHandler")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(WebFluxConfigurationSupport.class).webHandler());
  }

  /**
   * Get the bean definition for 'webHandler'.
   */
  public static BeanDefinition getWebHandlerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DispatcherHandler.class);
    beanDefinition.setInstanceSupplier(getWebHandlerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'responseStatusExceptionHandler'.
   */
  private static BeanInstanceSupplier<WebExceptionHandler> getResponseStatusExceptionHandlerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<WebExceptionHandler>forFactoryMethod(WebFluxConfigurationSupport.class, "responseStatusExceptionHandler")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(WebFluxConfigurationSupport.class).responseStatusExceptionHandler());
  }

  /**
   * Get the bean definition for 'responseStatusExceptionHandler'.
   */
  public static BeanDefinition getResponseStatusExceptionHandlerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(WebExceptionHandler.class);
    beanDefinition.setInstanceSupplier(getResponseStatusExceptionHandlerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'requestMappingHandlerMapping'.
   */
  private static BeanInstanceSupplier<RequestMappingHandlerMapping> getRequestMappingHandlerMappingInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<RequestMappingHandlerMapping>forFactoryMethod(WebFluxConfigurationSupport.class, "requestMappingHandlerMapping", RequestedContentTypeResolver.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(WebFluxConfigurationSupport.class).requestMappingHandlerMapping(args.get(0)));
  }

  /**
   * Get the bean definition for 'requestMappingHandlerMapping'.
   */
  public static BeanDefinition getRequestMappingHandlerMappingBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RequestMappingHandlerMapping.class);
    beanDefinition.setInstanceSupplier(getRequestMappingHandlerMappingInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'webFluxContentTypeResolver'.
   */
  private static BeanInstanceSupplier<RequestedContentTypeResolver> getWebFluxContentTypeResolverInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<RequestedContentTypeResolver>forFactoryMethod(WebFluxConfigurationSupport.class, "webFluxContentTypeResolver")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(WebFluxConfigurationSupport.class).webFluxContentTypeResolver());
  }

  /**
   * Get the bean definition for 'webFluxContentTypeResolver'.
   */
  public static BeanDefinition getWebFluxContentTypeResolverBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RequestedContentTypeResolver.class);
    beanDefinition.setInstanceSupplier(getWebFluxContentTypeResolverInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'routerFunctionMapping'.
   */
  private static BeanInstanceSupplier<RouterFunctionMapping> getRouterFunctionMappingInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<RouterFunctionMapping>forFactoryMethod(WebFluxConfigurationSupport.class, "routerFunctionMapping", ServerCodecConfigurer.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(WebFluxConfigurationSupport.class).routerFunctionMapping(args.get(0)));
  }

  /**
   * Get the bean definition for 'routerFunctionMapping'.
   */
  public static BeanDefinition getRouterFunctionMappingBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RouterFunctionMapping.class);
    beanDefinition.setInstanceSupplier(getRouterFunctionMappingInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'resourceHandlerMapping'.
   */
  private static BeanInstanceSupplier<HandlerMapping> getResourceHandlerMappingInstanceSupplier() {
    return BeanInstanceSupplier.<HandlerMapping>forFactoryMethod(WebFluxConfigurationSupport.class, "resourceHandlerMapping", ResourceUrlProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(WebFluxConfigurationSupport.class).resourceHandlerMapping(args.get(0)));
  }

  /**
   * Get the bean definition for 'resourceHandlerMapping'.
   */
  public static BeanDefinition getResourceHandlerMappingBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(HandlerMapping.class);
    beanDefinition.setInstanceSupplier(getResourceHandlerMappingInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'resourceUrlProvider'.
   */
  private static BeanInstanceSupplier<ResourceUrlProvider> getResourceUrlProviderInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ResourceUrlProvider>forFactoryMethod(WebFluxConfigurationSupport.class, "resourceUrlProvider")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(WebFluxConfigurationSupport.class).resourceUrlProvider());
  }

  /**
   * Get the bean definition for 'resourceUrlProvider'.
   */
  public static BeanDefinition getResourceUrlProviderBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ResourceUrlProvider.class);
    beanDefinition.setInstanceSupplier(getResourceUrlProviderInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'requestMappingHandlerAdapter'.
   */
  private static BeanInstanceSupplier<RequestMappingHandlerAdapter> getRequestMappingHandlerAdapterInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<RequestMappingHandlerAdapter>forFactoryMethod(WebFluxConfigurationSupport.class, "requestMappingHandlerAdapter", ReactiveAdapterRegistry.class, ServerCodecConfigurer.class, FormattingConversionService.class, Validator.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(WebFluxConfigurationSupport.class).requestMappingHandlerAdapter(args.get(0), args.get(1), args.get(2), args.get(3)));
  }

  /**
   * Get the bean definition for 'requestMappingHandlerAdapter'.
   */
  public static BeanDefinition getRequestMappingHandlerAdapterBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RequestMappingHandlerAdapter.class);
    beanDefinition.setInstanceSupplier(getRequestMappingHandlerAdapterInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'serverCodecConfigurer'.
   */
  private static BeanInstanceSupplier<ServerCodecConfigurer> getServerCodecConfigurerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ServerCodecConfigurer>forFactoryMethod(WebFluxConfigurationSupport.class, "serverCodecConfigurer")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(WebFluxConfigurationSupport.class).serverCodecConfigurer());
  }

  /**
   * Get the bean definition for 'serverCodecConfigurer'.
   */
  public static BeanDefinition getServerCodecConfigurerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ServerCodecConfigurer.class);
    beanDefinition.setInstanceSupplier(getServerCodecConfigurerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'webFluxAdapterRegistry'.
   */
  private static BeanInstanceSupplier<ReactiveAdapterRegistry> getWebFluxAdapterRegistryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ReactiveAdapterRegistry>forFactoryMethod(WebFluxConfigurationSupport.class, "webFluxAdapterRegistry")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(WebFluxConfigurationSupport.class).webFluxAdapterRegistry());
  }

  /**
   * Get the bean definition for 'webFluxAdapterRegistry'.
   */
  public static BeanDefinition getWebFluxAdapterRegistryBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ReactiveAdapterRegistry.class);
    beanDefinition.setInstanceSupplier(getWebFluxAdapterRegistryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'handlerFunctionAdapter'.
   */
  private static BeanInstanceSupplier<HandlerFunctionAdapter> getHandlerFunctionAdapterInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<HandlerFunctionAdapter>forFactoryMethod(WebFluxConfigurationSupport.class, "handlerFunctionAdapter")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(WebFluxConfigurationSupport.class).handlerFunctionAdapter());
  }

  /**
   * Get the bean definition for 'handlerFunctionAdapter'.
   */
  public static BeanDefinition getHandlerFunctionAdapterBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(HandlerFunctionAdapter.class);
    beanDefinition.setInstanceSupplier(getHandlerFunctionAdapterInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'simpleHandlerAdapter'.
   */
  private static BeanInstanceSupplier<SimpleHandlerAdapter> getSimpleHandlerAdapterInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SimpleHandlerAdapter>forFactoryMethod(WebFluxConfigurationSupport.class, "simpleHandlerAdapter")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(WebFluxConfigurationSupport.class).simpleHandlerAdapter());
  }

  /**
   * Get the bean definition for 'simpleHandlerAdapter'.
   */
  public static BeanDefinition getSimpleHandlerAdapterBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SimpleHandlerAdapter.class);
    beanDefinition.setInstanceSupplier(getSimpleHandlerAdapterInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'webFluxWebSocketHandlerAdapter'.
   */
  private static BeanInstanceSupplier<WebSocketHandlerAdapter> getWebFluxWebSocketHandlerAdapterInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<WebSocketHandlerAdapter>forFactoryMethod(WebFluxConfigurationSupport.class, "webFluxWebSocketHandlerAdapter")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(WebFluxConfigurationSupport.class).webFluxWebSocketHandlerAdapter());
  }

  /**
   * Get the bean definition for 'webFluxWebSocketHandlerAdapter'.
   */
  public static BeanDefinition getWebFluxWebSocketHandlerAdapterBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(WebSocketHandlerAdapter.class);
    beanDefinition.setInstanceSupplier(getWebFluxWebSocketHandlerAdapterInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'responseEntityResultHandler'.
   */
  private static BeanInstanceSupplier<ResponseEntityResultHandler> getResponseEntityResultHandlerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ResponseEntityResultHandler>forFactoryMethod(WebFluxConfigurationSupport.class, "responseEntityResultHandler", ReactiveAdapterRegistry.class, ServerCodecConfigurer.class, RequestedContentTypeResolver.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(WebFluxConfigurationSupport.class).responseEntityResultHandler(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'responseEntityResultHandler'.
   */
  public static BeanDefinition getResponseEntityResultHandlerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ResponseEntityResultHandler.class);
    beanDefinition.setInstanceSupplier(getResponseEntityResultHandlerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'responseBodyResultHandler'.
   */
  private static BeanInstanceSupplier<ResponseBodyResultHandler> getResponseBodyResultHandlerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ResponseBodyResultHandler>forFactoryMethod(WebFluxConfigurationSupport.class, "responseBodyResultHandler", ReactiveAdapterRegistry.class, ServerCodecConfigurer.class, RequestedContentTypeResolver.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(WebFluxConfigurationSupport.class).responseBodyResultHandler(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'responseBodyResultHandler'.
   */
  public static BeanDefinition getResponseBodyResultHandlerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ResponseBodyResultHandler.class);
    beanDefinition.setInstanceSupplier(getResponseBodyResultHandlerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'viewResolutionResultHandler'.
   */
  private static BeanInstanceSupplier<ViewResolutionResultHandler> getViewResolutionResultHandlerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ViewResolutionResultHandler>forFactoryMethod(WebFluxConfigurationSupport.class, "viewResolutionResultHandler", ReactiveAdapterRegistry.class, RequestedContentTypeResolver.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(WebFluxConfigurationSupport.class).viewResolutionResultHandler(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'viewResolutionResultHandler'.
   */
  public static BeanDefinition getViewResolutionResultHandlerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ViewResolutionResultHandler.class);
    beanDefinition.setInstanceSupplier(getViewResolutionResultHandlerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'serverResponseResultHandler'.
   */
  private static BeanInstanceSupplier<ServerResponseResultHandler> getServerResponseResultHandlerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ServerResponseResultHandler>forFactoryMethod(WebFluxConfigurationSupport.class, "serverResponseResultHandler", ServerCodecConfigurer.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(WebFluxConfigurationSupport.class).serverResponseResultHandler(args.get(0)));
  }

  /**
   * Get the bean definition for 'serverResponseResultHandler'.
   */
  public static BeanDefinition getServerResponseResultHandlerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ServerResponseResultHandler.class);
    beanDefinition.setInstanceSupplier(getServerResponseResultHandlerInstanceSupplier());
    return beanDefinition;
  }
}
