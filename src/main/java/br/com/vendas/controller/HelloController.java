package br.com.vendas.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

	/*utilizando a httpServlet, o padrão puro
	@GetMapping("/hello")
	public String hello(HttpServletRequest request) {
		request.setAttribute("nome", "Churros magico");
		return "hello";
	}
	*/
	
	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("nome", "Churros magico");
		return "hello";
	}
}
