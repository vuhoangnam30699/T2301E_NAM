package clock;

public class Clock implements IClock {
    private int hours;
    private int minutes;
    private int seconds;

    public Clock() {
        this(12, 0, 0);
    }

    public Clock(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    @Override
    public void setClock(int secondsSinceMidnight) {
        this.hours = secondsSinceMidnight % 60;
        this.minutes = (secondsSinceMidnight / 60) % 60;
        this.seconds = (secondsSinceMidnight / 3600) % 24;
    }

    @Override
    public int getHours() {
        return hours;
    }

    @Override
    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public int getMinutes() {
        return minutes;
    }

    @Override
    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    @Override
    public int getSeconds() {
        return seconds;
    }

    @Override
    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public void tick() {
        seconds++;
        if (seconds >= 60) {
            seconds = 0;
            minutes++;
        }
        if (minutes >= 60) {
            minutes = 0;
            hours++;
        }
        if (hours >= 24) {
            hours = 0;
        }
    }

    @Override
    public void addClock(IClock clock) {
        seconds += clock.getSeconds();
        minutes += clock.getMinutes();
        hours += clock.getHours();
        while (seconds >= 60) {
            seconds -= 60;
            minutes++;
        }
        while (minutes >= 60) {
            minutes -= 60;
            hours++;
        }
        while (hours >= 24) {
            hours -= 24;
        }
    }

    @Override
    public String toString() {
        return String.format("(%02d:%02d:%02d)", hours, minutes, seconds);
    }

    @Override
    public void tickDown() {
        seconds--;
        if (seconds < 0) {
            seconds = 59;
            minutes--;
        }
        if (minutes < 0) {
            minutes = 59;
            hours--;
        }
        if (hours < 0) {
            hours = 23;
        }
    }
}
