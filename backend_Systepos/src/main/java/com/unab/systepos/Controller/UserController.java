package com.unab.systepos.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unab.systepos.Dao.UserDao;
import com.unab.systepos.Models.User;
import com.unab.systepos.Service.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserDao userDao; 
    @Autowired
    private UserService userService;
    
    @PostMapping(value="/")
    public ResponseEntity<User> agregar(@RequestBody User user){        
        User obj = userService.save(user);
        return new ResponseEntity<>(obj, HttpStatus.OK);     
    }
   
    @DeleteMapping(value="/{id}") 
    public ResponseEntity<User> eliminar(@PathVariable String id){ 
        User obj = userService.findById(id); 
        if(obj!=null) 
            userService.delete(id); 
        else 
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR); 
        return new ResponseEntity<>(obj, HttpStatus.OK); 
    }
    
    @PutMapping(value="/") 
    public ResponseEntity<User> editar(@RequestBody User user){ 
        User obj = userService.findById(user.getId_cliente()); 
        if(obj!=null) { 
            obj.setNombre_user(user.getNombre_user());
            obj.setClave_user(user.getClave_user());
            userService.save(obj); 
        } 
        else 
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR); 
        return new ResponseEntity<>(obj, HttpStatus.OK); 
    }
    
    @GetMapping("/list") 
    public List<User> consultarTodo(){
        return userService.findAll(); 
    }
    
    @GetMapping("/list/{id}") 
    public User consultaPorId(@PathVariable String id){ 
        return userService.findById(id); 
    }
    
}
