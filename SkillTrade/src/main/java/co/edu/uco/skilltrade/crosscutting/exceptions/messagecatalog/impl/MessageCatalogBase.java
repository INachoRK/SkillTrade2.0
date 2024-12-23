package co.edu.uco.skilltrade.crosscutting.exceptions.messagecatalog.impl;

import java.util.HashMap;
import java.util.Map;

import co.edu.uco.skilltrade.crosscutting.exceptions.custom.CrosscuttingSkillTradeException;
import co.edu.uco.skilltrade.crosscutting.exceptions.messagecatalog.MessageCatalog;
import co.edu.uco.skilltrade.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.skilltrade.crosscutting.exceptions.messagecatalog.data.Mensaje;
import co.edu.uco.skilltrade.crosscutting.helpers.ObjectHelper;

public final class MessageCatalogBase implements MessageCatalog {

	private final Map<String, Mensaje> mensajes = new HashMap<>();

	@Override
	public final void inicializar() {
		mensajes.clear();
		mensajes.put(CodigoMensaje.M00001.getIdentificador(), new Mensaje(CodigoMensaje.M00001,
				"El código del mensaje que quiere obtener del catálogo mensajes llegó nulo..."));
		mensajes.put(CodigoMensaje.M00002.getIdentificador(), new Mensaje(CodigoMensaje.M00002,
				"Se ha presentado un problema tratando de llevar a cabo la operación deseada..."));
		mensajes.put(CodigoMensaje.M00003.getIdentificador(), new Mensaje(CodigoMensaje.M00003,
				"El identificador del mensaje \"${1}\" que se intentó obtener, no está en el catálogo de mensajes base..."));
		mensajes.put(CodigoMensaje.M00004.getIdentificador(), new Mensaje(CodigoMensaje.M00004,
				"El mensaje con identificador \"${1}\" que se intentó obtener, no está configurado para residir en el catálogo de mensajes base..."));
		mensajes.put(CodigoMensaje.M00005.getIdentificador(), new Mensaje(CodigoMensaje.M00005,
				"El mensaje con identificador \"${1}\" que se intentó obtener, no está configurado para residir en el catálogo de mensajes externo..."));
		mensajes.put(CodigoMensaje.M00006.getIdentificador(), new Mensaje(CodigoMensaje.M00006,
				"El identificador del mensaje \"${1}\" que se intentó obtener, no está en el catálogo de mensajes externo..."));
		mensajes.put(CodigoMensaje.M00007.getIdentificador(), new Mensaje(CodigoMensaje.M00007,
				"Se ha presentado un problema tratando de validar si la conexión SQL con la fuente de información deseada estaba cerrada..."));
		mensajes.put(CodigoMensaje.M00008.getIdentificador(), new Mensaje(CodigoMensaje.M00008,
				"Se ha presentado un problema INESPERADO tratando de validar si la conexión SQL con la fuente de información deseada estaba cerrada..."));
		mensajes.put(CodigoMensaje.M00009.getIdentificador(), new Mensaje(CodigoMensaje.M00009,
				"Se ha intentado realizar el cierre de una conexión que ya estaba cerrada..."));
		mensajes.put(CodigoMensaje.M00010.getIdentificador(), new Mensaje(CodigoMensaje.M00010,
				"Se ha presentado un problema trantando de cerrar la conexión SQL con la fuente de la información deseada..."));
		mensajes.put(CodigoMensaje.M00011.getIdentificador(), new Mensaje(CodigoMensaje.M00011,
				"Se ha presentado un problema INESPERADO trantando de cerrar la conexión SQL con la fuente de la información deseada..."));
		mensajes.put(CodigoMensaje.M00012.getIdentificador(), new Mensaje(CodigoMensaje.M00012,
				"Se ha intentado confirmar una transacción con una conexión SQL cerrada..."));
		mensajes.put(CodigoMensaje.M00013.getIdentificador(), new Mensaje(CodigoMensaje.M00013,
				"Se ha intentado confirmar una transacción cuando el autocommit de la conexión con la base de datos estaba activada..."));
		mensajes.put(CodigoMensaje.M00014.getIdentificador(), new Mensaje(CodigoMensaje.M00014,
				"Se ha presentado un problema tratando de confirmar una transacción SQL con la fuente de información deseada..."));
		mensajes.put(CodigoMensaje.M00015.getIdentificador(), new Mensaje(CodigoMensaje.M00015,
				"Se ha presentado un problema INESPERADO tratando de confirmar una transacción SQL con la fuente de información deseada..."));
		mensajes.put(CodigoMensaje.M00016.getIdentificador(), new Mensaje(CodigoMensaje.M00016,
				"Se ha intentado confirmar una transacción con una conexión SQL cerrada..."));
		mensajes.put(CodigoMensaje.M00017.getIdentificador(), new Mensaje(CodigoMensaje.M00017,
				"Se ha intentado confirmar una transacción cuando el autocommit de la conexión con la base de datos estaba activada..."));
		mensajes.put(CodigoMensaje.M00018.getIdentificador(), new Mensaje(CodigoMensaje.M00018,
				"Se ha presentado un problema tratando de confirmar una transacción SQL con la fuente de información deseada..."));
		mensajes.put(CodigoMensaje.M00019.getIdentificador(), new Mensaje(CodigoMensaje.M00019,
				"Se ha presentado un problema INESPERADO tratando de confirmar una transacción SQL con la fuente de información deseada..."));
		mensajes.put(CodigoMensaje.M00020.getIdentificador(), new Mensaje(CodigoMensaje.M00020,
				"Se ha intentado confirmar una transacción con una conexión SQL cerrada..."));
		mensajes.put(CodigoMensaje.M00021.getIdentificador(), new Mensaje(CodigoMensaje.M00021,
				"Se ha intentado confirmar una transacción cuando el autocommit de la conexión con la base de datos estaba activada..."));
		mensajes.put(CodigoMensaje.M00022.getIdentificador(), new Mensaje(CodigoMensaje.M00022,
				"Se ha presentado un problema tratando de confirmar una transacción SQL con la fuente de información deseada..."));
		mensajes.put(CodigoMensaje.M00023.getIdentificador(), new Mensaje(CodigoMensaje.M00023,
				"No es posible crear el DAO deseado, dado que la conexion SQL esta cerrada"));
		mensajes.put(CodigoMensaje.M00024.getIdentificador(), new Mensaje(CodigoMensaje.M00024,
				"No ha sido posible llevar a cabo el registro de la información del nuevo usuario. Por favor intente de nuevo y en caso de pérsisitir el problema, comuniquese con el administrador de SkillTrade..."));
		mensajes.put(CodigoMensaje.M00025.getIdentificador(), new Mensaje(CodigoMensaje.M00025,
				"No ha sido posible llevar a cabo la consulta del usuario. Por favor intente de nuevo y en caso de persisitir el problema, comuníquese con el administrador de SkillTrade..."));
		mensajes.put(CodigoMensaje.M00026.getIdentificador(), new Mensaje(CodigoMensaje.M00026,
				"No ha sido posible llevar a cabo el registro de la información de la nueva sesión. Por favor intente de nuevo y en caso de pérsisitir el problema, comuniquese con el administrador de SkillTrade..."));
		mensajes.put(CodigoMensaje.M00027.getIdentificador(), new Mensaje(CodigoMensaje.M00027,
				"No ha sido posible llevar a cabo el registro de la información del nuevo curso. Por favor intente de nuevo y en caso de pérsisitir el problema, comuniquese con el administrador de SkillTrade..."));
		mensajes.put(CodigoMensaje.M00028.getIdentificador(), new Mensaje(CodigoMensaje.M00028,
				"Se ha presentado un problema tratando de Registrar la información de una nueva sesión."));
		mensajes.put(CodigoMensaje.M00029.getIdentificador(), new Mensaje(CodigoMensaje.M00029,
				"Se ha presentado un problema INESPERADO tratando de ejecutar el método de la clase RegistrarSesionFachadaImpl. Por favor revise la traza completa del problema."));
		mensajes.put(CodigoMensaje.M00030.getIdentificador(), new Mensaje(CodigoMensaje.M00030,
				"Se ha presentado un problema tratando de Registrar la información de un nuevo curso"));
		mensajes.put(CodigoMensaje.M00031.getIdentificador(), new Mensaje(CodigoMensaje.M00031,
				"Se ha presentado un problema INESPERADO tratando de ejecutar el método de la clase RegistrarCursoFachadaImpl. Por favor revise la traza completa del problema."));
		mensajes.put(CodigoMensaje.M00032.getIdentificador(), new Mensaje(CodigoMensaje.M00032,
				"Se ha presentado un problema tratando de consultar la información del usuario deseado."));
		mensajes.put(CodigoMensaje.M00033.getIdentificador(), new Mensaje(CodigoMensaje.M00033,
				"Se ha presentado un problema INESPERADO tratando de ejecutar el método de la clase ConsultarUsuarioFachadaImpl. Por favor revise la traza completa del problema."));
		mensajes.put(CodigoMensaje.M00034.getIdentificador(), new Mensaje(CodigoMensaje.M00034,
				"Se ha presentado un problema tratando de obtener la conexión con la base de datos STDB en el servidor de bases de datos skilltrade-server.database.windows.net. Por favor revise la traza de errores para identificar y solucionar el problema..."));
		mensajes.put(CodigoMensaje.M00035.getIdentificador(), new Mensaje(CodigoMensaje.M00035,
				"Se ha presentado un problema INESPERADO tratando de obtener la conexión con la base de datos STDB en el servidor de bases de datos skilltrade-server.database.windows.net. Por favor revise la traza de errores para identificar y solucionar el problema..."));
		mensajes.put(CodigoMensaje.M00036.getIdentificador(), new Mensaje(CodigoMensaje.M00036,
				"No ha sido posible consultar la información de los usuarios. Por favor, inténtelo de nuevo o comuníquese con el administrador de SkillTrade."));
		mensajes.put(CodigoMensaje.M00037.getIdentificador(), new Mensaje(CodigoMensaje.M00037,
				"Se ha presentado un problema INESPERADO intentando consultar al ususario deseado en la bsae de datos SQL, si el problema persiste pÃ³ngase en contacto con un administrador de SkillTrade..."));
		mensajes.put(CodigoMensaje.M00038.getIdentificador(), new Mensaje(CodigoMensaje.M00038,
				"No ha sido posible llevar a cabo la eliminacion de la informacion del usuario deseado. Por favor intente de nuevo y en caso de pÃ©rsisitir el problema, comuniquese con el administrador de SkillTrade..."));
		mensajes.put(CodigoMensaje.M00039.getIdentificador(), new Mensaje(CodigoMensaje.M00039,
				"Se ha presentado un problema al buscar la categoría deseada, por favor inténtelo de nuevo y si el error persiste póngase en contacto con un administrador de SkillTrade."));
		mensajes.put(CodigoMensaje.M00040.getIdentificador(), new Mensaje(CodigoMensaje.M00040,
				"Hubo un problema inesperado al buscar la categoría en la base de datos SQL, por favor haga una traza completa del error."));
		mensajes.put(CodigoMensaje.M00041.getIdentificador(), new Mensaje(CodigoMensaje.M00041,
				"Se ha presentado un problema intentando mostrar la información de una categoría."));
		mensajes.put(CodigoMensaje.M00042.getIdentificador(), new Mensaje(CodigoMensaje.M00042,
				"No se ha podido traer la información de la categoría desde la base de datos SQL, intente de nuevo y si el pronlema persiste póngase en Contacto con un administrador de SkillTrade."));
		mensajes.put(CodigoMensaje.M00043.getIdentificador(), new Mensaje(CodigoMensaje.M00043,
				"Se ha presentado un problema tratando de consultar la información del curso deseado."));
		mensajes.put(CodigoMensaje.M00044.getIdentificador(), new Mensaje(CodigoMensaje.M00044,
				"Se ha presentado un problema INESPERADO tratando de ejecutar el método de la clase ConsultarCategoriaFachadaImpl. Por favor revise la traza completa del problema."));

	}


	@Override
	public final String obtenerContenidoMensaje(final CodigoMensaje codigo, final String... parametros) {
		return obtenerMensaje(codigo, parametros).getContenido();
	}

	@Override
	public final Mensaje obtenerMensaje(final CodigoMensaje codigo, final String... parametros) {

		if (ObjectHelper.getObjectHelper().isNull(codigo)) {
			var mensajeUsuario = obtenerContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = obtenerContenidoMensaje(CodigoMensaje.M00001);
			throw new CrosscuttingSkillTradeException(mensajeTecnico, mensajeUsuario);
		}

		if (!codigo.isBase()) {
			var mensajeUsuario = obtenerContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = obtenerContenidoMensaje(CodigoMensaje.M00004, codigo.getIdentificador());
			throw new CrosscuttingSkillTradeException(mensajeTecnico, mensajeUsuario);
		}

		if (!mensajes.containsKey(codigo.getIdentificador())) {
			var mensajeUsuario = obtenerContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = obtenerContenidoMensaje(CodigoMensaje.M00003, codigo.getIdentificador());
			throw new CrosscuttingSkillTradeException(mensajeTecnico, mensajeUsuario);
		}
		return mensajes.get(codigo.getIdentificador());
	}

}
