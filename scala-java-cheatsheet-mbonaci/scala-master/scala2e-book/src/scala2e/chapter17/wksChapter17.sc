package scala2e.chapter17

import scala.collection.mutable.ListBuffer
import scala.collection.mutable.ArrayBuffer

object wksChapter17 {
  val buf = new ListBuffer[Int]                   //> buf  : scala.collection.mutable.ListBuffer[Int] = ListBuffer()
  buf += 22                                       //> res0: scala2e.chapter17.wksChapter17.buf.type = ListBuffer(22)
  11 +=: buf                                      //> res1: scala2e.chapter17.wksChapter17.buf.type = ListBuffer(11, 22)
  buf.toList                                      //> res2: List[Int] = List(11, 22)


  val abuf = new ArrayBuffer[Int]()               //> abuf  : scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer()
  // append using '+='
  abuf += 8                                       //> res3: scala2e.chapter17.wksChapter17.abuf.type = ArrayBuffer(8)
  abuf += 4                                       //> res4: scala2e.chapter17.wksChapter17.abuf.type = ArrayBuffer(8, 4)
  abuf.length                                     //> res5: Int = 2
  abuf(1)                                         //> res6: Int = 4
 
 
  def hasUpperCaseLetter(s: String) = s.exists(_.isUpper)
                                                  //> hasUpperCaseLetter: (s: String)Boolean
  hasUpperCaseLetter("glupson 1")                 //> res7: Boolean = false
  hasUpperCaseLetter("glupson 1A")                //> res8: Boolean = true
  
  
  // sets
  val text = "run Forrest, run. That's it Forrest! Run!"
                                                  //> text  : String = run Forrest, run. That's it Forrest! Run!
  val wordsArray = text.split("[ !,.]+")          //> wordsArray  : Array[String] = Array(run, Forrest, run, That's, it, Forrest, 
                                                  //| Run)
  import scala.collection.mutable
  val set = mutable.Set.empty[String]             //> set  : scala.collection.mutable.Set[String] = Set()
 
  for(word <- wordsArray)
    set += word.toLowerCase
    
  set                                             //> res9: scala.collection.mutable.Set[String] = Set(it, run, that's, forrest)

  val w = mutable.Map.empty[String, Int]          //> w  : scala.collection.mutable.Map[String,Int] = Map()
  w += ("a" -> 1)                                 //> res10: scala2e.chapter17.wksChapter17.w.type = Map(a -> 1)
  w.clear
  w                                               //> res11: scala.collection.mutable.Map[String,Int] = Map()



  import scala.collection.immutable.TreeSet
  val ts = TreeSet(9, 2, 5, 1, 8, 6, 4, 3)        //> ts  : scala.collection.immutable.TreeSet[Int] = TreeSet(1, 2, 3, 4, 5, 6, 8,
                                                  //|  9)

  import scala.collection.immutable.TreeMap
  val tm = TreeMap(8 -> 'e', 7 -> 'a', 1 -> 'w')  //> tm  : scala.collection.immutable.TreeMap[Int,Char] = Map(1 -> w, 7 -> a, 8 -
                                                  //| > e)
  val otm = tm + (2 -> 'x')                       //> otm  : scala.collection.immutable.TreeMap[Int,Char] = Map(1 -> w, 2 -> x, 7 
                                                  //| -> a, 8 -> e)

  var toys = Set("bear", "car")                   //> toys  : scala.collection.immutable.Set[String] = Set(bear, car)
  toys += "doll"
  toys += "loading truck"
  toys                                            //> res12: scala.collection.immutable.Set[String] = Set(bear, car, doll, loadin
                                                  //| g truck)




  val stuff = mutable.Set[Any](42)                //> stuff  : scala.collection.mutable.Set[Any] = Set(42)
  stuff += "green"                                //> res13: scala2e.chapter17.wksChapter17.stuff.type = Set(42, green)
  stuff += 3.14                                   //> res14: scala2e.chapter17.wksChapter17.stuff.type = Set(3.14, 42, green)
  stuff                                           //> res15: scala.collection.mutable.Set[Any] = Set(3.14, 42, green)




  val a = ts.toArray                              //> a  : Array[Int] = Array(1, 2, 3, 4, 5, 6, 8, 9)
  val l = ts.toList                               //> l  : List[Int] = List(1, 2, 3, 4, 5, 6, 8, 9)
  
  
  val mts = mutable.Set.empty ++= ts              //> mts  : scala.collection.mutable.Set[Int] = Set(9, 1, 5, 2, 6, 3, 4, 8)
  val its = Set.empty ++ mts                      //> its  : scala.collection.immutable.Set[Int] = Set(5, 1, 6, 9, 2, 3, 8, 4)
  
  val lista = List[Any](1, "a", 'c')              //> lista  : List[Any] = List(1, a, c)
  

  def findLongest(words: Array[String]): Tuple2[String, Int] = {
    var len = -1
    var index = -1
    
    for(word <- words) {
      if(word.length > len) {
        index = words.indexOf(word)
        len = word.length
      }
    }
    (words(index), index)
  
  }                                               //> findLongest: (words: Array[String])(String, Int)
  
  val tup = findLongest(toys.toArray)             //> tup  : (String, Int) = (loading truck,3)
    
    
}