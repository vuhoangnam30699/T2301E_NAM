public class Clock {
    private int hours;
    private int minutes;
    private int seconds;

    public Clock() {
        hours = 12;
        minutes = 0;
        seconds = 0;
    }

    public Clock(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

     public void setClock(int secondsSinceMidnight) {
        if (secondsSinceMidnight == - 1) {
            secondsSinceMidnight = 86399;
        }
        if (secondsSinceMidnight == 86400) {
            secondsSinceMidnight = 0;
        }
        this.hours = secondsSinceMidnight / 3600;
        this.minutes = (secondsSinceMidnight - 3600 * hours) / 60;
        this.seconds = secondsSinceMidnight - 3600 * hours - 60 * minutes;
     }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public void tick() {
        int secondsSinceMidnight = getSecondsSinceMidnight() + 1;
        setClock(secondsSinceMidnight);
    }

    public void addClock(Clock time) {
        int secondsSinceMidnight;
        secondsSinceMidnight = getSecondsSinceMidnight() + time.getSecondsSinceMidnight();
        setClock(secondsSinceMidnight);
    }

    public int getSecondsSinceMidnight() {
        int secondsSinceMidnight = hours * 3600 + minutes * 60 + seconds;
        return secondsSinceMidnight;
    }

    @Override
    public String toString() {
        return String.format("(%02d:%02d:%02d)", hours, minutes, seconds);
    }

    public  void tickDown() {
        int secondsSinceMidnight = getSecondsSinceMidnight() - 1;
        setClock(secondsSinceMidnight);

    }
}