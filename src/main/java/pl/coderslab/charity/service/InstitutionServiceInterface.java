package pl.coderslab.charity.service;

import pl.coderslab.charity.entity.Institution;

import java.util.List;

public interface InstitutionServiceInterface {

    List<Institution> findAll();

    Institution findById(long id);

    void delete(long id);

    void save(Institution institution);
}
