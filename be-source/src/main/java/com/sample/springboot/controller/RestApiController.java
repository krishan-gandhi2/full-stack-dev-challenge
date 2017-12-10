package com.sample.springboot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sample.springboot.model.Item;
import com.sample.springboot.model.Repositories;

@RestController
@RequestMapping("/api")
public class RestApiController {

	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	public static final String REST_SERVICE_URI = "https://api.github.com";

	// -------------------Retrieve All
	// Users---------------------------------------------

	@RequestMapping(value = "/repo", method = RequestMethod.GET)
	@CrossOrigin
	public ResponseEntity<List> listAllCommitsByUsers(HttpServletRequest request,
			HttpServletResponse response) {
		String repoName = "angular/angular";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		ResponseEntity<Repositories> usersMap = restTemplate.exchange(REST_SERVICE_URI + "/search/repositories?q=" + repoName,HttpMethod.GET,new HttpEntity<byte[]>(headers),
				Repositories.class);
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "*");
		response.setHeader("Access-Control-Allow-Headers", "*");
		if (usersMap != null) {
			Repositories repositories = usersMap.getBody();
			if (repositories.getItems() != null && repositories.getItems().size() > 0) {
				for (Item item : repositories.getItems()) {
					StringBuilder repoNameTemp = new StringBuilder();
					if (item.getOwner() != null) {
						repoNameTemp.append(item.getOwner().getLogin());
					}
					repoNameTemp.append("/");
					repoNameTemp.append(item.getName());

					if (repoName.equals(repoNameTemp.toString())) {
						ResponseEntity<List> newObject = restTemplate
								.exchange(REST_SERVICE_URI + "/repos/" + repoName + "/commits",HttpMethod.GET,new HttpEntity<byte[]>(headers), List.class);
						return new ResponseEntity<List>(newObject.getBody(), HttpStatus.OK);
					}
				}

			}
		} else {
			System.out.println("No user exist----------");
		}
		return null;
	}

}
