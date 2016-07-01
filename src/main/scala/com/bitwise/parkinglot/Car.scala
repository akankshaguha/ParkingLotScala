package com.bitwise.parkinglot

/**
  * Created by akankshag on 6/29/2016.
  */
class Car(cNo:String){
  val carNumber=cNo
  def getCarNumber:String=carNumber
  override def toString:String="Car["+carNumber+"]"
  def canEqual(other: Any): Boolean = other.isInstanceOf[Car]
  override def equals(other: Any): Boolean = other match {
    case that: Car =>
      (that canEqual this) &&
        carNumber == that.carNumber
    case _ => false
  }
  override def hashCode(): Int = {
    val state = Seq(carNumber)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

object Car{
  type CarNumber=String
  def apply(carNumber: CarNumber)= carNumber match{
    case ""=>throw new InvalidCarNumberException
    case _ =>new Car(carNumber)
  }
  case class InvalidCarNumberException() extends RuntimeException

}
