package br.com.igor.cartorio.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.igor.cartorio.model.Cartorio;
import br.com.igor.cartorio.model.Certidao;

@Repository
public interface CertidaoRepository extends JpaRepository<Certidao, Long> {
	Set<Certidao> findByCartorios(Cartorio cartorio);
}
