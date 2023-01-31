package es.iesjandula.reservascarritos.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebHandlerReservas
{
    @RequestMapping(value="/index")
    public String showIndex()
    {
        return "index.html";
    }

    @RequestMapping(value="/mostrarReservas")
    public String showMostrarReservas()
    {
        return "mostrarReservas.html";
    }

    @RequestMapping(value="/eleccionReservas")
    public String showEleccionReservas()
    {
        return "eleccionReservas.html";
    }

    @RequestMapping(value="/reservarAula")
    public String showReservarAula()
    {
        return "reservarAula.html";
    }

    @RequestMapping(value="/reservarCarritoPcs")
    public String showReservarCarritoPcs()
    {
        return "reservarCarritoPcs.html";
    }

    @RequestMapping(value="/reservarCarritoTablets")
    public String showReservarCarritoTablets()
    {
        return "reservarCarritoTablets.html";
    }
}
