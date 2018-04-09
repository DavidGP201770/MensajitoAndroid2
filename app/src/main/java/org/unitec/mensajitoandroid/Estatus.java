package org.unitec.mensajitoandroid;

public class Estatus {
    private boolean success;
    private String msj;

    public Estatus() {
    }

    public Estatus(boolean success, String msj) {
        this.success = success;
        this.msj = msj;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsj() {
        return msj;
    }

    public void setMsj(String msj) {
        this.msj = msj;
    }
}
