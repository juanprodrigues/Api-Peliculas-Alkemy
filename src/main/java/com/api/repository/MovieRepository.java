/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.repository;

import com.api.entity.Movie;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JuanPC
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	List<Movie> findByTitle(String title);

	List<Movie> findByIdGender(Integer idGender);

	@Query("SELECT c FROM Movie c ORDER BY c.createdDate ASC")
	List<Movie> OrdendadoASC();

	@Query("SELECT c FROM Movie c ORDER BY c.createdDate DESC")
	List<Movie> OrdendadoDESC();

}
