var LightBulb = Java.type("no.steria.nashorn.light.LightBulb")

function sayHelloImpl(name) {
    return "Hello "+name;
}

function turnOnLightBulbImpl() {
    LightBulb.getInstance().turnOn();
}

function newHelloNashorn() {
    return new Packages.no.steria.nashorn.HelloNashorn() {
        sayHello: sayHelloImpl, //When someone calls sayHello on HelloNashorn, forward to function sayHelloImpl
        turnOnLightBulb: turnOnLightBulbImpl
    }
}

newHelloNashorn();