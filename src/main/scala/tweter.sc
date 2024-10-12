import scala.collection.mutable.ListBuffer

case class Persona(nombre: String, edad: Int, ciudad: String)
val persona1 = Persona("Juan", 25, "Ciudad A")
val persona2 = Persona("jose", 45, "Ciudad b")
val listaPersonas:ListBuffer[Persona]= ListBuffer[Persona]()
listaPersonas+=persona1
listaPersonas+=persona2
var eleccion:Int=1
var perfilSeleccionado: Persona = listaPersonas(eleccion - 1)
var listaNueva:ListBuffer[Persona]=ListBuffer[Persona]()
listaNueva+=perfilSeleccionado
var flagBlobal:Int=0
val argumento:String="carlos"
val desfragmentacion1:Array[Char]=argumento.toCharArray.take(4)
val fragmentadoArgumento:String=desfragmentacion1.mkString
var desfragmentacion:ListBuffer[Array[Char]]=listaPersonas.map(d=>d.nombre.toCharArray.take(5))
val fragmentado:String=desfragmentacion(0).mkString

val listaCrear:ListBuffer[ListBuffer[String]]=ListBuffer.fill(4)(ListBuffer[String]())

var lisltaTupla:ListBuffer[(String,Persona)]=ListBuffer[(String,Persona)]()
var stringAñadir:(String,Persona)=("añadido Ejmeplo",persona1)
lisltaTupla+=stringAñadir

var stringAñadir2:(String,Persona)=("Trizte",persona2)
lisltaTupla+=stringAñadir2
var tuplaObjeto:ListBuffer[(String,Persona)]=ListBuffer[(String,Persona)]()
tuplaObjeto+=stringAñadir
tuplaObjeto(0)

var stringNulo:String=null
stringNulo="hola mijo como estas"
println(listaPersonas(0).nombre+"\n"+" "+listaPersonas(0).edad)

var stringConcadena:String="hola ten buen dia"
stringConcadena+="\n"+"\n"+" "+" "+" "+" "+" "+" "+" "+" "+" "+" "+" "+" "+" "+" "+"bien como estas tu"
stringConcadena+="\n"+"\n"+"todo bien manda foto"
stringConcadena


def validarChat(usuarioLista: Persona, listaChats: ListBuffer[(String, Persona)]): (ListBuffer[Boolean], Int) = {
  var devolucionBooleana:ListBuffer[Boolean] = listaChats.map(tupla=>tupla._2.equals(usuarioLista))
  var funcionSinNombre:(ListBuffer[Boolean])=>Int=(lista:ListBuffer[Boolean])=>lista.indexOf(true)
  var implementPocicion:Int=funcionSinNombre(devolucionBooleana)
  (devolucionBooleana,implementPocicion)
}



var tuplaObjeto3:ListBuffer[(String,Persona)]=ListBuffer[(String,Persona)](("Hola",persona1),("adios",persona2))
var respuestaTupla:(ListBuffer[Boolean],Int) =validarChat(persona2,tuplaObjeto3)
respuestaTupla











