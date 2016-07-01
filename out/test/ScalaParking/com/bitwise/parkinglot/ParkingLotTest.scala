package com.bitwise.parkinglot


import org.junit.{Assert, Test}

/**
  * Created by akankshag on 6/29/2016.
  */
class ParkingLotTest {




  @Test(expected = classOf[ParkingLot1.SpaceOverflowException])
  def zeroSizedParkingLotIsIllegal(): Unit ={
    //given
    ParkingLot1(0)
  }

  @Test
  def correctFreeSpaceIsReturned(): Unit ={
    //given
    val givenFreeSpace=4
    val lot=ParkingLot1(givenFreeSpace)
    //when
    val freeSpace:Int=lot.getFreeSpace
    //then
    Assert.assertTrue(freeSpace==givenFreeSpace)
  }



  @Test
  def itShouldCheckWhetherCarHasBeenParked(): Unit ={
    //given
    val car=Car("AAA123")
    val car2=Car("BBB246")
    //when

    val lot=ParkingLot1(3,car::Nil)
    val lot1 =lot.parkCar(car2)

    //then
    //Assert.assertTrue(lot.isCarParked(car))
  Assert.assertEquals(List(car2,car),lot1.getListOfCars)
  }
  @Test
  def correctListOfCarsMustBeReturned(): Unit ={
    //given
    val listOfCars=List(new Car("aas"),new Car("bbd"),new Car("ccc"),new Car("ddd"))
    //when
    val lot=ParkingLot1(4,listOfCars)
    //then
    Assert.assertEquals(List(new Car("aas"),new Car("bbd"),new Car("ccc"),new Car("ddd")),lot.getListOfCars)
  }

  @Test
  def itShouldAbleToParkTheCar(): Unit ={
    //given

    val car1=Car("AAA123")
    val car2=Car("BBB246")
    val car3=Car("BBB276")
    //when

   val lot = ParkingLot1(8)
    val newlot =lot.parkCar(car3)
    val newlot1=newlot.parkCar(car2)

    //then
    Assert.assertEquals(6,newlot1.getFreeSpace)

  }

  @Test
  def itshouldAbleToUnParkTheCar(): Unit ={
    val car1=Car("AAA123")
    val car2=Car("BBB246")
    val car3=Car("BBB276")
    //when

    val lot = ParkingLot1(8)
    val newlot =lot.parkCar(car3)
    val newlot1=newlot.parkCar(car2)
    val newlot2=newlot1.unParkCar(car1)

    //then
    Assert.assertEquals(7,newlot2.getFreeSpace)
    Assert.assertEquals(List(car2,car3),newlot1.getListOfCars)




  }



}
