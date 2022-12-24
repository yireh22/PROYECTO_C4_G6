package com.unab.systepos.Dao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.unab.systepos.Models.Inventary;

@Repository
public interface InventaryDao  extends CrudRepository<Inventary, String> {
    
}
