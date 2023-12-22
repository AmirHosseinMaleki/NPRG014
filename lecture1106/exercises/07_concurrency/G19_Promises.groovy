import groovyx.gpars.dataflow.Dataflow
import static groovyx.gpars.dataflow.Dataflow.*
import groovyx.gpars.dataflow.DataflowVariable

def engineCheck = new DataflowVariable()
def tyrePressure = new DataflowVariable()
def radarOn = new DataflowVariable()
def electricity = new DataflowVariable()

task {
    println "Checking the engine"
    sleep 3000
    engineCheck << true
    println "Engine ok"
}

task {
    println "Preparing the tyres"
    sleep 4000
    tyrePressure << true
    println "Tyres ok"
}

task {
    println "Turning radar on"
    sleep 1000
    if (electricity.get()){
        radarOn << true
        println "Radar ok"

    } else {
        radarOn << false
        println "Radar ko"

    }
    
}

task{
    println "Electricity "
    sleep 2000
    if (system.currentTimeInMills() % 2 ==0) {
        electricity << true
        println "Electricity ok"

    } else {
        electricity << flase
        println "Electricity ko"
    }
}

//TASK: Radar can only be turned on after electricity is checked. Add an electricity-checking task
//and wire it so that the radar can only turned on after the electricity check finishes correctly.

boolean ready = [engineCheck, tyrePressure, radarOn].every {it.val}
if(ready) {
    println 'Taking off'
} else {
    println 'Staying on the ground today'
}