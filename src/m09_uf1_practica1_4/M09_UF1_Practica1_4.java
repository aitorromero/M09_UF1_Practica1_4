package m09_uf1_practica1_4;

public class M09_UF1_Practica1_4 {

    public static void main(String[] args) {
        xifratRSAEmissor xRSAe = new xifratRSAEmissor();
        xifratRSAReceptor xRSAr = new xifratRSAReceptor();
        
        xRSAr.generaClaus();
        
        xRSAe.xifraDadesEmissor(
                "El profesor Jorge es muy majo y por eso "
                + "todos vamos a sacar un 10 de nota final.", 
                xRSAr.getClauPublica());
        System.out.println(xRSAr.getClauPublica());
        System.out.println(xRSAe.getMissatgeXifrat());
        
        xRSAr.desxifraDadesReceptor(xRSAe.getMissatgeXifrat());
        //System.out.println(xRSAr.getTextDesxifrat());
        
    }

}
