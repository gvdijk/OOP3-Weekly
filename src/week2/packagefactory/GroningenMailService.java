package week2.packagefactory;

public class GroningenMailService extends MailService{

    @Override
    protected Package makePackage(String size) {
        if (size.equals("klein")) {
            return new GroningenSmallPackage();
        } else if (size.equals("middel")) {
            return new GroningenMediumPackage();
        } else if (size.equals("groot")) {
            return new GroningenLargePackage();
        } else if (size.equals("giga")) {
            return new GroningenGigaPackage();
        } else {
            return null;
        }
    }
}

