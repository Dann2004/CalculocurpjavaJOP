import javax.swing.*;
public class Curpdann {

    public static void main(String[] args) {
		    JTextField nombres = new JTextField();
		    JTextField apellido1 = new JTextField();
		    JTextField apellido2 = new JTextField();
		    JTextField dia = new JTextField();
		    JTextField mes = new JTextField();
		    JTextField anio = new JTextField();
		    String[] sexos = {"Hombre", "Mujer"};
		    JComboBox<String> sexos2 = new JComboBox<>(sexos);
		    String[] estados = {"Chihuahua","Distrito Federal","Durango","Guanajuato","Guerrero","Hidalgo","Jalisco",
		                        "Estado de Mexico","Michoacan","Morelos","Nayarit","Nuevo Leon","Oaxaca","Puebla",
		                        "Queretaro","Quintana Roo","San Luis Potosi","Sinaloa","Sonora","Tabasco","Tamaulipas",
		                        "Tlaxcala","Veracruz","Yucatan","Zacatecas","Aguas Calientes","Baja California",
		                        "Baja California Sur","Campeche","Coahuila","Colima","Chiapas","Nacido en el extranjero"};
		    JComboBox<String> estados2 = new JComboBox<>(estados);
		    
		 

		    Object[] datos={
		        "Nombres", nombres ,"Primer Apellido" ,apellido1 ,"Segundo Apellido", apellido2,"Dia",dia,"Mes",mes,"Año",anio,"Sexo",sexos2,"Estado",estados2};
		    
		    JOptionPane.showMessageDialog(null, datos,"Datos de la curp", JOptionPane.OK_CANCEL_OPTION);
		        String Nombres = nombres.getText();
		        String Primerapellido = apellido1.getText();
		        String Segundoapellido = apellido2.getText();
		        String Dia=dia.getText();
		        String Mes=mes.getText();
		        String Anio=anio.getText();
		        String Sexo = (String) sexos2.getSelectedItem();
		        String Estado = (String) estados2.getSelectedItem();
		        String CURP="";
		        
		        System.out.println("Nombre:"+Nombres);
		        System.out.println("Apellido 1:"+Primerapellido);
		        System.out.println("Apellido 2:"+Segundoapellido);
		        System.out.println("Dia:"+Dia);
		        System.out.println("Mes:"+Mes);
		        System.out.println("Año:"+Anio);
		        System.out.println("Sexo:"+Sexo);
		        System.out.println("Estado:"+Estado);
		        CURP=(CURP.concat(letrasapellido1(Primerapellido)));
		        CURP=(CURP.concat(letrasapellido2(Segundoapellido)));
		        CURP=(CURP.concat(letrasnombres(Nombres)));
		        CURP=chequeo(CURP);
		        CURP=(CURP.concat(fecha(Dia, Mes, Anio)));
		        CURP=(CURP.concat(sexodig(Sexo)));
		        CURP=(CURP.concat(estado(Estado)));
		        CURP=(CURP.concat(consonantes(Nombres,Primerapellido,Segundoapellido)));
		        CURP=(CURP.concat(homoclave()));
		        

		        JOptionPane.showMessageDialog(null,"La CURP es: "+CURP);
    }	
    public static String letrasapellido1(String Primerapellido){
        Primerapellido=Primerapellido.toUpperCase();
        Primerapellido.trim();
        char letra=Primerapellido.charAt(0);
        char letra2=Primerapellido.charAt(1);
        String letras=(Character.toString(letra));
        letras=letras.concat(Character.toString(letra2));
        return letras;
        
    }
    public static String letrasapellido2(String Segundoapellido){
        Segundoapellido=Segundoapellido.toUpperCase();
        Segundoapellido.trim();
        char letra=Segundoapellido.charAt(0);
        String letras=(Character.toString(letra));
        return letras; 
    }
    public static String letrasnombres(String Nombres){
        Nombres=Nombres.toUpperCase();
        Nombres.trim();
        String[] Nombres2 = Nombres.split(" ");
        char letra;
        String CURP="";
        if(Nombres2[0].equals("JOSE")||Nombres2[0].equals("MARIA")){
            letra=Nombres2[1].charAt(0);
            CURP=Character.toString(letra);  
        } else {
            letra=Nombres2[0].charAt(0);
            CURP=Character.toString(letra);
            }
        return CURP;
        
    }
    public static String chequeo(String CURP){
        String X="X";
        if(CURP.equals("VACA")||CURP.equals("COLA")){
            CURP=CURP.substring(1,4);
            CURP=X.concat(CURP);
        }
        CURP=CURP.replace('Ñ', 'X');
        return CURP;
    }
    public static String fecha(String Dia, String Mes, String Anio) {
        String CURP="", cero="0";
        Dia=Dia.trim();
        Mes=Mes.trim();
        Anio=Anio.trim();
        if(Dia.length()==1)
            Dia =cero.concat(Dia);
        if(Mes.length()==1)
            Mes = cero.concat(Mes);
        Anio=Anio.substring(2);
        CURP=CURP.concat(Anio.concat(Mes.concat(Dia)));
        return CURP;
    }
    public static String sexodig(String Sexo){
        String letra="";
        if(Sexo.equals("Hombre")){
            letra=letra.concat("H");
        }
        else{
            letra=letra.concat("M");
        }
            
        return letra;

    }
    public static String estado(String Estado){
        String letrasest="";
        char e1=' ',n1=' ';
        Estado=Estado.toLowerCase();
        switch (Estado) {
            case "chihuahua":
            e1='C';
            n1='H';
            break;

        case "distrito federal":
            e1='D';
            n1='F';
            break;

        case "durango":
            e1='D';
            n1='G';
            break;

        case "guanajuato":
            e1='G';
            n1='T';
            break;

        case "guerrero":
            e1='G';
            n1='R';
            break;

        case "hidalgo":
            e1='H';
            n1='G';
            break;
            
        case "jalisco":
            e1='J';
            n1='C';
            break;

        case "estado de méxico":
            e1='M';
            n1='C';
            break;

        
        case "michoacan":
            e1='M';
            n1='N';
            break;

        case "morelos":
            e1='M';
            n1='S';
            break;

        case "nayarit":
            e1='N';
            n1='T';
            break;

        case "nuevo leon":
            e1='N';
            n1='L';
            break;

        case "oaxaca":
            e1='O';
            n1='C';
            break;

        case "puebla":
            e1='P';
            n1='L';
            break;
            
        case "queretaro":
            e1='Q';
            n1='T';
            break;
            
        case "quintana roo":
            e1='Q';
            n1='R';
            break;

        case "san luis potosi":
            e1='S';
            n1='P';
            break;

        case "sinaloa":
            e1='S';
            n1='L';
            break;

        case "sonora":
            e1='S';
            n1='R';
            break;

        case "tabasco":
            e1='T';
            n1='C';
            break;

        case "tamaulipas":
            e1='T';
            n1='S';
            break;
        case "Tlaxcala":
            e1='T';
            n1='L';
            break;

        case "veracruz":
            e1='V';
            n1='Z';
            break;
        
        case "yucatan":
            e1='Y';
            n1='N';
            break;
                 
        case "zacatecas":    
            e1='Z';
            n1='S';
            break; 
            
        case "aguas calientes":
            e1='A';
            n1='S';
            break;
         
        case "baja california":
            e1='B';
            n1='C';
            break;
            
        case "baja california sur":
            e1='B';
            n1='S';
            
            break;

        case "campeche":
            e1='C';
            n1='C';
            break;
        
        case "coahuila":
            e1='C';
            n1='L';
            break;
            
        case "colima":
            e1='C';
            n1='M';
            break;

        case "chiapas":
            e1='C';
            n1='S';
            break;

        case "nacido en el extranjero":
            e1='N';
            n1='E';
            break;
               
         } 
        letrasest=letrasest.concat(Character.toString(e1));
        letrasest=letrasest.concat(Character.toString(n1));
        return letrasest;
    }
    public static String consonantes(String Nombres,String Primerapellido,String Segundoapellido){
        int i,j,n;
        String conson="";
        char letran=' ';
        char letraa1=' ';
        char letraa2=' ';
        Nombres=Nombres.toUpperCase();
        Primerapellido=Primerapellido.toUpperCase();
        Segundoapellido=Segundoapellido.toUpperCase();
        Nombres=Nombres.trim();
        Primerapellido=Primerapellido.trim();
        Segundoapellido=Segundoapellido.trim();
        for(i=1;Nombres.length()>i&&letran==' ';i++){
            if(Nombres.charAt(i)!='A'&&Nombres.charAt(i)!='E'&&Nombres.charAt(i)!='I'&&Nombres.charAt(i)!='O'&&Nombres.charAt(i)!='U')
                letran=Nombres.charAt(i);
        }
        for(j=1;Primerapellido.length()>i&&letraa1==' ';j++){
            if(Primerapellido.charAt(j)!='A'&&Primerapellido.charAt(j)!='E'&&Primerapellido.charAt(j)!='I'&&Primerapellido.charAt(j)!='O'&&Primerapellido.charAt(j)!='U')
                letraa1=Primerapellido.charAt(j);
        }
        for(n=1;Segundoapellido.length()>i&&letraa2==' ';n++){
            if(Segundoapellido.charAt(n)!='A'&&Segundoapellido.charAt(n)!='E'&&Segundoapellido.charAt(n)!='I'&&Segundoapellido.charAt(n)!='O'&&Segundoapellido.charAt(n)!='U')
                letraa2=Segundoapellido.charAt(n);
        }
        conson=conson.concat(Character.toString(letraa1));
        conson=conson.concat(Character.toString(letraa2));
        conson=conson.concat(Character.toString(letran));

        return conson;
    }
    public static String homoclave(){
        String aleatorioletra="ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        String aleatorionumero="0123456789";
        String num;
        int random;
        random=(int)(Math.random()*26);
        num=Character.toString(aleatorioletra.charAt(random) );
        random=(int)(Math.random()*10);
        num=num.concat(Character.toString((aleatorionumero.charAt(random))));
        return num;


    }
}
    


