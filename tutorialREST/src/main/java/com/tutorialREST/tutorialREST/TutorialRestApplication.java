package com.tutorialREST.tutorialREST;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@SpringBootApplication
public class TutorialRestApplication implements CommandLineRunner
{

	public static void main(String[] args) {
		SpringApplication.run(TutorialRestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
//		SET THE REST API
		RestTemplate restapp = new RestTemplate() ;
		HttpHeaders headers = new HttpHeaders();
		headers.set("KUNCI","5655567575671");
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		String resourceURL = "http://10.0.1.103:8080/users/getAllUser";

		HttpEntity<String> entity = new HttpEntity<String>(headers) ;
		ResponseEntity<String> responseEntity = restapp.exchange(resourceURL, HttpMethod.GET,entity,String.class);

		if(responseEntity.getStatusCode() == HttpStatus.OK) {
			System.out.println(responseEntity);
		}
		else
		{
			System.out.println("Error!!");
		}

		System.out.println("Test REST");



	}

}
