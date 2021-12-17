package com.api.service;



import com.api.dto.MovieBasicDTO;
import com.api.dto.MovieDTO;
import java.util.List;
import java.util.Set;

public interface MovieService {

    MovieDTO getDetailsById(Long id);

    List<MovieBasicDTO> getAll();

    List<MovieDTO> getByFilters(String name, String date, Set<Long> cities, String order);

    MovieDTO save(MovieDTO movieDTO);

    MovieDTO update(Long id, MovieDTO movieDTO);

    void addCharacter(Long id, Long idCharacter);

    void removeCharacter(Long id, Long idCharacter);

    void delete(Long id);
}
