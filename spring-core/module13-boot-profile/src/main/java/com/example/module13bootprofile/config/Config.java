package com.example.module13bootprofile.config;

import com.example.module13bootprofile.annotationDao.DatabaseReader;
import com.example.module13bootprofile.annotationDao.FileReader;
import com.example.module13bootprofile.annotationDao.Reader;
import com.example.module13bootprofile.annotations.DataBaseAnnotation;
import com.example.module13bootprofile.annotations.FileAnnotation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources(
        @PropertySource("file:app-home/app-default.properties")
)
public class Config {

    @Bean
    @DataBaseAnnotation
    public Reader databaseReader(){
        return new DatabaseReader();
    }

    @Bean
    @FileAnnotation
    public Reader fileReader() {
        return new FileReader();
    }
}
