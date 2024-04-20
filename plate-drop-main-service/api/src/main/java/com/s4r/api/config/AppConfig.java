package com.s4r.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;

@Configuration
public class AppConfig {

    private final Locale defaultLocale;

    public AppConfig(@Value("${app.default-language}") String defaultLanguage) {
        this.defaultLocale = defaultLanguage.equalsIgnoreCase("english")
                ? AppConstants.ENGLISH_LOCALE
                : AppConstants.BANGLA_LOCALE;
    }

    public Locale getDefaultLocale() {
        return defaultLocale;
    }

    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:i18n/messages");
        messageSource.setDefaultEncoding(AppConstants.DEFAULT_ENCODING);
        return messageSource;
    }

    @Bean
    public LocaleResolver localeResolver() {
        AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
        localeResolver.setDefaultLocale(AppConstants.ENGLISH_LOCALE);
        return localeResolver;
    }
}
