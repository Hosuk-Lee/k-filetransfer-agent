package k.filetransfer.agent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class AgentApp {
    public static void main(String[] args) {
        SpringApplication.run(AgentApp.class, args);
    }
}
