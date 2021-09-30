import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

//import org.apache.xml.serialize.XMLSerializer;
//import org.apache.xml.serialize.OutputFormat;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class RecorrerYMostrarDOM {
	public static void main(String[] args) throws Exception {
		RecorrerYMostrarDOM doc_dom = new RecorrerYMostrarDOM();
		File fichero = new File("clientes.xml");
		Document doc = null;
		doc = doc_dom.abrirXmlDom(fichero);
		System.out.println("Proceso abrir fichero DOM desde fichero XML terminado");

		String salida = doc_dom.recorrerDOMyMostrar(doc);
		System.out.println(salida); // Mostramos los datos almacenados en salida
		System.out.println();
		System.out.println("Proceso recorrer y mostrar documento DOM desde fichero XML terminado");
	}
	
	
	
	public Document abrirXmlDom(File fichero) throws Exception{
		Document doc = null;
		try {
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); // Creamos un objeto de la clase DocumentBuilderFactory
			
			dbf.setIgnoringComments(true); // Indicamos que el modelo DOM debe ignorar los comentarios que aparezcan en el XML
			dbf.setIgnoringElementContentWhitespace(true); // Indicamos que el modelo DOM debe ignorar los espacios en blanco del XML
			
			DocumentBuilder db = dbf.newDocumentBuilder(); // Se crea un objeto DocumentBuilder para cargar en él la estructura de árbol DOM a partir del XML seleccionado

			doc = db.parse(fichero); // Interpreta (parsea) el documento XML (fichero) y genera el DOM equivalente

			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
		return doc;
	}
	
	public String recorrerDOMyMostrar(Document doc) {
		String datos_nodo [] = null;
		String salida = "";
		Node nodo;
		
		try {
			Node raiz = doc.getFirstChild(); // Obtiene el nodo principal del arbol generado por DOM (el nodo raiz) que es cliente
			NodeList listaNodosRaiz = raiz.getChildNodes(); // Obtiene una lista de nodos con todos los nodos hijo del raíz; cliente1, cliente2, cliente3...
			
			for (int i = 0; i < listaNodosRaiz.getLength(); i++) { // recorremos cada objeto nodo cliente nodo
				nodo = listaNodosRaiz.item(i);
				if (nodo.getNodeType() == Node.ELEMENT_NODE) { // Es un nodo elemento de cliente
					datos_nodo = procesarNodoCliente(nodo);
					salida=salida + "\n " + "Dni: " + datos_nodo[0];
					salida=salida + "\n " + "Nombre: " + datos_nodo[1];
					salida=salida + "\n " + "Apellido: " + datos_nodo[2];
					salida=salida + "\n " + "Cp: " + datos_nodo[3] + "\n";
				}
			}
			return salida;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}
	
	
	public String [] procesarNodoCliente(Node nodo) {
		String datos[]= new String[5]; // 2 atributos y 5 datos
		Node nodo_tmp = null;
		int contador = 2;
		
		// Almacenamos los atributos
		datos[0]=nodo.getAttributes().item(0).getNodeValue(); // Obtenemos el valor del atributo "Nuss:"
		datos[1]=nodo.getAttributes().item(0).getNodeValue(); // Obtenemos el valor del atributo "Dni:"
		
		
		NodeList nodos_hijos = nodo.getChildNodes(); // calculamos los nodos hijo que contienen 
		for (int i = 0; i<nodos_hijos.getLength(); i++) {
			nodo_tmp = nodos_hijos.item(i);
			if (nodo_tmp.getNodeType() == Node.ELEMENT_NODE) {
				datos[contador] = nodo_tmp.getChildNodes().item(0).getNodeValue(); // Para obtener el valor del nodo Título y Autor, accedemos al nodo #text
				contador ++;
			}
		}
		
		return datos;
	}
	
	
}
