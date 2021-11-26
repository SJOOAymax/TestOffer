package com.airfrance.testoffer.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {


  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.ant("/**"))
        .build();
  }


  private ApiInfo metaInfo(){

    ApiInfo apiInfo = new ApiInfoBuilder()
        .title("Test Offer Air France")
        .description("Spring boot application for the test offer Air France")
        .version("1.0")
        .contact(new Contact("Seifeddine JOO","","seifeddine.joo@aymax.fr"))
        .build();

        return null;
  }
}
