package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
        public static void main(String[] args) {
            ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
            FavoritesService favoritesService = context.getBean("favoritesService", FavoritesService.class);
            favoritesService.addtofavor("Беспечный Ангел", "Новый герой");
            favoritesService.addtofavor("Беспечный Ангел", "Новый герой");

            favoritesService.addtofavor( "Алюминиевые огурцы", "Ява");
            favoritesService.addtofavor("Беспечный Ангел", "Яд");


            //favoritesService.removeFromFavorites("Беспечный Ангел");
            //favoritesService.addtoplaylist("Беспечный Ангел");
        }
}
