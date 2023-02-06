package br.com.igor.cartorio.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.igor.cartorio.model.Cartorio;
import br.com.igor.cartorio.model.Certidao;
import br.com.igor.cartorio.service.CartorioService;
import br.com.igor.cartorio.service.CertidaoService;

@Controller
@RequestMapping("/cartorio")
public class CartorioController {

	@Autowired
	private CartorioService cartorioService;

	@Autowired
	private CertidaoService certidaoService;

	@GetMapping("/new")
	public String newCartorio(Model model) {
		Cartorio cartorio = new Cartorio();
		model.addAttribute("cartorio", cartorio);
		return "create-cartorio";
	}

	@PostMapping("/create")
	public String create(@ModelAttribute("cartorio") Cartorio cartorio) {
		cartorioService.saveCartorio(cartorio);
		return "redirect:/cartorio/list-cartorios";
	}

	@GetMapping("/list-cartorios")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView("list-cartorios");
		mv.addObject("cartorios", cartorioService.getAllCartorios());
		return mv;
	}

	@GetMapping("/list-cartorios/{id}")
	public ModelAndView getCartorioById(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("list-cartorios");
		mv.addObject("cartorios", cartorioService.getCartorioById(id));
		return mv;
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Cartorio cartorio = cartorioService.getCartorioById(id);

		model.addAttribute("cartorio", cartorio);

		return "update-cartorio";
	}

	@GetMapping("/certidoes/{id}")
	public String getCertidoes(@PathVariable("id") Long id, Model model) {

		Cartorio cartorio = cartorioService.getCartorioById(id);
		Set<Certidao> certidoes = certidaoService.findByCartorio(cartorio);
		List<Certidao> certidoesAdd = certidaoService.getAllCertidoes();

		model.addAttribute("cartorio", cartorio);
		model.addAttribute("certidoes", certidoes);
		model.addAttribute("certidoesAdd", certidoesAdd);
		Certidao certidao = new Certidao();
		model.addAttribute("certidao", certidao);

		return "list-certidoes";
	}

	@GetMapping("/delete/{id}")
	public String deleteCartorioById(@PathVariable("id") Long id, Model model) {
		Cartorio cartorio = cartorioService.getCartorioById(id);
		cartorioService.deleteCartorioById(id);
		model.addAttribute("cartorio", cartorio);

		return "redirect:/cartorio/list-cartorios";
	}
	
	@RequestMapping(value="/certidoes/{id}", method=RequestMethod.POST)
    public String listCertidoesPost(@PathVariable("id") Long id, Certidao certidaoOp, Model model){
		
		Cartorio cartorio = cartorioService.getCartorioById(id);
		Certidao certidao = certidaoService.getCertidaoById(certidaoOp.getId());
		
		cartorio.getCertidoes().add(certidao);
		certidao.getCartorios().add(cartorio);
		cartorioService.saveCartorio(cartorio);

        return "redirect:/cartorio/certidoes/{id}";
    }
}
