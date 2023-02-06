package br.com.igor.cartorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.igor.cartorio.model.Cartorio;
import br.com.igor.cartorio.model.Certidao;
import br.com.igor.cartorio.repository.CartorioRepository;
import br.com.igor.cartorio.repository.CertidaoRepository;

@SpringBootApplication
public class CartorioApplication implements CommandLineRunner {

	
	@Autowired
	private CartorioRepository cartorioRepository;
	
	@Autowired
	private CertidaoRepository certidaoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CartorioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Cartorio cartorio = new Cartorio("Cartorio Teste", "Av. Itaquera");
		
		
		Certidao certidao1 = new Certidao("Certidao 1");
		Certidao certidao2 = new Certidao("Certidao 2");
		Certidao certidao3 = new Certidao("Certidao 3");
		Certidao certidao4 = new Certidao("Certidao 4");
		
		cartorio.getCertidoes().add(certidao1);
		cartorio.getCertidoes().add(certidao2);
		cartorio.getCertidoes().add(certidao3);
		
		certidao1.getCartorios().add(cartorio);
		certidao2.getCartorios().add(cartorio);
		certidao3.getCartorios().add(cartorio);
		
		this.cartorioRepository.save(cartorio);
		this.certidaoRepository.save(certidao4);
	}
}
