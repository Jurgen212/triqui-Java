import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import javax.swing.Timer;
import java.awt.event.MouseListener;

public class App extends JFrame{

    int width           = 600;
    int height          = 600;
    int contador_clicks = 0;
    int coord_x         = -1;
    int coord_y         = -1;
    int[][] matriz      = {     { 0, 0, 0}, 
                                { 0, 0, 0}, 
                                { 0, 0, 0} };

    int[] array_coordenadas_lineas_finales = { 0, 0, 0, 0};


    //Booleano con cada click, va a cambiar su valor de verdad, lo que permitira pasar de 1 a -1 y luego a 1, las equis son 1 y los circulos -1
    boolean booleano        = true ;

    //Permite saber cuando llegamos a 5 click y empezar a evaluar si hay ganador desde ahi
    boolean click_necesario = false;
    Container contenedor           ;
    

    //Seleccion es el objeto que permite invocar el metodo de colocar
    colocar     seleccion   = new colocar()     ;

    //Comprobar es el objeto con el metodo que permitira evaluar si hay ganadores
    validador   comprobar   = new validador()   ;
    manejador manejador     = new manejador()   ;


    public void paint( Graphics g){
        

        //Rayas verticales
        g.drawRect( ( width / 3 )       , 50, 1, ( height - 100) );
        g.drawRect( ( width / 3 ) * 2   , 50, 1, ( height - 100) );

        //Rayas horizontales

        g.drawRect( 50, ( height / 3)       , ( width - 100 ), 1);
        g.drawRect( 50, ( height / 3) * 2   , ( width - 100 ), 1);


        //Si ya se dio al menos 1 click, se empieza a dibujar
        if( coord_x != -1 ){
            
            //Si booleano es verdadero, dibujara un ovalo, de lo contrario una X
            if( !booleano ){
               
                g.drawLine( coord_x + 60, coord_y - 50, coord_x - 60, coord_y + 50);
                g.drawLine( coord_x - 60, coord_y - 50, coord_x + 60, coord_y + 50);
                //g.drawLine( coord_x, coord_y - 50, coord_x - 50, coord_y + 50);
                
            }
            else{
                g.drawOval( coord_x - 50, coord_y - 50, 100, 100);
            }
        }


        //Si hay mas de 5 clicks, se invoca el dibujar una linea con las coordenadas que tenga el arreglo que invocamos en validador
        if( contador_clicks >= 5){
            g.drawLine( array_coordenadas_lineas_finales[0], array_coordenadas_lineas_finales[1], 
                        array_coordenadas_lineas_finales[2], array_coordenadas_lineas_finales[3]);

                       
        }


        //Para evitar errores al dibujar los elementos
        coord_x = -1;
        coord_y = -1;
    }

    public App(){
        super("Juego triqui");
        contenedor = getContentPane();

        //El mouseListener permite que al hacer click el panel lo reconozca
        addMouseListener( manejador );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); 
        setSize( width, height );
        setVisible( true );
    }
    public static void main(String[] args) throws Exception {

        //Eliminar consola
        System.out.print("\033[H\033[2J");
        System.out.flush();

        //SUper importante, metodo app
        App app = new App();
    }






    private class manejador implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            
            //Al dar click obtener coordenadas
            System.out.println( e.getX() + " " + e.getY());


            //Primera fila de la matriz


            //reconocer si estamos entre los 0 y 200 pixeles en el eje y
            if( e.getY()  < 200 && e.getY() > 0 ){


                coord_y = 100;

                //Los siguientes if anidados, permitiran saber en que zona nos encontramos con respecto al eje x, recibir si es 1 o -1, poner que coordenada se dibujara la figura y 
                //Repintar para que se pinte la figura, tambien cambiamos el valor de verdad de booleano
                if( e.getX() < 200 ){
                    

                    if( matriz[0][0] == 0){
                        matriz[0][0] = seleccion.opcion( booleano );
                        coord_x = 100;
                        repaint();
                        booleano = !booleano;
                    }
                    //Aqui va el repaint
                    
                }
                
                else if( e.getX() > 200 && e.getX() < 400 ){
                    
                    if( matriz[0][1] == 0){
                        matriz[0][1] = seleccion.opcion( booleano );
                        coord_x = 300;
                        repaint();
                        booleano = !booleano;
                        
                    }
                    
                }
                else{
                   
                    if( matriz[0][2] == 0){
                        matriz[0][2] = seleccion.opcion( booleano );
                        coord_x = 500;
                        repaint();
                        booleano = !booleano;

                    }
                    
                }

                
                  
            }


            //Segunda fila de la matriz

            //Igual que el if anterior pero con y entre 200 y 400, los equises se evaluan igual y cumplen la misma funcion
            if( e.getY()  > 200 && e.getY() < 400 ){

                coord_y = 300;

                if( e.getX() < 200 ){
                    
                    if( matriz[1][0] == 0){
                        matriz[1][0] = seleccion.opcion( booleano );
                        coord_x = 100;
                        repaint();
                        booleano = !booleano;
                    }
                    
                    //Aqui va el repaint
                    
                }
                else if( e.getX() > 200 && e.getX() < 400 ){

                    if( matriz[1][1] == 0){
                        matriz[1][1] = seleccion.opcion( booleano );
                        coord_x = 300;
                        repaint();
                        booleano = !booleano;
                    }
                    
                }
                else{
                    
                    if( matriz[1][2] == 0){
                        matriz[1][2] = seleccion.opcion( booleano );
                        coord_x = 500;
                        repaint();
                        booleano = !booleano;
                    }
                    
                }
            }


             //Tercera fila de la matriz

            //Igual que el anterior con y entre 400 y 600, el comportamiento de el eje x se evalua igual
             if( e.getY()  > 400 && e.getY() < 600 ){

                coord_y = 500;

                if( e.getX() < 200 ){
                    
                    if( matriz[2][0] == 0){
                        matriz[2][0] = seleccion.opcion( booleano );
                        coord_x = 100;
                        repaint();
                        booleano = !booleano;
                    }
                    //Aqui va el repaint
                }
                else if( e.getX() > 200 && e.getX() < 400 ){
                    
                    if( matriz[2][1] == 0){
                        matriz[2][1] = seleccion.opcion( booleano );
                        coord_x = 300;
                        repaint();
                        booleano = !booleano;
                    }
                }
                else{
                    
                    if( matriz[2][2] == 0){
                        matriz[2][2] = seleccion.opcion( booleano );
                        coord_x = 500;
                        repaint();
                        booleano = !booleano;
                    }
                }    
            }



        //Sumamos un click 
        contador_clicks++;

        //Solo reevaluaremos cuando hayan mas de 5 click, aqui recibimos las coordenadas de la linea donde se haya encontrado una victoria y la pintamos
        if( contador_clicks >= 5){
            array_coordenadas_lineas_finales = comprobar.comprobar( matriz );
            repaint();
        }
        
        }
 



        //Eventos que no usaremos
        @Override
        public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        
    }
}