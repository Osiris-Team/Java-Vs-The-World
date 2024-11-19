import scala.util.Random

object PrimeBenchmark {
  def main(args: Array[String]): Unit = {
    val random = new Random()
    val randomMax = 10000000 + random.nextInt(101) // Random number between 10000000 and 10000100

    // First run (not timed)
    countPrimes(randomMax)

    // Second run (timed)
    val startTime = System.nanoTime()
    countPrimes(randomMax)
    val endTime = System.nanoTime()

    println(s"""{"type": "prime", "time_ns": ${endTime - startTime}}""")
  }

  def countPrimes(n: Int): Int = {
    val isPrime = Array.fill(n + 1)(true)
    for (i <- 2 to math.sqrt(n).toInt if isPrime(i)) {
      for (j <- i * i to n by i) {
        isPrime(j) = false
      }
    }
    isPrime.slice(2, n + 1).count(_ == true)
  }
}