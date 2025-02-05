public class TurnOnDevices {

    public static abstract class Connectable {
        public abstract void turnOn();

        public abstract void turnOff();

        public abstract boolean isOn();
    }

    public static class Lamp extends Connectable {
        private boolean state = false;
        
        @Override
        public void turnOn() { state = true; System.out.println("Lampara encendida");}

        @Override
        public void turnOff() { state = false; System.out.println("Lampara apagada");}

        @Override
        public boolean isOn() {
            if (state) { return true; } else{ return false; }
        }
    }

    public static class Computer extends Connectable {
        private boolean state = false;

        @Override
        public void turnOn() { state = true; System.out.println("Computadora encendida");}

        @Override
        public void turnOff() { state = false; System.out.println("Computadora apagada");}

        @Override
        public boolean isOn() {
            if (state) { return true; } else{ return false; }
        }
    }

    public static class CoffeMaKer {
        private boolean state = false;

        public void on(){ state = true; System.out.println("Cafetera encendida");}

        public void off(){ state = false; System.out.println("Cafetera apagada");}

        public boolean isOff(){
            if (state) { return false; }else{ return true;}
        }

    }

    public static class CoffeMaKerAdaptor extends Connectable{

        private CoffeMaKer coffeMaKer = new CoffeMaKer();

        @Override
        public void turnOn() { coffeMaKer.on();}

        @Override
        public void turnOff() { coffeMaKer.off();}

        @Override
        public boolean isOn() {
            return !coffeMaKer.isOff();
        }
        
    }

    public static void main(String[] args) {

        //turnOnDevice(new Lamp());
        //turnOnDevice(new Computer());
        turnOnDevice(new CoffeMaKerAdaptor());
    }

    private static void turnOnDevice(Connectable device) {
        device.turnOff();
        System.out.println(device.isOn());
    }
}