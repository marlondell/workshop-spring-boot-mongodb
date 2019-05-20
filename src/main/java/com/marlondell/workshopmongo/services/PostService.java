package com.marlondell.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marlondell.workshopmongo.domain.Post;
import com.marlondell.workshopmongo.repository.PostRepository;
import com.marlondell.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired 
	PostRepository repo;
	
	
	public Post findById(String id) {
		Optional<Post> obj  = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não Encontrado"));
	}
	
	public List<Post> findByTitle(String text){
		// return repo.findByTitleContainingIgnoreCase(text);
		return repo.searchTitle(text);
	}

}
