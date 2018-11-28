package mars_rover;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XMLimporter {
	private static Logger logger = Logger.getLogger("XML Exporter");

	public static void xmlImporter(String uri, String expression)
	{
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		Document xmlDocument = null;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			xmlDocument = dBuilder.parse(uri);
			xmlDocument.normalizeDocument();

			NodeList nList = xmlDocument.getElementsByTagName("Test");

			for (int i = 0; i < nList.getLength(); i++){
				Node node = nList.item(i);
				Element eNode = (Element) node;
				NodeList oList = eNode.getElementsByTagName("Option");
				System.out.println("\n--------------------");
				System.out.println("Test ID: " + eNode.getAttribute("ID") + ", Test name: " + eNode.getAttribute("Name"));
				System.out.println("--------------------");
				for (int j = 0; j < oList.getLength(); j++)
				{
					Node oNode = oList.item(j);
					if(!((Element) oNode).getAttribute("World_Size").isEmpty())
						System.out.println("World size is: " + ((Element) oNode).getAttribute("World_Size"));
					if(!((Element) oNode).getAttribute("Obstacles").isEmpty())
						System.out.println("Obstacles: " + ((Element) oNode).getAttribute("Obstacles"));
					if(!((Element) oNode).getAttribute("Commands").isEmpty())
						System.out.println("List of commands: " + ((Element) oNode).getAttribute("Commands"));
					if(!((Element) oNode).getAttribute("Initial_Rover_Coordinates").isEmpty())
						System.out.println("Rover's staring point and direction: " + ((Element) oNode).getAttribute("Initial_Rover_Coordinates"));
					if(!((Element) oNode).getAttribute("Expected_Rover_Coordinates").isEmpty())
						System.out.println("Rover's expected end point and direction: " + ((Element) oNode).getAttribute("Expected_Rover_Coordinates"));
				}
			}

		} catch (Exception e) {
			logger.log(Level.WARNING, "Something happens", e);
		}
	}

	public static void main(String[] args)
	{
		xmlImporter("xml/MarsRover_ListOfTest.xml", "/Mars_Rover_Tests/Test");
	}
}
