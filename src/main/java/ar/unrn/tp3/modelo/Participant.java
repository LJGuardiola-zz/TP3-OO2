package ar.unrn.tp3.modelo;

public class Participant {

    private final String name;
    private final Phone phone;
    private final Region region;

    public Participant(String name, String phone, String region) {
        if (name == null || name.isEmpty())
            throw new RuntimeException("Debe cargar un nombre");
        this.name = name;
        if (phone == null || phone.isEmpty())
            throw new RuntimeException("Debe ingresar un teléfono");
        this.phone = new Phone(phone);
        if (region == null || region.isEmpty())
            throw new RuntimeException("Debe ingresar una región");
        this.region = Region.getByCode(region);
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phone.getNumber();
    }

    public String getRegion() {
        return region.getCode();
    }

}
