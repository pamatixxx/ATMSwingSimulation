import java.util.HashMap;
import java.util.Map;

public class Validation {
    /**
     * Поле бользователя ключ - номер карты, значение - пин код
     */
    //создаем коллекцию пара/ключ
    public static Map<String, String> mapUser = new HashMap<>();

    /**
     * Поле Логическое валидации по умолчанию false
     */
    //флаг отработки валидации
    public static  boolean valid = false;

    /**
     * Поле для наполнения сообщения пользователю
     */
    //переменная для сообщения
    public static String msg = "";


    /**
     * Метод валидации соответсвия и поиска в коллекции ключ/значения
     * @param numCard - номер карты
     * @param pinCode - пин код карты
     */
    //блок валидации введения пин кода, ищет по коллекции совпадения
    public Validation(String numCard, String pinCode) {
        if (mapUser.get(numCard).equals(pinCode)) {valid = true;}
        else {
            msg = "Не корректно ввели пин код";
        }
    }

}
