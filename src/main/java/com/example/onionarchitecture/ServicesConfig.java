package com.example.onionarchitecture;

import com.example.onionarchitecture.application.details.*;
import com.example.onionarchitecture.application.favorites.FavoriteService;
import com.example.onionarchitecture.domain.details.Details;
import com.example.onionarchitecture.domain.favorites.Favorites;
import com.example.onionarchitecture.infrastructure.details.repositories.DetailRepository;
import com.example.onionarchitecture.infrastructure.details.repositories.FavoriteRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServicesConfig {

    @Bean
    public CreateDetailService detailService(){
        return new CreateDetailService(details());
    }

    @Bean
    public UpdateDetailService updateDetailService() {
        return new UpdateDetailService(details());
    }

    @Bean
    public DetailDeleteService detailDeleteService() {
        return new DetailDeleteService(details());
    }

    @Bean
    public Favorites favorites() {
        return new FavoriteRepository();
    }

    @Bean
    public Details details() {
        return new DetailRepository();
    }

    @Bean
    public DetailListService detailListService(Details details, Favorites favorites){
        return new DetailListService(details, favorites);
    }

    @Bean
    public DetailInfoService detailInfoService(Details details, Favorites favorites){
        return new DetailInfoService(details, favorites);
    }

    @Bean
    public FavoriteService favoriteService(Details details, Favorites favorites){
        return new FavoriteService(details, favorites);
    }
}
