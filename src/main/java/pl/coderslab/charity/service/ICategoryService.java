package pl.coderslab.charity.service;

import pl.coderslab.charity.entity.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> findAll();

    Category findById(long id);

    void delete(long id);

    void save(Category category);
}
