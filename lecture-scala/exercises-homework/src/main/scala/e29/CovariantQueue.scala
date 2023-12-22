package e29

/* Features:
 * - covariance with internal state
 */
// object CovariantQueue:
// 	def apply()= new CovariantQueue(Nil, Nil) // you can use this way to use private stuff in CovariantQueue

// 	def apply()=
// 		 val x = new CovariantQueue(Nil, Nil) // you should not do this, it is forbbiden
// 		 x.leading = Nil

//constractor does not have to be private here
class CovariantQueue[+T] private (
		private var leading: List[T],
		private var trailing: List[T]
		// private[this] var leading: List[T],
		// private[this] var trailing: List[T]
	):

	private def mirror(): Unit =
		// The compiler checks that all accesses to the mutable state are within a single instance only
		if leading.isEmpty then
			leading = trailing.reverse
			trailing = Nil

	def head: T =
		mirror()
		leading.head
	
	def tail: CovariantQueue[T] =
		mirror()
		new CovariantQueue(leading.tail, trailing)
	
	def enqueue[U >: T](x: U) = new CovariantQueue[U](leading, x :: trailing)

