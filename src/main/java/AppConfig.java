import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean(name = "helloworld")
    public HelloWorld getHelloWorld() {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setMessage("Hello World!");
        return helloWorld;
    }

    // Новый бин: POJO Cat, создаётся заново при каждом запросе из контекста
    @Bean(name = "cat")
    @Scope("prototype")
    public Cat getCat() {
        return new Cat();
    }
}
