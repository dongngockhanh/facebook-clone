package com.example.facebookclone.Configuration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

//
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**") // cho phép tất cả các endpoint
//                .allowedOrigins("http://localhost:4200") // chỉ định nguồn được phép
//                .allowedMethods(HttpMethod.GET.name(),"POST") // các phương thức HTTP cho phép
//                .allowedHeaders("*"); // cho phép tất cả các header
//    }
//}
@Configuration
public class WebConfig {
//    @Bean
//    public WebMvcConfigurer corsConfig(){
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                        .allowedOrigins("http://localhost:4200/")
//                        .allowCredentials(true)
//                        .allowedMethods(HttpMethod.GET.name(),
//                                HttpMethod.POST.name())
//                        .allowedHeaders(HttpHeaders.CONTENT_TYPE,
//                                HttpHeaders.AUTHORIZATION);
//            }
//        };
//    }
    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilterFilterRegistrationBean(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:4200");
        config.addAllowedMethod("*");
        config.addAllowedHeader("*");
        source.registerCorsConfiguration("/users/**",config);
        source.registerCorsConfiguration("/**",config);
        FilterRegistrationBean<CorsFilter> bean  = new FilterRegistrationBean<>(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }
}