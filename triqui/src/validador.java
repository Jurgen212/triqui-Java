import javax.swing.JOptionPane;
import javax.swing.Timer;

public class validador {
   
    int diagonal_x1 = -1, diagonal_x2 = -1, diagonal_y1 = -1, diagonal_y2 = -1;
    int[] arreglo_coords = { 0, 0, 0, 0 };

    boolean ganador = false;
    public int[] comprobar( int[][] matriz){

        for( int i = 0; i < 3; i++ ){

            //Codigo para validar si se completo una fila

                //Filas de circulos
                if( matriz[i][0] == -1 && matriz[i][1] == -1 && matriz[i][2] == -1 ){
                    System.out.println("La fila " + i + " ganaron los -1");

                    diagonal_x1 = 50;
                    diagonal_x2 = 550;

                    if( i == 0){
                        diagonal_y1 = 100;
                        diagonal_y2 = 100;
                        
                    }
                    else if( i == 1 ){
                        diagonal_y1 = 300;
                        diagonal_y2 = 300;
                        
                    }
                    else{
                        diagonal_y1 = 500;
                        diagonal_y2 = 500;
                    }
                    ganador = true;
                    break;
                }

                //Fila de equises
                
                if( matriz[i][0] == 1 && matriz[i][1] == 1 && matriz[i][2] == 1 ){
                    System.out.println("La fila " + i + " ganaron los 1");

                    diagonal_x1 = 50;
                    diagonal_x2 = 550;

                    if( i == 0){
                        diagonal_y1 = 100;
                        diagonal_y2 = 100;
                    }
                    else if( i == 1 ){
                        diagonal_y1 = 300;
                        diagonal_y2 = 300;
                    }
                    else{
                        diagonal_y1 = 500;
                        diagonal_y2 = 500;
                    }
                    ganador = true;
                    break;

                }   
                

                //Diagonal de izquierda a derecha

                //Diagonal de circulos
                if( matriz[0][0] == -1 && matriz[1][1] == -1 &&  matriz[2][2] == -1){
                    System.out.println("Diagonal de izquierda a derecha, ganaron los -1");

                    diagonal_x1 = 50;
                    diagonal_x2 = 550;

                    diagonal_y1 = 50;
                    diagonal_y2 = 550;
                    ganador = true;
                    break;
                }

                //Diagonal de equises

                if( matriz[0][0] == 1 && matriz[1][1] == 1 &&  matriz[2][2] == 1){
                    System.out.println("Diagonal de izquierda a derecha, ganaron los -1");

                    diagonal_x1 = 50;
                    diagonal_x2 = 550;

                    diagonal_y1 = 50;
                    diagonal_y2 = 550;
                    ganador = true;
                    break;
                }

                //Diagonal de derecha a izquierda

                //Diagonal de circulos

                if( matriz[0][2] == -1 && matriz[1][1] == -1 &&  matriz[2][0] == -1){
                    System.out.println("Diagonal de derecha a izquierda, ganaron los -1");

                    diagonal_x1 = 50;
                    diagonal_x2 = 550;

                    diagonal_y1 = 550;
                    diagonal_y2 = 50;
                    ganador = true;
                    break;
                }

                //Diagonal de equises
                if( matriz[0][2] == 1 && matriz[1][1] == 1 &&  matriz[2][0] == 1){
                    System.out.println("Diagonal de derecha a izquierda, ganaron los 1");
                    diagonal_x1 = 50;
                    diagonal_x2 = 550;

                    diagonal_y1 = 550;
                    diagonal_y2 = 50;
                    ganador = true;
                    break;
                }


                //Columnas


                //COlumna completa con circulos
                if( matriz[0][i] == -1 && matriz[1][i] == -1 && matriz[2][i] == -1 ){
                    System.out.println("La columna " + i + " ganaron los -1");
                    
                    diagonal_y1 = 50;
                    diagonal_y2 = 550;

                    if( i == 0){
                        diagonal_x1 = 100;
                        diagonal_x2 = 100;
                    }
                    else if( i == 1 ){
                        diagonal_x1 = 300;
                        diagonal_x2 = 300;
                    }
                    else{
                        diagonal_x1 = 500;
                        diagonal_x2 = 500;
                    }
                    ganador = true;
                    break;
                }
                
                //COlumna completa con equises
                if( matriz[0][i] == 1 && matriz[1][i] == 1 && matriz[2][i] == 1 ){
                    System.out.println("La columna " + i + " ganaron los 1");
                    
                    diagonal_y1 = 50;
                    diagonal_y2 = 550;

                    if( i == 0){
                        diagonal_x1 = 100;
                        diagonal_x2 = 100;
                    }
                    else if( i == 1 ){
                        diagonal_x1 = 300;
                        diagonal_x2 = 300;
                    }
                    else{
                        diagonal_x1 = 500;
                        diagonal_x2 = 500;
                    }
                    ganador = true;
                    break;
                }

                

        }

        int suma_marcas = 0;

                

        //Arreglo coords lo vamos a retornar cuando se llame el metodo y con el dibujaremos una recta desde el metodo paint()
        arreglo_coords[0] = diagonal_x1;
        arreglo_coords[1] = diagonal_y1;
        arreglo_coords[2] = diagonal_x2;
        arreglo_coords[3] = diagonal_y2;

 if(  !ganador  ){


    for( int i = 0; i < 3; i ++){

        for( int k = 0; k < 3; k++ ){


            if( matriz[i][k] != 0 ){
                suma_marcas ++;
            }
        }
    }

    if( suma_marcas == 9){
        JOptionPane.showMessageDialog( null, "Ninguno gano XD", "Error", 0);
        
        new java.util.Timer().schedule( new java.util.TimerTask() { @Override public void run() { System.exit(0); } }, 5000 );

    }
    

 }
        return arreglo_coords;
    }
}
