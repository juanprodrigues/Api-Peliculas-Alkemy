/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.repository;

import java.util.List;
import com.api.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JuanPC
 */

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long>{		
	
	public List<Character> findByName(String name);
	
	public List<Character> findByAge(int age);
	
	public List<Character> findByIdMovie(long idMovie);
}