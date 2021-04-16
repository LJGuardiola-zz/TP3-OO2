package ar.unrn.tp3.modelo;

class Phone {

    private final String number;

    Phone(String number) {
        if ( ! number.matches("\\d{4}-\\d{6}"))
            throw new RuntimeException("El teléfono debe ingresarse de la siguiente forma: NNNN - NNNNNN");
        this.number = number;
    }

    String getNumber() {
        return number;
    }

}
