package mainpackage.entities.foreigncurrencies;

public enum Currencies {

    USD, EUR, UAH;

    /*
    public static Currencies choose(Scanner sc) {
        while (true) {
            String curn;
            System.out.print("Enter currency (1 - UAH, 2 - USD, 3 - EUR): ");
            curn = sc.nextLine();
            switch (curn) {
                case "1":
                    return Currencies.UAH;
                case "2":
                    return Currencies.USD;
                case "3":
                    return Currencies.EUR;
                default:
                    System.out.println("Command doesn't exist");
            }
        }
    }
     */
}
