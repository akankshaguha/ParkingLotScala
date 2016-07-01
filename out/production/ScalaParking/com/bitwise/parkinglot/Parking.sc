import com.bitwise.parkinglot.ParkingLot1
import com.bitwise.parkinglot.ParkingLot1.SpaceNotAvailException


trait ParkingLot1{
  def getFreeSpace():Int
}

case class EmptyParkingLot() extends ParkingLot1{
   def getFreeSpace()=throw new NoSuchElementException("asdsad")


}

case class NonEmptyParkingLot(freespace:Int) extends ParkingLot1{
  override  def getFreeSpace() = freespace
}
object ParkingLot1{

  def apply(freespace:Int): ParkingLot1 = freespace match{
    case 0 => EmptyParkingLot()
    case _ =>NonEmptyParkingLot(freespace)
  }


}
ParkingLot1(0)