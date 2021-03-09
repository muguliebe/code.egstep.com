package com.egstep.code

//import nz.net.ultraq.thymeleaf.LayoutDialect
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Description
import org.thymeleaf.spring5.SpringTemplateEngine
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver
import org.thymeleaf.spring5.view.ThymeleafViewResolver

@Configuration
class BaseConfig {

    @Bean
    fun templateResolver(): SpringResourceTemplateResolver {
        val templateResolver = SpringResourceTemplateResolver()
        templateResolver.prefix = "classpath:/views/"
        templateResolver.characterEncoding = "UTF-8"
        templateResolver.suffix = ".html"
        templateResolver.setTemplateMode("HTML")
        templateResolver.isCacheable = false
        return templateResolver
    }

    @Bean
    fun templateEngine(): SpringTemplateEngine? {
        val templateEngine = SpringTemplateEngine()
        templateEngine.setTemplateResolver(templateResolver())
//        templateEngine.addDialect(LayoutDialect())
        return templateEngine
    }

    @Bean
    @Description("Thymeleaf View Resolver")
    fun viewResolver(): ThymeleafViewResolver? {
        val viewResolver = ThymeleafViewResolver()
        viewResolver.templateEngine = templateEngine()
        viewResolver.characterEncoding = "UTF-8"
        viewResolver.order = 1
        return viewResolver
    }

}
