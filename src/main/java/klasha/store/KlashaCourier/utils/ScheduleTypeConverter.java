package klasha.store.KlashaCourier.utils;

import klasha.store.KlashaCourier.models.ScheduleType;

public class ScheduleTypeConverter {

    public static ScheduleType convertStringToEnum(String scheduleType) {

        String cityUpperCase = scheduleType.toUpperCase();

        ScheduleType enumCity = ScheduleType.valueOf(cityUpperCase);
        return enumCity;
    }

    public static String convertEnumToString(ScheduleType scheduleType) {

        String stringCity = scheduleType.toString();
        return stringCity;
    }
}
