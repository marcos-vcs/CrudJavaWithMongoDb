package com.transportadora.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.transportadora.models.CentralEncomenda;
import com.transportadora.models.Destino;
import com.transportadora.models.Entregador;
import com.transportadora.models.Origem;
import com.transportadora.services.EntregadorService;
import com.transportadora.services.EntregasService;

@Controller
public class Controllers {
	
	@Autowired
	EntregadorService serviceEntregador;
	@Autowired
	EntregasService   serviceEncomenda;
	
	  //mapeia o caminho para a home
	  @RequestMapping("/index")
	  public String home() {
		  return "index";
	  }
	
	  //Mapeia a página que cadastra um novo entregador
	  @RequestMapping("/newEntregador")
	  public String formEntregador(Model model) {
		  Entregador modelo = new Entregador();
		  model.addAttribute("modelo",modelo);
		  return "cadastroEntregador";
	  }
	  
	  //Mapeia o html e gera uma lista com os itens do banco que podem ser carregados no thymeleaf
	  //read
	  @RequestMapping("/entregadores")
	  public String entregadores(Model model) {
		  List<Entregador> listEntregadores = serviceEntregador.listAll();
		  model.addAttribute("listEntregadores",listEntregadores);
		  return "listaEntregador";
	  }
	
	  //create entregador
	  @RequestMapping(value = "/saveEntregador", method = RequestMethod.POST)
	  public String saveEntregador(@ModelAttribute ("modelo")Entregador entregador) {
		  serviceEntregador.save(entregador);
		  return "redirect:/entregadores";
	  }
	  
	  //edit entregador
	  @RequestMapping("/editEntregador/{id}")
	  public ModelAndView showEditEntregador(@PathVariable(name = "id")String id) {
		  ModelAndView ent = new ModelAndView("editEntregador");
		  Optional<Entregador> modelo = serviceEntregador.getEntregador(id);
		  ent.addObject("modelo", modelo);
		  return ent;
	  }
	  
	  //delete entregador
	  @RequestMapping("/deleteEntregador/{id}")
	  public String deleteEntregador(@PathVariable(name = "id")String id) {
		  serviceEntregador.delete(id);
		  return "redirect:/entregadores";
	  }
	  
	  //-------------------------------------------------------
	  //DAQUI PRA FRENTE TRATAREMOS DO CONTROLLER DAS ENTREGAS
	  //-------------------------------------------------------
	  
	  //Mapeia a página de cadastro das encomendas
	  @RequestMapping("/newEncomenda")
	  public String formEncomenda(Model entrega) {
		  CentralEncomenda encomenda = new CentralEncomenda();
		  entrega.addAttribute("encomenda", encomenda);
		  return "cadastroEntrega"; 
	  }
	  
	  //Create Encomenda
	  @RequestMapping(value = "/saveEncomenda", method = RequestMethod.POST)
	  public String saveEncomenda(@ModelAttribute ("encomenda")CentralEncomenda encomenda) {
		  serviceEncomenda.save(encomenda);
		  return "redirect:/encomendas";
	  }
	  //Create Origem
	  @RequestMapping(value = "/saveOrigem", method = RequestMethod.POST)
	  public String saveOrigem(@ModelAttribute ("origem")Origem origem) {
		  serviceEncomenda.saveOrigem(origem);
		  return "redirect:/encomendas";
	  } 
	  
	  //Create Destino
	  @RequestMapping(value = "/saveDestino", method = RequestMethod.POST)
	  public String saveDestino(@ModelAttribute ("destino")Destino destino) {
		  serviceEncomenda.saveDestino(destino);
		  return "redirect:/encomendas";
	  }
	  
	  //Mapeia a lista de entregas a serem feitas;
	  @RequestMapping("/encomendas")
	  public String listEncomendas (Model model) {
		  List<Origem> listOrigem = serviceEncomenda.listOrigem();
		  model.addAttribute("listOrigem", listOrigem);
		  
		  List<Destino> listDestino = serviceEncomenda.listDestino();
		  model.addAttribute("listDestino", listDestino);
		  
		  return "listaEntregas";
	  }
	  
	  //delete a destino e a origem
	  @RequestMapping("/deleteEncomenda/{id}")
	  public String deleteEncomenda(@PathVariable(name = "id")String id ){
		  serviceEncomenda.delete(id);
		  return "redirect:/encomendas";
	  }
	  
	  //edtar destino
	  @RequestMapping("/editDestino/{id}")
	  public ModelAndView showEditDestino(@PathVariable(name = "id")String id) {
		  ModelAndView edit = new ModelAndView("editDestino");
		  Optional<Destino> editDestino = serviceEncomenda.getDestino(id);
		  edit.addObject("destino", editDestino);
		  return edit;
	  }
	  
	  //editar origem
	  @RequestMapping("/editOrigem/{id}")
	  public ModelAndView showEditOrigem(@PathVariable(name = "id")String id) {
		  ModelAndView edit = new ModelAndView("editOrigem");
		  Optional<Origem> editOrigem = serviceEncomenda.getOrigem(id);
		  edit.addObject("origem", editOrigem);
		  return edit;
	  }

	  
	   
	  
	  
	}
	