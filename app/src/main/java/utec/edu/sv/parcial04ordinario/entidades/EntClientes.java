package utec.edu.sv.parcial04ordinario.entidades;

public class EntClientes {
    private int    CODCLIENTE;
    private String NOMBRE;
    private String APELLIDO;
    private String DIRECCION;
    private String CIUDAD;

    public int getCODCLIENTE() {
        return CODCLIENTE;
    }

    public void setCODCLIENTE(int CODCLIENTE) {
        this.CODCLIENTE = CODCLIENTE;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getAPELLIDO() {
        return APELLIDO;
    }

    public void setAPELLIDO(String APELLIDO) {
        this.APELLIDO = APELLIDO;
    }

    public String getDIRECCION() {
        return DIRECCION;
    }

    public void setDIRECCION(String DIRECCION) {
        this.DIRECCION = DIRECCION;
    }

    public String getCIUDAD() {
        return CIUDAD;
    }

    public void setCIUDAD(String CIUDAD) {
        this.CIUDAD = CIUDAD;
    }
}
