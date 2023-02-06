package br.com.igor.cartorio.service;

import java.util.List;
import java.util.Set;

import br.com.igor.cartorio.model.Cartorio;
import br.com.igor.cartorio.model.Certidao;

public interface CertidaoService {
	void saveCertidao(Certidao certidao);
	Set<Certidao> findByCartorio(Cartorio cartorio);
	List<Certidao> getAllCertidoes();
	Certidao getCertidaoById(Long id); 
}
