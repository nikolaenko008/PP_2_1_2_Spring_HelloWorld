import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);

        // 1. Получаем HelloWorld дважды и сравниваем по ссылке
        HelloWorld hw1 = (HelloWorld) applicationContext.getBean("helloworld");
        HelloWorld hw2 = (HelloWorld) applicationContext.getBean("helloworld");

        System.out.println("HelloWorld ссылки равны: " + (hw1 == hw2));
        // Ожидается: true (singleton — один экземпляр на весь контекст)

        // 2. Получаем Cat дважды и сравниваем по ссылке
        Cat cat1 = (Cat) applicationContext.getBean("cat");
        Cat cat2 = (Cat) applicationContext.getBean("cat");

        System.out.println("Cat ссылки равны: " + (cat1 == cat2));
        // Ожидается: false (prototype — новый экземпляр при каждом запросе)

        applicationContext.close();
    }
}
