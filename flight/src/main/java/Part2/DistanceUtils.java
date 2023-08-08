package Part2;

import org.apache.lucene.util.SloppyMath;

public class DistanceUtils {

    public static Double calculateDistance(Location loc1, Location loc2) {
        return SloppyMath.haversinMeters(
                loc1.getLatitude(), loc1.getLongitude(),
                loc2.getLatitude(), loc2.getLongitude()
        ) / 1000;
    }
}

