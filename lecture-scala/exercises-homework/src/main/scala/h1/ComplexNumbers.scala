package h1

import scala.language.implicitConversions


class Complex(val real: Int, val imaginary: Int):
    def +(that: Complex) = Complex(real + that.real, imaginary + that.imaginary)
    def -(that: Complex) = Complex(real - that.real, imaginary - that.imaginary)
    def *(that: Complex) = Complex(real * that.real - imaginary * that.imaginary, real * that.imaginary + imaginary * that.real)
    def unary_- = Complex(-real, -imaginary)
    override def toString = s"$real${if (imaginary >= 0) "+" else ""}$imaginary" + "i"

	
object Complex {
  def apply(real: Int, imaginary: Int): Complex = new Complex(real, imaginary)

  given Conversion[Int, Complex] = (value: Int) => new Complex(value, 0)
}


object I extends Complex(0, 1)


object ComplexNumbers:
  def main(args: Array[String]): Unit =
    println(Complex(1,2)) // 1+2i

    println(1 + 2*I + I*3 + 2) // 3+5i

    val c = (2+3*I + 1 + 4*I) * I
    println(-c) // 7-3i
