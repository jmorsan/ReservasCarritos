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
            httpSession = utils.comprobarResevaSession(httpSession);


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

    @RequestMapping(method = RequestMethod.POST, value = "/reservar_carrito_pcs")
    public ResponseEntity<?> reservarCarritoPcs(HttpSession httpSession,
                                                    @RequestParam Long idProfesor,
                                                    @RequestParam Long idCarritoPcs,
                                                    @RequestParam Long date,
                                                    @RequestParam String ubicacionPrestamo)
    {
        try
        {
            httpSession = utils.comprobarResevaSession(httpSession);


            Profesor profesor = this.iProfesorRepository.findById(idProfesor).orElse(null);

            CarritoPcs carritoPcs = this.iCarritoPcsRepository.findById(idCarritoPcs).orElse(null);

            if(profesor !=null && carritoPcs != null)
            {
                ReservaCarritoPcs reservaCarritoPcs = new ReservaCarritoPcs(new ReservaCarritoPcsId(idProfesor,idCarritoPcs,new Date(date)),profesor,carritoPcs,ubicacionPrestamo);

                ((List<ReservaCarritoPcs>)httpSession.getAttribute(Constantes.RESERVAS_CARRITOS_PCS)).add(reservaCarritoPcs);

                return ResponseEntity.ok(reservaCarritoPcs);

            }

            return ResponseEntity.status(404).body("Profesor o Aula no encontrada");
        }
        catch (Exception exception)
        {
            Logger.error(exception.getStackTrace());

            return ResponseEntity.status(500).body("Error Fatal");
        }

    }

    @RequestMapping(method = RequestMethod.POST, value = "/reservar_carrito_tablets")
    public ResponseEntity<?> reservarCarritoTablets(HttpSession httpSession,
                                                    @RequestParam Long idProfesor,
                                                    @RequestParam Long idCarritoTablets,
                                                    @RequestParam Long date,
                                                    @RequestParam String ubicacionPrestamo)
    {
        try
        {
            httpSession = utils.comprobarResevaSession(httpSession);


            Profesor profesor = this.iProfesorRepository.findById(idProfesor).orElse(null);

            CarritoTablets carritoTablets = this.iCarritoTabletsRepository.findById(idCarritoTablets).orElse(null);

            if(profesor !=null && carritoTablets != null)
            {
                ReservaCarritoTablets reservaCarritoTablets = new ReservaCarritoTablets(new ReservaCarritoTabletsId(idProfesor,idCarritoTablets,new Date(date)),profesor,carritoTablets,ubicacionPrestamo);

                ((List<ReservaCarritoTablets>)httpSession.getAttribute(Constantes.RESERVA_CARRITOS_TABLETS)).add(reservaCarritoTablets);

                return ResponseEntity.ok(reservaCarritoTablets);

            }

            return ResponseEntity.status(404).body("Profesor o Aula no encontrada");
        }
        catch (Exception exception)
        {
            Logger.error(exception.getStackTrace());

            return ResponseEntity.status(500).body("Error Fatal");
        }


    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/cancelarAula")
    public ResponseEntity<?> cancelarAula(@RequestParam(required = true) Long idProfesor,
                                      @RequestParam(required = true) Long idAulaInformatica,
                                      @RequestParam(required = true) Long date)
    {
        try
        {

            this.iReservaAulaRepository.deleteById(new ReservaAulaId(idProfesor,idAulaInformatica,new Date(date)));


            return ResponseEntity.ok().build();
        }
        catch (Exception exception)
        {
            return ResponseEntity.status(590).body(exception.getMessage());
        }

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/cancelarCarritoPcs")
    public ResponseEntity<?> cancelarCarritoPcs(@RequestParam Long idProfesor,
                                                @RequestParam Long idCarritoPcs,
                                                @RequestParam Long date)
    {
        try
        {

            this.iReservaCarritoPcsRepository.deleteById(new ReservaCarritoPcsId(idProfesor,idCarritoPcs,new Date(date)));


            return ResponseEntity.ok().build();
        }
        catch (Exception exception)
        {
            return ResponseEntity.status(590).body(exception.getMessage());
        }

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/cancelarCarritoTablets")
    public ResponseEntity<?> cancelarCarritoTablets(@RequestParam Long idProfesor,
                                                    @RequestParam Long idCarritoTablets,
                                                    @RequestParam Long date)
    {
        try
        {

            this.iReservaCarritoTabletsRepository.deleteById(new ReservaCarritoTabletsId(idProfesor,idCarritoTablets,new Date(date)));


            return ResponseEntity.ok().build();
        }
        catch (Exception exception)
        {
            return ResponseEntity.status(590).body(exception.getMessage());
        }

    }

    @RequestMapping(method = RequestMethod.POST, value = "/confirmar")
    public ResponseEntity<?> confirmacion(HttpSession session)
    {
        try
        {
            List<ReservaAula> reservaAulaList = (List<ReservaAula>) session.getAttribute(Constantes.RESERVAS_AULAS);
            List<ReservaCarritoTablets> reservaCarritoTabletsList = (List<ReservaCarritoTablets>) session.getAttribute(Constantes.RESERVA_CARRITOS_TABLETS);
            List<ReservaCarritoPcs> reservaCarritoPcsList = (List<ReservaCarritoPcs>) session.getAttribute(Constantes.RESERVAS_CARRITOS_PCS);

            this.iReservaAulaRepository.saveAllAndFlush(reservaAulaList);
            this.iReservaCarritoTabletsRepository.saveAllAndFlush(reservaCarritoTabletsList);
            this.iReservaCarritoPcsRepository.saveAllAndFlush(reservaCarritoPcsList);

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
}


