package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("client/v1/client")
public class ClientController {
	
	@Autowired
	private  ClientService clientService;	
	
	@PostMapping("/create")
	public ClientResponse createClient(@RequestBody Client client) {
		
		return clientService.createNewClient(client);
		
	}
	
	
	@PutMapping("/update")
	public ClientResponse updateClient(@RequestBody Client client) {
		
		return clientService.updateClient(client);
		
	}
	
	@GetMapping("/getByIdNumber/{id}")
	public ClientResponse getByIdNumber(@PathVariable("id") String idNumber ) {
		return  clientService.getClientById(idNumber);
		
	}
//	
//	@Autowired
//	ClientRepository repo;
//	
//	@RequestMapping("/")
//	public String addClient() {
//		return "AddClient";
//	}	
//	
//	@RequestMapping("/details")
//	public String details(ClientDetails clientDetails) {
//		repo.save(clientDetails);
//		return "AddClient";
//	}
//	
//	@RequestMapping("/getdetails")
//	public String getdetails() {
//		return "ViewClient1";
//	}
//	
//	@PostMapping("/getdetails")
//	public ModelAndView getdetails(@RequestParam int cid) {
//		ModelAndView mv = new ModelAndView("Retrieve");
//		ClientDetails clientDetails= repo.findById(cid).orElse(null);
//		mv.addObject(clientDetails);
//		return mv;
//	}
	
//	@RequestMapping("/clients")
//	public String viewClients() {
//		return repo.findAll().toString();
//	}
//	
	
//	@GetMapping("/")
//	public String addClient() {
//		return "AddClient";
//	}
	
//	@PostMapping("/details")
//	public String details(
//			@RequestParam("cfn") String cfn,
//			@RequestParam("cln") String cln,
//			@RequestParam("cid") String cid,
//			@RequestParam("caddr") String caddr,
//			@RequestParam("cph") String cph, ModelMap mm
//			) {
//		mm.put("cfn", cfn);
//		mm.put("cln", cln);
//		mm.put("cid", cid);
//		mm.put("caddr", caddr);
//		mm.put("cph", cph);
//		return "ViewClient";
}
