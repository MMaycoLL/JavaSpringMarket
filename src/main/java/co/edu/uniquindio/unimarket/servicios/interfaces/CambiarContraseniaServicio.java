package co.edu.uniquindio.unimarket.servicios.interfaces;

public interface CambiarContraseniaServicio {

    void linkCambiarContrasenia(String email) throws Exception;

    public void cambiarContrasenia(String correo) throws Exception;

    void cambiarContrasenia(String email, String contrasenia) throws Exception;
}