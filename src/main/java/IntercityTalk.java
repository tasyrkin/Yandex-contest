import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class IntercityTalk {
    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cities = in.nextInt();

        final HashMap<String, HashMap<String, boolean[]>> data = new HashMap<>();

        for (int city = 0; city < cities; city++) {
            final String cityName = in.next();
            final int numRooms = in.nextInt();

            data.put(cityName, new HashMap<>());

            for (int roomNum = 0; roomNum < numRooms; roomNum++) {
                final String timeTable = in.next();
                final String roomName = in.next();
                boolean[] boolTimeTable = convertToBool(timeTable);

                data.get(cityName).put(roomName, boolTimeTable);
            }
        }

        final int requests = in.nextInt();

        requests:
        for (int req = 0; req < requests; req++) {
            int numReqCities = in.nextInt();
            final String[] reqCities = new String[numReqCities];
            for (int reqCity = 0; reqCity < numReqCities; reqCity++) {
                reqCities[reqCity] = in.next();
            }

            for (int hour = 0; hour < 24; hour++) {

                List<String> availableRooms = new ArrayList<>();

                for (String reqCity : reqCities) {
                    final String availableRoom = getAvailableRoom(data, hour, reqCity);
                    if (availableRoom != null) {
                        availableRooms.add(availableRoom);
                    }
                }

                if (availableRooms.size() == numReqCities) {
                    final StringBuilder sb = new StringBuilder("Yes");
                    for (String availableRoom : availableRooms) {
                        if (sb.length() > 0) {
                            sb.append(" ");
                        }
                        sb.append(availableRoom);
                    }
                    System.out.println(sb.toString());
                    continue requests;
                }
            }

            System.out.println("No");
        }

    }

    private static String getAvailableRoom(final HashMap<String, HashMap<String, boolean[]>> data, final int hour, final String reqCity) {

        final HashMap<String, boolean[]> roomsData = data.get(reqCity);

        if (roomsData == null) return null;

        for (Map.Entry<String, boolean[]> entry : roomsData.entrySet()) {
            if (entry.getValue()[hour]) {
                return entry.getKey();
            }
        }
        return null;
    }

    private static boolean[] convertToBool(final String timeTable) {
        final boolean[] result = new boolean[timeTable.length()];
        int index = 0;
        for (char ch : timeTable.toCharArray()) {
            result[index++] = ch == '.';
        }
        return result;
    }
}
