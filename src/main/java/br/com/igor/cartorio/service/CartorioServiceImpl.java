package br.com.igor.cartorio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.igor.cartorio.model.Cartorio;
import br.com.igor.cartorio.repository.CartorioRepository;

@Service
public class CartorioServiceImpl implements CartorioService {

	@Autowired
	private CartorioRepository cartorioRepository;

	@Override
	public Cartorio saveCartorio(Cartorio cartorio) {
		return cartorioRepository.save(cartorio);
	}

	@Override
	public List<Cartorio> getAllCartorios() {
		return cartorioRepository.findAll();
	}

	@Override
	public Optional<Cartorio> getCartorioById(Long id) {
		return cartorioRepository.findById(id);
	}

	@Override
	public void deleteCartorioById(Long id) {
		cartorioRepository.deleteById(id);
	}

}
