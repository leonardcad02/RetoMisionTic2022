package misiontic2022.model.dao;

import misiontic2022.model.vo.PrimerInformeBancoVo;
import misiontic2022.util.JDBUtilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class PrimerInformeBancoDao {

    /**
     * Recurso encargado de listar los lideres según la ciudad de residencia
     * @return a
     * @throws SQLException
     */
    public List<PrimerInformeBancoVo> listarPrimerInforme()throws SQLException {
        ArrayList<PrimerInformeBancoVo> a=new ArrayList<PrimerInformeBancoVo>();
        Connection conn= JDBUtilities.getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String consulta="SELECT ID_LIDER, NOMBRE , PRIMER_APELLIDO , CIUDAD_RESIDENCIA"
                +" FROM LIDER"
                +" ORDER BY CIUDAD_RESIDENCIA ASC ";
        try {
            pstmt=conn.prepareStatement(consulta);
            rs=pstmt.executeQuery();
            while (rs.next()) {
                PrimerInformeBancoVo objeto=new PrimerInformeBancoVo();
                objeto.setId(rs.getInt("ID_LIDER"));
                objeto.setNombre(rs.getString("NOMBRE"));
                objeto.setPrimerApelido(rs.getString("PRIMER_APELLIDO"));
                objeto.setCiudadResidencia(rs.getString("CIUDAD_RESIDENCIA"));
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
