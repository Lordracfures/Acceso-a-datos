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

	private static String CLIENTES = "Clientes";
	private static String CLIENTE	= "Cliente";
	private static String DNI = "Dni";
	private static String NOMBRE = "Nombre";
	private static String APELLIDO = "Apellido";
	private static String CP = "Cp";
	
	
	// creamos el fichero Xml en formato Dom
	
	public Document  crearDocumentoXml() {
		
		Document doc = null;
		Element raizElement = null;
		Element cliente = null; // elemento raiz
		
		try {
			
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance(); // reservamos una instancia en la memoria
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder(); // generamos la estructura DOM
			doc = docBuilder.newDocument(); // creamos el socumento DOM
			
			raizElement = doc.createElement(CLIENTES); // creamos el elemento raiz que sera clientes
			doc.appendChild(raizElement); // enlazamos clientes con doc
			
			cliente = crearNodeCliente(doc, new Cliente("31890517M","Ra?l","Pineda Caballero", "1234")); // Creamos los 3 nodos cliente y los a?adimos
			raizElement.appendChild(cliente);
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		return doc;
	}
	
	public Element crearNodeCliente(Document doc, Cliente cliente) throws DOMException{
		
		Element nodeCliente = null;
		
		try {
			nodeCliente = doc.createElement(CLIENTE); // asignamos el elemento cliente en el objeto nodeCliente
		
		
			Attr attr = doc.createAttribute(DNI); // creamos el objeto atrubuto
			attr.setValue(cliente.getDni()); // asignamos el valor a DNI
			nodeCliente.setAttributeNode(attr); // a?adimos el atributo al nodo cliente
			
			Element nombre = doc.createElement(NOMBRE);
			Node node_text_nombre = doc.createTextNode(cliente.getNombre());
			nombre.appendChild(node_text_nombre);
			nodeCliente.appendChild(nombre);
			
			Element apellido = doc.createElement(APELLIDO);
			Node node_text_apellido = doc.createTextNode(cliente.getApellido());
			apellido.appendChild(node_text_apellido);
			nodeCliente.appendChild(apellido);
			
			Element cp = doc.createElement(CP);
			Node node_text_cp = doc.createTextNode(cliente.getCp());
			apellido.appendChild(node_text_cp);
			nodeCliente.appendChild(cp);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return	nodeCliente;
	}
	
	public void domToFile(Document doc, String nombreFichero) throws TransformerFactoryConfigurationError, TransformerException, IOException {
		try {
			//Transform the XML Source to a Result.
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT,"yes");
			DOMSource source = new DOMSource(doc);
			File file = new File("files/" + nombreFichero);
			if (!file.exists()) {
				file.createNewFile();
			}
			StreamResult result = new StreamResult(file);	 
			transformer.transform(source, result);
		}
		catch(TransformerFactoryConfigurationError | TransformerException | IOException e) {
			e.printStackTrace();
			throw e;
		} 
	}
	
	public static void main(String[] args) throws Exception {
			
			try {
				
				// ------------------- Probamos la 1? parte -----------------------
				//creamos un arbol dom;
				CrearClientesDOM createDom = new CrearClientesDOM();
				Document doc = createDom.crearDocumentoXml();
				System.out.println("1.1 El arbol ha sido creado y guardado en un Document");
				
				//guardamos en un XML el arbol DOM creado en el metodo anterior
				createDom.domToFile(doc, "lista_de_clientes.xml");
				System.out.println("1.2 El documento XML ha sido creado a partir de su arbol DOM");
				
				
				
			} 
			catch (DOMException | TransformerFactoryConfigurationError | TransformerException | IOException e) {
				e.printStackTrace();
				throw e;
			} 
		}
		
	
	
	
	
	
	
	
	
	
}
