
package com.mycompany.library;

import com.mycompany.db.Database;
import com.mycompany.interfaces.DAOUsers;
import com.mycompany.models.Users;
import java.sql.PreparedStatement;
import java.util.List;


public class DAOUsersImpl extends Database implements DAOUsers {

    @Override
    public void registrar(Users user) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("INSERT INTO users (id, name, last_name_p, last_name_m, domicilio, tel, sanctions, sanc money) VALUES(?,?,?,?,?,?,?,?);");
            st.setString(1, user.getId());
            st.setString(2, user.getName());
            st.setString(3, user.getLast_name_p());
            st.setString(4, user.getLast_name_m());
            st.setString(5, user.getDomicilio());
            st.setString(6, user.getTel());
            st.setInt(7, user.getSanctions());
            st.setInt(8, user.getSanc_money());
            st.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void modificar(Users user) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(Users user) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Users> listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
