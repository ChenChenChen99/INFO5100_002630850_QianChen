import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import org.json.simple.*;
import org.json.simple.parser.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("DOM Parser");
        DomParser domParser = new DomParser();
        domParser.parseXML("bookshelf.xml");
        domParser.addNewBook();
        domParser.parseXML("new_bookshelf.xml");

        System.out.println("JSON Parser");
        JsonParser jsonParser = new JsonParser();
        jsonParser.parseJSON("bookshelf.json");
        jsonParser.addNewBook();
        jsonParser.parseJSON("new_bookshelf.json");
    }
}

class DomParser {
    public void parseXML(String xml) {
        try {
            File inputFile = new File(xml);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            NodeList bookList = doc.getElementsByTagName("Book");
            System.out.println("Number of books: " + bookList.getLength());
            System.out.println("----------------------------");

            for (int temp = 0; temp < bookList.getLength(); temp++) {
                Node nNode = bookList.item(temp);
                System.out.println("Current Element: " + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Title: " + eElement.getElementsByTagName("title").item(0).getTextContent());
                    System.out.println("Year: " + eElement.getElementsByTagName("publishedYear").item(0).getTextContent());
                    System.out.println("Number of pages: " + eElement.getElementsByTagName("numberOfPages").item(0).getTextContent());
                    NodeList authorList = eElement.getElementsByTagName("author");
                    System.out.print("Authors: ");
                    for (int i = 0; i < authorList.getLength(); i++) {
                        System.out.print(authorList.item(i).getTextContent() + " ");
                    }
                    System.out.println();
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addNewBook() {
        try {
            File inputFile = new File("bookshelf.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(inputFile);
            Element newBook = doc.createElement("Book");

            Element title = doc.createElement("title");
            title.appendChild(doc.createTextNode("The Chronicles of Narnia"));
            newBook.appendChild(title);

            Element publishedYear = doc.createElement("publishedYear");
            publishedYear.appendChild(doc.createTextNode("1950"));
            newBook.appendChild(publishedYear);

            Element numberOfPages = doc.createElement("numberOfPages");
            numberOfPages.appendChild(doc.createTextNode("778"));
            newBook.appendChild(numberOfPages);

            Element authors = doc.createElement("authors");
            Element author = doc.createElement("author");
            author.appendChild(doc.createTextNode("C.S. Lewis"));
            authors.appendChild(author);
            newBook.appendChild(authors);

            doc.getDocumentElement().appendChild(newBook);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("new_bookshelf.xml"));
            transformer.transform(source, result);

//            StreamResult consoleResult = new StreamResult(System.out);
//            transformer.transform(source, consoleResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class JsonParser{
    public void parseJSON(String json){
        try {
            FileReader reader = new FileReader(json);
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            JSONArray bookList = (JSONArray) jsonObject.get("Book");
            System.out.println("Number of books: " + bookList.size());
            System.out.println("----------------------------");

            for (int temp = 0; temp < bookList.size(); temp++) {
                System.out.println("Title: " + ((JSONObject) bookList.get(temp)).get("title"));
                System.out.println("Year: " + ((JSONObject) bookList.get(temp)).get("publishedYear"));
                System.out.println("Number of pages: " + ((JSONObject) bookList.get(temp)).get("numberOfPages"));
                JSONArray authorList = (JSONArray) ((JSONObject) bookList.get(temp)).get("authors");

                System.out.print("Authors: ");
                for (int i = 0; i < authorList.size(); i++) {
                    System.out.print(authorList.get(i) + " ");
                }
                System.out.println();
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addNewBook(){
        try {
            FileReader reader = new FileReader("bookshelf.json");
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            JSONArray bookList = (JSONArray) jsonObject.get("Book");

            JSONObject newBook = new JSONObject();
            newBook.put("title", "JSON");
            newBook.put("publishedYear", "2015");
            newBook.put("numberOfPages", "100");
            JSONArray authors = new JSONArray();
            authors.add("AuthorF");
            authors.add("AuthorG");
            newBook.put("authors", authors);
            bookList.add(newBook);

            FileWriter file = new FileWriter("new_bookshelf.json");
            file.write(jsonObject.toString());
            file.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}