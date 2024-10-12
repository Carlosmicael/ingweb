import java.util.concurrent.{Callable, Executors}

object CallableExample extends App {
  val callable = new Callable[String] {
    override def call(): String = {
      "Resultado de la tarea usando Callable"
    }
  }
  val executor = Executors.newSingleThreadExecutor()
  val future = executor.submit(callable)
  val result = future.get()
  println(result)
  executor.shutdown()
}





