package cn.mty.jts.jtsoa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("cn.mty.jts.jtsoa")
public class JtsOaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JtsOaApplication.class, args);
	}
}
