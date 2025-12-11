import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 */

/**
 * Класс PbDZ_v1, банкомата , рабочий код
 *
 * @version 1.0
 * @autor Судариков Сергей
 */

public class ATMApplication {


    public static void main(String[] args) throws InterruptedException {

        //захардкожен пользователь в базе карта:ключ (пин код)
        /**
         * БД статическая карта/пин код
         */
        Validation.mapUser.put("44556534665456213", "1423");
        //запускаем фрем
        Thread threadWait = new Thread(String.valueOf(new GuiPin()));
        threadWait.run();
    }


    public static class Currency {
        /**
         * Поле код пары валюты
         */
        private int currencyCode;
        /**
         * Коллекция купюр
         */
        private ArrayList<Integer> banknote;
        /**
         * Поле короткое наименование валюты
         */
        private String shortNameCurrency;
        /**
         * Поле символ валюты
         */
        private String currencySymvol;
        /**
         * Поле Коллекция доступной валюты в касете банкомата
         */
        private ArrayList<Integer> cassette;

        /**
         * Конструктор - создания нового обхекта валюты
         * @param  currencyCode код пары
         * @param currencyCode Банкроты доступные
         * @param shortNameCurrency короткое наименование по стандартам валют
         * @param currencySymvol символ валюты
         * @param  cassette доступный наминал в касете
         */
        public Currency(int currencyCode, ArrayList<Integer> banknote, String shortNameCurrency, String currencySymvol, ArrayList<Integer> cassette) {
            this.currencyCode = currencyCode;
            this.banknote = banknote;
            this.shortNameCurrency = shortNameCurrency;
            this.currencySymvol = currencySymvol;
            this.cassette = cassette;
        }

        /**
         * Получение кода валюты
         * @return currencyCode
         */
        public int getCurrencyCode() {
            return currencyCode;
        }

        /**
         * Процедура установки кода валюты
         */
        public void setCurrencyCode(int currencyCode) {
            this.currencyCode = currencyCode;
        }

        /**
         * Функция Получения доступного наминала
         * @return banknote
         */

        public ArrayList<Integer> getBanknote() {
            return banknote;
        }

        /**
         * Процедура установки доступных банкнот
         */

        public void setBanknote(ArrayList<Integer> banknote) {
            this.banknote = banknote;
        }

        /**
         *  Функция получения короткого наименования валюты
         * @return shortNameCurrency
         */

        public String getShortNameCurrency() {
            return shortNameCurrency;
        }
        /**
         * Процедура установки  наименования валюты
         */
        public void setShortNameCurrency(String shortNameCurrency) {
            this.shortNameCurrency = shortNameCurrency;
        }
        /**
         *
         */
        public String getCurrencySymvol() {
            return currencySymvol;
        }
        /**
         * Процедура установки символа валюты
         * @param  currencySymvol
         */
        public void setCurrencySymvol(String currencySymvol) {
            this.currencySymvol = currencySymvol;
        }

        /**
         * Функция получения касеты банкомата
         */

        public ArrayList<Integer> getCassette() {
            return cassette;
        }

        /**
         * Функция удаления наминала по индексу
         * @param i
         */

        public void removeCasetForIndex(int i) {
            cassette.remove(i);
        }

        /**
         * Процедура установки доступной валюты (колличества купюр и наминала) в касете Коллекция
         * @param cassette
         */
        public void setCassette(ArrayList<Integer> cassette) {
            this.cassette = cassette;
        }
    }

    /**
     * Класс банкомат
     */
    public static class Bankomate {
        ArrayList<Currency> currencies = new ArrayList<>();
        String currencyCode;
        int sumReq;

        /**
         * Конструктор создания нового обьекта с определенными значениями
         * @param currencyCode - код валюты
         * @param sumReq - запрашиваемая сумма
         */
        public Bankomate(String currencyCode, int sumReq) {
            this.currencyCode = currencyCode;
            this.sumReq = sumReq;
        }

        /**
         * функция получения значение валюты
         * @return
         */
        public ArrayList<Currency> getCurrencies() {
            return currencies;
        }

        /**
         * Процедура определения валюты
         * @param currencies
         */
        public void setCurrencies(ArrayList<Currency> currencies) {
            this.currencies = currencies;
        }
    }

    /**
     * блок проверки  доступного наминала в банкомате для выдачи пользователю
     * Функция check
     */

    public static String check(String a) {
        /**
         * Поле заказ валюты (получение данных введенных пользователем)
         */
        int zakazValue = Integer.parseInt(GuiBanknote.countBanknoteText);
/**
 * статическое наполнение короткого наименования валюты
 */
        String shortNameCurrency = "UAH";

        /**
         * Коллекция доступного наминала валюты для добавления (10,20,50,100,200,500)
         */

        ArrayList<Integer> value = new ArrayList();
        value.add(10);
        value.add(20);
        value.add(50);
        value.add(100);
        value.add(200);
        value.add(500);

        //инициализация массива
        /**
         * Статический массив наполнения кассеты
         */
        int mass[] = {50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 20, 30, 20, 20, 20, 20, 100, 150, 200, 200, 500, 500, 500, 500, 500, 10, 10, 10, 10, 100, 100, 100};

        //сортировка по возрастанию
        Arrays.sort(mass);
        //создаем касету с купюрами которые в ней будут находятся
        ArrayList<Integer> cassette = new ArrayList<>();

        //переносим массив в коллекцию купюр
        for (int i = 0; i < mass.length; i++) {
            for (int list : value
            ) {
                if (mass[i] == list) {
                    cassette.add(mass[i]);
                }

            }
        }
        //наполнение конструктора Currency для тестирования
        ATMApplication.Currency currency = new ATMApplication.Currency(840, value, "UAH", "₴", cassette);

        int maxSumOnBankomate = 0;//temp доступной суммы в банкомате
        ArrayList<Integer> tempIndexBanknote = new ArrayList<>(); //темп  для индекса , удаления купюр если все успешно
        boolean check = false; // флаг успешности для выдачи
        int iCanGiftYouMin = 0; //приблеженная сумма к выдаче -
        int iCanGiftYouMax = 0;//приблеженная сумма к выдаче +
        String msg = "";


        //temp доступного массива с купюрами для обработчика
        ArrayList<Integer> copy = new ArrayList<>();
        for (Integer list : currency.getCassette()
        ) {
            maxSumOnBankomate += list;
            copy.add(list);
        }

        if (maxSumOnBankomate < zakazValue) {
            msg = "Сорян, у нас нет столько, запросите меньшую сумму";
        } else {
            for (int i = copy.size() - 1; i >= 0; i--) {
                if (zakazValue >= copy.get(i)) {
                    zakazValue -= copy.get(i);
                    iCanGiftYouMax += copy.get(i);
                    iCanGiftYouMin += copy.get(i);
                    tempIndexBanknote.add(i);
                } else if (zakazValue == 0) {
                    check = true;
                    msg = "Одобрено, возьмите Ваши деньги";
                } else {
                    if (zakazValue < copy.get(i)) {
                        msg = "Доступная сумма для выдачи  минимальная : ";
                    }
                }

            }
        }

        if (msg.equals("Доступная сумма для выдачи  минимальная : ")) {
            //System.out.println(tempIndexBanknote.get(ls);
            iCanGiftYouMin = iCanGiftYouMax - copy.get(tempIndexBanknote.get(tempIndexBanknote.size() - 1));
            msg += iCanGiftYouMin + " максимальная : " + iCanGiftYouMax;

        }

        for (int i = 0; i < tempIndexBanknote.size(); i++) {
            currency.removeCasetForIndex(tempIndexBanknote.get(i));
        }

        System.out.println(msg);
        return msg;
    }
}
