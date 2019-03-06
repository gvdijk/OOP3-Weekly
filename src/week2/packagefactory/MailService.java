package week2.packagefactory;

public abstract class MailService {

    public Package sendPackage(String size) {
        Package pack = makePackage(size);

        pack.prepare();
        pack.pack();
        pack.fill();
        pack.seal();

        return pack;
    }

    protected abstract Package makePackage(String size);
}
