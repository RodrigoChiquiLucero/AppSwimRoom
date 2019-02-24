# AppSwimRoom
App para profesores y nadadores

La idea de la app basicamente es tener una base de datos de tus nadadores. Las especificaciones serian :
  1. Poder tener una lista de n nadadores
  2. Que, en cada nadador, tengamos un historial en las carreras que nado. Osea ejemplo seria :
        Igor Andruskiewitsch nado en estas 2 carreras : 50 metros crol, 100 Metros crol
        
        En 50 crol tiene un historial asi :
        
        
    ID    Torneo(tournament)  Lugar(place)   MetroPileta(25 o 50)               Time          CuantoMejoro o emperoró
     1    "name"                 "name"              50                        35:04             0 
     2    "name"                 "name"              25                        34:04            -1 sec ( en verde)
     
     La idea que pueda saber el historial de sus carreras, sus tiempos y que calcule automaticamente cuanto mejoro de su ultimo tiempo.
     La otra idea que tengo en historial seria algo que se llama pasajes. Es decir, en cuanto tiempo paso en una cierta cantidad de metros.
     Ejemplo 
        Las 4 carreras de 50 metros( mariposa espalda pecho crol) solo va a haber 2 pasajes de 25 metros
        Ejemplo 
         ID    Torneo(tournament)  Lugar(place)   MetrosPileta        25m         50m         Time     CuantoMejoro o emperoró
     1    "name"                 "name"                               18:02      18:02       35:04                 0 
     2    "name"                 "name"                               17:02      17:02       34:04      -1 sec ( en verde)
    
    Ahora si sabemos que la persona pone opcion de 50 metros en metros pileta(en carreras de 50metros), automaticamente 25m se tendria que poner en 0.
    
    Voy a poner ahora las carreras y en que se dividen cada una
    
    50 Metros(Mariposa, Espalda,Pecho,Crol) en 25 metros
    100,200 Metros   "           "    "     "    en 50 Metros
    
    400  Crol en 100 metros
    400 Combinados en 100 metros
    800  Crol en 100 metros
    1500 Crol en 100 metros
    
    Postas
    
    4X50 CROL        Varones 
    4X50 Combinados  Varones
    4X50 CROL        Mujeres
    4X50 Combinados  Mujeres
    4X50 CROL        Mixto
    4X50 Combinados  Mixto
    
    En 50 metros todas 
    
     Caso excepcional 
      
     100 Combinados no puede nadarse en pileta de 50
     
    
    3. Entrenamientos
    
 
    
    4. Una parte que haya técnicas
    
    Basicamente va a ser todo string, comentando los estilos y como se nadan
    Despues recomendar ciertos videos de youtube(eso lo tengo que consultar con unos tipos que hacen video sobre eso).
    
    
    
        
