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



public class CrearClientesDOM {

	private static String Clientes = "Libros";
	private static String Cliente	= "Cliente";
	private static String Dni = "Dni";
	private static String Apellido = "Apellido";
	private static String Cp = "Cp";
	
	
	// creamos el fichero Xml en formato Dom
	
	public void crearDocumentoXml() {
		
		Document doc = null;
		Element raizElement = null;
		Element cliente = null; // elemento raiz
		
		try {
			
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			doc = docBuilder.newDocument();
			
			raizElement = doc.createElement(Clientes);
			doc.appendChild(raizElement); //A�adimos la raiz
			//Cliente = crearNodeCliente(doc, new Cliente("","","","")); // Creamos los 3 nodos cliente y los a�adimos
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void crearNodeCliente() {
		
	}
	
	
	
	
	
	
	
	
	
	
	
}