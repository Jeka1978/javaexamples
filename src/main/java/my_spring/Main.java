package my_spring;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {
      /*  IRobot iRobot = ObjectFactory.getInstance().createObject(IRobot.class);

        iRobot.cleanRoom();
        System.out.println(iRobot.getClass());*/
        SafeChargeService chargeService = ObjectFactory.getInstance().createObject(SafeChargeService.class);
        chargeService.doWork();
        chargeService.drinkBeer();
    }
}
