package misiontic2022.model.vo;

public class PrimerInformeBancoVo {
    private Integer id;
    private String nombre;
    private String primerApelido;
    private String ciudadResidencia;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApelido() {
        return primerApelido;
    }

    public void setPrimerApelido(String primerApelido) {
        this.primerApelido = primerApelido;
    }

    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }
}
