package week2;

import week2.packagefactory.FrieslandMailService;
import week2.packagefactory.GroningenMailService;
import week2.packagefactory.MailService;
import week2.packagefactory.Package;

public class PackageTester {

    public static void main (String args[]) {
        MailService grMail = new GroningenMailService();
        MailService frMail = new FrieslandMailService();

        Package pack = frMail.sendPackage("klein");
        System.out.println("Pakketje verstuurd: " + pack.getName());

        pack = grMail.sendPackage("groot");
        System.out.println("Pakketje verstuurd: " + pack.getName());

        pack = grMail.sendPackage("giga");
        System.out.println("Pakketje verstuurd: " + pack.getName());
    }
}
