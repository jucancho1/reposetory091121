/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto3.reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JuanK
 */
@Service
public class ServiciosReservaciones {
    @Autowired
    private RepositorioReservaciones metodosCrud;
    
    public List<Reservaciones> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Reservaciones> getReservaciones(int reservacionesId){
        return metodosCrud.getReservaciones(reservacionesId);
    }
    
    public Reservaciones save(Reservaciones reservaciones){
        if(reservaciones.getIdReservation()==null){
            return metodosCrud.save(reservaciones);
        }else{
            Optional<Reservaciones> e = metodosCrud.getReservaciones(reservaciones.getIdReservation());
            if(e.isEmpty()){
                return metodosCrud.save(reservaciones);
            }else{
                return reservaciones;
            }
        }
    }
    
    public Reservaciones update(Reservaciones reservaciones){
        if(reservaciones.getIdReservation()!=null){
            Optional<Reservaciones> e=metodosCrud.getReservaciones(reservaciones.getIdReservation());
            if(!e.isEmpty()){
                if(reservaciones.getStartDate()!=null){
                    e.get().setStartDate(reservaciones.getStartDate());
                }
                if(reservaciones.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservaciones.getDevolutionDate());
                }
                if(reservaciones.getStatus()!=null){
                    e.get().setStatus(reservaciones.getStatus());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return reservaciones;
            }
        }else{
            return reservaciones;
        }
    }


    public boolean deleteReservaciones(int reservacionesId) {
        Boolean aBoolean = getReservaciones(reservacionesId).map(reservaciones -> {
            metodosCrud.delete(reservaciones);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
