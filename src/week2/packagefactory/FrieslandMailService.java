package week2.packagefactory;

public class FrieslandMailService extends MailService {

    @Override
    protected Package makePackage(String size) {
        if (size.equals("klein")) {
            return new FrieslandSmallPackage();
        } else if (size.equals("middel")) {
            return new FrieslandMediumPackage();
        } else if (size.equals("groot")) {
            return new FrieslandLargePackage();
        } else {
            return null;
        }
    }
}
