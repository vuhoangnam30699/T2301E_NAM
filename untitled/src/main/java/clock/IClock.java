package clock;

public interface IClock {

    public void setClock(int secondsSinceMidnight);

    public int getHours();

    public int getMinutes();

    public int getSeconds();

    public void setHours(int hours);

    public void setMinutes(int minutes);

    public void setSeconds(int seconds);

    public void tick();

    public void addClock(IClock clock);

    public String toString();

    public void tickDown();
}
