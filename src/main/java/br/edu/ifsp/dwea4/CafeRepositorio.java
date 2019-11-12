package br.edu.ifsp.dwea4;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CafeRepositorio extends JpaRepository<Cafe, Long> {

}
