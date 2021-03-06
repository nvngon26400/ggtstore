package J6Store.service;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import J6Store.entity.FavoriteProduct;

public interface FavoriteProductService {

	FavoriteProduct create(JsonNode favoriteData);
		
	List<FavoriteProduct> findByUsername(String username);
	
	List<FavoriteProduct> findAll();
	
	void delete(Long id);
	
	void deleteById(Long id);
	
	long count();
}
