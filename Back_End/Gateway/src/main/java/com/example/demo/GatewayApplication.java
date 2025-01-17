package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;


@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
	
	/*// routage statique 
	 * @Bean
	 
   RouteLocator routeLocator(RouteLocatorBuilder builder) {
      return builder.routes()
            .route(r -> r.path("/membres/**").uri("lb://Membre-service"))
          .route(r -> r.path("/publications/**").uri("lb://Publication-service"))
           .route(r -> r.path("/evenements/**").uri("lb://Evenement-Service"))
           .route(r -> r.path("/outils/**").uri("lb://Outil-service"))
          .build();
    }
	*/
	//routage dynamique 
	@Bean
	DiscoveryClientRouteDefinitionLocator definitionLocator(
	ReactiveDiscoveryClient rdc,
	DiscoveryLocatorProperties dlp)
	{
	return new DiscoveryClientRouteDefinitionLocator(rdc, dlp);
	}
	
}
