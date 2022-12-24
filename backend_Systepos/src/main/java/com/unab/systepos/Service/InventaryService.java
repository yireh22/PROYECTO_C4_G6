package com.unab.systepos.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional;

import com.unab.systepos.Dao.CuentaDao;
import com.unab.systepos.Models.Cuenta;

@Service
public class InventaryService {
    @Autowired
    private InventaryDao inventaryDao;
    
    @Transactional(readOnly=false)
    public Inventary save(Inventary inventary) {
        return inventaryDao.save(inventary);
    }
    @Transactional(readOnly=false)
    public void delete(String id) {
        inventaryDao.deleteById(id);;
    }
    @Transactional(readOnly=true)
    public Inventary findById(String id) {
       return inventaryDao.findById(id).orElse(null);
    }
    @Transactional(readOnly=true)
    public List<Inventary> findByAll() {
        return (List<inventary>) inventaryDao.findAll();
    }

}
