package com.example.demo;

import java.util.HashSet;

import org.springframework.stereotype.Repository;

@Repository
public class ClientRepository {

	private HashSet<Client> clientDatabase = new HashSet<Client>();

	public void createClient(Client client) {
		clientDatabase.add(client);
		
	}

	public Client findByMobileNumber(String mobileNumber) {
		Client client = clientDatabase.stream().filter(s -> s.getMobileNumber().equals(mobileNumber)).findAny().orElse(null);
		return client;
	}

	public Client findByIdNumber(String idNumber) {
		Client client = clientDatabase.stream().filter(s -> s.getIdNumber().equals(idNumber)).findAny().orElse(null);
		return client;
		
	}

	public Client updateClient(Client client) {
		
		Client client1 = this.findByIdNumber(client.getIdNumber());
		client1.setFirstName(client.getFirstName());
		client1.setLastName(client.getLastName());
		client1.setMobileNumber(client.getMobileNumber());
		return client1;
	}
}
