package misiontic2022.controller;

import misiontic2022.model.dao.PrimerInformeBancoDao;
import misiontic2022.model.dao.TercerInformeBancoDao;
import misiontic2022.model.vo.PrimerInformeBancoVo;
import misiontic2022.model.dao.SegundoInformeBancoDao;
import misiontic2022.model.vo.SegundoInformeBancoVo;
import misiontic2022.model.vo.TercerInformeBancoVo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReportesController {
    private PrimerInformeBancoDao primerInformeBanco;
    private SegundoInformeBancoDao segundoInformeBancoDao;
    private TercerInformeBancoDao tercerInformeBancoDao;


    public ReportesController() {
        primerInformeBanco      = new PrimerInformeBancoDao();
        segundoInformeBancoDao  = new SegundoInformeBancoDao();
        tercerInformeBancoDao    = new TercerInformeBancoDao();

    }

    // Informe 1: Listado de Líderes por Ciudad de Residencia
    public List<PrimerInformeBancoVo> listarProyectosPorBanco()throws SQLException {
        return primerInformeBanco.listarPrimerInforme();
    }

    // Informe 2: Listado de Proyectos
    public List<SegundoInformeBancoVo> listarSegundoInformeBanco() throws SQLException {
        return segundoInformeBancoDao.ListarSegundoInformeBanco();
    }

    // Informe 3: Listado de Compras por Proyecto
    public List<TercerInformeBancoVo> listarTercerInformeBanco() throws SQLException {
        return tercerInformeBancoDao.ListarTercerInformeBanco();
    }




}
