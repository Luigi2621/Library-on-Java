
package com.mycompany.interfaces;

import com.mycompany.models.Lendings;
import java.util.List;


public interface DAOLendings {
    public void registrar(Lendings user) throws Exception;
    public void modificar(Lendings user) throws Exception;
    //public void eliminar(Lendings user) throws Exception;
    public List<Lendings> listar() throws Exception;
    }
