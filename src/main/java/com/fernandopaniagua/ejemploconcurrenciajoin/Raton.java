package com.fernandopaniagua.ejemploconcurrenciajoin;

public class Raton extends Thread {
    private String nombre;
    private Raton ratonVIP = null;
    public Raton(String nombre){
        this.nombre=nombre;
    }
    public String getNombre(){
        return this.nombre;
    }
    public void esperaAlVIP(Raton ratonVIP){
        this.ratonVIP = ratonVIP;
    }
    @Override
    public void run() {
        try {
            for(int i=0;i<10;i++){
                if (ratonVIP!=null){
                    ratonVIP.join();//Indicamos a qué hilo hay que esperar
                }
                ratonVIP=null;
                System.out.println(String.format("%s está comiendo.",nombre));
                Thread.sleep(5000);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
