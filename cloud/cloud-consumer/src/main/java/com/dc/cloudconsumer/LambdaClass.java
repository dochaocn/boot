package com.dc.cloudconsumer;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.client.loadbalancer.LoadBalancerAutoConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalancerInterceptor;
import org.springframework.cloud.client.loadbalancer.RestTemplateCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class LambdaClass {

    @Bean
    @ConditionalOnMissingBean
    public RestTemplateCustomizer restTemplateCustomizer(
            final LoadBalancerInterceptor loadBalancerInterceptor) {
        return restTemplate -> {
            List<ClientHttpRequestInterceptor> list = new ArrayList<>(
                    restTemplate.getInterceptors());
            list.add(loadBalancerInterceptor);
            restTemplate.setInterceptors(list);
        };
    }

    @Bean
    @ConditionalOnMissingBean
    public RestTemplateCustomizer restTemplateCustomizer1(
            final LoadBalancerInterceptor loadBalancerInterceptor) {
        return new RestTemplateCustomizer() {
            @Override
            public void customize(RestTemplate restTemplate) {
                List<ClientHttpRequestInterceptor> list = new ArrayList<>(
                        restTemplate.getInterceptors());
                list.add(loadBalancerInterceptor);
                restTemplate.setInterceptors(list);
            }
        };
    }

    @Bean
    @ConditionalOnMissingBean
    public RestTemplateCustomizer restTemplateCustomizer2(
            final LoadBalancerInterceptor loadBalancerInterceptor) {
        return new RestTemplateCustomizerImpl(loadBalancerInterceptor);
    }

    class RestTemplateCustomizerImpl implements RestTemplateCustomizer {

        LoadBalancerInterceptor loadBalancerInterceptor;

        RestTemplateCustomizerImpl(LoadBalancerInterceptor loadBalancerInterceptor) {
            this.loadBalancerInterceptor = loadBalancerInterceptor;
        }

        @Override
        public void customize(RestTemplate restTemplate) {
            List<ClientHttpRequestInterceptor> list = new ArrayList<>(
                    restTemplate.getInterceptors());
            list.add(loadBalancerInterceptor);
            restTemplate.setInterceptors(list);
        }
    }



//    @Bean
//    public SmartInitializingSingleton loadBalancedRestTemplateInitializerDeprecated(
//            final ObjectProvider<List<RestTemplateCustomizer>> restTemplateCustomizers) {
//        return () -> restTemplateCustomizers.ifAvailable(customizers -> {
//            for (RestTemplate restTemplate : LoadBalancerAutoConfiguration.restTemplates) {
//                for (RestTemplateCustomizer customizer : customizers) {
//                    customizer.customize(restTemplate);
//                }
//            }
//        });
//    }
//
//    @Bean
//    public SmartInitializingSingleton loadBalancedRestTemplateInitializerDeprecated1(
//            final ObjectProvider<List<RestTemplateCustomizer>> restTemplateCustomizers) {
//        return new SmartInitializingSingleton() {
//            @Override
//            public void afterSingletonsInstantiated() {
//                restTemplateCustomizers.ifAvailable(
//                        new Consumer<List<RestTemplateCustomizer>>() {
//                            @Override
//                            public void accept(List<RestTemplateCustomizer> customizers) {
//                                for (RestTemplate restTemplate : LoadBalancerAutoConfiguration.restTemplates) {
//                                    for (RestTemplateCustomizer customizer : customizers) {
//                                        customizer.customize(restTemplate);
//                                    }
//                                }
//                            }
//                });
//            }
//        };
//    }
//
//    @Bean
//    public SmartInitializingSingleton loadBalancedRestTemplateInitializerDeprecated2(
//            final ObjectProvider<List<RestTemplateCustomizer>> restTemplateCustomizers) {
//        One one = new One(restTemplateCustomizers);
//        one.afterSingletonsInstantiated();
//        return one;
//    }
//
//    class One implements SmartInitializingSingleton{
//        ObjectProvider<List<RestTemplateCustomizer>> restTemplateCustomizers;
//        One(ObjectProvider<List<RestTemplateCustomizer>> restTemplateCustomizers){
//            this.restTemplateCustomizers = restTemplateCustomizers;
//        }
//        @Override
//        public void afterSingletonsInstantiated() {
//            Two two = new Two();
//            restTemplateCustomizers.ifAvailable(two);
//        }
//    }
//
//    class Two implements Consumer<List<RestTemplateCustomizer>>{
//        @Override
//        public void accept(List<RestTemplateCustomizer> customizers) {
//            for (RestTemplate restTemplate : LoadBalancerAutoConfiguration.restTemplates) {
//                for (RestTemplateCustomizer customizer : customizers) {
//                    customizer.customize(restTemplate);
//                }
//            }
//        }
//    }

}
