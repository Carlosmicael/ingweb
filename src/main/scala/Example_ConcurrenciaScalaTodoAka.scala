import akka.actor.typed.{ActorRef, ActorSystem, Behavior}
import akka.actor.typed.scaladsl.Behaviors
import Messages._
object Example_ConcurrenciaScalaTodoAka extends App {
  //Aqui creamos nuestros sistemas de actores o nuestro sistema de hilo
  // cabe recalcar que un solo systema puede manejat muchos actores o muchos hilos en este caso
  //yo cree dos sitemas de actores para q se entienda mcho mejor ya que un systema contiene un hilo y el otro contiene
  //el segundo huilo
  val system: ActorSystem[ExecuteTask] = ActorSystem(TaskActor(), "taskActorSystem")
  val system2: ActorSystem[ExecuteTask] = ActorSystem(TaskActor2(), "taskActorSystem")
  //hacemos un rango del uno hasta el 3 para ejecutar tres veces los dos hilos es decir trabajo 1 pertenece al TaskACtor y el trabajo 1
  //nuevamente pertenceria al TaskActor2
  (1 to 3).foreach { taskId =>
    //Aqui mandaiamos a trabajar nuestros hilos
    // este signo de interrogacion en Scala significa en un contexto dicho realiza esto no es exclusivo de AKKA
    system ! ExecuteTask(taskId)
    system2 ! ExecuteTask(taskId)
  }
  //el hilo principal esperaria 4 segundos hasta q termine los tres trabajos de cada hilo y terminaria la ejecucion de los de ambos hilos y systema
  Thread.sleep(4000)
  system.terminate()
  system2.terminate()
}

object Messages {
  final case class ExecuteTask(taskId: Int)
  //tenemos nuestra case class con un solo atributo de tipo entero esto va hacer los mensaje que resivan los hilo
  //en el sistema para poder comunicarse
}

object TaskActor {
  //creamos nuestro hilo o Actor llamado Task Actor
  //donde va revisivir un mensaje en este caso como ejemplo el mensaje no tiene
  //funcion alguna mas que presentar el trabajo de forma grafica
  def apply(): Behavior[ExecuteTask] = {
    //para poder hacer concurrenci EN SIERTO BLOQUE DE CODIGO COMO podran ver se debe ubicar dentro del behaviors. receive que seria
    //el codigo q se ejecuta en forma paralela
    Behaviors.receive { (context, message) =>
      println(s"Executing task ${message.taskId}")//comenzo
      val sum=20+4+6//hago un ejemplo de suma para ver los valores del hilo 1
      println(sum)
      Thread.sleep(1000)//espero un segundo para terminar la tarea
      println(s"Task ${message.taskId} completed")//presento
      Behaviors.same
    }
  }
}
object TaskActor2 {
  def apply(): Behavior[ExecuteTask] = {
    Behaviors.receive { (context, message) =>
      println(s"Executing task_Hilo2 ${message.taskId}")
      val sum = 5+5+5
      println(sum)
      Thread.sleep(1000)
      println(s"Task_Hilo2 ${message.taskId} completed")
      Behaviors.same
    }
  }
}





