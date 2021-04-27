import java.util.Random;
import java.util.Scanner;

public class robotWorkProcess {

//Това е функция която генерира нова емоция на робота всеки път като е извикана
    public static String generateRobotEmotion() {
        Random random = new Random();
        int moodNumber = random.nextInt(10);
        int emotionTypeIndex = random.nextInt(100);
        if (moodNumber == 0) {
            moodNumber++;
        }
        if (emotionTypeIndex == 0) {
            emotionTypeIndex++;
        }
        if (moodNumber % 2 == 0 && emotionTypeIndex >= 60 && emotionTypeIndex <= 80 && emotionTypeIndex % 3 == 0) {
            return "tragedy";
        }
        if (moodNumber % 2 == 0 && emotionTypeIndex >= 5 && emotionTypeIndex <= 55 && emotionTypeIndex % 5 == 0) {
            return "productivity";
        }
        if (moodNumber % 2 != 0 && emotionTypeIndex >= 60 && emotionTypeIndex <= 80 && emotionTypeIndex % 3 == 0) {
            return "chaos";
        }
        if (moodNumber % 2 != 0 && emotionTypeIndex >= 5 && emotionTypeIndex <= 55 && emotionTypeIndex % 5 == 0) {
            return "friendliness";
        }
        return "depression";
    }

//Принтира израз който показва как робота се чувства робота в началото на програмата
    public static String printRobotResponseToEmotion(String robotEmotion) {
        if (robotEmotion.equals("tragedy")) {
            return "Сега стана страшно";
        }
        if (robotEmotion.equals("productivity")) {
            return "Работа, работа, работа";
        }
        if (robotEmotion.equals("chaos")) {
            return "Време е да унищожим всички човеци";
        }
        if (robotEmotion.equals("friendliness")) {
            return "Прекрасен ден птичките пеят";
        }
        return "Трудно е да си робот :(";
    }

//Функция за лекуване на депресия
    public static String cureDepressionProcess(int depressionCureAttempts) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        depressionCureAttempts++;
        System.out.println("Робота не изглежда щастлив. Ще бъде добра идея да го питате как е.");
        String userWorryAboutRobot = scanner.nextLine();
        String robotResponseToDepression = "placeholder";
        int robotChanceForResponding = random.nextInt(10);
        if (robotChanceForResponding >= 5) {
            robotResponseToDepression = "Добре съм";
            System.out.println(robotResponseToDepression);
        }
        if (robotChanceForResponding < 5) {
            robotResponseToDepression = "Не ми се живее";
            System.out.println(robotResponseToDepression);
        }
        if (robotResponseToDepression.equals("Добре съм")) {
            System.out.println("Подканете робота да работи.");
            userWorryAboutRobot = scanner.nextLine();
            return generateRobotEmotion();
        }
        if (robotResponseToDepression.equals("Не ми се живее")) {
            System.out.println("Предложете му пари");
            userWorryAboutRobot = scanner.nextLine();
            int salaryNumber = random.nextInt(1000);
            System.out.println("Намислих си чисо за заплата от 1 до 1000 пробвай да го надвишиш");
            int userGuessNumber = scanner.nextInt();
            if (salaryNumber <= userGuessNumber)
                return generateRobotEmotion();
            else cureDepressionProcess(depressionCureAttempts);
        }
        return generateRobotEmotion();
    }

//Функция за самоунищожение на робота
    public static void selfDestructionSequence(int successfulStepsTaken) {

        System.out.println("Самоунищожение след:");
        for (int i = successfulStepsTaken; i >= 0; i--) {
            System.out.println(i);
        }
        System.out.println("Сбогом жесток свят!");
        System.exit(0);
    }

//Функция за вървене на робота. (Правене на стъпки)
    public static int robotWalkingProcess(String robotEmotion, int successfulSteps) {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int intervalBottomBorder = 0;
        int intervalTopBorder = 0;
        int failedSteps = 0;
        String userEncouragement;
        String requiredEncouragement = "placeholder";

        int stepSuccessionChance = random.nextInt(101);
        if (stepSuccessionChance < 1)
            stepSuccessionChance++;
        if (robotEmotion.equals("tragedy")) {
            intervalBottomBorder = 1;
            intervalTopBorder = 10;
            requiredEncouragement = "Животът не струва.";
        }
        if (robotEmotion.equals("productivity")) {
            intervalBottomBorder = 2;
            intervalTopBorder = 100;
            requiredEncouragement = "Разбий ги!";
        }
        if (robotEmotion.equals("chaos")) {
            intervalBottomBorder = 1;
            intervalTopBorder = 15;
            requiredEncouragement = "Невежеството е благодат.";
        }
        if (robotEmotion.equals("friendliness")) {
            intervalBottomBorder = 1;
            intervalTopBorder = 65;
            requiredEncouragement = "Давай, ти си!";
        }
        if (stepSuccessionChance >= intervalBottomBorder && stepSuccessionChance <= intervalTopBorder) {
            successfulSteps++;
            System.out.println("Стъпка" + "{" + successfulSteps + "}");
        }
        if (stepSuccessionChance <= intervalBottomBorder || stepSuccessionChance >= intervalTopBorder) {
            System.out.println("Стъпката беше неуспешна, моля окуражете робота подобаващо.");
            failedStepsCounter(failedSteps);
            userEncouragement = scanner.nextLine();
            if (userEncouragement.equals(requiredEncouragement)) {
                successfulSteps++;
            } else selfDestructionSequence(successfulSteps);
        }
        return successfulSteps;
    }

//Проверява дали баничарското зрение е пуснато. Ако не е пуснато генерира нова емоция докато не го пусне.
    public static String banichkaVision(String robotEmotion, int successfulSteps) {
        Random random = new Random();
        int randomNumberSum = 0;
        while (robotEmotion.equals("depression") || robotEmotion.equals("chaos") || robotEmotion.equals("tragedy")) {
            robotEmotion = generateRobotEmotion();
        }
        for (int i = 0; i < 3; i++) {
            randomNumberSum = random.nextInt(7);
            if (randomNumberSum == 0)
                randomNumberSum++;
            randomNumberSum += randomNumberSum;
        }
        if (randomNumberSum >= successfulSteps) {
            System.out.println("Баничката е разпозната");
        } else banichkaVision(robotEmotion, successfulSteps);
        return robotEmotion;
    }

//Брояч за провалени стъпки
    public static int failedStepsCounter(int failedSteps) {
        failedSteps++;
        return failedSteps;
    }

//Проверка за версия на софтуера за вземане на банички
    public static void banchikaPickUpSoftware(int failedSteps) {
        Random random = new Random();
        int softwareVersion = 1;
        int randomNumberPlusFailedSteps = 0;
        int randomNumber = random.nextInt(70);
        if (randomNumber == 0)
            randomNumber++;
        randomNumberPlusFailedSteps = randomNumber + failedSteps;
        if (randomNumberPlusFailedSteps <= 10)
            System.out.println("Банички ще има само за member-и на пупек");
        if (randomNumberPlusFailedSteps > 10) {
            System.out.println("Вие успешно актуализирахте версията на софтуер Doors в момента сте с версия " + "{" + softwareVersion + "}");
        }
    }

//Главната функция където е сглобено всичко
    public static void main(String[] args) {

        int successfulSteps = 0;
        int failedSteps = 0;

        String robotEmotion = generateRobotEmotion();
        String robotResponse = printRobotResponseToEmotion(robotEmotion);
        System.out.println(robotResponse);

        while (robotEmotion.equals("depression")) {
            int depressionCureAttempts = 0;
            robotEmotion = cureDepressionProcess(depressionCureAttempts);
        }

        robotResponse = printRobotResponseToEmotion(robotEmotion);
        System.out.println(robotResponse);

        do {
            successfulSteps = robotWalkingProcess(robotEmotion, successfulSteps);
        } while (successfulSteps < 3);

        banichkaVision(robotEmotion, successfulSteps);
        banchikaPickUpSoftware(failedSteps);

        do {
            successfulSteps = robotWalkingProcess(robotEmotion, successfulSteps);
        } while (successfulSteps < 6);

        System.out.println("Робота пристигна в склада успешно !");
        selfDestructionSequence(successfulSteps);
    }
}