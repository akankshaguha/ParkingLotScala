package com.bitwise.parkinglot

import com.bitwise.parkinglot.ParkingLot1.{InvalidLotSpaceException, NoCarInTheParkingLotException, SpaceOverflowException, listOfCars}


/**
  * Created by akankshag on 6/29/2016.
  */
trait ParkingLot1 {


  def getFreeSpace:Int
  def getListOfCars:listOfCars
  def parkCar(car:Car):ParkingLot1
 def unParkCar(car:Car):ParkingLot1

}
 case class EmptyParkingLot() extends ParkingLot1
 {
   override def getFreeSpace: Int =throw new ParkingLot1.SpaceOverflowException

   override def getListOfCars: listOfCars = throw new NoCarInTheParkingLotException

   override def parkCar(car: Car): ParkingLot1 =throw new NoCarInTheParkingLotException
   override def unParkCar(car: Car): ParkingLot1 = throw new NoCarInTheParkingLotException


 }


 case class NonEmptyParkingLot(fs:Int,cars:List[Car]) extends ParkingLot1
 {
  override def getFreeSpace: Int = fs


 override def getListOfCars: List[Car] = cars

  override def parkCar(car: Car): ParkingLot1 =new NonEmptyParkingLot(fs-1,car::getListOfCars)
 override def unParkCar(car: Car): ParkingLot1 = new NonEmptyParkingLot(fs+1,getListOfCars.filter(x=>x==car))



 }



object ParkingLot1{

  def apply(freespace:Int):ParkingLot1=freespace match{
    case 0 => EmptyParkingLot()
    case _ =>NonEmptyParkingLot(freespace,List())



  }
  def apply(freespace:Int,cars:listOfCars):ParkingLot1= (freespace,cars) match{
    case(0,_) => EmptyParkingLot()
      case(_,_)=>  NonEmptyParkingLot(freespace,cars)
  }



  type listOfCars = List[Car]
  case class InvalidLotSpaceException() extends RuntimeException

  case class NoCarInTheParkingLotException() extends RuntimeException

  case class SpaceOverflowException() extends  RuntimeException

  case class DuplicateCarEntryError() extends  RuntimeException
  case class SpaceNotAvailException() extends RuntimeException

  

}
