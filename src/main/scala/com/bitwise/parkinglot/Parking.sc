val list1 = List("a","b","c")
val list2 = List(1,2,3)
val list3=list1 zip list2
case class Node(_1:String,_3:Int)




val nodeNameAge=list3.map(e=>Node(e._1,e._2))

val nameAgeListAgain=for{
  x<-nodeNameAge
}yield (x._1,x._3)::List()

val (namez,agez)=nameAgeListAgain.flatten.unzip


namez
agez
