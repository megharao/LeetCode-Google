package org.neetcode.arrays.hashing;

import java.util.*;

public class UndergroundSystem {

    Map<Integer, Data> dataMap;
    List<Data> dataList;

    public UndergroundSystem() {
        dataMap = new HashMap<>();
        dataList = new ArrayList<>();
    }

    public void checkIn(int id, String stationName, int t) {
        Data data = new Data();
        data.id = id;
        data.checkinStationName = stationName;
        data.t1 = t;
        dataMap.put(id,data);
    }

    public void checkOut(int id, String stationName, int t) {
        Data data = dataMap.get(id);
        data.checkoutStationName = stationName;
        data.t2 = t;
        dataList.add(data);
        dataMap.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        return dataList.stream().filter(data -> startStation.equals(data.checkinStationName) &&
                endStation.equals(data.checkoutStationName)).mapToInt(data -> data.t2-data.t1).average().getAsDouble();
    }

    class Data{
        int id;
        String checkinStationName;
        int t1;
        String checkoutStationName;
        int t2;
    }

    public static void main(String[] args) {
        UndergroundSystem undergroundSystem = new UndergroundSystem();
        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);  // Customer 45 "Leyton" -> "Waterloo" in 15-3 = 12
        undergroundSystem.checkOut(27, "Waterloo", 20);  // Customer 27 "Leyton" -> "Waterloo" in 20-10 = 10
        undergroundSystem.checkOut(32, "Cambridge", 22); // Customer 32 "Paradise" -> "Cambridge" in 22-8 = 14
        System.out.println(undergroundSystem.getAverageTime("Paradise", "Cambridge")); // return 14.00000. One trip "Paradise" -> "Cambridge", (14) / 1 = 14
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));    // return 11.00000. Two trips "Leyton" -> "Waterloo", (10 + 12) / 2 = 11
        undergroundSystem.checkIn(10, "Leyton", 24);
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));    // return 11.00000
        undergroundSystem.checkOut(10, "Waterloo", 38);  // Customer 10 "Leyton" -> "Waterloo" in 38-24 = 14
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));    // return 12.00000. Three trips "Leyton" -> "Waterloo", (10 + 12 + 14) / 3 = 12
    }
}
