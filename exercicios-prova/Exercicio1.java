public class Exercicio1 {

    public static int esqFestiva(No p) {
        if(p == null){
            return 0;
        }

        int contEsq = esqFestiva(p.esq);
        int contDir = esqFestiva(p.dir);

        if(p.esq != null ){
            return contEsq + contDir + 1;
        }
        return contEsq + contDir;
    }

}