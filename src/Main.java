import java.time.LocalDate;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void checkLeapYear(int year) {
        if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
            System.out.println(year + " год является високосным");
        } else {
            System.out.println(year + " год не является високосным");
        }
    }
    public static void defineOs(int os){
        switch (os)  {
            case 0:
                System.out.print(" для iOS по ссылке");
                break;
            case 1:
                System.out.print(" для Android по ссылке");
                break;
        }
    }
    public static void checkRequiredVersion(int osType, int deviceYear) {
        int currentYear = LocalDate.now().getYear();
        if (deviceYear < currentYear) {
            System.out.print("Установите lite-версию приложения");
            defineOs(osType);
        } else {
            System.out.print("Установите версию приложения");
            defineOs(osType);
        }
    }
    public static void calculationNumberOfDeliveryDays(int deliveryDistance){
        int deliveryDaysCount = 1;
        int distansAddAdditionalDay = 40;
        int remaningDistance = deliveryDistance - 20;
        if (remaningDistance != 0 && remaningDistance > 0) {
            if (remaningDistance % distansAddAdditionalDay != 0) {
                deliveryDaysCount += (remaningDistance / distansAddAdditionalDay) + 1;
            } else {
                deliveryDaysCount += remaningDistance / distansAddAdditionalDay;
            }
        }
        System.out.println("Потребуется дней: " + deliveryDaysCount);
    }

    public static Scanner sc = new Scanner(System.in);
    public static int[] generateRandomArray() {
        Random random =  new Random();
        int arr[] =new int[30];
        for (int i = 0; i < arr.length; i++) {
            arr[i]  = random.nextInt(100_000)  + 100_000;
        }
        return arr;
    }
    public static int[] array = generateRandomArray();

    public static void spendingPerMonth(int[] arr) {
        int sumSpendingPerMonth = 0;
        for (int i = 0; i < arr.length; i++) {
            sumSpendingPerMonth += arr[i];
        }
        calculateMonthlyAverage(sumSpendingPerMonth, arr.length);
    }

    public static void calculateMonthlyAverage(int sumMonthly, int daysCount) {
        float monthAverage = sumMonthly/daysCount;
        System.out.println("Средняя сумма трат за месяц составила " + monthAverage + " рублей.");
    }

    public static void main(String[] args) {
        //Ex1
        System.out.println("Задание номер один");
        int ourYear = 2024;
        checkLeapYear(ourYear);
        //Ex2
        System.out.println("Задание номер два");
        System.out.println("Какая у вас операционная система? Введите 0 " +
                "если у вас IOS, 1 если у вас Andriod: ");
        int clintOS = sc.nextInt();
        System.out.println("В каком году было выпущено ваше устройство: ");
        int clientDeviceVersion = sc.nextInt();
        checkRequiredVersion(clintOS, clientDeviceVersion);
        //Ex3
        System.out.println("Задание номер три");
        System.out.println("Введиите расстояние на которое нужно доставить карту: ");
        int clientDistans = sc.nextInt();
        calculationNumberOfDeliveryDays(clientDistans);
        //Ex4
        System.out.println("Дополнительное заданиие по методам");
        spendingPerMonth(array);


    }

}