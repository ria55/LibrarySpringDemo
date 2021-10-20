package progmatic.helpers;

import org.springframework.stereotype.Component;

@Component
public class EnumHelper {

    public <T extends Enum<T>> Enum<T> findEnumByNumber(Enum<T>[] enums, int num) {
        for (Enum<T> e : enums) {
            if (e.ordinal() == num) {
                return e;
            }
        }

        return enums[0];
    }

    public <T extends Enum<T>> Enum<T> findEnumByName(Enum<T>[] enums, String name) {
        for (Enum<T> e : enums) {
            if (e.name().equals(getEnumFormatName(name))) {
                return e;
            }
        }

        return enums[0];
    }

    private String getEnumFormatName(String name) {
        return name.toUpperCase().replace(' ', '_');
    }

}
