import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.net.URL;

 /**
* @Höfundur: Kristján
* @Dagsetning: 29.10.14
* Klasinn tekur tvo gjaldmiðla og geymir gengið á milli þeirra og dagetningu gengisins
*/

public class Currency{

	public String currencies;									//Gjaldmiðlarnir samsettir t.d. usdisk
	public double rate;											//Gengið
	public String date;											//Dagsetning þegar gengið var sótt
	
	Currency(String leftcurr, String rightcurr){
		
		this.currencies = leftcurr + rightcurr;												//Yahoo vinnur með gjaldmiðla þannig að þú setur 2 saman
		try {																				//t.d. usd og isk og biður um gengið á milli þeirra
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(new URL("http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.xchange%20where%20pair%20in%20%28%22" + currencies +"%22%29&env=store://datatables.org/alltableswithkeys").openStream());
		doc.getDocumentElement().normalize();
		NodeList nList = doc.getElementsByTagName("rate");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			this.rate = Double.parseDouble((eElement.getElementsByTagName("Rate").item(0).getTextContent()));
			this.date = (eElement.getElementsByTagName("Date").item(0).getTextContent());
			}
		} catch (Exception e) {
		e.printStackTrace();
		}
		
		
		}
	public static void main(String argv[]) {
		}
}
