package com.github.com.crudjean.service;

import com.github.com.crudjean.dto.CourseDto;
import com.github.com.crudjean.model.Course;
import com.github.com.crudjean.repository.CourseRepository;
import com.github.com.crudjean.service.exceptions.ResourceNotFoundException;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Transactional(readOnly = true)
    public List<CourseDto> findAll() {
        List<Course> list = courseRepository.findAll();
        return list.stream().map(x -> new CourseDto(x)).collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public CourseDto findById(String id) {
        Optional<Course> obj = courseRepository.findById(id);
        Course course = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new CourseDto(course);
    }
    @Transactional
    public CourseDto insert(@NotNull CourseDto dto) {
        Course entity = new Course();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setCategory(dto.getCategory());
        entity = courseRepository.save(entity);
        return new CourseDto(entity);
    }

    @Transactional
    public CourseDto update(String id, CourseDto dto) {
        Course entity = new Course();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setCategory(dto.getCategory());
        entity = courseRepository.save(entity);
        return new CourseDto(entity);
    }


    public void delete(String id) {
        courseRepository.deleteById(id);
    }
}

