package childrencare.app.controller;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import childrencare.app.model.ServiceModel;
import childrencare.app.service.ServiceModelService;

@Controller
@RequestMapping(path = "/")
public class HomeController {
	@Autowired
	private ServiceModelService serviceModelService;
	private final int size = 5;

	public HomeController(ServiceModelService serviceModelService) {
		this.serviceModelService = serviceModelService;
	}
	@GetMapping()
	public String getCarts(Model model, HttpSession session,
			@CookieValue(name = "carts", defaultValue = "") String carts) {
		List<ServiceModel> serviceCarts = (List<ServiceModel>) session.getAttribute("list");
		model.addAttribute("list", serviceCarts);
		return "index";
	}

}
