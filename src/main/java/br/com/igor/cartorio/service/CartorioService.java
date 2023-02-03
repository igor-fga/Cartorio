package br.com.igor.cartorio.service;

import java.util.List;
import java.util.Optional;

import br.com.igor.cartorio.model.Cartorio;

public interface CartorioService {
	Cartorio saveCartorio(Cartorio cartorio);
	List<Cartorio> getAllCartorios();	 
	Optional<Cartorio> getCartorioById(Long id);   
    void deleteCartorioById(Long id);
}
