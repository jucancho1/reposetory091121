
package reto3.reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JuanK
 */
@Repository
public class RepositorioReservaciones {
    @Autowired
    private InterfaceReservaciones crud4;
    
    public List<Reservaciones> getAll(){
        return (List<Reservaciones>) crud4.findAll();
    }
    
    public Optional<Reservaciones> getReservaciones(int id){
        return crud4.findById(id);
    }
    
    public Reservaciones save(Reservaciones reservaciones){
        return crud4.save(reservaciones);
    }
    
    public void delete(Reservaciones reservaciones){
        crud4.delete(reservaciones);
    }
}
