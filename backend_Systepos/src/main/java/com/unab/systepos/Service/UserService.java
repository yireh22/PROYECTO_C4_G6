package com.unab.systepos.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unab.systepos.Dao.UserDao;
import com.unab.systepos.Models.User;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Transactional(readOnly=false)
    public User save(User user) {
        return userDao.save(user);
    }

    @Transactional(readOnly=false)
    public void delete(String id) {
        userDao.deleteById(id);
    }

    @Transactional(readOnly=true)
    public User findById(String id) {
        return userDao.findById(id).orElse(null);
    }

    @Transactional(readOnly=true)
    public List<User> findAll() {
        return (List<User>) userDao.findAll();
    }

}
