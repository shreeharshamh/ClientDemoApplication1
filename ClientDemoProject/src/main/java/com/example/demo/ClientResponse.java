package com.example.demo;

public class ClientResponse {

	private Client client;
	private String message;
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ClientResponse(Client client, String message) {
		super();
		this.client = client;
		this.message = message;
	}
	
}
