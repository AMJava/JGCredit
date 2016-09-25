package lv.javaguru.java2.config;

/**
 * Created by Arturs on 24.09.2016.
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"lv.javaguru.java2"})
public class WebMVCConfig extends WebMvcConfigurerAdapter {
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/js/**")
        .addResourceLocations("/js/");

        registry.addResourceHandler("/styles/**")
        .addResourceLocations("/styles/");

        registry.addResourceHandler("/images/**")
        .addResourceLocations("/images/");

        registry.addResourceHandler("/fonts/**")
        .addResourceLocations("/fonts/");

        registry.addResourceHandler("/assets/**")
        .addResourceLocations("/assets/");
/*
        registry.addResourceHandler("/staticRes*//**")
         .addResourceLocations("/staticRes/css/")
         .addResourceLocations("/staticRes/icons/")
         .addResourceLocations("/staticRes/images/");*/
    }
}
