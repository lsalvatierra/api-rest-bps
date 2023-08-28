package uy.gub.bps.apirestbps.service;

import java.util.List;
import java.util.Optional;

public interface BaseService<E> {

    List<E> obtenerTodo();

    Optional<E> obtenerPorId(Long id);

    public E guardar(E entidad);

}
