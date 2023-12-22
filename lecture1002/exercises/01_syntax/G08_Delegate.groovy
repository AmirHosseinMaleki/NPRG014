def joe = [name : 'Joe', age : 83]
def jeff = [name : 'Jeff', age : 38]
def jess = [name : 'Jess', age : 33]

def process(person, code) {
    code.delegate = person    
//    code.resolveStrategy = Closure.DELEGATE_FIRST
    code.call()
//    person.with(code)
}

name = "Noname"
//process(joe, {println name})
//process(jeff, {println age})


/*
class Person {
    final name = "Whatever"
    final greet = {println name}
}
process(joe, new Person().greet)
*/


//TASK Experiment with owner, delegate as well as with different resolution strategies






println("Using delegate:")
process(joe, { println name })
process(jeff, { println age })

class Person {
    final name = "Whatever"
    final greet = { println name }
}

println("\nUsing delegate and owner:")
process(joe, new Person().greet)

println("\nUsing owner:")
joe.with {
    process(joe, { println name })
}

def customStrategy = { name -> println "Custom strategy: $name" }
customStrategy.resolveStrategy = Closure.OWNER_ONLY

println("\nUsing custom resolution strategy:")
process(joe, customStrategy)

def customDelegate = { name -> println "Custom delegate: $name" }
customDelegate.resolveStrategy = Closure.DELEGATE_ONLY

println("\nUsing custom delegate:")
process(joe, customDelegate)
