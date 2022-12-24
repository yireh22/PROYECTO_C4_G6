package com.unab.systepos.Dao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.unab.systepos.Models.User;

@Repository
public interface UserDao extends CrudRepository< User, String>  {
    

}
