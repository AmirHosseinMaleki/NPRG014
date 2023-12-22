final capitals = [
        'cz': 'Prague',
        'ch': 'Bern',
        'fr': 'Paris',
        'uk': 'London',
        'de': 'Berlin',
        'at': 'Vienna',
        'sk': 'Bratislava',
        'it': 'Roma',
        'se': 'Stockholm',
        'es': 'Madrid',
        'ie': 'Ireland',
        'pl': 'Poland',
]
assert capitals.size() == 12

//TASK Add Poland and Ireland to the map
//assert capitals.size() == 12

println "All countries: ${capitals.keySet()}"
println "The capital of CZ: ${capitals['cz']}"

//TASK Print in upper case the names of all capitals of countries, the name of which starts with 's'
//assert ['BRATISLAVA', 'STOCKHOLM'] == capitals...

// Use the findAll method to filter countries starting with 's'
def capitalsStartingWithS = capitals.findAll { key, value -> key.toLowerCase().startsWith('s') }

// Use the collect method to convert the values to uppercase
def capitalsUppercase = capitalsStartingWithS.collect { key, value -> value.toUpperCase() }

// Now, you can print the result
println "Capitals whose names start with 'S': ${capitalsUppercase}"

// Optional: You can also assert the result
assert ['BRATISLAVA', 'STOCKHOLM'] == capitalsUppercase

final cities = capitals.values()
assert ['Prague', 'Paris','Poland'] == cities.findAll {it.startsWith 'P'}

println 'done'