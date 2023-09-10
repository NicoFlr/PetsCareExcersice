package com.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface CustomJPARepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

    <S extends T> S save(S entity);
    <S extends T> List<S> saveAll(Iterable<S> entities);

    Optional<T> findById(ID id);

    T getReferenceById(ID id);

    List<T> findAllById(Iterable<ID> ids);

    List<T> findAll();

    void deleteById(ID id);
    void delete(T entity);
    void deleteAllById(Iterable<? extends ID> ids);
    //void deleteAll(Iterable<? extends T> entities);

}
