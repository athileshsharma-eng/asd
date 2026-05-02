class UAV {
    private int altitude;
    private int battery;
    private boolean flying;

    public UAV() {
        altitude = 0;
        battery = 100;
        flying = false;
    }

    public String takeOff() {
        if (!flying && battery > 10) {
            flying = true;
            altitude = 10;
            battery -= 5;
            return "UAV has taken off.";
        } else {
            return "Cannot take off.";
        }
    }

    public String land() {
        if (flying) {
            flying = false;
            altitude = 0;
            return "UAV has landed.";
        } else {
            return "UAV already on ground.";
        }
    }

    public String increaseAltitude() {
        if (flying && battery > 5) {
            altitude += 10;
            battery -= 5;
            return "Altitude increased.";
        } else {
            return "Cannot increase altitude.";
        }
    }

    public String decreaseAltitude() {
        if (flying && altitude > 10) {
            altitude -= 10;
            return "Altitude decreased.";
        } else {
            return "Cannot decrease altitude.";
        }
    }

    public int getAltitude() { return altitude; }
    public int getBattery() { return battery; }
    public boolean isFlying() { return flying; }
}
