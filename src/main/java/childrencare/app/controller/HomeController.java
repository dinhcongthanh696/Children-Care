package childrencare.app.controller;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpSession;

import childrencare.app.model.FeedbackModel;
import childrencare.app.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import childrencare.app.model.ServiceCategoryModel;
import childrencare.app.model.ServiceModel;
import childrencare.app.service.ServiceCategoryService;
import childrencare.app.service.ServiceModelService;

@Controller
@RequestMapping(path = "/")
public class HomeController {
	@Autowired
	private ServiceModelService serviceModelService;
	
	@Autowired
	private ServiceCategoryService serviceCategoryService;
	private final int size = 5;

	@Autowired
	private FeedbackService feedbackService;

	public HomeController(ServiceModelService serviceModelService) {
		this.serviceModelService = serviceModelService;
	}

	// start thanh code (dispatch to service carts)
/*	@GetMapping()
	public String getCarts(Model model, HttpSession session,
			@CookieValue(name = "carts", defaultValue = "") String carts) {
		return "index";
	} */

	@GetMapping(path = "/")
	public String getServices(Model model) {
		List<FeedbackModel> feedbacks = feedbackService.getAll();
		List<ServiceModel> services = serviceModelService.getHighestRatedStarServices(size);
		for(ServiceModel service : services) {
			service.setBase64ThumbnailEncode(service.getThumbnail());
		}	
		model.addAttribute("serviceitems", serviceModelService.getHighestRatedStarServices(size));
		model.addAttribute("servicecategories", serviceCategoryService.findAll());
		model.addAttribute("feedbacks", feedbacks);
		return "index";
	} 
	
	@GetMapping("/abc")
	public String toLiveChat() {
		return "live-chat";
	}

	@GetMapping("/thanks")
	public String toThankYou() {
		return "thank_you";
	}

	// end thanh code
}
