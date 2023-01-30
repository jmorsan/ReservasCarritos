package es.iesjandula.reservascarritos.rest;

import es.iesjandula.reservascarritos.models.*;
import es.iesjandula.reservascarritos.repositories.*;
import es.iesjandula.reservascarritos.utils.Utils;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RequestMapping(value = "/reservas", produces = {"application/json"})
@RestController //
public class RestHandlerReservas
{
    private final Logger Logger = LogManager.getLogger(RestHandlerReservas.class);
    @Autowired
    private IReservaAulaRepository iReservaAulaRepository;

    @Autowired
    private IReservaCarritoPcsRepository iReservaCarritoPcsRepository;

    @Autowired
    private IReservaCarritoTabletsRepository iReservaCarritoTabletsRepository;

    @Autowired
    private IAulaInformaticaRepository iAulaInformaticaRepository;

    @Autowired
    private ICarritoPcsRepository iCarritoPcsRepository;

    @Autowired
    private ICarritoTabletsRepository iCarritoTabletsRepository;

    @Autowired
    private IProfesorRepository iProfesorRepository;

    @Autowired
    private Utils utils;



    public RestHandlerReservas()
    {
        //Empty constructor
    }

    @RequestMapping(method = RequestMethod.GET, value = "/MostrarReservas")
    public ResponseEntity<?> getReservas()
    {

        List<ReservaAula> reservaAulaList = this.iReservaAulaRepository.findAll();

        List<ReservaCarritoPcs> reservaCarritoPcs = this.iReservaCarritoPcsRepository.findAll();

        List<ReservaCarritoTablets> reservaCarritoTablets = this.iReservaCarritoTabletsRepository.findAll();

        return ResponseEntity.ok().body(new Reservas(reservaAulaList , reservaCarritoPcs , reservaCarritoTablets));

    }

    @RequestMapping(method = RequestMethod.POST, value = "/reservar_aula/")
    public ResponseEntity<?> reservarAula(HttpSession httpSession,
                                          @RequestParam(required = true) Long idProfesor,
                                          @RequestParam(required = true) Long idAulaInformatica,
                                          @RequestParam(required = true) Long date)
    {
        try
        {
            httpSession = utils.comprobarResevaAula(httpSession);


            Profesor profesor = this.iProfesorRepository.findById(idProfesor).orElse(null);

            AulaInformatica aulaInformatica = this.iAulaInformaticaRepository.findById(idAulaInformatica).orElse(null);

            if(profesor !=null && aulaInformatica != null)
            {
                ReservaAula reservaAula = new ReservaAula(new ReservaAulaId(idProfesor,idAulaInformatica,new Date(date)),profesor,aulaInformatica);

                ((List<ReservaAula>)httpSession.getAttribute(Constantes.RESERVAS_AULAS)).add(reservaAula);

                return ResponseEntity.ok(reservaAula);

            }

            return ResponseEntity.status(404).body("Profesor o Aula no encontrada");
        }
        catch (Exception exception)
        {
            Logger.error(exception.getStackTrace());

            return ResponseEntity.status(500).body("Error Fatal");
        }

    }

    @RequestMapping(method = RequestMethod.POST, value = "/confirmar")
    public ResponseEntity<?> confirmacion(HttpSession session)
    {
        try
        {
            List<ReservaAula> reservaAulaList = (List<ReservaAula>) session.getAttribute(Constantes.RESERVAS_AULAS);
            List<ReservaCarritoTablets> reservaCarritoTablets = (List<ReservaCarritoTablets>) session.getAttribute(Constantes.RESERVA_CARRITOS_TABLETS);
            List<ReservaCarritoPcs> reservaCarritoPcs = (List<ReservaCarritoPcs>) session.getAttribute(Constantes.RESERVAS_CARRITOS_PCS);

            this.iReservaAulaRepository.saveAllAndFlush(reservaAulaList);
            this.iReservaCarritoTabletsRepository.saveAllAndFlush(reservaCarritoTablets);
            this.iReservaCarritoPcsRepository.saveAllAndFlush(reservaCarritoPcs);

            session.removeAttribute(Constantes.RESERVAS_AULAS);
            session.removeAttribute(Constantes.RESERVA_CARRITOS_TABLETS);
            session.removeAttribute(Constantes.RESERVAS_CARRITOS_PCS);

            return ResponseEntity.ok().build();
        }
        catch (Exception exception)
        {
            return ResponseEntity.status(590).body(exception.getMessage());
        }

    }
/**
    @RequestMapping(method = RequestMethod.POST, value = "/reservar_carrito_tablets")
    public ResponseEntity<?> reservarCarritoTablets(@RequestBody(required=true) final ReservaCarritoTablets reservaCarritoTablets)
    {

    }

    @RequestMapping(method = RequestMethod.POST, value = "/reservar_carrito_pcs")
    public ResponseEntity<?> reservarCarritoPcs(@RequestBody(required=true) final ReservaCarritoPcs reservaCarritoPcs)
    {

    }



    @RequestMapping(method = RequestMethod.DELETE, value = "/cancelarAula")
    public ResponseEntity<?> cancelar(@RequestBody(required=true) final ReservaAula reservaAula)
    {

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/cancelarCarritoPcs")
    public ResponseEntity<?> cancelar(@RequestBody(required=true) final ReservaCarritoPcs reservaCarritoPcs)
    {

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/cancelarCarritoTablets")
    public ResponseEntity<?> cancelar(@RequestBody(required=true) final ReservaCarritoTablets reservaCarritoTablets)
    {

    }

**/
}


