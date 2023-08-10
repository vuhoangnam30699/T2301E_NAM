package employee2;

public enum Level {
        INTERN(0.5),FRESHER(1.0),JUNIOR(2.0),SENIOR(5.0);
        private final double heso;

        Level(double heso) {
            this.heso = heso;
        }

        public double getHeso() {
            return heso;
        }
    }

