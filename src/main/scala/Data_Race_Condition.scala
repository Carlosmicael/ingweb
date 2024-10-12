import akka.actor.{Actor, ActorSystem, Props}
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.duration._


class CounterActor extends Actor {
  var counter: Int = 1
  def receive: Receive = {
    case CounterActorM.Increment =>
      counter += 1
    case CounterActorM.Decrement =>
      counter -= 1
    case CounterActorM.GetValue =>
      sender() ! counter
  }
}
object CounterActorM {
  case object Increment
  case object Decrement
  case object GetValue
}

object AkkaActorExample extends App {
  val system = ActorSystem("CounterSystem")
  private val counterActor = system.actorOf(Props[CounterActor], "counterActor")
  counterActor ! CounterActorM.Increment
  counterActor ! CounterActorM.Increment
  counterActor ! CounterActorM.Decrement
  counterActor ! CounterActorM.GetValue
  implicit val timeout: Timeout = Timeout(5.seconds)
  import system.dispatcher
  val result = counterActor ? CounterActorM.GetValue
  result.onComplete { value =>
    println(s"Valor final del contador: ${value.get}")
    system.terminate()
  }
}


