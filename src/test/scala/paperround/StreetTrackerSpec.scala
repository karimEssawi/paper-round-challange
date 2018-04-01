package paperround

import org.scalatest.{FunSpec, Matchers}

class StreetTrackerSpec extends FunSpec with Matchers {

  describe("Given a street specification") {

    describe("when invalid") {
      it("then returns false for no duplicates") {
        val streetTracker = new StreetTracker(Seq(1, 1, 2))
        streetTracker.noDuplicates shouldBe false
      }
      it("then returns false if even number skipped") {
        val streetTracker = new StreetTracker(Seq(1, 3, 2, 6))
        streetTracker.isConsecutive shouldBe false
      }
      it("then returns false if odd number skipped") {
        val streetTracker = new StreetTracker(Seq(1, 5, 2, 4))
        streetTracker.isConsecutive shouldBe false
      }
      it("then should throw exception") {
        an[IllegalArgumentException] shouldBe thrownBy {
          val streetTracker = new StreetTracker(Seq(1, 5, 2, 4))
          streetTracker.validate()
        }
      }
    }

    describe("when valid") {
      val streetTracker = new StreetTracker(Seq(1, 3, 2, 5, 4, 6))

      it("then returns correct number of houses") {
        streetTracker.getNumberOfHouses shouldBe 6
      }
      it("then returns correct number of northern houses") {
        streetTracker.getNumberOfNorthernHouses shouldBe 3
      }
      it("then returns correct number of southern houses") {
        streetTracker.getNumberOfSouthernHouses shouldBe 3
      }
      it("then returns true for no duplicates") {
        streetTracker.noDuplicates shouldBe true
      }
      it("then returns true for consecutive numbers") {
        streetTracker.isConsecutive shouldBe true
      }

    }
  }

}
