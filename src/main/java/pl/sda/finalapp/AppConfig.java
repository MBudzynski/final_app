package pl.sda.finalapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.sda.finalapp.beans.TextProvider;
import pl.sda.finalapp.beans.WelcomeTextService;

@Configuration
public class AppConfig {

    @Bean
    public PasswordEncoder badPasswordEncoder(){
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString().hashCode() + "";
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return (charSequence.toString().hashCode() + "").equals(s);
            }
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public TextProvider goodbyeService(){
        return new WelcomeTextService("goodbye");
    }

    @Bean
    public TextProvider somethingService(){
        return new WelcomeTextService("something");
    }

    @Profile("dev")
    @Bean(name = "welcomeTextService")
    public TextProvider welcomeTextService1(){
        return new WelcomeTextService("1");
    }

    @Profile("default")
    @Bean(name = "welcomeTextService")
    public TextProvider welcomeTextService2(){
        return new WelcomeTextService("2");
    }
}
