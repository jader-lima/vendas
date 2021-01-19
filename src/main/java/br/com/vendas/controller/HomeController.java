package br.com.vendas.controller;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.vendas.model.Pedido;
import br.com.vendas.model.StatusPedido;
import br.com.vendas.repository.PedidoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {

	/*utilizando a httpServlet, o padrão puro
	@GetMapping("/hello")
	public String hello(HttpServletRequest request) {
		request.setAttribute("nome", "Churros magico");
		return "hello";
	}
	*/
	@Autowired
	private PedidoRepository pedidoRepository;
	
//	@PersistenceContext
//	private EntityManager entityManager;
	
	@GetMapping
	public String home(Model model) {		
		/*usando JpaRepository do spring, existem metodos padrão, sem necessitar 
		 * implementar os mais simples*/
		List<Pedido> pedidos = pedidoRepository.findAll();
		model.addAttribute("pedidos", pedidos);		
		return "home";
	}
	
	@GetMapping("/{status}")	
	public String porStatus(@PathVariable("status") String status, Model model) {		
		/*usando JpaRepository do spring, existem metodos padrão, sem necessitar 
		 * implementar os mais simples*/
		
		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));		
		model.addAttribute("pedidos", pedidos);		
		model.addAttribute("status",status);
		return "home";
	}
	
	@ExceptionHandler
	public String onError(IllegalArgumentException exception) {
		return "redirect:/home";
	}
	/*
	@GetMapping("/home")
	public ModelAndView home() {
	    List<Pedido> pedidos = repository.findAll();
	    ModelAndView mv = new ModelAndView("home");
	    mv.addObject("pedidos", pedidos);
	    return mv; 
	}   
	*/
	
}
