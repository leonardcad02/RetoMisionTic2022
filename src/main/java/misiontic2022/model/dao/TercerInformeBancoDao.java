package misiontic2022.model.dao;

import misiontic2022.model.vo.TercerInformeBancoVo;
import misiontic2022.util.JDBUtilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class TercerInformeBancoDao {

    /**
     * Recurso encargado de listar los comprar segun el proveedor Homecenter y por la ciudad salento
     * @return a
     * @throws SQLException
     */
    public List<TercerInformeBancoVo> ListarTercerInformeBanco()throws SQLException {
        ArrayList<TercerInformeBancoVo> a=new ArrayList<TercerInformeBancoVo>();
        Connection conn= JDBUtilities.getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String consulta="SELECT C.ID_PROYECTO, P.CONSTRUCTORA , P.BANCO_VINCULADO"
                +" FROM COMPRA C"
                +" JOIN PROYECTO P ON (C.ID_PROYECTO = P.ID_PROYECTO)"
                +" WHERE C.PROVEEDOR = 'Homecenter'"
                +" AND P.CIUDAD = 'Salento'";
        try {
            pstmt=conn.prepareStatement(consulta);
            rs=pstmt.executeQuery();
            while (rs.next()) {
                TercerInformeBancoVo objeto=new TercerInformeBancoVo();
                objeto.setId(rs.getInt("ID_PROYECTO"));
                objeto.setConstructora(rs.getString("CONSTRUCTORA"));
                objeto.setBancoVinculado(rs.getString("BANCO_VINCULADO"));
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
