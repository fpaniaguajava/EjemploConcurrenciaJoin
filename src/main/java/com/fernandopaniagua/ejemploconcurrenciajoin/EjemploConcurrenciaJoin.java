package com.fernandopaniagua.ejemploconcurrenciajoin;

public class EjemploConcurrenciaJoin {

    public static void main(String[] args) {
        Raton r1 = new Raton("R1");
        Raton r2 = new Raton("R2");
        Raton r3 = new Raton("R3");
        Raton[] ratones = {r1,r2,r3};
        for(Raton raton : ratones){
            raton.start();
        }
        try {
            Thread.sleep(4000);
        } catch (Exception e){
            e.printStackTrace();
        }
        String nombreRatonVIP="R2";
        Raton ratonVIP=null;
        for(Raton raton : ratones){
            if (raton.getNombre().equals(nombreRatonVIP)){
                ratonVIP=raton;
                break;
            }
        }
        for(Raton raton : ratones){
            System.out.println("Evaluando ratón " + raton.getNombre());
            if (!(raton.getNombre().equals(nombreRatonVIP))){
                System.out.println("Invocando a " + raton.getNombre());
                raton.esperaAlVIP(ratonVIP);
            }
        }
    }
}
