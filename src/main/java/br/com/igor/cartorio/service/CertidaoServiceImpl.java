package br.com.igor.cartorio.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.igor.cartorio.model.Cartorio;
import br.com.igor.cartorio.model.Certidao;
import br.com.igor.cartorio.repository.CertidaoRepository;

@Service
public class CertidaoServiceImpl implements CertidaoService {

	@Autowired
	private CertidaoRepository certidaoRepository;
	
	@Override
	public void saveCertidao(Certidao certidao) {
		certidaoRepository.save(certidao);
		
	}

	@Override
	public Set<Certidao> findByCartorio(Cartorio cartorio) {
		return certidaoRepository.findByCartorios(cartorio);
	}

	@Override
	public List<Certidao> getAllCertidoes() {
		return certidaoRepository.findAll();
	}

	@Override
	public Certidao getCertidaoById(Long id) {
	
		Optional<Certidao> certidaoOptional = certidaoRepository.findById(id);
		Certidao certidao = null;

		if (certidaoOptional.isPresent()) {
			certidao = certidaoOptional.get();
		} else {
			throw new RuntimeException("Cartorio Id not found: " + id);
		}

		return certidao;
	}
}
