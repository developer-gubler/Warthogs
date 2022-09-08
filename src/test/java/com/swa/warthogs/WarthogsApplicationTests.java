package com.swa.warthogs;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.PostgreSQLR2DBCDatabaseContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@SpringBootTest
//@Testcontainers
class WarthogsApplicationTests {

//	private PostgreSQLR2DBCDatabaseContainer container;
	
//	@Container
//	public GenericContainer postgresql = new GenericContainer(DockerImageName.parse("postgres:14.5-alpine"))
//	    .withExposedPorts(5432);
//
//    @BeforeEach
//    public void setUp() {
//        String address = postgresql.getHost();
//        Integer port = postgresql.getFirstMappedPort();
//    }

	@Test
	void getApi() {
		System.out.println("Enter method");
		OkHttpClient client = new OkHttpClient()
								.newBuilder()
								.build();
		System.out.println("MediaType.parse");
		MediaType mediaType = MediaType.parse("text/plain");
		System.out.println("RequestBody.create");
		RequestBody body = RequestBody.create(mediaType, "");
		System.out.println("Request.Builder");
		Request request = new Request.Builder()
		  .url("http://localhost:8080/api")
		  .method("GET", body)
		  .build();
		try {
			System.out.println("execute");
			Response response = client.newCall(request).execute();
			System.out.println(response.body().string());
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	void getProfile() {
		OkHttpClient client = new OkHttpClient().newBuilder()
				  .build();
		MediaType mediaType = MediaType.parse("text/plain");
		RequestBody body = RequestBody.create(mediaType, "");
		Request request = new Request.Builder()
		  .url("http://localhost:8080/api/profile")
		  .method("GET", body)
		  .build();
		try {
			System.out.println("execute");
			Response response = client.newCall(request).execute();
			System.out.println(response.body().string());
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	void getWarthogs() {
		OkHttpClient client = new OkHttpClient().newBuilder()
				  .build();
		MediaType mediaType = MediaType.parse("text/plain");
		RequestBody body = RequestBody.create(mediaType, "");
		Request request = new Request.Builder()
		  .url("http://localhost:8080/api/warthogs")
		  .method("GET", body)
		  .build();
		try {
			System.out.println("execute");
			Response response = client.newCall(request).execute();
			System.out.println(response.body().string());
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	void addWarthog() {
		OkHttpClient client = new OkHttpClient().newBuilder()
				  .build();
		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, "{\"firstName\": \"Daffy\", \"lastName\": \"Duck\"}");
		Request request = new Request.Builder()
		  .url("http://localhost:8080/api/warthogs")
		  .method("POST", body)
		  .addHeader("Content-Type", "application/json")
		  .build();
		try {
			System.out.println("execute");
			Response response = client.newCall(request).execute();
			System.out.println("show body");
			System.out.println(response.body().string());
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	void deleteWarthog() {
		OkHttpClient client = new OkHttpClient().newBuilder()
				  .build();
		MediaType mediaType = MediaType.parse("text/plain");
		RequestBody body = RequestBody.create(mediaType, "");
		Request request = new Request.Builder()
		  .url("http://localhost:8080/api/warthogs/11")
		  .method("DELETE", body)
		  .build();
		try {
			System.out.println("execute");
			Response response = client.newCall(request).execute();
			System.out.println(response.body().string());
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
