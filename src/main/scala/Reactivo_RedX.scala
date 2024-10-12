import akka.actor._
import scala.collection.mutable.ListBuffer
object Reactivo_RedX {
  def main(args: Array[String]): Unit = {
    case class messenger(contrasena:String,mensaje:String)
    case class usuario(nombre:String,contra:String,edad:String,estudios:String,nacionalidad:String,civil:String,listaAmigos:ListBuffer[usuario],listaMensajes:ListBuffer[String])


    ////////////////////////enviar funcion///////////////////////
    def reactivoMessenger(functionContrase_Nombre:ListBuffer[usuario]=>String,usuarioMensaje:String,borrarEjemlo:ListBuffer[usuario]):(String,String) = {
      var notification: String = "Tienes Una Nueva Notificacion"
      var mensaje: String = null


      class ActorOne extends Actor {
        def receive(): Receive = {
          case "Seguir"=>
            context.stop(self)
          case _ =>
            context.stop(self)
        }
      }
      val system: ActorSystem = ActorSystem("SistemaMensajes")
      val myActor: ActorRef = system.actorOf(Props[ActorOne], "Objeto")
      myActor ! usuarioMensaje


      /////////////////////////////////
      if (usuarioMensaje.equals("Seguir")){
        var corroborar:String= functionContrase_Nombre(borrarEjemlo)
        println(s"el usuario ${corroborar} ha sido añadido a tu lista de amigos")
      }else{
        mensaje=usuarioMensaje
      }
      //////////////////////////////////////
      system.terminate()
      (notification,mensaje)
    }

    def funcionBorrar(borrar:ListBuffer[usuario]):String={
      var nombre:String=borrar(0).nombre
      nombre
    }


    val miListaMensajes1:ListBuffer[String]=ListBuffer[String]()
    val miListaMensajes2:ListBuffer[String]=ListBuffer[String]()



    val listanula:ListBuffer[usuario]=null
    val usu1:usuario=usuario("maria ortega","123","34","utpl","española","soltera",listanula,miListaMensajes1)
    val miLista:ListBuffer[usuario]=ListBuffer[usuario](usu1)
    val usu2:usuario=usuario("carlos guaman","0908","20","berlin","ecuatoriana","soltero",miLista,miListaMensajes2)



    val listaborrarCaseclas:ListBuffer[usuario]=ListBuffer[usuario](usu2)
    val ejemploMessenger:(String,String)=reactivoMessenger(funcionBorrar,"Seguir",listaborrarCaseclas)
    println(ejemploMessenger)
  }
}
