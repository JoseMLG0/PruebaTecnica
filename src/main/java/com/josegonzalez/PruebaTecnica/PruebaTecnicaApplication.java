package com.josegonzalez.PruebaTecnica;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class PruebaTecnicaApplication {

	public static void main(String[] args) {

		File dotenvFile = new File(".env");
		if (dotenvFile.exists()) {
			Dotenv dotenv = Dotenv.load();
			dotenv.entries().forEach((entry) -> System.setProperty(entry.getKey(), entry.getValue()));
		} else {
			System.out.println(".env no encontrado. Omitiendo carga de variables de entorno desde el archivo.");
			System.out.println(System.getenv("TEST_MYSQL_HOST"));
			System.out.println(System.getenv("TEST_MYSQL_PORT"));
			System.out.println(System.getenv("TEST_MYSQL_DB"));
			System.out.println(System.getenv("TEST_MYSQL_USERNAME"));
			System.out.println(System.getenv("TEST_MYSQL_PASSWORD"));

		}
		SpringApplication.run(PruebaTecnicaApplication.class, args);
	}

}
