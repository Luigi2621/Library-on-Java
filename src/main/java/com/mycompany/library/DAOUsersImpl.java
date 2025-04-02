
package com.mycompany.library;

import com.mycompany.db.Database;
import com.mycompany.interfaces.DAOUsers;
import com.mycompany.models.Users;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DAOUsersImpl extends Database implements DAOUsers {

    @Override
    public void registrar(Users user) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("INSERT INTO users (name, last_name_p, last_name_m, domicilio, tel) VALUES(?,?,?,?,?);");
            //st.setInt(1, user.getId());
            st.setString(1, user.getName());
            st.setString(2, user.getLast_name_p());
            st.setString(3, user.getLast_name_m());
            st.setString(4, user.getDomicilio());
            st.setString(5, user.getTel());
            //st.setInt(6, user.getSanctions());
            //st.setInt(7, user.getSanc_money());
            st.executeUpdate();
            st.close();
            
            
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
        List<Users> lista = null;
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM users;");
            
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
               Users user = new Users();
               user.setId(rs.getInt("id"));
               user.setName(rs.getString("name"));
               user.setLast_name_p(rs.getString("Last_name_p"));
               user.setLast_name_m(rs.getString("Last_name_m"));
               user.setDomicilio(rs.getString("domicilio"));
               user.setTel(rs.getString("tel"));
               user.setSanctions(rs.getInt("sanctions"));
               user.setSanc_money(rs.getInt("sanc_money"));
               lista.add(user);
            }
            rs.close(); //Se cierra el result set
            st.close(); // Se cierra el prepared statement
            
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }
    
}
