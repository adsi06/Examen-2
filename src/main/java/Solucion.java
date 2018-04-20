//import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;

public class Solucion {
	
	private final static Logger LOG = Logger.getLogger(Solucion.class);
	
	/**
	 * Se crean los nodos con los que se van a trabajar.
	 * Cada nodo tiene un apuntador a un siguiente nodo
	 * Cada nodo tiene como información un String data
	 */
	
    class Node {
        String data;
        Node next;
        
        Node(String data) {
            this.data = data;
        }
        
        /*
         * Se recibe un nodo y se busca el último nodo asociado a éste.
         * Se crea otro nodo auxiliar para guardar el primer nodo y se hace recursivamente
         * la búsqueda del último nodo. Una vez encontrado, se borran los siguientes nodos
         * y se cambia el valor del nodo al último asociado.
         */
        Node gus() {
            if(next == null)
            	return this;
            Node otro = next; //Se crea un nodo auxiliar para buscar el siguiente nodo
            next      = null;
            Node tavo = otro.gus(); //Se busca el siguiente nodo hasta llegar al último.
            otro.next = this; //Se  asocia al nodo auxiliar de .next el último nodo asociado
            return tavo;
        }
      
        /**
         * Imprime en la consola la secuencia de Nodos que 
         * componen a esta lista. Por ejemplo, para la lista
         * que devuelve el método "build", la invocación de
         * este método escribe en la consola: 
         * 
         * A-->B-->C-->D-->E-->F-->
         * 
         * Lo anterior sería lo que se visualiza en la consola 
         * justo después de ejecutar las siguintes dos lineas:
         * 
         *         Node a = build();
         *         a.prn();
         *         
         */
        void prn() {
            // Este método requiere sólo de 3 a 7 lineas de código para funcionar correctamente
        	LOG.debug("Impresión del nodo");
        	Node aux=this;
        	while(aux.next!=null) {
        		LOG.debug("El nodo contiene: "+aux.data+" -->");
        		System.out.print(aux.data + "-->");
        		aux=aux.next;
        	}
        	LOG.debug("Se terminó la lectura del nodo");
        	System.out.println();
        	
        }
        
    }// ends Node class
    
    /**
     * Creación de nodos distintos asignando un nodo siguiente
     * a cada uno
     * 
     * @return Node Regresa el primero que se creó.
     */
    private Node build() {
        Node n1 = new Node("A");
        Node n2 = new Node("B");
        Node n3 = new Node("C");
        Node n4 = new Node("D");
        Node n5 = new Node("E");
        Node n6 = new Node("F");
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        return n1;
    }

    /**
     * Prueba la funcionalidad de el método "gus" con distintos casos de prueba
     */
    public void ok() {
        Node a = build();
        a.prn();
        a = a.gus();
        a.prn();
        a = a.gus();
        a.prn();
        
        Node b = new Node("X");
        b = b.gus();
        b.prn();
        
        Node c = new Node("X");
        Node d = new Node("Y");
        c.next = d;
        c = c.gus();
        c.prn();   
    }

    public static void main(String...argv) {
        new Solucion().ok();
    }

}
