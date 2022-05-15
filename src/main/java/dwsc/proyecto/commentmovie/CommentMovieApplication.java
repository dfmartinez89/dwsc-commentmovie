package dwsc.proyecto.commentmovie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CommentMovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommentMovieApplication.class, args);
	}

}
