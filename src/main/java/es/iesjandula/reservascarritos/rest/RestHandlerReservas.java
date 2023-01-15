package es.iesjandula.reservascarritos.rest;

import es.iesjandula.reservascarritos.models.ReservaAula;
import es.iesjandula.reservascarritos.models.ReservaCarritoPcs;
import es.iesjandula.reservascarritos.models.ReservaCarritoTablets;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/reservas", produces = {"application/json"})
@RestController //
public class RestHandlerReservas
{
    public RestHandlerReservas()
    {
        //Empty constructor
    }

    @RequestMapping(method = RequestMethod.GET, value = "/reservas/")
    public ResponseEntity<?> getReservas()
    {

    }

    @RequestMapping(method = RequestMethod.POST, value = "/reservar_aula/")
    public ResponseEntity<?> reservarAula(@RequestBody(required=true) final ReservaAula reservaAula)
    {

    }

    @RequestMapping(method = RequestMethod.POST, value = "/reservar_carrito_tablets/")
    public ResponseEntity<?> reservarCarritoTablets(@RequestBody(required=true) final ReservaCarritoTablets reservaCarritoTablets)
    {

    }

    @RequestMapping(method = RequestMethod.POST, value = "/reservar_carrito_pcs/")
    public ResponseEntity<?> reservarCarritoPcs(@RequestBody(required=true) final ReservaCarritoPcs reservaCarritoPcs)
    {

    }

    @RequestMapping(method = RequestMethod.POST, value = "/confirmacion/")
    public ResponseEntity<?> confirmacion()
    {

    }




}