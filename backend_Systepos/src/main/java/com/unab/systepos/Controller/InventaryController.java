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

import com.unab.systepos.Dao.InventaryDao;
import com.unab.systepos.Models.Inventary;
import com.unab.systepos.Service.InventaryService;

@RestController
@CrossOrigin("*")
@RequestMapping("/cuenta")
public class InventaryController {
    
    @Autowired
    private InventaryDao inventaryDao;

    @Autowired
    private InventaryService inventaryService;
    
    @PostMapping(value="/")
    public ResponseEntity<Inventary> agregar(@RequestBody Inventary inventary){        
        Inventary obj = inventaryService.save(cuenta);
        return new ResponseEntity<>(obj, HttpStatus.OK);     
    }
    
    @DeleteMapping(value="/{id}") 
    public ResponseEntity<Inventary> eliminar(@PathVariable String id){ 
        Inventary obj = inventaryService.findById(id); 
        if(obj!=null) 
            inventaryService.delete(id); 
        else 
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR); 
        return new ResponseEntity<>(obj, HttpStatus.OK); 
    }
    
    @PutMapping(value="/") 
    public ResponseEntity<Inventary> editar(@RequestBody Inventary inventary){ 
        Inventary obj = inventaryService.findById(inventary.getId_inventary()); 
        if(obj!=null) {
            
            obj.setSaldo_inventary(inventary.getSaldo_inventary());
            
            inventaryService.save(obj); 
        } 
        else 
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR); 
        return new ResponseEntity<>(obj, HttpStatus.OK); 
    }
    
    @GetMapping("/list")
    public List<Inventary> consultarTodo(){
        return inventaryService.findByAll(); 
    }
    
    @GetMapping("/list/{id}") 
    public Inventary consultaPorId(@PathVariable String id){ 
        return inventaryService.findById(id); 
    }
}
