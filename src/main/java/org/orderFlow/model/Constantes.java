package org.orderFlow.model;

/**
 * Clase que contiene las constantes utilizadas en la aplicación.
 */
public class Constantes {

    // Mensajes relacionados con el usuario
    public static final String Msg_User_Credenciales = "Credenciales incorrectas";
    public static final String Msg_User_NoExiste = "Usuario no existe";
    public static final String Msg_User_Logeado = "Usuario ya está logeado en el sistema";
    public static final String Msg_User_Correcto = "Logeado correctamente";
    public static final String Msg_User_Logout = "Cierre de sesión exitoso";
    public static final String Msg_User_ErrorLogout = "Cierre de sesión erróneo";
    public static final String Msg_User_FaltaUser = "Debe ingresar un nombre de usuario";
    public static final String Msg_User_FaltaPass = "Debe ingresar una contraseña";
    public static final String Msg_User_Mesas = "Mozo aún tiene mesas abiertas";
    public static final String Msg_User_Transfer_Pendiente = "Mozo tiene una transferencia pendiente";

    // Mensajes relacionados con la transferencia de mesas
    public static final String Msg_Transferencia_FaltaMozo = "Debe seleccionar un mozo para transferir";
    public static final String Msg_Transferencia_Rechazada = "Transferencia rechazada";
    public static final String Msg_Transferencia_Aceptada = "Transferencia aceptada";

    // Mensajes relacionados con las mesas
    public static final String Msg_Mesas_OtroMozo = "Mesa corresponde a otro mozo";
    public static final String Msg_Mesas_FaltaMesa = "Debe seleccionar una mesa";
    public static final String Msg_Mesas_Pendientes = "Mesa aún tiene pedidos pendientes";
    public static final String Msg_Mesas_Cerrada = "Mesa debe estar abierta";

    // Mensajes relacionados con los pedidos
    public static final String Msg_Pedidos_Cantidad = "Debe ingresar una cantidad de al menos 1";
    public static final String Msg_Pedidos_Tomado = "El pedido ya ha sido tomado";
    public static final String Msg_Pedidos_FaltaPedido = "Debe seleccionar un pedido";
    public static final String Msg_Pedidos_YaFinalizado = "El pedido ya ha sido finalizado";
    public static final String Msg_Pedidos_Pendientes = "Aún quedan pedidos en proceso";
    public static final String Msg_Pedidos_Finalizado = "Pedido finalizado:";

    // Mensajes relacionados con los productos
    public static final String Msg_Productos_CantidadMal = "Cantidad inválida";
    public static final String Msg_Productos_NoStock = "Sin stock";
    public static final String Msg_Productos_NoValido = "Producto inválido";

    // Mensajes relacionados con los clientes
    public static final String Msg_Cliente_ID_Invalido = "El ID ingresado no es válido";
    public static final String Msg_Cliente_ID_No_Existe = "Cliente no válido";
    public static final String Msg_Cliente_Registrado = "Cliente registrado con éxito";
    public static final String Msg_Cliente_No_Registrado = "No se pudo registrar el cliente";
    public static final String Msg_Cliente_Faltan_Datos = "Se debe ingresar tanto Nombre como Email";
}
