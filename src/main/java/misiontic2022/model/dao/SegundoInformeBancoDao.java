package misiontic2022.model.dao;

import misiontic2022.model.vo.SegundoInformeBancoVo;
import misiontic2022.util.JDBUtilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SegundoInformeBancoDao{
    /**
     * Recurso encargado de listar los proyectos cuya ciudad sea Santamarta - Cartagena - Barranquilla
     * Que su clasificacion sea Casa Campestre
     * @return a
     * @throws SQLException
     */
    public List<SegundoInformeBancoVo> ListarSegundoInformeBanco()throws SQLException {
        ArrayList<SegundoInformeBancoVo> a=new ArrayList<SegundoInformeBancoVo>();
        Connection conn= JDBUtilities.getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String consulta="SELECT ID_PROYECTO, CONSTRUCTORA , NUMERO_HABITACIONES , CIUDAD"
                +" FROM PROYECTO"
                +" WHERE CIUDAD IN ('Santa Marta', 'Cartagena', 'Barranquilla')"
                +"AND CLASIFICACION = 'Casa Campestre'";
        try {
            pstmt=conn.prepareStatement(consulta);
            rs=pstmt.executeQuery();
            while (rs.next()) {
                SegundoInformeBancoVo objeto=new SegundoInformeBancoVo();
                objeto.setId(rs.getInt("ID_PROYECTO"));
                objeto.setConstructora(rs.getString("CONSTRUCTORA"));
                objeto.setNumeroHabitaciones(rs.getInt("NUMERO_HABITACIONES"));
                objeto.setCiudad(rs.getString("CIUDAD"));
                a.add(objeto);

            }
        }finally{
            if (rs != null){
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null){
                conn.close();
            }

        }
        return a;
    }

}
