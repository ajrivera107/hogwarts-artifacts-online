package edu.tcu.cs.hogwartsartifactsonlinecda;

import edu.tcu.cs.hogwartsartifactsonlinecda.artifact.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HogwartsArtifactsOnlineCdaApplication {

    public static void main(String[] args) {

        SpringApplication.run(HogwartsArtifactsOnlineCdaApplication.class, args);
    }

    @Bean
    public IdWorker idWorker() {
        return new IdWorker(1, 1);
    }

}
