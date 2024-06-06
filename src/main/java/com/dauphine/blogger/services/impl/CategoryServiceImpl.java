package com.dauphine.blogger.services.impl;

import com.dauphine.blogger.exceptions.CategoryNameAlreadyExistsException;
import com.dauphine.blogger.exceptions.CategoryNotFoundByIdException;
import com.dauphine.blogger.exceptions.CategoryNotFoundByNameException;
import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.repositories.CategoryRepository;
import com.dauphine.blogger.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    private final List<Category> temporaryCategories;

    public CategoryServiceImpl(CategoryRepository repository){
        this.repository = repository;
        this.temporaryCategories = new ArrayList<>();
        temporaryCategories.add(new Category("my first category"));
        temporaryCategories.add(new Category("my second category"));
        temporaryCategories.add(new Category("my third category"));
    }
    @Override
    public List<Category> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Category> getAllByName(String name) {
        return repository.findAllByName(name);
    }

    @Override
    public Category getById(UUID id) throws CategoryNotFoundByIdException {
        return repository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundByIdException(id));
    }

    @Override
    public Category create(String name) throws CategoryNameAlreadyExistsException {
        if(!repository.findAllByName(name).isEmpty()){
            throw new CategoryNameAlreadyExistsException(name);
        }
        Category category = new Category(name);
        return repository.save(category);
    }

    @Override
    public Category update(UUID id, String newName) throws CategoryNotFoundByIdException, CategoryNameAlreadyExistsException {
        Category category = getById(id);
        if(!repository.findAllByName(newName).isEmpty()){
            throw new CategoryNameAlreadyExistsException(newName);
        }
        category.setName(newName);
        return repository.save(category);
    }

    @Override
    public void deleteById(UUID id) throws CategoryNotFoundByIdException {
        getById(id);
        repository.deleteById(id);
    }
}
