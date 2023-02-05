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
import java.util.Objects;

/**
 * @author Joaquin Moreno
 *
 * Clase RestHandler
 *
 * Controla la aplicacion
 */
@RequestMapping(value = "/reservas", produces = {"application/json"})
@RestController //
public class RestHandlerReservas
{
    private final Logger Logger = LogManager.getLogger(RestHandlerReservas.class);

    /** Atributo - Repositorio de la reserva de aula */
    @Autowired
    private IReservaAulaRepository iReservaAulaRepository;

    /** Atributo - Repositorio de la reserva de carritos de pc  */
    @Autowired
    private IReservaCarritoPcsRepository iReservaCarritoPcsRepository;

    /** Atributo - Repositorio de la reserva de carrito de tablets  */
    @Autowired
    private IReservaCarritoTabletsRepository iReservaCarritoTabletsRepository;

    /** Atributo - Repositorio de la reserva de aulas de informatica  */
    @Autowired
    private IAulaInformaticaRepository iAulaInformaticaRepository;

    /** Atributo - Repositorio de carrito de pcs  */
    @Autowired
    private ICarritoPcsRepository iCarritoPcsRepository;

    /** Atributo - Repositorio de carrito de tablets  */
    @Autowired
    private ICarritoTabletsRepository iCarritoTabletsRepository;


    /** Atributo - Repositorio del profesor.  */
    @Autowired
    private IProfesorRepository iProfesorRepository;

    /** Atributo - Repositorio del profesor.  */
    @Autowired
    private Utils utils;

    /** Constructor vacio */
    public RestHandlerReservas()
    {
        //Empty constructor
    }

    /**
     * @return todas las reservas
     */
    @RequestMapping(method = RequestMethod.GET, value = "/mostrar_reservas")
    public ResponseEntity<?> getReservas()
    {

        List<ReservaAula> reservaAulaList = this.iReservaAulaRepository.findAll();

        List<ReservaCarritoPcs> reservaCarritoPcs = this.iReservaCarritoPcsRepository.findAll();

        List<ReservaCarritoTablets> reservaCarritoTablets = this.iReservaCarritoTabletsRepository.findAll();

        return ResponseEntity.ok().body(new Reservas(reservaAulaList , reservaCarritoPcs , reservaCarritoTablets));

    }

    /**
     * @return las reservas de aula
     */
    @RequestMapping(method = RequestMethod.GET, value = "/mostrar_reservas_aula")
    public ResponseEntity<?> getReservasAula()
    {

        List<ReservaAula> reservaAulaList = this.iReservaAulaRepository.findAll();


        return ResponseEntity.ok().body(reservaAulaList);

    }

    /**
     * @return las reservas de carritos de tablets
     */
    @RequestMapping(method = RequestMethod.GET, value = "/mostrar_reservas_carrito_tablets")
    public ResponseEntity<?> getReservasCarritoTablets()
    {



        List<ReservaCarritoTablets> reservaCarritoTablets = this.iReservaCarritoTabletsRepository.findAll();

        return ResponseEntity.ok().body(reservaCarritoTablets);

    }

    /**
     * @return las reservas de carritos de pcs
     */
    @RequestMapping(method = RequestMethod.GET, value = "/mostrar_reservas_carrito_pcs")
    public ResponseEntity<?> getReservasCarritoPcs()
    {



        List<ReservaCarritoPcs> reservaCarritoPcs = this.iReservaCarritoPcsRepository.findAll();



        return ResponseEntity.ok().body(reservaCarritoPcs);

    }

    /**
     * @param httpSession la session actual
     * @param idProfesor identificador unico del profesor que hace la reserva.
     * @param idAulaInformatica con identificador unico del aula informatica.
     * @param date fecha de la reserva.
     *
     * @return realiza una reserva de un aula de informatica
     */
    @RequestMapping(method = RequestMethod.POST, value = "/reservar_aula")
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

    /**
     * @param httpSession la session actual
     * @param idProfesor identificador unico del profesor que hace la reserva.
     * @param idCarritoPcs con identificador unico del carrito de pcs.
     * @param date fecha de la reserva.
     * @param ubicacionPrestamo ubicacion del carrito de pcs.
     *
     * @return realiza una reserva de un carrito de pcs
     */
    @RequestMapping(method = RequestMethod.POST, value = "/reservar_carrito_pcs")
    public ResponseEntity<?> reservarCarritoPcs(HttpSession httpSession,
                                                    @RequestParam(required = true) Long idProfesor,
                                                    @RequestParam(required = true) Long idCarritoPcs,
                                                    @RequestParam(required = true) Long date,
                                                    @RequestParam(required = true) String ubicacionPrestamo)
    {
        try
        {
            httpSession = utils.comprobarResevaSession(httpSession);


            Profesor profesor = this.iProfesorRepository.findById(idProfesor).orElse(null);

            Logger.info(profesor);

            CarritoPcs carritoPcs = this.iCarritoPcsRepository.findById(idCarritoPcs).orElse(null);

            if(profesor !=null && carritoPcs != null)
            {
                ReservaCarritoPcs reservaCarritoPcs = new ReservaCarritoPcs(new ReservaCarritoPcsId(idProfesor,idCarritoPcs,new Date(date)),profesor,carritoPcs,ubicacionPrestamo);

                ((List<ReservaCarritoPcs>)httpSession.getAttribute(Constantes.RESERVAS_CARRITOS_PCS)).add(reservaCarritoPcs);

                return ResponseEntity.ok(reservaCarritoPcs);

            }

            return ResponseEntity.status(404).body("Profesor o Carrito pcs no encontrado");
        }
        catch (Exception exception)
        {
            Logger.error(exception.getStackTrace());

            return ResponseEntity.status(500).body("Error Fatal");
        }

    }

    /**
     * @param httpSession la session actual
     * @param idProfesor identificador unico del profesor que hace la reserva.
     * @param idCarritoTablets con identificador unico del carrito de tablets.
     * @param date fecha de la reserva.
     * @param ubicacionPrestamo ubicacion del carrito de tablets.
     *
     * @return realiza una reserva de un carrito de tablets
     */
    @RequestMapping(method = RequestMethod.POST, value = "/reservar_carrito_tablets")
    public ResponseEntity<?> reservarCarritoTablets(HttpSession httpSession,
                                                    @RequestParam(required = true) Long idProfesor,
                                                    @RequestParam(required = true) Long idCarritoTablets,
                                                    @RequestParam(required = true) Long date,
                                                    @RequestParam(required = true) String ubicacionPrestamo)
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

            return ResponseEntity.status(404).body("Profesor o carrito no encontrado");
        }
        catch (Exception exception)
        {
            Logger.error(exception.getStackTrace());

            return ResponseEntity.status(500).body("Error Fatal");
        }


    }

    /**
     * @param idProfesor identificador unico del profesor que hace la reserva.
     * @param idAulaInformatica con identificador unico del aula informatica.
     * @param date fecha de la reserva.
     *
     * @return cancela una reserva de un aula de informatica o de la sesion
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/cancelar_reserva_aula")
    public ResponseEntity<?> cancelarReservaAula(HttpSession httpSession,
                                        @RequestParam(required = true) Long idProfesor,
                                      @RequestParam(required = true) Long idAulaInformatica,
                                      @RequestParam(required = true) Long date)
    {
        try
        {

            List<ReservaAula> reservaAulaList = (List<ReservaAula>) httpSession.getAttribute(Constantes.RESERVAS_AULAS);


            if(reservaAulaList != null)
            {
                for(ReservaAula reservaAulaSession : reservaAulaList)
                {
                    if(Objects.equals(reservaAulaSession.getReservaAulaId().getIdProfesor(), idProfesor)
                            && Objects.equals(reservaAulaSession.getReservaAulaId().getIdAulaInformatica(), idAulaInformatica)
                            && reservaAulaSession.getReservaAulaId().getFecha().getTime()==date)
                    {
                        reservaAulaList.remove(reservaAulaSession);
                        httpSession.setAttribute(Constantes.RESERVAS_AULAS,reservaAulaList);
                        Logger.info("Reserva borrada de la Sesión.");


                        return ResponseEntity.ok().build();
                    }
                }
            }

            if(this.iReservaAulaRepository.findById(new ReservaAulaId(idProfesor,idAulaInformatica,new Date(date))).isPresent())
            {
                this.iReservaAulaRepository.deleteById(new ReservaAulaId(idProfesor,idAulaInformatica,new Date(date)));
                Logger.info("Reserva borrada de la BBDD.");
            }
            else
            {
                return ResponseEntity.status(404).body("Reserva no encontrada en la BBDD/Sesion");

            }



            return ResponseEntity.ok().build();
        }
        catch (Exception exception)
        {
            Logger.error(exception.getStackTrace());

            return ResponseEntity.status(500).body("Error Fatal");
        }

    }

    /**
     * @param idProfesor identificador unico del profesor que hace la reserva.
     * @param idCarritoPcs con identificador unico del carrito de pcs.
     * @param date fecha de la reserva.
     *
     * @return realiza una reserva de un carrito de pcs
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/cancelar_reserva_carrito_pcs")
    public ResponseEntity<?> cancelarReservaCarritoPcs(HttpSession httpSession,
                                                @RequestParam Long idProfesor,
                                                @RequestParam Long idCarritoPcs,
                                                @RequestParam Long date)
    {
        try
        {
            List<ReservaCarritoPcs> reservaCarritoPcsList = (List<ReservaCarritoPcs>) httpSession.getAttribute(Constantes.RESERVAS_CARRITOS_PCS);


            if(reservaCarritoPcsList != null)
            {
                for(ReservaCarritoPcs reservaCarritoPcsSession : reservaCarritoPcsList)
                {
                    if(Objects.equals(reservaCarritoPcsSession.getReservaCarritoPcsId().getIdProfesor(), idProfesor)
                            && Objects.equals(reservaCarritoPcsSession.getReservaCarritoPcsId().getIdCarritoPcs(), idCarritoPcs)
                            && reservaCarritoPcsSession.getReservaCarritoPcsId().getFecha().getTime()==date)
                    {
                        reservaCarritoPcsList.remove(reservaCarritoPcsSession);
                        httpSession.setAttribute(Constantes.RESERVAS_CARRITOS_PCS,reservaCarritoPcsList);
                        Logger.info("Reserva borrada de la Sesión.");


                        return ResponseEntity.ok().build();
                    }
                }
            }

            if(this.iReservaCarritoPcsRepository.findById(new ReservaCarritoPcsId(idProfesor,idCarritoPcs,new Date(date))).isPresent())
            {
                this.iReservaCarritoPcsRepository.deleteById(new ReservaCarritoPcsId(idProfesor,idCarritoPcs,new Date(date)));
                Logger.info("Reserva borrada de la BBDD.");
            }
            else
            {
                return ResponseEntity.status(404).body("Reserva no encontrada en la BBDD/Sesion");
            }

            return ResponseEntity.ok().build();
        }
        catch (Exception exception)
        {
            Logger.error(exception.getStackTrace());

            return ResponseEntity.status(500).body("Error Fatal");
        }

    }

    /**
     * @param idProfesor identificador unico del profesor que hace la reserva.
     * @param idCarritoTablets con identificador unico del carrito de tablets.
     * @param date fecha de la reserva.
     *
     * @return realiza una reserva de un carrito de tablets
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/cancelar_reserva_carrito_tablets")
    public ResponseEntity<?> cancelarReservaCarritoTablets(HttpSession httpSession,
                                                    @RequestParam Long idProfesor,
                                                    @RequestParam Long idCarritoTablets,
                                                    @RequestParam Long date)
    {
        try
        {
            List<ReservaCarritoTablets> reservaCarritoTabletsList = (List<ReservaCarritoTablets>) httpSession.getAttribute(Constantes.RESERVA_CARRITOS_TABLETS);


            if(reservaCarritoTabletsList != null)
            {
                for(ReservaCarritoTablets reservaCarritoTabletsSession : reservaCarritoTabletsList)
                {
                    if(Objects.equals(reservaCarritoTabletsSession.getReservaCarritoTabletsId().getIdProfesor(), idProfesor)
                            && Objects.equals(reservaCarritoTabletsSession.getReservaCarritoTabletsId().getIdCarritoTablets(), idCarritoTablets)
                            && reservaCarritoTabletsSession.getReservaCarritoTabletsId().getFecha().getTime()==date)
                    {
                        reservaCarritoTabletsList.remove(reservaCarritoTabletsSession);
                        httpSession.setAttribute(Constantes.RESERVA_CARRITOS_TABLETS,reservaCarritoTabletsList);
                        Logger.info("Reserva borrada de la Sesión.");


                        return ResponseEntity.ok().build();
                    }
                }
            }

            if(this.iReservaCarritoTabletsRepository.findById(new ReservaCarritoTabletsId(idProfesor,idCarritoTablets,new Date(date))).isPresent())
            {
                this.iReservaCarritoTabletsRepository.deleteById(new ReservaCarritoTabletsId(idProfesor,idCarritoTablets,new Date(date)));
                Logger.info("Reserva borrada de la BBDD.");
            }
            else
            {
                return ResponseEntity.status(404).body("Reserva no encontrada en la BBDD/Sesion");
            }


            return ResponseEntity.ok().build();

        }
        catch (Exception exception)
        {
            Logger.error(exception.getStackTrace());

            return ResponseEntity.status(500).body("Error Fatal");
        }

    }

    /**
     * @param httpSession la session actual
     * @return la confirmacion de que se han hecho correctamente todas las reservas
     */
    @RequestMapping(method = RequestMethod.POST, value = "/confirmar")
    public ResponseEntity<?> confirmacion(HttpSession httpSession)
    {
        try
        {
            List<ReservaAula> reservaAulaList = (List<ReservaAula>) httpSession.getAttribute(Constantes.RESERVAS_AULAS);
            List<ReservaCarritoTablets> reservaCarritoTabletsList = (List<ReservaCarritoTablets>) httpSession.getAttribute(Constantes.RESERVA_CARRITOS_TABLETS);
            List<ReservaCarritoPcs> reservaCarritoPcsList = (List<ReservaCarritoPcs>) httpSession.getAttribute(Constantes.RESERVAS_CARRITOS_PCS);

            if(reservaAulaList!=null)
            {
                this.iReservaAulaRepository.saveAllAndFlush(reservaAulaList);
            }

            if(reservaCarritoTabletsList!=null)
            {
                this.iReservaCarritoTabletsRepository.saveAllAndFlush(reservaCarritoTabletsList);
            }

            if(reservaCarritoPcsList!=null)
            {
                this.iReservaCarritoPcsRepository.saveAllAndFlush(reservaCarritoPcsList);
            }

            httpSession.removeAttribute(Constantes.RESERVAS_AULAS);
            httpSession.removeAttribute(Constantes.RESERVA_CARRITOS_TABLETS);
            httpSession.removeAttribute(Constantes.RESERVAS_CARRITOS_PCS);

            return ResponseEntity.ok().build();
        }
        catch (Exception exception)
        {
            Logger.error(exception.getStackTrace());

            return ResponseEntity.status(500).body("Error Fatal");
        }

    }
}


