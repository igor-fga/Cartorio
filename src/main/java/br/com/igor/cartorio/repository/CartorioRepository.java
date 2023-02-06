package br.com.igor.cartorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.igor.cartorio.model.Cartorio;

@Repository
public interface CartorioRepository extends JpaRepository<Cartorio, Long> {
	@Query("delete from Cartorio c where c.id=:id") 
	void deleteCartorioById(@Param("id") Long id);
}
