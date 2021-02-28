package main;

import Services.JewelryService;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) throws Exception{
        try(var c = new AnnotationConfigApplicationContext(ProjectConfig.class)) {
            JewelryService j = c.getBean(JewelryService.class);
            j.addOneJewelry();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
