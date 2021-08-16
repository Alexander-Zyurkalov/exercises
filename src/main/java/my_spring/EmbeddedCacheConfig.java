//package my_spring;
//
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@EnableCaching
//class EmbeddedCacheConfig {
//
//    @Bean
//    Config config() {
//        Config config = new Config();
//
//        MapConfig mapConfig = new MapConfig();
//        mapConfig.setTimeToLiveSeconds(300);
//        config.getMapConfigs().put("cars", mapConfig);
//
//        return config;
//    }
//}
