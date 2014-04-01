function sayHelloImpl(name) {
    return "";
}

function turnOnLightBulbImpl() {

}

function newHelloNashorn() {
    return new Packages.no.steria.nashorn.HelloNashorn() {
        sayHello: sayHelloImpl, //When someone calls sayHello on HelloNashorn, forward to function sayHelloImpl
        turnOnLightBulb: turnOnLightBulbImpl
    }
}

newHelloNashorn();