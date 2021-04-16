package br.com.bandtec.nicolegregorio012010663sc2.repositorio;

import br.com.bandtec.nicolegregorio012010663sc2.dominio.Lutadores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LutadoresRepository extends  JpaRepository<Lutadores, Integer> {
}
