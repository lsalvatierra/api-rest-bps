package uy.gub.bps.apirestbps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uy.gub.bps.apirestbps.model.Sala;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Integer> {
}
