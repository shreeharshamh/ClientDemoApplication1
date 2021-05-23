package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	public ClientResponse createNewClient(Client client) {
		String message;
		
		 if(( message = validateClient(client))!= "") {
			 return new ClientResponse(null, message);
		 }
		clientRepository.createClient(client);
		return new ClientResponse(client, "");
	}

	private String validateClient(Client client) {
		if(client.getFirstName() == null || client.getFirstName() == "") {
			return "First Name is Required";
		} if(client.getLastName() == null || client.getLastName() == "") {
			return "Last Name is Required";
		} if(client.getIdNumber() == null || client.getIdNumber() == "") {
			return "ID Number is Required";	
		} if(client.getIdNumber().length() != 13) {
			return "Invalid ID Number";
		} if(client.getIdNumber() == null || client.getIdNumber() == "") {
			Client client1 =  clientRepository.findByIdNumber(client.getIdNumber());
			if(client1 != null) {
				return "Duplicate Id Number";
			}
		}
		
		if(client.getMobileNumber() != null || client.getMobileNumber() != "") {
			Client client1 =  clientRepository.findByMobileNumber(client.getMobileNumber());
			if(client1 != null) {
				return "Duplicate Mobile Number";
			}
		}
		return "";
		
	}

	public ClientResponse updateClient(Client client) {
	
		Client client1 = clientRepository.findByIdNumber(client.getIdNumber());
		if(client1 == null) {
			return new ClientResponse(client1, "no client found");
		}
		return new ClientResponse(clientRepository.updateClient(client), "client updated successfully");
	}

	public ClientResponse getClientById(String idNumber) {
		Client client = clientRepository.findByIdNumber(idNumber);
		if(client != null) {
			return new ClientResponse(client, "");
		}
		return new ClientResponse(null, "No client Found with id Number "+idNumber);
	}

}
