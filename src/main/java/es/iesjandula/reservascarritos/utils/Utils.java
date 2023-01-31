package es.iesjandula.reservascarritos.utils;

import es.iesjandula.reservascarritos.repositories.Constantes;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class Utils
{
    public HttpSession comprobarResevaSession(HttpSession httpSession)
    {
        if(httpSession.getAttribute(Constantes.RESERVAS_AULAS)==null)
        {
            httpSession.setAttribute(Constantes.RESERVAS_AULAS,new ArrayList<>());
        }

        if(httpSession.getAttribute(Constantes.RESERVAS_CARRITOS_PCS)==null)
        {
            httpSession.setAttribute(Constantes.RESERVAS_CARRITOS_PCS,new ArrayList<>());
        }

        if(httpSession.getAttribute(Constantes.RESERVA_CARRITOS_TABLETS)==null)
        {
            httpSession.setAttribute(Constantes.RESERVA_CARRITOS_TABLETS,new ArrayList<>());
        }

        return httpSession;

    }
}
